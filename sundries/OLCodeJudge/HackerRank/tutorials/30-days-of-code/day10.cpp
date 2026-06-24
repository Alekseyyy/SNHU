/*
 * Tutorial: 30 Days of Code.
 * A solution to "Day 10: Binary Numbers"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted on Feb. 29, 2024
 *   Link: https://www.hackerrank.com/challenges/30-binary-numbers/problem
 * 
 * Task description: Given a base-10 integer, n, convert it to binary (base-2). Then find and print the base-10 integer denoting the maximum number of consecutive 1's in n's binary representation. When working with different bases, it is common to show the base as a subscript. 
 */

#include <bits/stdc++.h>

using namespace std;

list<int> DecimalToBinary(int n);
int MaximalConsecutive(list<int> result);

string ltrim(const string &);
string rtrim(const string &);

int main()
{
    string n_temp;
    getline(cin, n_temp);

    int n = stoi(ltrim(rtrim(n_temp)));
    
    list<int> binaryRepresentation = DecimalToBinary(n);
    int maxConsecutive = MaximalConsecutive(binaryRepresentation);
    
    cout << maxConsecutive << endl;

    return 0;
}

list<int> DecimalToBinary(int n) {
    
    list<int> result;
    
    int i = 0;
    while (n > 0) {
        result.push_back(n % 2);
        n /= 2;
        i++;
    }
    
    return result;
}

int MaximalConsecutive(list<int> result) {
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
    return max_count;
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
