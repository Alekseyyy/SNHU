/*
 * Problem: When the given integer variable numBooks is:
     - less than 28, output "One-level bookshelf".
     - between 28 inclusive and 180 inclusive, output "Full-wall bookshelf".
     - greater than 180, output "Too many books".
   End with a newline.
 */

#include <iostream>
using namespace std;

int main() {
   int numBooks;

   cin >> numBooks;

   /* Your code goes here
      Note that I got the "(void)0" no-op in the else branch from a StackOverflow thread 
      Retrieved on May. 9, 2023 from: 
          https://stackoverflow.com/questions/300208/how-does-one-execute-a-no-op-in-c-c/
   */
   
   if (numBooks < 28)
      cout << "One-level bookshelf" << endl;
   else if (numBooks >= 28 && numBooks <= 180)
      cout << "Full-wall bookshelf" << endl;
   else if (numBooks >= 180)
      cout << "Too many books" << endl;
   else
      (void)0;
   /* End student submission */

   return 0;
}

