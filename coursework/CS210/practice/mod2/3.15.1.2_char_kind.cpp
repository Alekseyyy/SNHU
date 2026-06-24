
/*
 * Problem: Read in a 3-character string from input into variable passCode. Declare a boolean variable areAlphas and set areAlphas to true if the first and second characters of passCode are both alphabetic characters. Otherwise, set areAlphas to false.
 */

#include <iostream>
#include <string>
#include <cctype>
using namespace std;

int main() {
   string passCode;
   
   /* Your code goes here */
   getline(cin, passCode);
   bool areAlphas = isalpha(passCode.at(0)) 
       && isalpha(passCode.at(1));
       
   /* End student solution */
   
   if (areAlphas) {
      cout << "Passcode is valid" << endl;
   }
   else {
      cout << "Passcode is not valid" << endl;
   }

   return 0;
}

