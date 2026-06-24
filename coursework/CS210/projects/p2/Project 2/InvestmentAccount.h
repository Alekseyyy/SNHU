#pragma once

#include <string>
#include <iostream>

class InvestmentAccount
{

public:
	InvestmentAccount(double initialAmount, double annualInterestRate); //monthlyDeposit is 0!
	InvestmentAccount(double initialAmount, double annualInterestRate, double monthlyDeposit);

	double getEndingBalance(int numberOfYears);  //Calculate the ending balance after number of years
	// Use www.calculators.org/savings/monthly.php to test values
	double getInterestEarned(int numberOfYears); //Calculate the interest earned for number of years

	std::string getEndingBalanceFormatted(int numberOfYears);	//Use format and round to get the ending balance as a decimal to 2 places
	std::string getInterestEarnedFormatted(int numberOfYears);  //Use format and round to get the ending balance as a decimal to 2 places

	double getInitialAmount();
	double getMonthlyDeposit();
	double getAnnualInterestRate();

	double round(double value, int places);
	std::string format(double value);


private:
	double initialAmount;
	double monthlyDeposit;
	double annualInterestRate;

	double endingBalance;
	double interestEarned;

	void calculateInvestment(int numberOfYears); //set the calculations
};

