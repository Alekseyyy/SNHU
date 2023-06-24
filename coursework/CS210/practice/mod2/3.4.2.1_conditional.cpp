/*
 * Problem: Complete the if-else statement to output "Under 40" if the value of userNum is under 40. Otherwise, output "40 or more".
 */

#include <iostream>
using namespace std;

int main() {
   int userNum;
   
   cin >> userNum; 
   
   /* Note that my solution was just to fill
    in the conditional between the parenthesis */
   if (userNum < 40) {
      cout << "Under 40" << endl;       
   }
   else {
      cout << "40 or more" << endl;
   }

   return 0;
}

