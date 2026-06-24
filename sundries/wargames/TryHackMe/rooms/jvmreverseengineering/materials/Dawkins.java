/*
 * An application to crack an XOR cipher using Dawkins' weasel
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - Githubs: https://github.com/Alekseyyy
 * - TryHackMe: https://tryhackme.com/p/EntropyThot
 *
 * Note that some parts of this programme are borrowed from o-
 * -ther sources. Most notably, the "xor" function that retur-
 * -ns a String is the result of decompiling the .class file
 * of TryHackMe's problem. P1's random string generator is ba-
 * -sed off of the following website:
 * - https://www.baeldung.com/java-random-string
 */

import java.io.*;
import java.util.*;

public class Dawkins {
   private static final String correctPassword = "aRa2lPT6A6gIqm4RE";

   public static void main(String[] args) {
      Random random = new Random();
      int counter = 1;
    
      char[] target = correctPassword.toCharArray();
      char[] solution = new char[target.length];

      System.out.println("==========================================================");
      System.out.println("= A crude, amateurish implementation of Dawkins'          ");
      System.out.println("= weasel to crack the TryHackMe XOR cipher                ");
      System.out.println("= By A. S. \"Aleksey\" Ahmann <hackermaneia@riseup.net>   ");
      System.out.println("= - https://github.com/Alekseyyy                          ");
      System.out.println("= - https://tryhackme.com/p/EntropyThot                   ");
      System.out.println("==========================================================\n");

      boolean done = false;
      while (!done) {
         // [P1] Generate random string (of course the length of random string should = correctPassword)
         // - this "seed" is based off of the following: https://www.baeldung.com/java-random-string
         char[] seed = random.ints(48, 123)
            .filter(k -> (k <= 57 || k >= 65) && (k <= 90 || k >= 97))
            .limit(target.length)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString().toCharArray(); 
         // [P2] Put the random string through the xor cipher, and split it into char array of course
         char[] nextGen = xor(new String(seed)).toCharArray();
         // [P3] Save the matching characters as "offspring"
         boolean emptySlots = false;
         for (int k = 0; k < solution.length; k++) {
            if (solution[k] != Character.MIN_VALUE) {
               continue;
            }
            else {
               emptySlots = true;
               if (nextGen[k] == target[k]) {
                  solution[k] = seed[k];
               }
            }
         }

         System.out.printf("Generation %d: %s\n", counter, new String(solution));
         counter++;
         if (!emptySlots) {
            done = true;
         }
      }

      System.out.printf("Solution: %s\n", new String(solution));
   }

   // From the decompile dump of "BasicStringObfuscation.class"
   private static String xor(String var0) {
      char[] var1 = var0.toCharArray();
      char[] var2 = new char[var1.length];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         char var4 = var1[var3];
         var2[var3] = (char)(var4 ^ var3 % 3);
      }

      return new String(var2);
   }
}

