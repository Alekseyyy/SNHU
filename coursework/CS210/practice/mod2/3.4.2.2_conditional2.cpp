/*
 * Problem: The second branch outputs "Greater than -100" when the value of userVal is greater than -100. Fill in the expression for the first branch that outputs "-100 or less".
 */

#include <iostream>
using namespace std;

int main() {
   int userVal;
   
   cin >> userVal; 
   
   /* Note that my solution was just to fill
    in the conditional between the parenthesis */
   if (userVal <= -100) {
      cout << "-100 or less" << endl;       
   }
   else {
      cout << "Greater than -100" << endl;
   }

   return 0;
}

