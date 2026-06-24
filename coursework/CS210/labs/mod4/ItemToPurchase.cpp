#include <iostream>
using namespace std;

#include "ItemToPurchase.h"

void ItemToPurchase::SetName(string name) {
   itemName = name;
}

string ItemToPurchase::GetName() {
   return itemName;
}

void ItemToPurchase::SetPrice(int price) {
   itemPrice = price;
}

int ItemToPurchase::GetPrice() {
   return itemPrice;
}

void ItemToPurchase::SetQuantity(int quantity) {
   itemQuantity = quantity;
}

int ItemToPurchase::GetQuantity() {
   return itemQuantity;
}

