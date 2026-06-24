
#include <iostream>
#include <string>

using namespace std;

class ContactNode {
public:
   ContactNode(string cName = "", string cPhone = "", ContactNode* nAddress = nullptr);
   string GetName();
   string GetPhoneNumber();
   void InsertAfter(ContactNode* npNext);
   ContactNode* GetNext();
   void PrintContactNode(int count);
   
private:
   string contactName;
   string contactPhoneNumber;
   ContactNode* nextNodeAddress;
};

int main() {   
   ContactNode* head = nullptr;
   ContactNode* contactNode1 = nullptr;
   ContactNode* contactNode2 = nullptr;
   ContactNode* contactNode3 = nullptr;
   ContactNode* current = nullptr;
   
   head = new ContactNode();
   
   string getName1;
   getline(cin, getName1);
   string getContact1;
   getline(cin, getContact1);
   
   contactNode1 = new ContactNode(getName1, getContact1);
   head->InsertAfter(contactNode1);
   
   string getName2;
   getline(cin, getName2);
   string getContact2;
   getline(cin, getContact2);
   
   contactNode2 = new ContactNode(getName2, getContact2);
   contactNode1->InsertAfter(contactNode2);
   
   string getName3;
   getline(cin, getName3);
   string getContact3;
   getline(cin, getContact3);
   
   contactNode3 = new ContactNode(getName3, getContact3);
   contactNode2->InsertAfter(contactNode3);
   
   current = head;
   int count = 0;
   while (current != nullptr) {
      current->PrintContactNode(count);
      current = current->GetNext();
      count++;
   }
   
   cout << endl << "CONTACT LIST" << endl;
   
   current = contactNode1;
   while (current != nullptr) {
      cout << "Name: " << current->GetName() << endl;
      cout << "Phone number: " << current->GetPhoneNumber() << endl << endl;
      current = current->GetNext();
   }
   
   return 0;
}

/*
 * ContactNode constructor
 * This initialises a new node that is to be added to the Linked
 *   List.
 * @param cName - the contact's given name and surname
 * @param cPhone - the contact's phone number
 * @param nAddress - the memory address of the next node's address
 */
ContactNode::ContactNode(string cName, string cPhone, ContactNode* nAddress) {
   this->contactName = cName;
   this->contactPhoneNumber = cPhone;
   this->nextNodeAddress = nAddress;
}

/*
 * function GetName()
 * @returns the phone number stored in the string
 *   "contactName"
 */
string ContactNode::GetName() {
   return contactName;
}

/*
 * function GetPhoneNumber
 * @returns the phone number stored in the string
 *   "contactPhoneNumber"
 */
string ContactNode::GetPhoneNumber() {
   return contactPhoneNumber;
}

/*
 * function InsertAfter()
 * This function will insert a new contact into the Linked
 *   List
 * @param npNext - a ContactNode pointer that contains the
 *  address to point to the new node.
 */
void ContactNode::InsertAfter(ContactNode* npNext) {
   ContactNode* npNext_ = nullptr;
   npNext_ = this->nextNodeAddress;
   this->nextNodeAddress = npNext;
   npNext->nextNodeAddress = npNext_;
}

/*
 * function GetNext()
 * @returns the next node's memory address
 */
ContactNode* ContactNode::GetNext() {
   return this->nextNodeAddress;
}

/*
 * function PrintContactNode
 * This function takes the contactName and contactPhoneNumber
 *   of a node --- which is 
 * @param count - the current person on the list
 */
void ContactNode::PrintContactNode(int count) {
   if (contactName == "" || contactPhoneNumber == "")
      return;
   cout << "Person " << count << ": " << contactName
      << ", " << contactPhoneNumber << endl;
}

/*
 * Endnotes:
 * [1] I referenced the following article for a more abstract implementation of the Linked List (Retrieved on
 *   Jun. 15, 2023 from): https://realpython.com/linked-lists-python/
 * [2] I referenced the following YouTube presentation for an introduction to Linked Lists (Retrieved on Jun.
 *   15, 2023 from): https://www.youtube.com/watch?v=R9PTBwOzceo
 * [3] I referenced the following YouTube presentation for an introduction to Linked Lists (Retrieved on Jun.
 *   15, 2023 from): https://www.youtube.com/watch?v=WwfhLC16bis
 * [4] I referenced the following YouTube presentation for another introduction to Linked Lists (Retrieved on
 *   Jun. 15, 2023 from): https://www.youtube.com/watch?v=_jQhALI4ujg
 * [5] I referenced the following YouTube presentation for another introduction to Linked Lists (Retrieved on
 *   Jun. 15, 2023 from): https://www.youtube.com/watch?v=JlMyYuY1aXU
 * [6] I tried to avoid YouTube presentations of Linked Lists with C/C++/Java code, and stick to Python implementations or purely abstract discussions. I ultimately ended up referencing most of §10.5 from the programming languages textbook.
 */
