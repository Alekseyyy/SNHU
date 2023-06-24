/*
 * CS-210: Programming Languages
 * By Alexander Ahmann <alexander.ahmann@snhu.edu> 
 *
 * Problem: Driving is expensive. Write a program with a car's gas milage (miles/gallon) and the cost of gas (dollars/gallon) as floating-point input, and output the gas cost for 20 miles, 75 miles, and 500 miles. Output each floating-point value with two digits after the decimal point, which can be achieved by executing ``cout << fixed << setprecision(2);`` once before all other cout statements. Note: End with a newline.
 */

#include <iostream>
#include <iomanip>               //For setprecision
using namespace std;

int main() {

   /* Type your code here. */
   float milesPerGallon;
   float costOfGas;
   
   cin >> milesPerGallon;
   cin >> costOfGas;
   
   float totalCost = milesPerGallon / costOfGas;
   cout << fixed << setprecision(2) << 20.0 / totalCost << " ";
   cout << fixed << setprecision(2) << 75.0 / totalCost << " ";
   cout << fixed << setprecision(2) << 500.0 / totalCost << " ";

   return 0;
}

