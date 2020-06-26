#include <iostream>
using namespace std;

int main()
{
	
	const int MAX = 5;
	const int LIMIT = 1000;
	const int QUANT = 2;
	
	double prices[MAX][QUANT], total, remainder, average, count, price, quantity = 0;
	string items[MAX];
	
	
	for(int i, j = 0; i < MAX; i++)
	{
		cout << "Enter the Item name:" << endl;
		cin >> items[i];
		cout << "Enter the purchase armount:" << endl;
		cin >> prices[i][j];
		price = prices[i][j];
		j++;
		cout << "Enter the quantity:" << endl;
		cin >> prices[i][j];
		quantity = prices[i][j];
			
		total = price * quantity;	
		count = i + 1;
	
		if (total > LIMIT)
			{
				cout << "You can only spend $1000" <<endl;
				total -= total;
				i -= 1;
				cout << "Your total is: $" << total << endl;
				continue;
			}
		else if (total < 0)
			{
				total -= total;	
				i -= 1;
				cout << "Error: Please enter a positive value" << endl;	
				continue;		
			}
		else if (prices[i] == 0 || total == LIMIT || i == 4)
			break;
			
		cout << "Your total is: $" << total << endl << endl;
		
	}
	
	average = total / count;
	remainder = LIMIT - total;	
	
	cout << "\nYour final total is: $" << total << endl;
	cout << count << " items were bought" << ", with an average price of $" << average << endl;
	cout << "You have $" << remainder << " left" << endl << endl;
	
	for(int i = 0 ; i < count; i++)
		for(int j = 0 ; j < QUANT; j++)
			cout << "The cost of the " << items[i] << " was $" << prices[i][j] << endl;
		

	return 0;
}




	

