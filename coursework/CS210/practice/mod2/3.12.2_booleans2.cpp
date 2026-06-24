/*
 * Problem: Write an if-else statement to describe an object. Print "Balloon" if isBalloon is true and isRed is false. Print "Red balloon" if isBalloon and isRed are both true. Print "Not a balloon" otherwise. End with newline.
 */

#include <iostream>
using namespace std;

int main() {
   bool isRed;
   bool isBalloon;

   cin >> isRed;
   cin >> isBalloon;

   /* Your solution goes here  */
   if (!isRed && isBalloon)
      cout << "Balloon" << endl;
   else if (isRed && isBalloon)
      cout << "Red balloon" << endl;
   else
      cout << "Not a balloon" << endl;
   /* End student solution */

   return 0;
}

