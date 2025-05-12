import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final int LOWER_BOUND = 1;
        final int UPPER_BOUND = 100;
        final int MAX_ATTEMPTS = 5;
        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        boolean playAgain;
        do {
            int targetNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.println("\n🎯 Round " + (roundsPlayed + 1) + ": Guess a number between " + LOWER_BOUND + " and " + UPPER_BOUND);

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (" + attemptsLeft + " attempts left): ");
                int guess;

                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input. Please enter a number.");
                    continue;
                }

                if (guess < targetNumber) {
                    System.out.println("📉 Too low!");
                } else if (guess > targetNumber) {
                    System.out.println("📈 Too high!");
                } else {
                    System.out.println("✅ Correct! You've guessed the number!");
                    guessedCorrectly = true;
                    totalScore += (MAX_ATTEMPTS - attemptsLeft + 1);
                    break;
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The correct number was " + targetNumber);
            }

            roundsPlayed++;
            System.out.println("📊 Current Score: " + totalScore);
            System.out.print("🔁 Do you want to play another round? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            playAgain = answer.equals("yes") || answer.equals("y");

        } while (playAgain);

        System.out.println("\n🏁 Game Over! You played " + roundsPlayed + " rounds. Final Score: " + totalScore);
        scanner.close();
    }
}
