/*
 * Problem: Integers userAge and hoursOfSleep are read from input. If userAge is 18 or more, assign hoursOfSleep with hoursOfSleep minus 3.
 */

#include <iostream>
using namespace std;

int main() {
   int userAge;
   int hoursOfSleep;

   cin >> userAge;
   cin >> hoursOfSleep;

   /* Your code goes here */
   if (userAge >= 18)
      hoursOfSleep -= 3;

   cout << hoursOfSleep << endl;

   return 0;
}

