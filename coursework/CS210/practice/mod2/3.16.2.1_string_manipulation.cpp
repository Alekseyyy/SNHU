
/*
 * Problem: Given string givenInput on one line and string endString on a second line, assign finalStr with the copy of givenInput with endString appended.
 */

#include <iostream>
#include <string>
using namespace std;

int main() {
   string givenInput;
   string endString;
   string finalStr;

   getline(cin, givenInput);
   getline(cin, endString);

   /* Your code goes here */
   finalStr = givenInput + endString;
   /* End student solution */
   
   cout << finalStr << endl;

   return 0;
}

