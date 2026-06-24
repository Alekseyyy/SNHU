#ifndef ITEM_TO_PURCHASE_H
#define ITEM_TO_PURCHASE_H

#include <string>
using namespace std;

class ItemToPurchase {
   public:
      void SetName(string);
      string GetName();
      void SetPrice(int);
      int GetPrice();
      void SetQuantity(int);
      int GetQuantity();
   private:
      string itemName;
      int itemPrice;
      int itemQuantity;
};

#endif

