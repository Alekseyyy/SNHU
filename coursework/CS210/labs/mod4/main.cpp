#include <iostream>
using namespace std;

#include "ItemToPurchase.h"

void SetItem(int itemNumber, ItemToPurchase& item) {
   string itemName;
   int itemPrice;
   int itemQuantity;
      
   cout << "Item " << itemNumber << endl;
   cout << "Enter the item name:" << endl;
   getline(cin, itemName);
   cout << "Enter the item price:" << endl;
   cin >> itemPrice;
   cout << "Enter the item quantity:" << endl;
   cin >> itemQuantity;
   cout << endl;
   
   item.SetName(itemName);
   item.SetPrice(itemPrice);
   item.SetQuantity(itemQuantity);
   
   cin.ignore();
}

int main() {
   
   ItemToPurchase item1;
   SetItem(1, item1);
   ItemToPurchase item2;
   SetItem(2, item2);
   
   cout << "TOTAL COST" << endl;
   int totalItem1 = item1.GetQuantity() * item1.GetPrice();
   cout << item1.GetName() << " " << item1.GetQuantity() << " @ $"
      << item1.GetPrice() << " = $" << totalItem1 << endl;
   int totalItem2 = item2.GetQuantity() * item2.GetPrice();
   cout << item2.GetName() << " " << item2.GetQuantity() << " @ $"
      << item2.GetPrice() << " = $" << totalItem2 << endl << endl;
      
   cout << "Total: $" << (totalItem1 + totalItem2) << endl;
   
   return 0;
}

/* Endnotes
 * [1] I referenced the following tutorial on pass by reference when I forgot the syntax: 
       https://www.ibm.com/docs/en/zos/2.4.0?topic=calls-pass-by-reference-c-only
   [2] I referenced the following tutorial on getting user input when writing the "SetItem"
       function: https://www.udacity.com/blog/2021/07/how-to-get-user-input-in-cpp.html
   [3] I referenced the following tutorial when (trying to) implement operator overloading
       notions: https://www.youtube.com/watch?v=ZcmQ5y7QyTc
   [4] I referenced the following tutorial when (trying to) implement operator overloading
       notions: https://www.youtube.com/watch?v=PgGhEovFhd0
 */
