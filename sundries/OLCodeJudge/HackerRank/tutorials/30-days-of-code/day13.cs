/*
 * Tutorial: 30 Days of Code.
 * A solution to "Day 13: Abstract Classes"
 *   Submitted by A. S. "Aleksey" Ahmann <alekseyyy2@outlook.com>
 *   Submitted circa 2017
 *   Link: https://www.hackerrank.com/challenges/30-abstract-classes/problem
 * 
 * Task description:
 *   Given a Book class and a Solution class, write a MyBook class that does the following:
 *     * Inherits from Book
 *     * Has a parameterized constructor taking these 3 parameters: 
 *       1. string title;
 *       2. string author;
 *       3. int price;
 *     * Implements the Book class' abstract display() method so it prints these 3 lines:
 *       1. "Title: {title}"
 *       2. "Author: {author}"
 *       3. "Price: {price}"
 */

using System;
using System.Collections.Generic;
using System.IO;

abstract class Book
{
    
    protected String title;
    protected  String author;
    
    public Book(String t,String a){
        title=t;
        author=a;
    }
    public abstract void display();


}

//Write MyBook class

class MyBook : Book {
    
    private static int price;
    
    public MyBook(string inTitle, string inAuthor, int inPrice) : base(inTitle, inAuthor) {
        base.title = inTitle;
        base.author = inAuthor;
        MyBook.price = inPrice;
    }
    
    public override void display() {
        Console.WriteLine("Title: {0}", base.title);
        Console.WriteLine("Author: {0}", base.author);
        Console.WriteLine("Price: {0}", MyBook.price);
    }
}
class Solution {
    static void Main(String[] args) {
      String title=Console.ReadLine();
      String author=Console.ReadLine();
      int price=Int32.Parse(Console.ReadLine());
      Book new_novel=new MyBook(title,author,price);
      new_novel.display();
    }
}

