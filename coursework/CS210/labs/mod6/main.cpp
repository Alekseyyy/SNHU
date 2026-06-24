#include <string>
#include <iostream>
#include <limits>

using namespace std;

int main() {
   string inputName;
   int age;
   bool done = false;
   cin.exceptions(ios::failbit);
   
   cin >> inputName;
   while(!done) {
      
      try {
         cin >> age;
      }
      catch (ios_base::failure& thisException) {
         age = -1;
         cin.clear();
         cin.ignore(
            numeric_limits<streamsize>::max(), 
            /* I think that numeric_limits::max() gives the maximum length of streamsize, and
             streamsize is basically a type to represent characters in the I/O stream */
            '\n'); /* The Newline "\n" character instructs streamsize to
          stop when a newline is presented */
      }
      
      if (inputName == "-1") {
         done = true;
         break;
      }
      
      cout << inputName << " " << (age + 1) << endl; // See [3]
      cin >> inputName;
   }
   
   return 0;
}

/*
 * Endnotes:
 * [1] When researching a way to properly handle this kind of exception, I stumbled
 *   across this StackOverflow thread (Retrieved on Jun. 9, 2023 from): 
 *   https://stackoverflow.com/questions/65110442/how-to-handle-the-iosfailbit-correctly
 * [2] The "cin" clear/ignore is supposed to be cleared in the "catch" block
 * [3] The print should be outside the try/catch block
 * [4] My mistake was to put most of the important logic in the "try" block, when it should
 *   be checking for specifically the error in parsing the age integer.
 * [5] I referenced the following for the stuff to do with std::numeric_types (Retrieved on Jun.
 *   9, 2023 from): https://en.cppreference.com/w/cpp/types/numeric_limits
 * [6] I referenced the following for the stuff to do with std::streamsize (Retrieved on Jun.
 *   9, 2023 from): https://en.cppreference.com/w/cpp/io/streamsize
 */
