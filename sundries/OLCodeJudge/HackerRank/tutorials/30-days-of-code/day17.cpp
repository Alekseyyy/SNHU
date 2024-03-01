
/*
 * Tutorial: 30 Days of Code.
 * A solution to "Day 17: More Exceptions"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted on Feb. 29, 2024
 *   Link: https://www.hackerrank.com/challenges/30-more-exceptions/problem
 * 
 * Task description: Write a Calculator class with a single method: int power(int,int). The power method takes two integers, m and p, as parameters and returns the integer result of . 
 *   If either n or p is negative, then the method must throw an exception with the message: "n and p should be non-negative".
 * 
*/

#include <cmath>
#include <iostream>
#include <exception>
#include <stdexcept>
using namespace std;

//Write your code here

class Calculator {
    
    public:
        int power(int n, int p) {
            if (n < 0 || p < 0)
                throw invalid_argument("n and p should be non-negative");
            int y = 1;
            for (int i = 0; i < p; i++)
                y *= n;
            return y;
        }
};

int main()
{
    Calculator myCalculator=Calculator();
    int T,n,p;
    cin>>T;
    while(T-->0){
      if(scanf("%d %d",&n,&p)==2){
         try{
               int ans=myCalculator.power(n,p);
               cout<<ans<<endl; 
         }
         catch(exception& e){
             cout<<e.what()<<endl;
         }
      }
    }
    
}

/* Endnotes:
 * 1. I referenced the following resources when writing this solution:
 *   1a. https://rollbar.com/blog/error-exceptions-in-c/#
 */
