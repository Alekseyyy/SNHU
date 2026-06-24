/*
 Problem: Convert totalSeconds to hours, minutes, and seconds, finding the maximum number of hours, then minutes, then seconds. Note: An hour has 3600 seconds. A minute has 60 seconds.
 */

#include <iostream>
using namespace std;
 
int main() {
   int totalSeconds;
   int numHours;
   int numMinutes;
   int numSeconds;
   
   cin >> totalSeconds;
   
   /* Your code goes here */
   numHours = totalSeconds / 3600;
   totalSeconds = totalSeconds % 3600;
   numMinutes = (totalSeconds / 60);
   totalSeconds = totalSeconds % 60;
   numSeconds = totalSeconds;
   /* End Student Solution */

   cout << "Hours: " << numHours << endl;
   cout << "Minutes: " << numMinutes << endl;
   cout << "Seconds: " << numSeconds << endl;
 
   return 0;
}

