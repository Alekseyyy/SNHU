
/*
 * Problem: Given string inputStr, output "Found match" if the fifth character of inputStr is 'w'. Otherwise, output "No match". End with a newline.
 */

#include <iostream>
#include <string>
using namespace std;

int main() {
   string inputStr;

   getline(cin, inputStr);

   /* Your code goes here */
   if (inputStr[4] == 'w')
      cout << "Found match" << endl;
   else
      cout << "No match" << endl;
   /* End student solution */
   
   return 0;
}

