/*
 * Problem: Given string stringVar on one line, string altStr on a second line, and integer selectionLen on a third line, replace the first selectionLen characters in stringVar with the contents of altStr.
 */

#include <iostream>
#include <string>
using namespace std;

int main() {
   string stringVar;
   string altStr;
   int selectionLen;

   getline(cin, stringVar);
   getline(cin, altStr);
   cin >> selectionLen;

   /* Your code goes here */
   stringVar.replace(0, selectionLen, altStr);
   /* End student solution */

   cout << stringVar << endl;
   
   return 0;
}

