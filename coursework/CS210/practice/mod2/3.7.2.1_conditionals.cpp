/*
 * Problem: Write multiple if statements:
    - If carYear is before 1967, print "Probably has few safety features." (without quotes).
    - If after 1970, print "Probably has seat belts.".
    - If after 1990, print "Probably has anti-lock brakes.".
    - If after 2001, print "Probably has tire-pressure monitor.".
   End each phrase with period and newline. Ex: carYear = 1995 prints:
 */

#include <iostream>
using namespace std;

int main() {
   int carYear;

   cin >> carYear;

   /* Your code goes here */
   if (carYear < 1967)
      cout << "Probably has few safety features." << endl;
   if (carYear > 1970)
      cout << "Probably has seat belts." << endl;
   if (carYear > 1990)
      cout << "Probably has anti-lock brakes." << endl;
   if (carYear > 2001)
      cout << "Probably has tire-pressure monitor." << endl;
   /* End student solution */

   return 0;
}

