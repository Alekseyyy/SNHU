
/*
 * Problem: Given string stringValue on one line and string string2 on a second line, output the index where string2 starts within stringValue. End with a newline.
 */

#include <iostream>
#include <string>
using namespace std;

int main() {
   string stringValue;
   string string2;

   getline(cin, stringValue);
   cin >> string2;

   /* Your code goes here */
   cout << stringValue.find(string2) << endl;
   /* End student submission */

   return 0;
}

