/*
 Problem: A cashier distributes change using the maximum number of five dollar bills, followed by one dollar bills. For example, 19 yields 3 fives and 4 ones. Write a single statement that assigns the number of 1 dollar bills to variable numOnes, given amountToChange. Hint: Use the % operator.
 */

#include <iostream>
using namespace std;

int main() {
   int amountToChange;
   int numFives;
   int numOnes;

   cin >> amountToChange;
   numFives = amountToChange / 5;

   /* Your solution goes here  */
   numOnes = amountToChange % 5;

   cout << "numFives: " << numFives << endl;
   cout << "numOnes: " << numOnes << endl;

   return 0;
}

