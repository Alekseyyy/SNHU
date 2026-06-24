/*
 * Problem: Using a conditional expression, write a statement that increments numUsers if updateDirection is 1, otherwise decrements numUsers.
 */

#include <iostream>
using namespace std;

int main() {
   int numUsers;
   int updateDirection;

   cin >> numUsers;
   cin >> updateDirection;

   /* Your solution goes here  */
   numUsers = (updateDirection == 1) ? numUsers + 1 : numUsers - 1;
   /* End student solution */

   cout << "New value is: " << numUsers << endl;

   return 0;
}

