/*
 * Tutorial: 30 Days of Code.
 * A solution to "Day 16: Exceptions - String to Integer"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted on Feb. 29, 2024
 *   Link: https://www.hackerrank.com/challenges/30-exceptions-string-to-integer/problem
 * 
 * Task description: Read a string, S, and print its integer value; 
 *   if S cannot be converted to an integer, print "Bad String".
 * 
*/

#include <bits/stdc++.h>

using namespace std;


int main()
{
    string S;
    getline(cin, S);
    
    try {
        int converted = stoi(S);
        cout << converted << endl;
    }
    catch (const invalid_argument &except) {
        cout << "Bad String" << endl;
    }
    catch (const out_of_range &except) {
        cout << "Bad String" << endl;
    }

    return 0;
}

