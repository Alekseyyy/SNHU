/*
 * Problem: Integers objectCount, acceptedGroups, and invalidGroups are read from input. If objectCount is 21 or less, then add 3 to acceptedGroups. Otherwise, subtract 2 from invalidGroups.
 */

#include <iostream>
using namespace std;

int main() {
   int objectCount;
   int acceptedGroups;
   int invalidGroups;

   cin >> objectCount;
   cin >> acceptedGroups;
   cin >> invalidGroups;

   /* Your code goes here */
   if (objectCount <= 21)
      acceptedGroups += 3;
   else
      invalidGroups -= 2;
   /* End student solution */

   cout << acceptedGroups << endl;
   cout << invalidGroups << endl;

   return 0;
}

