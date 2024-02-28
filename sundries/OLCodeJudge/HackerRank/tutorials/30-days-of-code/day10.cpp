/*
 * Tutorial: 30 Days of Code.
 * A solution to "Day 10: Binary Numbers"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted on Feb. 24, 2024
 *   Link: https://www.hackerrank.com/challenges/30-binary-numbers/problem
 * 
 * Task description: 
 */

#include <bits/stdc++.h>

using namespace std;

void DecimalToBinary(int n);
string ltrim(const string &);
string rtrim(const string &);

int main()
{
    string n_temp;
    getline(cin, n_temp);

    int n = stoi(ltrim(rtrim(n_temp)));
    DecimalToBinary(n);

    return 0;
}

void DecimalToBinary(int n) {
    
    list<int> result;
    
    // Convert it to binary
    int i = 0;
    while (n > 0) {
        result.push_back(n % 2);
        n /= 2;
        i++;
    }
    
    // Determine the length of the biggest consecutive 1s
    int max_count, curr_count;
    max_count = 0;
    curr_count = 0;
    for (auto bit : result) {
        if (bit == 0)
            curr_count = 0;
        else {
            curr_count++;
            max_count = max(max_count, curr_count);
        }
    }
    cout << max_count << endl;
    
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

/*
 * Endnotes:
 * 1. I referenced the following resources when making this solution:
 *   1a. https://www.geeksforgeeks.org/maximum-consecutive-ones-or-zeros-in-a-binary-array/
 *   1b. https://www.geeksforgeeks.org/list-cpp-stl/
 */
