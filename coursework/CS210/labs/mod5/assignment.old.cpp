
/* CS-210 - Assignment 5-2: File I/O
 *   Operations and temperature unit conversion.
 * By Alexander Ahmann <alexander.ahmann@snhu.edu>
 *
 * Written & tested in Linux and compiled with g++ like so:
 *   aleksey@homepc:~/ g++ --Wall assignment.cpp
*/

#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>

using namespace std;

double fahrenheitToCelsius(double);
int writeOutput(string, int, int);

int main() {
    ifstream entries;
    string city;
    double tempF;
    
    // Try to open the file for conversion inputs
    entries.open("FahrenheitTemperature.txt");
    if (!entries.is_open()) {
        cerr << "Could not open file "
          << "FahrenheitTemperature.txt" << endl;
        return -1;
    }

    // Enumerate input file for conversions
    do {
        entries >> city;
        entries >> tempF;
        double conversion = fahrenheitToCelsius(tempF);
        
        writeOutput(city, tempF, conversion);
        entries.ignore();
        entries.clear();
        getline(entries, city);
    } while (entries);
    
    entries.close();
    return 0;
}

/* Function to convert a temperature inputed as
 *   fahrenheit to celsius.
 * @param fahrenheit - the fahrenheit input
 * @returns the fahrenheit converted to celsius
 */
double fahrenheitToCelsius(double fahrenheit) {
    return (5.0 / 9.0) * (fahrenheit - 32.0);
}

/* Function to write the results of conversion
 *   to an output file
 * @param city - the conversion output to write
 * @param fahrenheit - integer of converted unit
 * @param celsius - integer of measure pre-conversion
 * @returns an code where "0" indicates successful
 *   execution and "-1" indicates failure.
 */
int writeOutput(string city, int fahrenheit, int celsius) {
    ofstream newEntries;
    newEntries.open("CelsiusTemperature.txt", ios::app); // See [3]
    
    if (!newEntries.is_open()) {
        cerr << "Could not open file " 
          << "CelsiusTemperature.txt" << endl;
        return -1;
    }
    
    cout << setprecision(4) << city << " " << fahrenheit
      << " " << celsius << endl; // See [2]
    newEntries << setprecision(4) << city << " "
      << fahrenheit << " " << celsius << endl; // See [2]
    
    newEntries.close();
    return 0;
}

/* Endnotes:
 * [1] I referenced this tutorial when writing this code in general: "How to
 *   Read From a File in C++"; Retrieved on May. 31, 2023 from: 
 *   https://www.udacity.com/blog/2021/05/how-to-read-from-a-file-in-cpp.html
 * [2] I referenced this tutorial when figuring out how to round numbers
 *   (Retrieved on May. 31, 2023 from): 
 *   https://www.programiz.com/cpp-programming/float-double
 * [3] I referenced the following tutorial when learning to append to a text
 *   file rather than overwriting it (Retrieved on Jun. 1, 2023 from):
 *   https://www.geeksforgeeks.org/cpp-program-to-append-a-string-in-an-existing-file/
 */

