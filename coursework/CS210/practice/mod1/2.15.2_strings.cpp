/*
 Problem: Write a program that reads a person's first and last names separated by a space, assuming the first and last names are both single words. Then the program outputs last name, first name. End with newline.
 */

#include <iostream>
#include <string>
using namespace std;

int main() {
   string firstName;
   string lastName;

   /* Your solution goes here  */
   cin >> firstName;
   cin >> lastName;
   cout << lastName << ", " << firstName << endl;
   /* End student solution */

   return 0;
}

