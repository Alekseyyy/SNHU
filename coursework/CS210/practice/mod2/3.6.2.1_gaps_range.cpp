/*
 * Problem: Given integer applesAvailable, if the number of apples is 9 or more but fewer than or equal to 27, output "Admissable batch", followed by a newline.
 */

#include <iostream>
using namespace std;

int main() {
   int applesAvailable;

   cin >> applesAvailable;  
   
   /* Your code goes here */
   if (applesAvailable >= 9 && applesAvailable <= 27)
      cout << "Admissable batch" << endl;
   /* End student submission */

   return 0;
}

