
<img src="./images/banner.png" width="500px" />

This is a simple utility that reads the text file ``inventory.txt`` which contains a list of items that can be found in a grocery store. The utility then calculates the frequency of each item in real time, and then computes the frequency of each item based on the number of times it appears in ``inventory.txt``. It can then print out the frequency of any and all items in the list, and can also print a frequency histogram into command prompt.

## Usage

A simple [manual](./Manual.docx) was created to document the features of the utility.

<details>
<summary>Search for a specific item</summary>

<img src="./images/Figure_1.png" width="650px" />
</details>

<details>
<summary>Display all frequencies</summary>

<img src="./images/Figure_2.png" width="650px" />
</details>

<details>
<summary>Display a frequency distribution</summary>

<img src="./images/Figure_3.png" width="650px" />
</details>

### Compiling and executing

1. Download the contents of the ``spotlight`` directory and open it up in a file browser.
2. Make sure you have Visual Studio installed: open ``Project 3.sln``.
3. On the Viual Studio menu bar: go to ``Build`` > ``Build Solution`` (or do a ``Ctrl`` + ``Shift`` + ``B``).
4. On the file explorer, Navigate to ``x64/Debug`` and launch ``Project 3.exe``.

## Discussion

### Programme implementation

The following ``BASIC`` like pseudocode describes a high-level simplified version of my implementation:

```vbnet
PrintWelcome()
    
Set done = new Boolean
done = False
    
While Not Done
    Set items = New List(Of GroceryItems)
    Try
        items = ReadInventory("inventory.txt")
    Catch
        Print Error Message
        done = True
    End Try
        
    Set option_ = New HandleInput()
        
    If option == 1 Then
        Ask the user what to search for
        For Item in items:
            If option_.item() == What the User Wanted Then
                Print Item and its respective frequency
            End If
        End For
    Else If option == 2 Then
        For Item in items
            Print Item and its respective frequency
        End For
    Else If option == 3 Then
        For Item in Items
            Print Item's name (no new line)
            For K in Item.Quantity
                Print "*" (no new line)
            End For
            Print New Line
        End For
    Else If option == 4 Then
        done = True
    End If
End While
```

### Experience

I found the implementation of the ``ReadInventory`` function to be the most difficult because I was working with pointers (a notion that I have very little experience in). I was able to overcome the struggle by referencing many different resources online regarding the implementation of ``set``s, pointers and their interaction through an object-oritented design.

### Limitation

From the teacher's feedback, I notice a number of flaws:

* There is no documentation written for the end user. I have documented the utility's functionality for the programmer in the form of comments and decent coding style. But I did not think much of the _end user_, who is the ultimate justification for the making of my software utility.
* I should have used ``CONST`` variables when defining options for the users to choose.

I also noticed that, while looking through the ``Source.cpp`` file, I may have been redundant in how I implemented exception handling. In lines 144-151 of the ``set<GroceryItem> ReadInventory()`` function, I have implemented the following ``try-catch`` block:

```c++
try {
    inventory.open(input);
    if (!inventory.is_open())
        throw invalid_argument("Could not open " + input);
} catch (invalid_argument& error) {
    cerr << error.what() << endl;
}
```

However, it may have been superfulous since the ``try-catch`` block in lines 26-33 of the ``int main()`` function would catch any excpetions caused by children functions:

```c++
try {
    items = ReadInventory("inventory.txt");
}
catch (exception except) {
    cerr << except.what() << endl;
    done = true;
    break;
}
```

Eliminating this redundancy may make for better code maintainability.
