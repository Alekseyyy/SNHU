/*
 * Problem: Create a conditional expression that evaluates to string "negative" if userVal is less than 0, and "non-negative" otherwise.
 */

#include <iostream>
#include <string>
using namespace std;

int main() {
   string condStr;
   int userVal;

   cin >> userVal;

   condStr = (userVal < 0) ? "negative" : "non-negative" /* This line is my solution */;

   cout << userVal << " is " << condStr << "." << endl;

   return 0;
}

