/*
 * Problem: Write an if-else statement for the following: If userTickets is not equal to 6, execute awardPoints = 10. Else, execute awardPoints = userTickets.

 */
 
#include <iostream>
using namespace std;

int main() {
   int awardPoints;
   int userTickets;

   cin >> userTickets; // Program will be tested with values: 6, 7, 8, 9.

   /* Your code goes here */
   if (userTickets != 6)
       awardPoints = 10;
   else
       awardPoints = userTickets;
   /* End student solution */

   cout << awardPoints << endl;

   return 0;
}

