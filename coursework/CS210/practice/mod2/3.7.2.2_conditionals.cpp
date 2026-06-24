/*
 * Problem: Print "userNum1 is negative." if userNum1 is less than 0. End with newline.
Assign userNum2 with 2 if userNum2 is greater than 14. Otherwise, print "userNum2 is less than or equal to 14.". End with newline.
 */

#include <iostream>
using namespace std;

int main() {
   int userNum1;
   int userNum2;

   cin >> userNum1;
   cin >> userNum2;

   /* Your code goes here */
   if (userNum1 < 0)
      cout << "userNum1 is negative." << endl;

   if (userNum2 > 14)
      userNum2 = 2;
   else
      cout << "userNum2 is less than or equal to 14." << endl;
   /* End student solution */

   cout << "userNum2 is " << userNum2 << endl;

   return 0;
}

