/*
 * Problem: Write an if-else statement for the following: If numDifference is equal to -15, execute totalDifference = -25. Else, execute totalDifference = numDifference.
 */
 
#include <iostream>
using namespace std;

int main() {
   int totalDifference;
   int numDifference;

   cin >> numDifference; // Program will be tested with values: -14, -15, -16, -17.

   /* Your code goes here */
   if (numDifference == -15)
       totalDifference = -25;
   else
       totalDifference = numDifference;
   /* End student solution */

   cout << totalDifference << endl;

   return 0;
}

