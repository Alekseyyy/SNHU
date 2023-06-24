/*
 * Problem: Given float lengthCentimeters, if the length is longer than 19.9 centimeters and shorter than 98.1 centimeters, output "Approve". Otherwise, output "Pass". End each output with a newline.
 */

#include <iostream>
using namespace std;

int main() {
   float lengthCentimeters;
   
   cin >> lengthCentimeters;
   
   /* Your code goes here */
   if (lengthCentimeters > 19.9 && lengthCentimeters <= 98.1)
      cout << "Approve" << endl;
   else
      cout << "Pass" << endl;
   /* End student submission */
   
   return 0;
}

