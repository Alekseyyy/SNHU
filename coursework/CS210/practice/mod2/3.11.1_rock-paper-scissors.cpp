/*
 * Problem: Write a switch statement that checks nextChoice. If 0, print "Rock". If 1, print "Paper". If 2, print "Scissors". For any other value, print "Unknown". End with newline.
 */

#include <iostream>
using namespace std;

int main() {
   int nextChoice;

   cin >> nextChoice;

   /* Your solution goes here  */
   switch (nextChoice) {
      case 0:
         cout << "Rock" << endl;
         break;
      case 1:
         cout << "Paper" << endl;
         break;
      case 2:
         cout << "Scissors" << endl;
         break;
      default:
         cout << "Unknown" << endl;
         break;
   }
   /* End student solution */

   return 0;
}

