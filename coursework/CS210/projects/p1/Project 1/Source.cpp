
#include <iostream>
#include <iomanip>
#include <string>
#include <process.h>
#include "Clock.h"
using namespace std;

unsigned int getMenuChoice(unsigned int);
void printError(string);
void printMenu();
void printClocks(unsigned int, unsigned int, unsigned int);

int main() {

	// Print the welcome
	cout << nCharString(52, '*') << endl;
	cout << "* A simple time keeping programme" 
		<< setfill(' ') << setw(19) << "*" << endl;
	cout << "* By Alexander Ahmann <alexander.ahmann@snhu.edu>  *" << endl;
	cout << nCharString(52, '*') << endl;
	
	//Set the time
	cout << "Initial hour: ";
	cin >> clockHour;
	cout << "Initial minute: ";
	cin >> clockMinute;
	cout << "Initial second: ";
	cin >> clockSecond;

	printClocks(clockHour, clockMinute, clockSecond);

	bool done = false;
	while (!done) {
		printMenu(); //Print menu
		
		unsigned int choice = getMenuChoice(4); //Get the user choice
		if (choice == 1)
			addHour();
		else if (choice == 2)
			addMinute();
		else if (choice == 3)
			addSecond();
		else if (choice == 4) {
			done = true;
			break;
		}
		else
			(void)0; // nop
	    //Display updated clock
		printClocks(clockHour, clockMinute, clockSecond);
	}

	//Print Good Bye for appropriate choice
	return 0;
}

/**
 * Gets menu choice 1 through maxChoice, inclusive
 *
 * @param maxChoice, maximum choice index, a number between 1 and 9, inclusive
 * @return the first legal choice input, could be 1 through maxChoice, inclusive
 */
unsigned int getMenuChoice(unsigned int maxChoice) {
	bool done = false;
	unsigned int choice;
	while (!done) {
		cout << "What do you want to do? ";
		cin >> choice;
		if (choice >= 1 && choice <= maxChoice)
			done = true;
		else
			printError("Invalid input.Try Again.");
	}
	return choice; // return the value
}

/**
 * Prints an error message.
 *
 * @param error, an error message to print
 */
void printError(string error) {
	cout << "[Error]: " << error << endl;
}

/*
 * Prints the menu of options
 */
void printMenu() {
	cout << nCharString(20, '*') << endl;
	cout << "Options: " << endl;
	cout << "- 1. Add Hour" << endl;
	cout << "- 2. Add Minute" << endl;
	cout << "- 3. Add Second" << endl;
	cout << "- 4. Exit" << endl;
	cout << nCharString(20, '*') << endl;
}

/**
* Display the clocks
*
* @param h, hours 0 to 23
* @param m, minutes 0 to 59
* @param s, seconds 0 to 59
*/
void printClocks(unsigned int h, unsigned int m, unsigned int s) {
	cout << nCharString(27, '*') 
		<< nCharString(3, ' ') 
		<< nCharString(27, '*') << endl;
	cout << "*" << nCharString(6, ' ')
		<< "12-HOUR CLOCK" << nCharString(6, ' ') 
		<< "*" << nCharString(3, ' ');
	cout << "*" << nCharString(6, ' ') << "24-HOUR CLOCK"
		<< nCharString(6, ' ') << "*" << endl;
	cout << endl;
	cout << "*" << nCharString(6, ' ') 
		<< get12HourFormat(h, m, s) << nCharString(8, ' ')
		<< "*" << nCharString(3, ' ');
	cout << "*" << nCharString(8, ' ')
		<< get24HourFormat(h, m, s)
		<< nCharString(9, ' ') << "*" << endl;
	cout << nCharString(27, '*') 
		<< nCharString(3, ' ')
		<< nCharString(27, '*') << endl << endl;
}

/* Endnotes
 * [1] "Easiest way to convert int to string in C++" Retrieved on May. 19, 2023 from:
 *     https://stackoverflow.com/questions/5590381/easiest-way-to-convert-int-to-string-in-c
 * [2] "Append a character to the end of a string in C++" Retrieved on May. 19, 2023
 *     from: https://www.techiedelight.com/append-char-end-string-cpp/
 * [3] "C++ Global variable declaration" Retrieved on May. 19, 2023 from:
 *     https://stackoverflow.com/questions/19929681/c-global-variable-declaration
*/
