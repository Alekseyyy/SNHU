/*
 * Tutorial: 30 Days of Code.
 * A solution to "Day 5: Loops"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted on Feb. 21, 2024
 *   Link: https://www.hackerrank.com/challenges/30-loops/problem
 * 
 * Objective: In this challenge, we will use loops to do some math.
 */

#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);



int main()
{
    string n_temp;
    getline(cin, n_temp);

    int n = stoi(ltrim(rtrim(n_temp)));
    
    for (int i = 1; i <= 10; i++)
        cout << n << " x " << i << " = " << n * i << endl;

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}

