/*
 Problem: Print a message telling a user to press the ``letterToQuit`` key ``numPresses`` times to quit. End with newline.
 */

#include <iostream>
using namespace std;

int main() {
   char letterToQuit;
   int  numPresses;

   cin >> letterToQuit;
   cin >> numPresses;

   /* Your solution goes here  */
   cout << "Press the " << letterToQuit << " key " << numPresses << " times to quit." << endl;
   /* End student solution */

   return 0;
}

