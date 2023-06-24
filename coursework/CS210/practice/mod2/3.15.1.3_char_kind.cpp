
/*
 * Problem: Read in a 2-character string from input into variable passCode. Declare a boolean variable isValid and set isValid to true if passCode contains a lowercase letter. Otherwise, set isValid to false.
 */

#include <iostream>
#include <string>
#include <cctype>
using namespace std;

int main() {
   string passCode;

   /* Your code goes here */
   getline(cin, passCode);
   bool isValid = islower(passCode.at(0)) 
      || islower(passCode.at(1));
   /* End student solution */
      
   if (isValid) {
      cout << "Valid passcode" << endl;
   }
   else {
      cout << "Invalid passcode" << endl;
   }

   return 0;
}

