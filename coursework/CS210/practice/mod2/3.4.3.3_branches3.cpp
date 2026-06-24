/*
 * Problem: Integer carCount is read from input. If carCount is no more than 9, output "A good number of cars". Otherwise, output "Way too many cars". End with a newline.
 */

#include <iostream>
using namespace std;

int main() {
   int carCount;

   cin >> carCount;

   /* Your code goes here */
   if (carCount <= 9)
      cout << "A good number of cars" << endl;
   else
      cout << "Way too many cars" << endl;

   return 0;
}

