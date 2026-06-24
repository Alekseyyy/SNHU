/*
 * Problem: Re-type the code and fix any errors. The code should convert non-positive numbers to 1.
     if (userNum > 0)
       cout << "Positive." << endl;
     else
       cout << "Not positive, converting to 1." << endl;
       userNum = 1;
     cout << "Final: " << userNum << endl;
 */

#include <iostream>
using namespace std;

int main() {
   int userNum;

   cin >> userNum;

   /* Your solution goes here  */
   if (userNum > 0)
       cout << "Positive." << endl;
   else {
       cout << "Not positive, converting to 1." << endl;
       userNum = 1;
   }
 
   cout << "Final: " << userNum << endl;

   return 0;
}

