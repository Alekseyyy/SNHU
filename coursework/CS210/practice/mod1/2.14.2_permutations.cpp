/*
 Problem: Output all combinations of character variables a, b, and c, in the order shown below. After the final output, end with a newline.
 */

#include <iostream>
using namespace std;

int main() {
   char a;
   char b;
   char c;

   cin >> a;
   cin >> b;
   cin >> c;

   /* Your solution goes here  
     NOTE that I used a software tool to work
     out all the possible permutations of 3 objects.
     
     Specifically, after this tutorial (Last Retrieved 3 May., 2023):
     https://www.digitalocean.com/community/tutorials/permutation-and-combinatios-in-python
   */
   
   cout << a << b << c << " ";
   cout << a << c << b << " ";
   cout << b << a << c << " ";
   cout << b << c << a << " ";
   cout << c << a << b << " ";
   cout << c << b << a << endl;
   /* End student solution */

   return 0;
}
