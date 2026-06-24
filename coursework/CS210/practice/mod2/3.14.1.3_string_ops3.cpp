/*
 * Problem: Given string userInput1 on one line and string userInput2 on a second line, assign minSize with the length of the shorter string.
 */

#include <iostream>
#include <string>
using namespace std;

int main() {
   string userInput1;
	string userInput2;
	int minSize;
   
   getline(cin, userInput1);
	getline(cin, userInput2);
   
   /* Your code goes here */
   if (userInput1.size() < userInput2.size())
      minSize = userInput1.size();
   else
      minSize = userInput2.size();
   /* End student solution */
   
   cout << minSize << endl;

   return 0;
}

