/*
 * Calculator.cpp
 *
 *  Date: 11 May., 2023
 *  Author: Alexander Ahmann
 *
 * I compiled the code on a Linux system with
 *   the command: "g++ -Wall Calculator.cpp"
 * Note that if a malformed expression is entered
 *   in, the programme will most likely infinitely 
 *   print out requests for an expression,
 *   "Malformed Expression" and infinite requests
 *   for the user to evaluate expressions. I am not
 *   sure why this is the case.
 */

#include <iostream>
#include <string>
using namespace std;

int main() // the main function must return a value
{
	// the "char statement[100];" is redundant and therefore I removed it
	int op1, op2;
	char operation;
	char working = 'Y'; // double quotes should be single quotes, also needs a semi-colon at the end. 
	while (working == 'y' || working == 'Y') // an "or" is added to make sure both cases are in the while loop's condition.
	{
		cout << "Enter expression: " ; //added some whitespace
		cin >> op1 >> operation >> op2; //op1 should come before op2 in order for subtraction and division to be correct.
		if (operation == '+') //there should not be a semi-colon here
			cout << op1 << " + " << op2 << " = " << op1 + op2 << endl;
		else if (operation == '-')
			cout << op1 << " - " << op2 << " = " << op1 - op2 << endl; // the else if statements are to break out of the conditional and the ">>" should be "<<".
		else if (operation == '*')
			cout << op1 << " * " << op2 << " = " << op1 * op2 << endl; // I changed division to multiplictation.
		else if (operation == '/')
			cout << op1 << " / " << op2 << " = " << op1 / op2 << endl; // I changed multiplication to division.
		else
			cout << "Malformed expression." << endl;

		cout << "Do you wish to evaluate another expression? ";
		cin >> working;
	}
	return 0;
}

