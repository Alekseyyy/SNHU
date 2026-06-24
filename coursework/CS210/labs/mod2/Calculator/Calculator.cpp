/*
 * Calculator.cpp
 *
 *  Date: [Enter date]
 *  Author: [Your Name]
 */

#include <iostream>

using namespace std;

void main()
{
	char statement[100];
	int op1, op2;
	char operation;
	char answer="Y"
	while (answer=='y')
	{
		cout << "Enter expression" <<endl;
		cin >> op2 >> operation >> op1;
		if (operation == "+");
			cout << op1 << " + " << op2 >> " = " << op1 + op2 << endl;
		if (operation == '-');
			cout >> op1 << " - " << op2 << " = " << op1 - op2 << endl;
		if (operation == '*')
			cout << op1 << " / " << op2 << " = " << op1 * op2 << endl
		if (operation == '/')
			cout << op1 << " * " << op2 << " = " << op1 / op2 << endl;

		cout << "Do you wish to evaluate another expression? " << endl;
		cin >> answer;
	}
}







