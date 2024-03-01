
/*
 * Tutorial: 30 Days of Code.
 * A solution to "Day 19: Interfaces"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted on Feb. 29, 2024
 *   Link: https://www.hackerrank.com/challenges/30-interfaces/problem
 * 
 * Task description:  The AdvancedArithmetic interface and the method declaration for the abstract divisorSum(n) method are provided for you in the editor below.
 *   Complete the implementation of Calculator class, which implements the AdvancedArithmetic interface. The implementation for the divisorSum(n) method must return the sum of all divisors of n.
 *
*/

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
class AdvancedArithmetic{
    public:
        virtual int divisorSum(int n)=0;
};
class Calculator : public AdvancedArithmetic {
public:
    int divisorSum(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                result += i;
        }
        return result;
    }
    
};

int main(){
    int n;
    cin >> n;
    AdvancedArithmetic *myCalculator = new Calculator(); 
    int sum = myCalculator->divisorSum(n);
    cout << "I implemented: AdvancedArithmetic\n" << sum;
    return 0;
}

/*
 * Endnotes:
 * 1. Interesting article on interfaces: 
 *   https://www.tutorialspoint.com/cplusplus/cpp_interfaces.htm
 */

