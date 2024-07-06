import java.util.Scanner;
import java.util.Random;

public class numgame {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            int attempts = 0;
            int maxAttempts = 10; // you can set the maximum attempts here
            int numberToGuess = random.nextInt(100) + 1;
            boolean correctGuess = false;

            System.out.println("I have generated a number between 1 and 100. Try to guess it!");

            while (attempts < maxAttempts && !correctGuess) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    correctGuess = true;
                    System.out.println("Congratulations! You've guessed the correct number.");
                    totalScore += (maxAttempts - attempts + 1); // score based on remaining attempts
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, you've used all attempts. The number was: " + numberToGuess);
            }

            System.out.println("Your score for this round: " + (correctGuess ? (maxAttempts - attempts + 1) : 0));
            System.out.println("Your total score so far: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
