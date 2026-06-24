/*
 * Problem: Given string userName on one line and string lastName on a second line, append a forward slash to userName. Then, append lastName to userName.
 */

#include <iostream>
#include <string>
using namespace std;

int main() {
   string userName;
   string lastName;

   getline(cin, userName);
   getline(cin, lastName);

   /* Your code goes here */
   userName.append("/");
   userName.append(lastName);
   /* End student solution */

   cout << userName << endl;

   return 0;
}

