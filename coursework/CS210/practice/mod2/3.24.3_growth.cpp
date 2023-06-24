/*
 * Problem: Given positive integer numInsects, write a while loop that prints, then doubles, numInsects each iteration. Print values < 200. Follow each number with a space. After the loop, print a newline.
 */

#include <iostream>
using namespace std;

int main() {
   int numInsects;

   cin >> numInsects; // Must be >= 1

   /* Your solution goes here  */
   while (numInsects < 200) {
      cout << numInsects << " ";
      numInsects *= 2;
   }
   cout << endl;
   /* End student solution */

   return 0;
}

