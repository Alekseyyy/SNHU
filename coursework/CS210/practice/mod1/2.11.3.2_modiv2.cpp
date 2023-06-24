/*
 Problem: Integer userVal is read from input. Assume userVal is greater than 1000 and less than 99999. Assign onesDigit with userVal's ones place value.
 */

#include <iostream>
using namespace std;
 
int main() {
   int userVal;
   int onesDigit;
 
   cin >> userVal;

   /* Your code goes here */
   onesDigit = userVal % 10;
   /* End student solution */

   cout << "The value in the ones place is: " << onesDigit << endl;
}

