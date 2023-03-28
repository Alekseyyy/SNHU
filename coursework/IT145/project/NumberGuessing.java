
/**
 * Classic game that challenges the user to guess the random number
 * By Alexander Ahmann <alexander.ahmann@snhu.edu>
 */

import java.util.*;

public class NumberGuessing {

  /**
   * Function to print a welcome message into the terminal
   */
  public static void printMessage() {
    System.out.println("=======================================");
    System.out.println("= Simple random number generator game =");
    System.out.println("=         By Alexander Ahmann         =");
    System.out.println("=======================================");
    System.out.println("\nI am thinking of a number between 1 and 100");
    System.out.println("Can you guess what it is?\n");
  }

  /**
   * The Main Logic of the Numbers Guessing Game
   */
  public static void main(String[] args) {

    // Declaring the classes with the functionality needed by the game
    Random random = new Random(); // for random number generation
    Scanner inputMechanism = new Scanner(System.in); // for

    printMessage(); // Print the welcome message

    int magicNumber = random.nextInt(99) + 1; // The target random number that the user has to guess
    int countGuesses = 0; // The numbers of guesses that it took for the user to guess the magicNumber

    boolean done = false; // the state of the game's while loop

    /**
     * This is the while loop for the game. It asks for an input and will
     * break if the user can input a number that matches the magicNumber.
     */
    while (!done) {
      /**
       * After some rudimentary testing, I added a try-catch exception
       * handling mechanism to handle bad inputs regarding guessing.
       */
      try {
        System.out.print("Guess: "); // asking for the user's guess
        int inputGuess = inputMechanism.nextInt(); // parse the user's input as an integer
        countGuesses++; // increment the countGuesses by 1

        /**
         * This conditional compares the user's guess (inputGuess) and the
         * magicNumber. The game ends if inputGuess equals magicNumber.
         */
        if (inputGuess == magicNumber) {
          System.out.printf("Correct! The random number is %d. It took you %d guesses to guess the random number!\n",
              magicNumber, countGuesses); // Congratulate the user for correctly guessing the magicNumber
          inputMechanism.close(); // "Cleanup" by closing the Scanner class.
          done = true; // Break the loop.
        } else if (inputGuess > magicNumber)
          System.out.println("Your guess is greater than what I'm thinking."); // Incorrect guess because the input is
                                                                               // larger than the magicNumber, inform
                                                                               // the user that the number is too big.
        else if (inputGuess < magicNumber)
          System.out.println("Your guess is less than what I'm thinking."); // Incorrect guess because the input is
                                                                            // smaller than the magicNumber, inform the
                                                                            // user that the number is too small.
        else
          continue; // this should not execute
      }
      /**
       * Print out an error message in the case of a bad input
       */
      catch (InputMismatchException ex) {
        System.out.println("Input is not a valid number."); // prints error message
        inputMechanism.nextLine(); // empty out the input buffer
      }
    }
  }
}

