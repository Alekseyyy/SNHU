/*
 Problem: compute z = y + √x
 */

#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

int main() {
   double x;
   double y;
   double z;

   cin >> x;
   cin >> y;
   
   /* Your code goes here */
   z = y + sqrt(x);
   /* End student solution */
   
   cout << fixed << setprecision(1); // setprecision(1) outputs z with 1 decimal place.
   cout << z << endl;

   return 0;
}

