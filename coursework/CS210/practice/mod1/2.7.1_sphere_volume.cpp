#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

int main() {
   double sphereVolume;
   double sphereRadius;

   cin >> sphereRadius;

   /* Your solution goes here  */
   sphereVolume = (4.0 / 3.0) * M_PI * pow(sphereRadius, 3); //note that I looked up the pow() function on a search engine
                                                             //something that I recalled with previous C++ experience
   cout << fixed << setprecision(2) << sphereVolume << endl;

   return 0;
}

