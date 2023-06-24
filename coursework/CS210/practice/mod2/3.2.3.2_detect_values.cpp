
/*
 * Problem: If integer numCards is:
    32, output "Piquet".
    52, output "Standard".
    Otherwise, output "Other kind of deck". End with a newline.
 */

#include <iostream>
using namespace std;

int main() {
   int numCards;

   cin >> numCards;

   /* Your code goes here */
   if (numCards == 32)
       cout << "Piquet" << endl;
   else if (numCards == 52)
       cout << "Standard" << endl;
   else
       cout << "Other kind of deck" << endl;

   return 0;
}

