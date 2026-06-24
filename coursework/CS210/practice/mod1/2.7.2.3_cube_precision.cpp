/*
 Problem: Complete the code to output "Side is " followed by the value of cubeSide to two digits after the decimal point. On the next line, output "Surface area is " followed by the value of cubeArea to six digits after the decimal point. End with a newline."
 */

#include <iomanip>
#include <cmath>
#include <iostream>
using namespace std;

int main() {
   double cubeSide;
   double cubeArea;
   
   cin >> cubeSide;
   
   cubeArea = 6.0 * cubeSide * cubeSide;

   /* Your code goes here */
   cout << "Side is " << fixed << setprecision(2) << cubeSide << endl;
   cout << "Surface area is " << fixed << setprecision(6) << cubeArea << endl;

   return 0;
}
