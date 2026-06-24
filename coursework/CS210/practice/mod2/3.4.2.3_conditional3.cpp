/*
 * Problem: Write an if-else statement to output "At least 100" if the value of userInput is at least 100. Otherwise, output "Less than 100". End with a newline.
 */

#include <iostream>
using namespace std;

int main() {
   int userInput;
   
   cin >> userInput; 
   
   /* Your code goes here */
   if (userInput >= 100)
      cout << "At least 100" << endl;
   else
      cout << "Less than 100" << endl;
   /* End student solution */

   return 0;
}

