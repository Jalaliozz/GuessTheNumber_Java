import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int wins = 0;
        int guessesTotal = 0;
        int guessesTaken = 0;

        System.out.print("Play (y/n?): ");
        String choice = input.nextLine();

        while (true) {
            if (choice.equalsIgnoreCase("n")) {
                System.out.println("See you again next time!");
                break;
            } else if (choice.equalsIgnoreCase("y")) {
                int randomNumber = random.nextInt(10) + 1;
                for (guessesTaken = 0; guessesTaken < 5; guessesTaken++) {
                    int playerGuess;
                    while (true) {
                        try {
                            System.out.print("\tEnter an integer from 1 to 10: ");
                            playerGuess = Integer.parseInt(input.nextLine());
                            if (playerGuess < 1 || playerGuess > 10) {
                                System.out.println("\t\tPlease enter a valid integer between 1 and 10.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("\t\tPlease enter a valid integer.");
                        }
                    }
                    
                    if (playerGuess == randomNumber) {
                        System.out.println("\t\tCongratulations! You guessed right in " + (guessesTaken + 1) + " tries for this round.");
                        wins++;
                        guessesTotal += (guessesTaken + 1);
                        break;
                    } else {
                        System.out.println("\t\tIncorrect. Please guess again.");
                    }
                }
            } else {
                System.out.print("\tPlease input y or n: ");
            }
            System.out.print("Play again? (y/n): ");
            choice = input.nextLine();
        }

        System.out.println("\tTotal guesses: " + guessesTotal);
        System.out.println("\tTotal wins: " + wins);
        if (guessesTotal > 0) {
            System.out.println("\tSuccess rate: " + String.format("%.2f", (wins * 100.0 / guessesTotal)) + "%");
        }
    }
}
