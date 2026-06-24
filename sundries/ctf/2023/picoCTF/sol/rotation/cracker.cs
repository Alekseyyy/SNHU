
// A "work in progress."
// Ported by A. S. "Aleksey" Ahmann

// Original implementation from: https://www.tutorialspoint.com/cryptography_with_python/cryptography_with_python_caesar_cipher.htm

using System;
using System.IO;

class Cracker {

    public static void Main(string[] args) {
        string alphabet = "abcdefghijklmnopqrstuvwxyz";
        string cryptogram = File.ReadAllText("encrypted.txt");
        cryptogram = cryptogram.Replace("\n", "");
        cryptogram = cryptogram.ToLower();
        
        foreach (char letter in alphabet) {
            string decrypted = "";
            foreach (char symbol in cryptogram) {
                if (cryptogram.Any(symbol => char.IsLetter(symbol))) {
                    int index = alphabet.IndexOf(symbol);
                    index = index - letter;
                    if (index < 0)
                        index += alphabet.length;
                    decrypted += alphabet[index];
                }
                else
                    decrypted += symbol;
            }
        }
        
        Console.WriteLine("Cryptogram: " + cryptogram);
    }
}
