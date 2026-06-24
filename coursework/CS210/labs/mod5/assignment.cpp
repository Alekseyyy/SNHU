
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
#include <vector>

using namespace std;

double fahrenheitToCelsius(double);
bool writeOutput(vector<string>&, vector<double>&, vector<double>&);

int main() {
    ifstream entries;
    
    vector<string> cities;
    vector<double> fahrenheits;
    vector<double> conversions;
    
    // Try to open the file for conversion inputs
    entries.open("FahrenheitTemperature.txt");
    if (!entries.is_open()) {
        cerr << "Could not open file "
          << "FahrenheitTemperature.txt" << endl;
        return -1;
    }

    /* Enumerate input file for things to convert.
     * Specifically, push them into vectors: */
    do {
        /* Declare string and double to hold inputs for
         the current city and fahrenheit and parse them */
        string city;
        double fahrenheit;
        entries >> city;
        entries >> fahrenheit;
        
        // Convert current fahrenheit to celsius
        double conversion = fahrenheitToCelsius(fahrenheit);
        
        // Push the calculations into the vectors for writing
        cities.push_back(city);
        fahrenheits.push_back(fahrenheit);
        conversions.push_back(conversion);
        
        // Clear the buffer and "make way" for new inputs.
        entries.ignore();
        entries.clear();
        getline(entries, city);
    } while (entries);
    
    entries.close();
    
    /* Now, proceed to write the inputs from FahrenheitTemperature.txt
     * to CelsiusTemperature.txt and their respective conversions */
    bool writeFile = writeOutput(cities, fahrenheits, conversions);
    if (!writeFile)
        cerr << "The conversion values failed to write to file.";
    
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

/* Function to write data to a new file called
 *   "CelsiusTemperature.txt" and output it to
 *   the terminal
 * @param t - vector of cities to write to file passed by reference.
 * @param f - vector of city's respective fahrenheit passed by reference.
 * @param c - vector of city's respective celsius passed by reference. 
 * @returns a "0" if successful and "-1" if not successful.
 */
bool writeOutput(vector<string>& t, vector<double>& f, vector<double>& c) {
    
    ofstream newEntries; 
    newEntries.open("CelsiusTemperature.txt"); //See [3][4]
    
    if (!newEntries.is_open()) {
        cerr << "Could not open file " << 
          "CelsiusTemperature.txt" << endl;
        return false;
    }
    
    for (int counter = 0; counter < t.size(); counter++) {
      cout << setprecision(4) << t[counter] << " " << f[counter]
        << " " << c[counter] << endl; // See [2]
      newEntries << setprecision(4) << t[counter] << " "
        << f[counter] << " " << c[counter] << endl; // See [2]
    }
    
    newEntries.close();
    return true;
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
 * [4] Initially, I had this tool write to the target file for each time a conversion
 *   was made. I later changed this to write all conversions to the target file at once.
 */

