/*
 * Problem: Mad Libs are activities that have a person provide various words, which are then used to complete a short story in unexpected (and hopefully funny) ways. Write a program that takes a string and an integer as input, and outputs a sentence using the input values as shown in the example below. The program repeats until the input string is quit and disregards the integer input that follows.
 */

#include <iostream>
#include <string>
using namespace std;

int main() {

   /* Type your code here. */
   while (true) {
      string inputString;
      int inputNumber;
      
      cin >> inputString;
      cin >> inputNumber;
      
      if (inputString == "quit")
         break;
         
      cout << "Eating " << inputNumber << " " << inputString
          << " a day keeps you happy and healthy." << endl;
   }

   return 0;
}

