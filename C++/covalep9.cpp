#include <iostream>
using namespace std;

int main()
{
	
	const int MAX = 5;
	const int LIMIT = 1000;
	double prices[MAX], total, remainder, average, count = 0;
	
	
	for(int i = 0; i < MAX; i++)
	{
		cout << "Enter the purchase armount:" << endl;
		cin >> prices[i];
		total += prices[i];
		count = i + 1;
		
		if (total > LIMIT)
			{
				cout << "You can only spend $1000" <<endl;
				total -= prices[i];
				i -= 1;
				cout << "Your total is: $" << total << endl;
				continue;
			}
		else if (total < 0)
			{
				total -= prices[i];	
				i -= 1;
				cout << "Error: Please enter a positive value" << endl;	
				continue;		
			}
		else if (prices[i] == 0 || total == LIMIT || i == 4)
			break;
			
		cout << "Your total is: $" << total << endl;
		
	}
	
	average = total / count;
	remainder = LIMIT - total;	
	
	cout << "Your final total is: $" << total << endl;
	cout << count << " items were bought" << ", with an average price of $" << average << endl;
	cout << "You have $" << remainder << " left" << endl << endl;
	
	for(int i = 0 , item = 1 ; i < count; i++, item++)
	{
		cout << "Item " << item << " was $" << prices[i] << endl;
		
	}
	return 0;
}




	

