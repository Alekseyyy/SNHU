/*
 * Tutorial: 30 Days of Code.
 * A solution to "Day 14: Scope"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted on Feb. 27, 2024
 *   Link: https://www.hackerrank.com/challenges/30-scope/problem
 * 
 * Task description: Complete the Difference class by writing the following:
 *   * A class constructor that takes an array of integers as a parameter and saves it to the  __elements instance variable.
 *   * A computeDifference method that finds the maximum absolute difference between any 2 numbers in __elements and stores it in the maximumDifference instance variable. 
 */

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

class Difference {
    private:
    vector<int> elements;
  
  	public:
  	int maximumDifference;

	// Add your code here
    Difference (vector<int> elements) {
        this->elements = elements;
    }
    
    void computeDifference() {
        maximumDifference = 0;
        for (int j : elements) {
            for (int k : elements) {
                int absDiff = abs(j - k);
                if (absDiff > maximumDifference)
                    maximumDifference = absDiff;
            }
        }
    }

}; // End of Difference class

int main() {
    int N;
    cin >> N;
    
    vector<int> a;
    
    for (int i = 0; i < N; i++) {
        int e;
        cin >> e;
        
        a.push_back(e);
    }
    
    Difference d(a);
    
    d.computeDifference();
    
    cout << d.maximumDifference;
    
    return 0;
}

