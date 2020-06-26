#include <stdint.h>
#include <iostream>
#include <vector>
#include <stdexcept>
#include "RingBuffer.hpp"

//Default constructor
Ringbuffer::Ringbuffer(int capacity)
{
	//Checking to see if the capacity is less than 1
	if(capacity <= 0)
	{
		throw invalid_argument("Error*: capacity must be greater than zero.");
	}	
	ringbuffer.reserve(capacity);
}

//Returns the size of the vector
int Ringbuffer::size()
{
	return ringbuffer.size();
}

//Function to check to see if the vector is empty
bool Ringbuffer::isEmpty()
{
	//Checking to see if the size is equal to zero, if it passes then it will return true
	if(size() == 0)
		return 1;
	else
		return 0;

}
//Function to check to see if the vector is full
bool Ringbuffer::isFull()
{
	int current; //creating an integer for the current capacity of the vector
	current = ringbuffer.capacity(); //assigning value of the current capacity
	//Checking to see if the size is equal to the current capacity 
	if(size() == current)
		return 1;
	else
		return 0;
}

//Function which allows us to enqueue a type "double" onto the vector
void Ringbuffer::enqueue(int16_t x)
{
	//Checking to see if the vector is occupied
	if(!isFull())
		//if so then we use the push_back function to push the type onto the vector
		ringbuffer.push_back(x);
	//However if we have an error it displays an error message
	else
		throw runtime_error("Enqueue error*: Can't enqueue to a full ring");
}

//Function which allows us to dequeue a type from the vector
int16_t Ringbuffer::dequeue()
{
	//creating a temp variable 
	int16_t temp;
	//setting equal to the front of the vector
	temp = ringbuffer.front();
	//checking to see if the vector is empty or not
	if(!isEmpty())
		ringbuffer.erase(ringbuffer.begin(), ringbuffer.begin() + 1);
	else
		throw runtime_error("Dequeue error*: unable to remove from an empty ring");
	return temp;
}
int16_t Ringbuffer::peek()		
{
	if(!isEmpty())
		return ringbuffer.front();
	else
		throw runtime_error("Peek error*: unable to peek at an empty ring");
}
