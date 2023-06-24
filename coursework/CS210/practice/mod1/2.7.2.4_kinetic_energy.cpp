/*
 Problem: Kinetic energy is given by ``(1.0 / 2.0) * objectMass * objectVelocity^2``. Write a program that reads double variables objectMass and objectVelocity from the input, respectively, and computes kineticEnergy using the formula. Then, outputs "Kinetic energy is " followed by the value of kineticEnergy to five digits after the decimal point. End with a newline.
 */

#include <iomanip>
#include <cmath>
#include <iostream>
using namespace std;

int main() {

   /* Your code goes here */
   double objectMass;
   double objectVelocity;
   double kineticEnergy;
   
   cin >> objectMass;
   cin >> objectVelocity;
   kineticEnergy = (1.0 / 2.0) * objectMass * pow(objectVelocity, 2);
   
   cout << "Kinetic energy is " << fixed << setprecision(5) << kineticEnergy << endl;

   return 0;
}

