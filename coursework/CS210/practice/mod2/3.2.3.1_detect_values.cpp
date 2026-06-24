/*
 * Problem: "If integer dimensionsNumber is 3, output "Three-dimensional space". Otherwise, output "Not a three-dimensional space". End with a newline."
 */
 
#include <iostream>
using namespace std;

int main() {
   int dimensionsNumber;

   cin >> dimensionsNumber;

   /* Your code goes here */
   if (dimensionsNumber == 3)
       cout << "Three-dimensional space" << endl;
   else
       cout << "Not a three-dimensional space" << endl;
   /* End student code solution */
   
   return 0;
}

