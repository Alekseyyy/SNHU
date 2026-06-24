/*
 * Print: Write a switch statement that checks origLetter. If 'a' or 'A', print "Alpha". If 'b' or 'B', print "Beta". For any other character, print "Unknown". Use fall-through as appropriate. End with newline.
 */
 
#include <iostream>
using namespace std;

int main() {
   char origLetter;

   cin >> origLetter;

   /* Your solution goes here  */
   switch (origLetter) {
      case 'a':
         cout << "Alpha" << endl;
         break;
      case 'A':
         cout << "Alpha" << endl;
         break;
      case 'b':
         cout << "Beta" << endl;
         break;
      case 'B':
         cout << "Beta" << endl;
         break;
      default:
         cout << "Unknown" << endl;
         break;
   }
   /* End student solution */

   return 0;
}

