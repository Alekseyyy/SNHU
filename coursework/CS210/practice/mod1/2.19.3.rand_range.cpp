/*
 Problem: Type two statements that use rand() to print 2 random integers between (and including) 100 and 149. End with a newline.
 */

#include <iostream>
#include <cstdlib>   // Enables use of rand()
#include <ctime>     // Enables use of time()
using namespace std;

int main() {
   int seedVal;

   cin >> seedVal;
   srand(seedVal);

   /* Your solution goes here  */
   cout << (rand() % 50) + 100 << endl;
   cout << (rand() % 50) + 100 << endl;

   return 0;
}

