/*
 * Problem: When the given integer variable drinkSize is:
    - 5 fluid ounces or less, output "Too small".
    - between 5 fluid ounces exclusive and 15 fluid ounces exclusive, output "Acceptable".
    - 15 fluid ounces or more, output "Too large".
   End with a newline.
 */

#include <iostream>
using namespace std;

int main() {
   int drinkSize;

   cin >> drinkSize;

   /* Your code goes here
      Note that I got the "(void)0" no-op in the else branch from a StackOverflow thread 
      Retrieved on May. 9, 2023 from: 
          https://stackoverflow.com/questions/300208/how-does-one-execute-a-no-op-in-c-c/
   */
   if (drinkSize <= 5)
      cout << "Too small" << endl;
   else if (drinkSize > 5 && drinkSize < 15)
      cout << "Acceptable" << endl;
   else if (drinkSize >= 15)
      cout << "Too large" << endl;
   else
      (void)0;
   /* End student submission */ 

   return 0;
}
