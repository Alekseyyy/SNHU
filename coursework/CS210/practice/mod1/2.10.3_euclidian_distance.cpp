/*
 Problem: Determine the distance between point (x1, y1) and point (x2, y2), and assign the result to pointsDistance. The calculation is: ``Distance = √((x2 - x1)^2 + (y2 - y1)^2)``
 */

#include <iostream>
#include <cmath>
using namespace std;

int main() {
   double x1;
   double y1;
   double x2;
   double y2;
   double xDist;
   double yDist;
   double pointsDistance;

   xDist = 0.0;
   yDist = 0.0;
   pointsDistance = 0.0;

   cin >> x1;
   cin >> y1;
   cin >> x2;
   cin >> y2;

   /* Your solution goes here  */
   xDist = pow(x2 - x1, 2);
   yDist = pow(y2 - y1, 2);
   pointsDistance = sqrt(xDist + yDist);
   /* End student solution */

   cout << pointsDistance << endl;

   return 0;
}

