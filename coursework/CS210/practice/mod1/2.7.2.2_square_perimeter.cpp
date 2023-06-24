/**
  Problem: The perimeter of a square is given by 4.0 * squareSize. Declare double variables squareSide and squarePerimeter. Then, read squareSide from input and compute squarePerimeter using the formula. Ex: If the input is 2.00, then the output is: 8.00.
  **/

#include <iomanip>
#include <cmath>
#include <iostream>
using namespace std;

int main() {

   /* Your code goes here */
   double squareSize;
   double squarePerimeter;
   
   cin >> squareSize;
   squarePerimeter = 4.0 * squareSize;
   /* End my solution */

   cout << fixed << setprecision(2) << squarePerimeter << endl;

   return 0;
}

