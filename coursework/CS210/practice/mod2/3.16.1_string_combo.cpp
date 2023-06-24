/*
 * Problem: Assign secretID with firstName, a space, and lastName.
 */

#include <iostream>
#include <string>
using namespace std;

int main() {
   string secretID;
   string firstName;
   string lastName;

   cin >> firstName;
   cin >> lastName;

   /* Your solution goes here  */
   secretID = firstName + " " + lastName;
   /* End student solution */

   cout << secretID << endl;
   return 0;
}

