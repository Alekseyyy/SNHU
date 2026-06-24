#include <iostream>
#include <vector>
using namespace std;

void SortVector(vector<int>& myVec) {
   /* I based this sorting procedure from a previous
    * work that I did [1] and the Wikipedia entry on
    * bubble sort [2]. I also referenced [3] for working
    * with vectors that have been passed by reference */
    
   int length = myVec.size();
   if (length <= 1)
      return;

   do {
      int newLength = 0;
      for (int counter = 1; counter <= length - 1; counter++) {
         if (myVec[counter - 1] < myVec[counter]) {
            //swap
            int tempVal = myVec[counter - 1];
            myVec[counter - 1] = myVec[counter];
            myVec[counter] = tempVal;
            //end swap
            newLength = counter;
         }
      }
      length = newLength;
   } while (length >= 1);
}

int main() {
   vector<int> myVector;
   int numberOfInputs;
   
   // Get the input data:
   cin >> numberOfInputs;
   for (int counter = 0; counter < numberOfInputs; counter++) {
      int userInput;
      cin >> userInput;
      myVector.push_back(userInput);
   }
   SortVector(myVector); // Main logic
   // Output the results:
   for (int counter = 0; counter < myVector.size(); counter++)
      cout << myVector[counter] << ",";
   cout << endl;
   
   return 0;
}

/*
 * Endnotes
 * [1] I have written a somewhat inefficient sorting programme before:
 *     https://codepen.io/EpsilonCalculus/pen/ZEXMxYr
 *     I may have been influenced by the Bubble Sort? I can't quite remember.
 * [2] Wikipedia contributor. Bubble sort. Wikipedia entry last revised on March 2023
 *     from: https://en.wikipedia.org/w/index.php?title=Bubble_sort&oldid=1154159987
 * [3] GeeksForGeeks; Last retrieved on May. 16, 2023 from:
 *     https://www.geeksforgeeks.org/passing-vector-function-cpp/
 * [4] While testing this programme, I learnt about the SIGABRT code (-6), so that was nice:
 *     https://stackoverflow.com/questions/43013930/what-does-exit-code-6-generally-mean-in-c
 * [5] While testing this programme, I also learnt about the SIGSEGV code (-11) from:
       https://stackoverflow.com/questions/1564372/what-causes-a-sigsegv
 */
