/*
 * Problem: Write an if-else statement to output "A passing score" if the value of userScore is greater than or equal to 70. Otherwise, output "Not a passing score". End with a newline.
 */
 
#include <iostream>
using namespace std;

int main() {
   int userScore;
   
   cin >> userScore; 
   
   /* Your code goes here */
   if (userScore >= 70)
      cout << "A passing score" << endl;
   else
      cout << "Not a passing score" << endl;
   /* End student solution */

   return 0;
}

