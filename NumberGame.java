import java.util.*;


public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int attempts = 5; // Number of attempts allowed
            int numberToGuess = random.nextInt(100) + 1; // Generate random number between 1 and 100
            boolean guessedCorrectly = false;

            System.out.println("\nA random number between 1 and 100 has been generated. You have " + attempts + " attempts to guess it.");

            for (int i = 0; i < attempts; i++) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                System.out.println("Attempts remaining: " + (attempts - i - 1));
            }

            if (!guessedCorrectly) {
                System.out.println("You've run out of attempts. The correct number was: " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("\nGame Over. Your final score: " + score);
        scanner.close();
    }
}
