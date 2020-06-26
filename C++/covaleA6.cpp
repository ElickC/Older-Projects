// File Name: Word guessing game
// Written by: Elick Coval
// Description: The program prompts the user to enters, type * to see guessed letters, type ? to guess a word,
//				or type # to quit. Once the user guesses the secret word or types #, the program will display
//				number of letters guessed, number of words guessed, and what the guessed letters were.
//
// Challenges: Figuring out how to express the end of the array with pointers. How to walk through the array with pointers.
//			   Where to place the functions to get desired outcomes. I tried to use the null as condition for the guessWord
//			   function but I couldn't get it to work.
// 			   
// Time Spent: 6 hrs
// Given Input:       		     Expected Output: 
// --------------------          -------------------------
// 1) p,w,i,t,a,k				 There is 1 p in the word. 
//								 There are 0 z's in the word. 
//								 There are 0 w's in the word. 
//								 There are 2 i's in the word. 
//								 There is 1 t in the word. 
//								 There is 1 a in the word. 
// 2) ?problem					 Sorry, the word is not problem. Try again.
// 3) ?pilate					 Sorry, the word is not pilate. Try again.
// 4) ?probability				 You are correct! The word is probability! Contratulations!
//
//								 Number of letters guessed: 6
//								 Letters guessed were: PZWITA
//								 Number of words guessed: 3
//
// Revision History
// Date:        Revised By:     Action:
// ------------------------------------------------------------------
// 05/02/2016	EC				Wrote function headers, prototypes and array declarations.
// 05/06/2016	EC				Got the printCharArray function working as well as the
//								guessWord function to recognize if the guessed word is
//								correct. Modified main's switch statement and added guessWord
//								boolean as a loop exit condition.
// 05/07/2016	EC				Completed the guessWord function and got it working.
//								Completed the howMany function and used it in main's switch
//								statment. Modified the cout satements to be more user friendly.
// 05/08/2016	EC				Modified the guessed array to assign it " " so the array 
//								is empty if user plays more than once.		
// 05/10/2016	EC				Converted printCharArray's and howMany's loops to while loops, completed code
//								header.					

#include <iostream>

using namespace std;

void printCharArray(char *aPtr, int );
int howMany(char letter, char *aPtr);
bool guessWord(char *wPtr, char *gwPtr);

const int SWNUM = 12;				//Secret word index
const int GLNUM = 50;				//Guessed letter index

int main()
{
	char guessdlet[GLNUM] = " ";
	char word [SWNUM] = "PROBABILITY";
	char guessdwrd[50]; 
	char *aPtr = guessdlet;
	char input; 
	int count = 0;
	int repeats = 0;
	int words = 0;
	bool win = false;
	
	
	cout<<"Welcome to the Word Guessing Game." <<endl<<endl;
	cout<<"Try to guess the secret word!"<<endl;
	cout<<"Please enter a letter or type # to quit."<<endl<<endl;
	cout << "Enter a letter to see how many of them are in the secret word." << endl;
	cout << "Enter * to see the letter's you've already guessed." << endl;
	cout << "Enter ? to guess the secret word!" << endl;
	
	do 
	{
		
		cin >> input;
		
		switch(toupper(input))
		{
			case 'A' ... 'Z':
				if (howMany(input,guessdlet) > 0)
					cout << "You have already guessed that letter." << endl;
				else 
				{	
					*aPtr++ = toupper(input);
					count += 1;
					repeats = howMany(input,word);
					if (repeats == 1)
						cout << "There is " << repeats << " " << input << " in the word." <<endl;
					else if (repeats == 0)
						cout << "There are no " << input << "'s in the word." <<endl;
					else
						cout << "There are " << repeats << " " << input << "'s in the word." <<endl;
				}
				break;
			case '?':
				win = guessWord(word,guessdwrd);
				words += 1;
				break;	
			case '*':
				printCharArray(guessdlet,count);
				break;
			case '#':
				cout << "The secret word was Probability." << endl;
				cout << "Thanks for playing!" << endl;
				break;
			default:
				cout << "Please enter a letter (A-Z)" << endl;
				break;
		}	
	
  	}while(input != '#' && !win);
  	
  	cout << "\nNumber of letters guessed: " << count << endl;
  	if (count > 0)
  		cout << "Letters guessed were: " << (aPtr-count) << endl;
  	cout << "Number of words guessed: " << words;
  return 0;
}

void printCharArray(char *aPtr, int n)
{
	cout << "You have guessed: ";
	while(*aPtr)
		cout << *aPtr++ << " ";	
	cout << endl;
}

int howMany(char letter, char *aPtr)
{
	int counter = 0;
	int count = 0;
	
	while(*aPtr)
	{
		if (toupper(letter) == *aPtr++)
			count += 1;
	}	
	return count;
}

bool guessWord(char *wPtr, char *gwPtr)
{
	bool guess = false;
	int count = 0;
	
	cout << "Enter your guessed word"<<endl;
	cin >> gwPtr;
	
	for(int i=0;i<SWNUM;i++)
	{
		if (toupper(*gwPtr) == *wPtr)
		{
			gwPtr++;
			wPtr++;
			count += 1;
		}
	}
	gwPtr -= count;
	
	if (count == SWNUM)
	{
		guess = true;
		cout << "\nYou are correct! The word is " << gwPtr << "! Congratulations!" << endl;
	}
	else 	
		cout << "Sorry, the word is not " << gwPtr << ". Try again." << endl;
	return guess;	
}

