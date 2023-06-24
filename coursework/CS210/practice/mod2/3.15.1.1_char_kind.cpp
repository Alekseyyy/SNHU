
/*
 * Problem: A 3-character string, passwordStr, is read from input. Check if the first and second characters in passwordStr are digit characters. Replace the digit characters (if any) with '#'. If neither character is a digit, passwordStr is not changed.
 */
 
#include <iostream>
#include <string>
#include <cctype>
using namespace std;

int main() {
   string passwordStr;

   getline(cin, passwordStr);
   
   /* Your code goes here */
   if (isdigit(passwordStr[0]))
      passwordStr.at(0) = '#';
   if (isdigit(passwordStr[1]))
      passwordStr.at(1) = '#';
   /* End student solution */
      
   cout << passwordStr << endl;

   return 0;
}

