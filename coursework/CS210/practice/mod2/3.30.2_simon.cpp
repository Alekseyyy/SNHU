/*
 * Problem: "Simon Says" is a memory game where "Simon" outputs a sequence of 10 characters (R, G, B, Y) and the user must repeat the sequence. Create a for loop that compares the two strings starting from index 0. For each match, add one point to userScore. Upon a mismatch, exit the loop using a break statement. Assume simonPattern and userPattern are always the same length.
 */

#include <iostream>
#include <string>
using namespace std;

int main() {
   string simonPattern;
   string userPattern;
   int userScore;
   int i;

   userScore = 0;

   cin >> simonPattern;
   cin >> userPattern;

   /* Your solution goes here  */
   for (i = 0; i < userPattern.size() - 1; i++) {
      if (simonPattern.at(i) != userPattern.at(i))
         break;
      userScore += 1;
   }
   /* End student solution */

   cout << "userScore: " << userScore << endl;

   return 0;
}

