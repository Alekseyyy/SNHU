
#include "GroceryItem.h"

GroceryItem::GroceryItem(std::string& name) {
	this->name = name;
	this->quantity = 1;
}

GroceryItem::GroceryItem(std::string& name, int quantity) {
	this->name = name;
	this->quantity = quantity;
}

std::string GroceryItem::getName() const {
	return name;
}

int GroceryItem::getQuantity() const {
	return quantity;
}

void GroceryItem::addItem() {
	quantity++;
}

void GroceryItem::removeItem() {
	quantity--;
}

bool GroceryItem::operator<(const GroceryItem& other) const {
	return name.compare(other.getName()) < 0;
}
