
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Create a Random object to generate random numbers
        Random rand = new Random();
        int randomNumber = rand.nextInt(100) + 1; // Generates a number between 1 and 100

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Initialize attempt counter and set the maximum number of attempts
        int attempts = 0;
        final int MAX_ATTEMPTS = 10;

        // Loop to allow multiple attempts
        while (attempts < MAX_ATTEMPTS) {
            // Prompt the user to guess the number
            System.out.print("Guess the number (between 1 and 100): ");
            int userGuess = scanner.nextInt();
            
            // Increment the attempt counter
            attempts++;
            
            // Compare the guess with the generated number and provide feedback
            if (userGuess < randomNumber) {
                System.out.println("Too low!");
            } else if (userGuess > randomNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break; // Exit the loop if the guess is correct
            }
        }
        
        // Check if the maximum attempts were reached without a correct guess
        if (attempts == MAX_ATTEMPTS) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The number was " + randomNumber);
        }
        
        // Close the scanner
        scanner.close();
    }
}
