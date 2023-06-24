/*
 * Problem: Given integer cupsRequested, output:
    - "Large bin", if there are 20 - 40 cups inclusive.
    - "Extra large bin", if there are 70 - 100 cups inclusive.
   End each output with a newline.
 */

#include <iostream>
using namespace std;

int main() {
   int cupsRequested;

   cin >> cupsRequested;  
   
   /* Your code goes here */
   if (cupsRequested >= 20 && cupsRequested <= 40)
      cout << "Large bin" << endl;
   else if (cupsRequested >= 70 && cupsRequested <= 100)
      cout << "Extra large bin" << endl;
   else
      (void)0;
   /* End student solution */

   return 0;
}

