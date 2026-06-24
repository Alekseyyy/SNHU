
#include <iostream>
#include <string>
using namespace std;

int main() {
   string inputText;
	char newLetter;

   getline(cin, inputText);
	cin >> newLetter;
   
   /* Your code goes here */
   inputText.at(inputText.size() - 1) = newLetter;
   /* End student solution */

   cout << inputText << endl;

   return 0;
}

