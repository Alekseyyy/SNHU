/*
 * Problem: When the given integer variable numberOfBicycles is:
      - greater than or equal to 49, output "Too many bikes".
      - between 17 inclusive and 49 exclusive, output "Medium bike rack".
      - between 0 exclusive and 16 inclusive, output "Small bike rack".
      - less than or equal to 0, output "Invalid input".
    End with a newline.
 */

#include <iostream>
using namespace std;

int main() {
   int numberOfBicycles;

   cin >> numberOfBicycles;

   /* Your code goes here */
   if (numberOfBicycles >= 49)
      cout << "Too many bikes" << endl;
   else if (numberOfBicycles >= 17 && numberOfBicycles < 49)
      cout << "Medium bike rack" << endl;
   else if (numberOfBicycles > 0 && numberOfBicycles <= 16)
      cout << "Small bike rack" << endl;
   else
      cout << "Invalid input" << endl;
      
   /* End student submission */

   return 0;
}

