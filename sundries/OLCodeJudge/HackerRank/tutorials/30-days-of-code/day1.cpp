/*
 * Tutorial: 30 Days of Code.
 * A solution to "Day 1: Data Types"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted on Feb. 4, 2024
 *   Link: https://www.hackerrank.com/challenges/30-data-types/problem
 * 
 * Objective: "Today, we're discussing data types. Check out the Tutorial tab for learning materials and an instructional video!"
 */

#include <iostream>
#include <iomanip>
#include <limits>

using namespace std;

int main() {
    int i = 4;
    double d = 4.0;
    string s = "HackerRank ";

    
    // Declare second integer, double, and String variables.
    int iVar;
    double dVar;
    string sVar;
    
    // Read and save an integer, double, and String to your variables.
    cin >> iVar;
    // Remember to clear & flush stdin ...
    cin.clear(); // ... with cin.clear() ...
    cin.ignore(); // ... and cin.ignore()
    cin >> dVar;
    cin.clear();
    cin.ignore();
    getline(cin, sVar);
    cin.clear();
    cin.ignore();
    
    // Print the sum of both integer variables on a new line.
    cout << i + iVar << endl;
    
    // Print the sum of the double variables on a new line.
    cout << fixed << setprecision(1) << d + dVar << endl;
      // Note that "fixed" and "setprecision(x)" is from iomanip.h
    
    // Concatenate and print the String variables on a new line
    // The 's' variable above should be printed first.
    
    cout << s + sVar << endl;

    return 0;
}

