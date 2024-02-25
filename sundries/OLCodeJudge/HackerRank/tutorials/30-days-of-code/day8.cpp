/*
 * Tutorial: 30 Days of Code.
 * A solution to "Day 8: Dictionaries and Maps"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted on Feb. 22, 2024
 *   Link: https://www.hackerrank.com/challenges/30-dictionaries-and-maps/problem
 * 
 * Objective: Today, we're learning about Key-Value pair mappings using a Map or Dictionary data structure.
 */

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>

using namespace std;

void ClearBuffers() {
    cin.clear();
    cin.ignore();
}


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    map<string, int> phoneBook;
    int n;
    
    cin >> n;
    ClearBuffers();
    
    int i = 0;
    while (i < n) {
        string name;
        cin >> name;
        int number;
        cin >> number;
        ClearBuffers();
        
        phoneBook.insert(pair<string, int>(name, number));
        i++;
    }
    
    string key;
    while(getline(cin, key)) {
        if (phoneBook.find(key) == phoneBook.end())
            cout << "Not found" << endl;
        else
            cout << key << "=" << phoneBook[key] << endl;
    }
    
    return 0;
}

