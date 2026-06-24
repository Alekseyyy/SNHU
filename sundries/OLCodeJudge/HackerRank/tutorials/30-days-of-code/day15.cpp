/*
 * Tutorial: 30 Days of Code.
 * A solution to "Day 15: Linked List"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted on Feb. 28, 2024
 *   Link: https://www.hackerrank.com/challenges/30-linked-list/problem
 * 
 * Task description: Complete the insert function in your editor so that it creates a new Node (pass data as the Node constructor argument) and inserts it at the tail of the linked list referenced by the head parameter. Once the new node is added, return the reference to the node.
 *
 * Note: The head argument is null for an empty list. 
 *
*/

#include <iostream>
#include <cstddef>
using namespace std;	
class Node
{
    public:
        int data;
        Node *next;
        Node(int d){
            data=d;
            next=NULL;
        }
};
class Solution{
    public:

      Node* insert(Node *head,int data)
      {
        //Complete this method
        Node* n = new Node(data);
        if (head == NULL)
            head = new Node(data);
        else {
            Node* index = head;
            while (index->next != NULL)
                index = index->next;
            index->next = new Node(data);
        }
        return head;
      }

      void display(Node *head)
      {
          Node *start=head;
          while(start)
          {
              cout<<start->data<<" ";
              start=start->next;
          }
      }
};
int main()
{
	Node* head=NULL;
  	Solution mylist;
    int T,data;
    cin>>T;
    while(T-->0){
        cin>>data;
        head=mylist.insert(head,data);
    }	
	mylist.display(head);
		
}

