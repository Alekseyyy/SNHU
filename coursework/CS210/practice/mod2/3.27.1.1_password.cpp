/*
 * Problem: A website requires that passwords do not contain whitespace. For each character in passwordStr that is whitespace, replace the character with '-'.
 */

#include <iostream>
#include <string>
using namespace std;

int main() {
   string passwordStr;
   unsigned int i;
   
   getline(cin, passwordStr);

   /* Your code goes here
      Note that I referenced the following articles when solving this problem: 
      - https://cplusplus.com/reference/cctype/isspace/
   */
   for (i = 0; i < passwordStr.size(); i++) {
      if (isspace(passwordStr[i]))
         passwordStr[i] = '-';
   }
   /* End student solution */

   cout << "Adjusted password: " << passwordStr << endl;
   
   return 0;
}

