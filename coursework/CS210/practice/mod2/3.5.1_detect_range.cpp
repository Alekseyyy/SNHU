/*
 * Problem: Write an expression that prints "Eligible" if userAge is between 18 and 25 inclusive.
 */

#include <iostream>
using namespace std;

int main() {
   int userAge;

   cin >> userAge;

   if (/* Your solution goes here  */
      (userAge >= 18) && (userAge <= 25)
   /* End student solution */
   ) {
      cout << "Eligible" << endl;
   }
   else {
      cout << "Ineligible" << endl;
   }

   return 0;
}

