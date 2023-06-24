/*
 Problem: The cost to ship a package is a flat fee of 75 cents plus 25 cents per pound.
    1. Declare a const named CENTS_PER_POUND and initialize with 25.
    2. Get the shipping weight from user input storing the weight into shipWeightPounds.
    3. Using FLAT_FEE_CENTS and CENTS_PER_POUND constants, assign shipCostCents with the cost of shipping a package weighing shipWeightPounds.

 */


#include <iostream>
using namespace std;

int main() {
   int shipWeightPounds;
   int shipCostCents = 0;
   const int FLAT_FEE_CENTS = 75;

   /* Your solution goes here  */
   const int CENTS_PER_POUND = 25;
   cin >> shipWeightPounds;
   shipCostCents = (shipWeightPounds * CENTS_PER_POUND) + FLAT_FEE_CENTS;
   /* End student solution */

   cout << "Weight(lb): " << shipWeightPounds;
   cout << ", Flat fee(cents): " << FLAT_FEE_CENTS;
   cout << ", Cents per lb: " << CENTS_PER_POUND << endl;
   cout << "Shipping cost(cents): " << shipCostCents << endl;

   return 0;
}

