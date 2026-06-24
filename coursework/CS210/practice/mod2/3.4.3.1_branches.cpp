/*
 * Problem: Integer birdCount is read from input. If birdCount is more than 9, output "Enough birds". End the output with a newline.
 */
 
#include <iostream>
using namespace std;

int main() {
   int birdCount;

   cin >> birdCount;

   /* Your code goes here */
   if (birdCount > 9)
      cout << "Enough birds" << endl;
   /* End student solution */

   return 0;
}

