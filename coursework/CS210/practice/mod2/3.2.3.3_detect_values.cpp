/*
 * Problem: If integer numLegs is:
     1, output "Uniped".
     6, output "Hexapod".
     3, output "Triped".

Otherwise, output "Number of legs not found". End with a newline.
 */

#include <iostream>
using namespace std;

int main() {
   int numLegs;

   cin >> numLegs;

   /* Your code goes here */
   if (numLegs == 1)
       cout << "Uniped" << endl;
   else if (numLegs == 6)
       cout << "Hexapod" << endl;
   else if (numLegs == 3)
       cout << "Triped" << endl;
   else
       cout << "Number of legs not found" << endl;
   
   return 0;
}

