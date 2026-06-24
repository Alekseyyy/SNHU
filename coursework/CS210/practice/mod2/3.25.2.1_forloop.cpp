/*
 * Problem: Integer numVals is read from input representing the number of integers to be read next. Use a loop to read the remaining integers from input. For each integer read in the loop, output the integer followed by " apricots". End each output with a newline.
 */

#include <iostream>
using namespace std;

int main() {
   int numVals;
   int value;

   cin >> numVals;

   /* Your code goes here */
   for (int i = 0; i < numVals; i++) {
      cin >> value;
      cout << value << " apricots" << endl;
   }
   /* End student solution */

   return 0;
}
