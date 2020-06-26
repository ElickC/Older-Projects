#include <iostream>
#include <thread>
#include <condition_variable>
#include <mutex>
#include <chrono>
#include "AirportServer.h"


/**
*  Called by an Airplane when it wishes to land on a runway
*/
void AirportServer::reserveRunway(int airplaneNum, AirportRunways::RunwayNumber runway)
{
	// Acquire runway(s)
	 
	{
		lock_guard<mutex> lk(AirportRunways::checkMutex);

		cout << "Airplane #" << airplaneNum << " is acquiring any needed runway(s) for landing on Runway "
			 << AirportRunways::runwayName(runway) << endl;
	}

	/**
	 *  ***** Add your synchronization here! *****
	 */
	
	numLandingRequests++;

	unique_lock<mutex> lock(runwaysMutex);
	while(!safeToLand){
		landingRequest.wait(lock);
	}

	lock.unlock();

	switch (runway){
	case 0:						//4L
		runway4L.lock();
		runway15L.lock();
		runway15R.lock();
		break;
	case 1:						//4R
		runway4R.lock();
		runway9.lock();
		runway15L.lock();
		runway15R.lock();
		break;
	case 2:						//9
		runway4R.lock();
		runway9.lock();
		runway15R.lock();
		break;
	case 3:						//14
		runway14.lock();
		break;
	case 4:						//15L
		runway4L.lock();
		runway4R.lock();
		runway15L.lock();
		break;
	case 5:						//15R
		runway4L.lock();
		runway4R.lock();
		runway9.lock();
		runway15R.lock();
		break;
	default:
		break;
	}

	// Check status of the airport for any rule violations
	AirportRunways::checkAirportStatus(runway);

	// obtain a seed from the system clock:
	unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();
	std::default_random_engine generator(seed);

	// Taxi for a random number of milliseconds
	std::uniform_int_distribution<int> taxiTimeDistribution(1, MAX_TAXI_TIME);
	int taxiTime = taxiTimeDistribution(generator);

	{
		lock_guard<mutex> lk(AirportRunways::checkMutex);

		cout << "Airplane #" << airplaneNum << " is taxiing on Runway " << AirportRunways::runwayName(runway)
			 << " for " << taxiTime << " milliseconds\n";
	}

	std::this_thread::sleep_for(std::chrono::milliseconds(taxiTime));

} // end AirportServer::reserveRunway()


 /**
  *  Called by an Airplane when it is finished landing
  */
void AirportServer::releaseRunway(int airplaneNum, AirportRunways::RunwayNumber runway)
{
	// Release the landing runway and any other needed runways
	 
	{
		lock_guard<mutex> lk(AirportRunways::checkMutex);

		cout << "Airplane #" << airplaneNum << " is releasing any needed runway(s) after landing on Runway "
			 << AirportRunways::runwayName(runway) << endl;
	}

	/**
	 *  ***** Add your synchronization here! *****
	 */


	switch (runway){
	case 0:							//4L
		runway4L.unlock();
		runway15L.unlock();
		runway15R.unlock();
		break;
	case 1:							//4R
		runway4R.unlock();
		runway9.unlock();
		runway15L.unlock();
		runway15R.unlock();
		break;
	case 2:							//9
		runway4R.unlock();
		runway9.unlock();
		runway15R.unlock();
		break;
	case 3:							//14
		runway14.unlock();
		break;
	case 4:							//15L
		runway4L.unlock();
		runway4R.unlock();
		runway15L.unlock();
		break;
	case 5:							//15R
		runway4L.unlock();
		runway4R.unlock();
		runway9.unlock();
		runway15R.unlock();
		break;
	default:
		break;
	} 

	numLandingRequests--;

	if(numLandingRequests < 7){
		safeToLand = true;
		landingRequest.notify_one();
	}
	
	// Update the status of the airport to indicate that the landing is complete
	AirportRunways::finishedWithRunway(runway);

	// obtain a seed from the system clock:
	unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();
	std::default_random_engine generator(seed);

	// Wait for a random number of milliseconds before requesting the next landing for this Airplane
	std::uniform_int_distribution<int> waitTimeDistribution(1, MAX_WAIT_TIME);
	int waitTime = waitTimeDistribution(generator);

	{
		lock_guard<mutex> lk(AirportRunways::checkMutex);

		cout << "Airplane #" << airplaneNum << " is waiting for " << waitTime << " milliseconds before landing again\n";
	}

	std::this_thread::sleep_for(std::chrono::milliseconds(waitTime));

} // end AirportServer::releaseRunway()
