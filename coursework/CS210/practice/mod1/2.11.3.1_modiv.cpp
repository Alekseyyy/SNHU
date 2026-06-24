/*
 Problem: Integer variables totalMinutes and mileTime are read from input. Assign numMiles with the maximum number of complete miles that a person can walk in totalMinutes minutes, if each mile takes mileTime minutes to walk.
 */

#include <iostream>
using namespace std;
 
int main() {
   int totalMinutes;
   int mileTime;
   int numMiles;
 
   cin >> totalMinutes;
   cin >> mileTime;
   
   /* Your code goes here */
   numMiles = totalMinutes / mileTime;
   /* End student solution */

   cout << "Maximum number of miles: " << numMiles << endl;
   
   return 0;
}

