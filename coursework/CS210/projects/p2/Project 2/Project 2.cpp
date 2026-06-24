#include <iostream>
#include <iomanip>
#include <algorithm>
#include <vector>
#include "InvestmentAccount.h"

using namespace std;

//Main Class function prototypes
double handleInput(string);
string stripCharacters(string input);
void printWelcome();
void displayOutput(InvestmentAccount account, int numberOfYears, string label);

// Input prototypes
double initialInvestment;
double monthlyDeposit;
double annualInterest;
double numberOfYears;

int main()
{
    //Print a welcome message
    printWelcome();
    
    //Get the input
    initialInvestment = handleInput("Initial Investment Amount");
    monthlyDeposit = handleInput("Monthly Deposit");
    annualInterest = handleInput("Annual Interest");
    numberOfYears = static_cast<int>(handleInput("Number of years"));
    
    // Add a breakline
    cout << endl;

    //Create two InvestmentAccount variables...one with monthly deposit and one without monthly deposit
    InvestmentAccount investment(initialInvestment, annualInterest);
    InvestmentAccount investmentMonthly(initialInvestment, annualInterest, monthlyDeposit);

    //Display the output for each investment account
    displayOutput(investment, numberOfYears, "Balance and Interest Without Additional Monthly Deposits");
    displayOutput(investmentMonthly, numberOfYears, "Balance and Interest With Additional Monthly Deposits");

    //Pause until user enters key to exit
    system("PAUSE");

    return 0;
}

/*
* This function will take in an input from console and
*   then check to see if it is a double that is above
*   0.0; in the case that it is not, it will ask for an
*   input until the criteria is met
* @param prompt - what kind of information to gather from user
* @returns a double provided that the criteria is met
*/
double handleInput(string prompt) {
    double input;
    bool done = false;
    while (!done) {
        try {
            string rawInput;
            cout << prompt << ": ";
            cin >> rawInput;
            cin.clear();
            rawInput = stripCharacters(rawInput);
            input = stod(rawInput);
            if (input >= 0.0)
                done = true;
            else
                cout << "Invalid input (must be greater than"
                  << " or equal to 0).Try again." << endl;
        }
        catch (invalid_argument& error) {
            cerr << error.what() << endl;
            continue;
        }
    }
    return input;
}

/*
* Simple function to strip the values '$', '%', and ' ' from
*   a given string
* @param input - what string to strip the characters from
* @returns - a string with the characters stripped
*/
string stripCharacters(string input) {
    // I referenced [3] when writing this function
    char targetCharacters[] = { '$', '%', ' ' };
    for (int counter = 0; counter < sizeof(targetCharacters); counter++)
        input.erase(
            remove(
                input.begin(), input.end(), targetCharacters[counter]
            ), input.end()
        );
    return input;
}

// This function simply prints a welcome message
void printWelcome() {
    cout << "" << setfill('*') << setw(100) << "" << endl;
    cout << "*" << setfill(' ') << setw(66)
        << "A simple interest rate calculator"
        << setfill(' ') << setw(33) << "*" << endl;
    cout << "* " << setfill(' ') << setw(70)
        << "By Alexander Ahmann <alexander.ahmann@snhu.edu>"
        << setfill(' ') << setw(28) << " *" << endl;
    cout << setfill('*') << setw(100) << "" << endl << endl;
}

/*
* Function takes an instance of the "InvestmentAccount" class  
*   class and prints out its calculations to terminal.
* @param account - the instance of "InvestmentAccount"
* @param numberOfYears - the number of years that the initial
*    amount will stay in the account to get interest
* @param label - a title for the table
*/
void displayOutput(InvestmentAccount account, int numberOfYears, string label) {
    // I referenced [6] when developing this function
    cout << setfill('=') << setw(label.size() + 5) << "\n";
    cout << "= " << label << " =" << endl;
    cout << setfill('=') << setw(label.size() + 6) << "\n\n";
    cout << setfill(' ') << setw(2) << "Year" << setfill(' ') << setw(30)
        << "Year End Balance" << setfill(' ') << setw(30) << "Year End Earned Interest" << "\n";

    for (int year = 1; year <= numberOfYears; year++) {
        string currentEndingBalance = account.getEndingBalanceFormatted(year);
        string currentInterestRate = account.getInterestEarnedFormatted(year);
        cout << setfill(' ') << setw(2) << fixed << year
            << setw(25) << fixed << "$" << currentEndingBalance
            << setw(25) << fixed << "$" << currentInterestRate << endl;
    }
    cout << "\n\n";
}

/* 
* Endnotes
* [1] I referenced the following StackOverflow thread to diffentiate between C and C++ casting: Retrieved
*   on May. 23, 2023 from: https://stackoverflow.com/questions/32168/c-cast-syntax-styles
* [2] I referenced the following article for exception handling for C++: Retrieved on May. 23, 2023 from:
*   https://learn.microsoft.com/en-us/cpp/cpp/errors-and-exception-handling-modern-cpp?view=msvc-170
* [3] I referenced the following article for stripping "special" characters with C++: Retrieved on May. 23, 2023
*   from: https://stackoverflow.com/questions/5891610/how-to-remove-certain-characters-from-a-string-in-c
* [4] I referenced the following article when implementing the compounded interest. Retrieved on Jun. 3, 2023 from:
*   https://www.calculatorsoup.com/calculators/financial/compound-interest-calculator.php
* [5] Personal communications with Matthew Parker. Specifically, we discussed the implementation of calculating the
*   interest earned and the ending balance given the number of years that the initial amount is getting interest.
* [6] I referenced the following article when writing displayOutput: Referenced on Jun. 5, 2023 from:
*   https://www.cppstories.com/2023/fun-print-tables-format/
*/
