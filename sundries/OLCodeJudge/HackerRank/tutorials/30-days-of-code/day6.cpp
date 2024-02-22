/*
 * Tutorial: 30 Days of Code.
 * A solution to "Day 6: Let's Review"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted on Feb. 21, 2024
 *   Link: https://www.hackerrank.com/challenges/30-review-loop/problem
 * 
 * Objective: Today we will expand our knowledge of strings, combining it with what we have already learned about loops.
 */

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

/*
 * I realise that this is not the "smartest" way to solve this problem; the
 * runtime complexity is 2n (it could probably be reduced to 1n with a better
 * technique.
 */
void Procedure(string input) {
    for (int i = 0; i < input.length(); i++){
        if (i % 2 == 0)
            cout << input[i];
        
    }
    cout << " ";
    for (int i = 0; i < input.length(); i++) {
        if (i % 2 != 0)
            cout << input[i];
    }
    cout << endl;
}

void ClearBuffers() {
    cin.clear();
    cin.ignore();
}


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n_inputs;
    int i = 0;
    
    cin >> n_inputs;
    ClearBuffers();
    
    string input;
    while (getline(cin, input)) {
        Procedure(input);
    }
    
    return 0;
}

