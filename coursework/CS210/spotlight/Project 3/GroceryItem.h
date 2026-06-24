#pragma once

#include <iostream>
#include <string>

class GroceryItem
{
	public:
		GroceryItem(std::string& name);
		GroceryItem(std::string& name, int quantity);

		std::string getName() const;
		int getQuantity() const;

		void addItem();
		void removeItem();

		bool operator<(const GroceryItem& other) const;

	private:
		std::string name;
		int quantity;
};
