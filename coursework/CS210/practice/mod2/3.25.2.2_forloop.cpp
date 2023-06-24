/*
 * Problem: Read integer numVals from input as the number of integers to be read next. Use a loop to read the remaining integers from input. Output all integers on the same line, and surround each integer with square brackets. Lastly, end with a newline.
 */

#include <iostream>
using namespace std;

int main() {
   int numVals;

   /* Your code goes here */
   cin >> numVals;
   for (int i = 0; i < numVals; i++){
      int currentValue;
      cin >> currentValue;
      cout << "[" << currentValue << "]";
   }
   cout << endl;

   return 0;
}

