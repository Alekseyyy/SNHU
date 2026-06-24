/*
 * Problem: Print the two strings, firstString and secondString, in alphabetical order. Assume the strings are lowercase. End with newline.
 */

#include <iostream>
#include <string>
using namespace std;

int main() {
   string firstString;
   string secondString;

   cin >> firstString;
   cin >> secondString;

   /* Your solution goes here */
   if (firstString < secondString) {
      cout << firstString << " "
         << secondString << endl;
   }
   else {
      cout << secondString << " "
         << firstString << endl;
   }
   /* End student solution */

   return 0;
}

