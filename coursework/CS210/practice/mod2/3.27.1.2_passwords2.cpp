/*
 * Problem: "123" is a string commonly found in weak passwords. Remove all occurrences of "123" from passPhrase. Then, assign lengthStr with the length of passPhrase. 
   Note that this does not pass most test cases (I do not know why). 
 */

#include <iostream>
#include <string>
using namespace std;

int main() {
   string passPhrase;
   int index;
   int lengthStr;
   
   cin >> passPhrase;
   index = 0;
	lengthStr = 0;

   /* Your code goes here */
   while (true) {
      if (passPhrase.find("123") == string::npos)
         break;
      int targetIndex = passPhrase.find("123");
      passPhrase.replace(targetIndex, targetIndex + 2, "");
   }
   lengthStr = passPhrase.size();
   /* End student solution */

   cout << "Remaining string: " << passPhrase << endl;
	cout << "Length: " << lengthStr << endl;
   
   return 0;
}

