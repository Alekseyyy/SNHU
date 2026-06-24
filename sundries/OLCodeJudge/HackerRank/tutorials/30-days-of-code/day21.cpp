
/*
 * Tutorial: 30 Days of Code.
 * A solution to "Day 21: Generics"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted on Mar. 1, 2024
 *   Link: https://www.hackerrank.com/challenges/30-generics/problem
 * 
 * Task description: Write a single generic function named printArray; this function must take an array of generic elements as a parameter (the exception to this is C++, which takes a vector). The locked Solution class in your editor tests your function. Note: You must use generics to solve this challenge. Do not write overloaded functions. 
 *
*/

#include <iostream>
#include <vector>
#include <string>

using namespace std;

/**
*    Name: printArray
*    Print each element of the generic vector on a new line. Do not return anything.
*    @param A generic vector
**/

// Write your code here

template<typename T>

void printArray(vector<T> inputArray) {
    for (auto x : inputArray)
        cout << x << endl;
}

int main() {
	int n;
	
	cin >> n;
	vector<int> int_vector(n);
	for (int i = 0; i < n; i++) {
		int value;
		cin >> value;
		int_vector[i] = value;
	}
	
	cin >> n;
	vector<string> string_vector(n);
	for (int i = 0; i < n; i++) {
		string value;
		cin >> value;
		string_vector[i] = value;
	}

	printArray<int>(int_vector);
	printArray<string>(string_vector);

	return 0;
}

/*
 * Endnotes:
 * 1. I cited the following resources when writing this solution
 *   1a. https://www.geeksforgeeks.org/generics-in-c/
 *
*/

