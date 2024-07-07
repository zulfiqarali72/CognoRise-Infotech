import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("programming", "java", "hangman", "computer", "science");
        Random random = new Random();
        String wordToGuess = words.get(random.nextInt(words.size()));
        int wordLength = wordToGuess.length();
        char[] guessedWord = new char[wordLength];
        Arrays.fill(guessedWord, '_');

        int maxTries = 7;
        int wrongTries = 0;

        Scanner scanner = new Scanner(System.in);
        boolean wordGuessed = false;

        while (wrongTries < maxTries && !wordGuessed) {
            System.out.println("Current word: " + String.valueOf(guessedWord));
            System.out.print("Guess a letter: ");
            char guess = scanner.nextLine().charAt(0);

            if (wordToGuess.indexOf(guess) >= 0) {
                for (int i = 0; i < wordLength; i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedWord[i] = guess;
                    }
                }
            } else {
                wrongTries++;
                System.out.println("Wrong guess! Attempts left: " + (maxTries - wrongTries));
            }

            printHangman(wrongTries);
            wordGuessed = isWordGuessed(guessedWord);
        }

        if (wordGuessed) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you lost! The word was: " + wordToGuess);
        }
        scanner.close();
    }

    private static boolean isWordGuessed(char[] guessedWord) {
        for (char c : guessedWord) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    private static void printHangman(int wrongTries) {
        switch (wrongTries) {
            case 1:
                System.out.println(" O ");
                break;
            case 2:
                System.out.println(" O ");
                System.out.println(" | ");
                break;
            case 3:
                System.out.println(" O ");
                System.out.println("/| ");
                break;
            case 4:
                System.out.println(" O ");
                System.out.println("/|\\ ");
                break;
            case 5:
                System.out.println(" O ");
                System.out.println("/|\\ ");
                System.out.println("/  ");
                break;
            case 6:
                System.out.println(" O ");
                System.out.println("/|\\ ");
                System.out.println("/ \\ ");
                break;
            case 7:
                System.out.println(" O ");
                System.out.println("/|\\ ");
                System.out.println("/ \\ ");
                System.out.println("GAME OVER");
                break;
            default:
                break;
        }
    }
}
