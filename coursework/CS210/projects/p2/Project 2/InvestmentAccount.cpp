#include "InvestmentAccount.h"

//Implementation for InvestmentAccount

/* Constructor for the InvestmentAccount class (no monthly deposit)
 * @param x - the initial amount
 * @param y - the annual interest rate
*/
InvestmentAccount::InvestmentAccount(double x, double y) {
	initialAmount = x;
	annualInterestRate = y;
	monthlyDeposit = 0.0;
}

/* Constructor for the InvestmentAccount class
 * @param x - the initial amount
 * @param y - the annual interest rate
 * @param z - the monthly deposit
*/
InvestmentAccount::InvestmentAccount(double x, double y, double z) {
	initialAmount = x;
	annualInterestRate = y;
	monthlyDeposit = z;
}

/*
* Function returns the resulting balance given number of years
* @param numberOfYears - the number of years that the principal stays in the account
* @returns a double numeric type of the ending balance after procured interest
*/
double InvestmentAccount::getEndingBalance(int numberOfYears) {
	calculateInvestment(numberOfYears);
	return endingBalance;
}

/*
* Function returns the interest of the investment
* @returns a double numeric type of the ending balance after procured interest
*/
double InvestmentAccount::getInterestEarned(int numberOfYears) {
	calculateInvestment(numberOfYears);
	return interestEarned;
}

/*
* Function sets the resulting balance given number of years
* @param numberOfYears - the number of years that the principal stays in the account
*/
void InvestmentAccount::calculateInvestment(int numberOfYears) {
	// I based this implementation in part from [4] and [5]
	endingBalance = initialAmount;
	double previousYearBalance = 0.0;

	for (int month = 1; month <= numberOfYears * 12; month++) {
		interestEarned = (endingBalance + monthlyDeposit) * ((annualInterestRate / 100.0) / 12.0);
		endingBalance += monthlyDeposit + interestEarned;
		if (month == (numberOfYears - 1) * 12)
			previousYearBalance = endingBalance;
	}

	if (numberOfYears == 1)
		interestEarned = endingBalance - initialAmount - (monthlyDeposit * 12);
	else
		interestEarned = endingBalance - previousYearBalance - (monthlyDeposit * 12);
 }

/*
* Function to get the ending balance after investment (string format)
* @param numberOfYears - number of years to compund the interest
* @returns a formatted ending balance
*/
std::string InvestmentAccount::getEndingBalanceFormatted(int numberOfYears) {
	return format(
		round(
			getEndingBalance(numberOfYears), 2)
	);
}

/*
* Function to get the final interest after investment (string format)
* @param numberOfYears - number of years to compund the interest
* @returns a formatted final interest
*/
std::string InvestmentAccount::getInterestEarnedFormatted(int numberOfYears) {
	return format(
		round(
			getInterestEarned(numberOfYears), 2)
	);
}

/* 
 * Return the initial amount
 * @returns the initial amount
 */
double InvestmentAccount::getInitialAmount() {
	return initialAmount;
}

/*
 * Return the monthly deposit
 * @returns the monthly deposit
 */
double InvestmentAccount::getMonthlyDeposit() {
	return monthlyDeposit;
}

/* 
 * Return the annual interest rate
 * @returns the annual interest rate
 */
double InvestmentAccount::getAnnualInterestRate() {
	return annualInterestRate;
}

/* 
 * Number rounding function
 * @param value - the value to round
 * @param places - the number of places to round
 * @returns - the rounded number
*/
double InvestmentAccount::round(double value, int places) {
	const int multiplier = pow(10, places);

	double roundedValue = (int)(value * multiplier + 0.5);
	roundedValue = (double)roundedValue / multiplier;
	return roundedValue;
}

/*
 * Formats a double value for output purposes.
 * @param value - the value to format
 * @returns - the formatted value.
*/
std::string InvestmentAccount::format(double value) {
	std::string valueAsString = std::to_string(value);
	std::string formatted;

	bool decimalFound = false;
	int decimalCount = 0;

	int i;
	for (i = 0; i < valueAsString.size(); i++) {
		char currentChar = valueAsString[i];
		if (decimalCount == 2)
			break;

		if (currentChar == '.') 
			decimalFound = true;
		else if (decimalFound && decimalCount != 2) 
			decimalCount++;

		formatted.append(std::string(1, currentChar));
	}

	return formatted;
}
