/*
 Problem: Type a statement using srand() to seed random number generation using variable seedVal. Then type two statements using rand() to print two random integers between (and including) 0 and 9. End with a newline. Note: For this activity, using one statement may yield different output (due to the compiler calling rand() in a different order). Use two statements for this activity. Also, after calling srand() once, do not call srand() again.
 */

#include <iostream>
#include <cstdlib>   // Enables use of rand()
using namespace std;

int main() {
   int seedVal;

   cin >> seedVal;

   /* Your solution goes here  */
   srand(seedVal);
   cout << rand() % 10 << endl;
   cout << rand() % 10 << endl;

   return 0;
}

