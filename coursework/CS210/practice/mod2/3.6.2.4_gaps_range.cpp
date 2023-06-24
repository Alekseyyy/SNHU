/*
 * Problem: Given integer napkinsOrdered, output:
     - "Standard carton", if the number of napkins is greater than or equal to 28 and less than or equal to 47.
     - "Full carton", if the number of napkins is greater than 94 and less than or equal to 137.
     - "Not efficient to ship" otherwise.
   End each output with a newline.
 */

#include <iostream>
using namespace std;

int main() {
   int napkinsOrdered;

   cin >> napkinsOrdered;  
   
   /* Your code goes here */
   if (napkinsOrdered >= 28 && napkinsOrdered <= 47)
      cout << "Standard carton" << endl;
   else if (napkinsOrdered > 94 && napkinsOrdered <= 137)
      cout << "Full carton" << endl;
   else
      cout << "Not efficient to ship" << endl;
   /* End student solution */

   return 0;
}

