/* Source.cpp: This file contains the 'main' function.
 *   Program execution begins and ends there.
 * By Alexander Ahmann <alexander.ahmann@snhu.edu>
*/

#include <iostream>
#include <string>
#include <set>
#include <fstream>
#include <iomanip>

#include "GroceryItem.h"
using namespace std;

void PrintWelcome();
int HandleInput(string prompt);
void PrintHistogram(set<GroceryItem> dataSet);
set<GroceryItem> ReadInventory(string input);

/* Main Logic */
int main() {
    PrintWelcome();
    bool done = false;
    while (!done) {
        set<GroceryItem> items;
        try {
            items = ReadInventory("inventory.txt");
        }
        catch (exception except) {
            cerr << except.what() << endl;
            done = true;
            break;
        }

        int option = HandleInput("Option selection");
        if (option == 1) {
            string query;
            cout << "What to search for? ";
            cin >> query;
            cin.ignore();
            cin.clear();
            for (GroceryItem item : items) {
                if (item.getName() == query)
                    cout << "Item " << item.getName() << " has a frequency of "
                    << item.getQuantity() << "." << endl;
            }
            cout << "\n";
        }
        else if (option == 2) {
            cout << "Item,Frequency" << endl;
            for (GroceryItem item : items)
                cout << item.getName() << "," << item.getQuantity() << endl;
            cout << "\n";
        }
        else if (option == 3)
            PrintHistogram(items);
        else if (option == 4) {
            done = true;
            break;
        }
    }

    return 0;
}

// This function simply prints a welcome message
void PrintWelcome() {
    cout << "" << setfill('*') << setw(100) << "" << endl;
    cout << "*" << setfill(' ') << setw(66)
        << "A simple Grocery Item \"accounting\" tool"
        << setfill(' ') << setw(33) << "*" << endl;
    cout << "* " << setfill(' ') << setw(70)
        << "By Alexander Ahmann <alexander.ahmann@snhu.edu>"
        << setfill(' ') << setw(28) << " *" << endl;
    cout << setfill('*') << setw(100) << "" << endl;
    cout << "Programme options: " << endl;
    cout << "1. Search for an item." << endl;
    cout << "2. Display all frequencies." << endl;
    cout << "3. Print frequency distribution." << endl;
    cout << "4. Exit." << endl << endl;
}

/*
* This function will take in an input from console and
*   then check to see if it an integer between 1 and 4.
* @param prompt - what kind of information to gather from user
* @returns an integer provided that the criteria is met
*/
int HandleInput(string prompt) {
    int input;
    bool done = false;
    while (!done) {
        try {
            string rawInput;
            cout << prompt << ": ";
            cin >> rawInput;
            cin.clear();
            input = stoi(rawInput); // See [9]
            if (input >= 1 && input <= 4)
                done = true;
            else
                cout << "Invalid input (must be an integer"
                    << " between 1 and 4).Try again." << endl;
        }
        catch (invalid_argument& error) {
            cerr << error.what() << endl;
            continue;
        }
    }
    return input;
}

/*
 * This function will print out a histogram based on
 *   the GroceryItems dataset onto console.
 * @param dataset - a set of GroceryItem classes
 *   containing the item data & frequencies
*/
void PrintHistogram(set<GroceryItem> dataSet) {
    cout << "Grocery Items Histogram" << endl << endl;
    for (GroceryItem item : dataSet) {
        cout << item.getName() << ": ";
        for (int i = 1; i <= item.getQuantity(); i++)
            cout << "*";
        cout << "\n";
    }
    cout << "\n";
}

/*
 * Function to return a set of "GroceryItems" instances given some
 *   text file of their listings. It tallies up each listing of the
 *   item and returns a set of them and their respective frequencies.
 * @param input - the text file of the grocery items
 * @returns a set<GroceryItem> where GroceryItem is something of a 
 *   pseudo-struct that contains the properties of an item and its
 *   respective frequency.
 */
set<GroceryItem> ReadInventory(string input) {

    set<GroceryItem> items; //Create the set pointer; see [1]

    //Read the items from the file
    ifstream inventory;
    try {
        inventory.open(input);
        if (!inventory.is_open())
            throw invalid_argument("Could not open " + input);
    } catch (invalid_argument& error) {
        cerr << error.what() << endl;
    }

    do {
        string toInsert;
        inventory >> toInsert;

        //Set Logic
        if (toInsert != "") {
            GroceryItem* item = new GroceryItem(toInsert);
            auto existingItem = items.find(*item);
            if (existingItem != items.end()) {
                string name = existingItem->getName();
                int quantity = existingItem->getQuantity();
                items.erase(existingItem); // See [6][8]
                item = new GroceryItem(name, quantity);
            }
            item->addItem();
            items.insert(*item);
        }
        //End Set Logic

        inventory.ignore();
        inventory.clear();
        getline(inventory, toInsert);
    } while (inventory);

    //Backup the accumulated data to frequency.dat
    ofstream frequency;
    frequency.open("frequency.dat");

    if (!frequency.is_open())
        throw invalid_argument("Could not write to frequency.dat");

    for (GroceryItem item : items)
        frequency << item.getName() << "," << item.getQuantity() << endl;
    frequency.close();

    return items;
}

/*
* Endnotes
* [1] I referenced this article when learning how to declare sets (Retrieved Jun. 17, 2023
*   from): https://cplusplus.com/reference/set/set/
* [2] I referenced a previous project when recalling how to work with File I/O methods.
* [3] I referenced this article when implementing a means to throw an exception (Retrieved
*   on Jun. 19, 2023 from): https://rollbar.com/blog/error-exceptions-in-c/
* [4] I referenced this article in my attempt to recall how pass by reference works in C++
*   (Retrieved on Jun. 19, 2023 from): https://linuxhint.com/pass-string-reference-cpp/
* [5] I referenced this article when learning how to insert objects to a set (Retrieved on
*   Jun. 19, 2023 from): https://www.tutorialspoint.com/set-insert-in-cplusplus-stl
* [6] I referenced this article when learning how to delete objects from a set (Retrieved
*   on Jun. 19, 2023 from):
*   https://www.geeksforgeeks.org/how-to-delete-an-element-from-the-set-by-passing-its-value-in-c/
* [7] When implementing GroceryItems, I referenced the following article (Retrieved on
*   Jun. 19, 2023 from): https://www.techiedelight.com/use-object-key-stdset-cpp/
* [8] When implementing GroceryItems, I referenced the following article (Retrieved on
*   Jun. 19, 2023 from): https://www.techiedelight.com/remove-elements-set-cpp/
* [9] I referenced the following article when converting strings to integers (Retrieved on
*   Jun. 20, 2023 from): 
*   https://www.freecodecamp.org/news/string-to-int-in-c-how-to-convert-a-string-to-an-integer-example/
*/
