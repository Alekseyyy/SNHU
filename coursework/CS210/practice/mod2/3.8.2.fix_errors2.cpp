/*
 * Problem: Find and fix the error in the if-else statement.
 */

#include <iostream>
using namespace std;

int main() {
   int userNum;

   cin >> userNum;    // Program will be tested with values: 1, 2, 3, 0.

   if (userNum == 2) { //the error is that the comparison operator was "=" 
                       //when it should have been "=="
      cout << "Num is equal to two" << endl;
   }
   else {
      cout << "Num is not two" << endl;
   }

   return 0;
}
