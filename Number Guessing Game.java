import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * A simple console-based number guessing game.
 * The game generates a random number between 1 and 100, and the user
 * has a limited number of attempts (10) to guess it.
 */
public class NumberGuessingGame {

    public static void main(String[] args) {
        // Initialize Scanner to read user input
        // We use a try-with-resources statement to ensure the scanner is closed automatically
        try (Scanner scanner = new Scanner(System.in)) {
            // Initialize Random object to generate random numbers
            Random random = new Random();
            
            // String to control if the user wants to play again
            String playAgain;

            System.out.println("======================================");
            System.out.println("   Welcome to the Number Guessing Game! ");
            System.out.println("======================================");

            // Main game loop, continues as long as the user wants to play again
            do {
                // --- Game Setup ---
                int numberToGuess = random.nextInt(100) + 1; // Generates a random number between 1 and 100
                int numberOfAttempts = 0;
                final int MAX_ATTEMPTS = 10; // Constant for the maximum number of allowed guesses
                boolean hasGuessedCorrectly = false;

                System.out.println("\nI have generated a random number between 1 and 100.");
                System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");
                System.out.println("--------------------------------------");

                // Loop for a single game round (max 10 attempts)
                while (numberOfAttempts < MAX_ATTEMPTS) {
                    System.out.print("Attempt " + (numberOfAttempts + 1) + "/" + MAX_ATTEMPTS + ": Enter your guess: ");
                    
                    int userGuess;

                    // --- Input Validation ---
                    try {
                        userGuess = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        // If user enters something that's not an integer
                        System.out.println("Invalid input. Please enter a whole number.");
                        scanner.next(); // Clear the invalid input from the scanner
                        continue; // Skip the rest of the loop and ask for input again
                    }

                    // Increment the attempt counter
                    numberOfAttempts++;

                    // --- Game Logic ---
                    if (userGuess < 1 || userGuess > 100) {
                        System.out.println("Your guess is out of range (1-100). Try again.");
                    } else if (userGuess < numberToGuess) {
                        System.out.println("Too low! Try a higher number.");
                    } else if (userGuess > numberToGuess) {
                        System.out.println("Too high! Try a lower number.");
                    } else {
                        // Correct guess
                        hasGuessedCorrectly = true;
                        System.out.println("\n*************************************************");
                        System.out.println("Congratulations! You guessed the number!");
                        System.out.println("It took you " + numberOfAttempts + " attempts.");
                        System.out.println("*************************************************");
                        break; // Exit the game loop (while)
                    }
                } // End of single game loop

                // --- Game Over ---
                // If the loop finishes and the user hasn't guessed correctly, they've lost
                if (!hasGuessedCorrectly) {
                    System.out.println("\n--------------------------------------");
                    System.out.println("Game over! You've used all " + MAX_ATTEMPTS + " attempts.");
                    System.out.println("The correct number was: " + numberToGuess);
                    System.out.println("--------------------------------------");
                }

                // --- Play Again Prompt ---
                System.out.print("\nDo you want to play again? (yes/no): ");
                playAgain = scanner.next();
                
                // Clear the newline character left in the scanner
                scanner.nextLine(); 

            } while (playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("y"));
            
            System.out.println("\nThank you for playing! Goodbye.");

        } // The Scanner is automatically closed here
    }
}
