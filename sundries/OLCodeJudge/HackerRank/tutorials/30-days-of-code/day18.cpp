
/*
 * Tutorial: 30 Days of Code.
 * A solution to "Day 18: Queues and Stacks"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted on Feb. 29, 2024
 *   Link: https://www.hackerrank.com/challenges/30-queues-stacks/problem
 * 
 * Task description: Write the following declarations and implementations:
 *
 *   Two instance variables: one for your stack, and one for your queue.
      * A void pushCharacter(char ch) method that pushes a character onto a stack.
      * A void enqueueCharacter(char ch) method that enqueues a character in the instance variable.
      * A char popCharacter() method that pops and returns the character at the top of the instance variable.
      * A char dequeueCharacter() method that dequeues and returns the first character in the
instance variable.
 *
*/

#include <iostream>
#include <vector>

using namespace std;

class Solution {
    //Write your code here
    private:
        vector<char> stack;
        vector<char> queue;
        
        int stack_last = 0;
        int queue_curr = 0;
    
    public:
        void pushCharacter(char ch) {
            stack.push_back(ch);
            stack_last++;
        }
        
        void enqueueCharacter(char ch) {
            queue.push_back(ch);
        }
        
        char popCharacter() {
            char result = stack[stack_last - 1];
            stack_last--;
            return result;
        }
        
        char dequeueCharacter() {
            char result = queue[queue_curr];
            queue_curr++;
            return result;
        }
    
};

int main() {
    // read the string s.
    string s;
    getline(cin, s);
    
  	// create the Solution class object p.
    Solution obj;
    
    // push/enqueue all the characters of string s to stack.
    for (int i = 0; i < s.length(); i++) {
        obj.pushCharacter(s[i]);
        obj.enqueueCharacter(s[i]);
    }
    
    bool isPalindrome = true;
    
    // pop the top character from stack.
    // dequeue the first character from queue.
    // compare both the characters.
    for (int i = 0; i < s.length() / 2; i++) {
        if (obj.popCharacter() != obj.dequeueCharacter()) {
            isPalindrome = false;
            
            break;
        }
    }
    
    // finally print whether string s is palindrome or not.
    if (isPalindrome) {
        cout << "The word, " << s << ", is a palindrome.";
    } else {
        cout << "The word, " << s << ", is not a palindrome.";
    }
    
    return 0;
}

/* Endnotes:
 * 1. I referenced the following web resources when writing this solution:
 *   1a. https://www.geeksforgeeks.org/stack-in-python/
 *   1b. https://www.geeksforgeeks.org/implementing-stack-c-sharp/
 *   1c. https://www.w3schools.com/cpp/cpp_arrays.asp
 *   1d. https://www.geeksforgeeks.org/queue-in-python/
 */
