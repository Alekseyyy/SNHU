
#include <iostream>
#include <string>
using namespace std;

int main() {
   string workString;
   int idxBegin;
   string finalStr;

   getline(cin, workString);
   cin >> idxBegin;

   /* Your code goes here */
   finalStr = workString + workString.substr(idxBegin, workString.size() - 1);
   /* End student solution */
   
   cout << finalStr << endl;
   
   return 0;
}

