/*
 * Problem: Read integer numVals from input as the number of integers to be read next. Use a loop to read the remaining integers from input. Output all integers on the same line, and insert ": " between all integers, but not at the beginning or end of the output. Lastly, end with a newline.
 */

#include <iostream>
using namespace std;

int main() {
   int numVals;

   /* Your code goes here */
   cin >> numVals;
   int value;
   for (int i = 0; i < numVals - 1; i++) {
      cin >> value;
      cout << value << ": ";
   }
   cin >> value;
   cout << value << endl;
   /* End student solution */

   return 0;
}

