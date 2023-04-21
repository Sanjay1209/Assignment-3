import java.util.Scanner;

import java.util.Random;
/*
 program prompts the user to enter the names of three players, generates a random number between 1 and 10, 
 asks each player to guess the number, calculates the difference between each player's guess and 
 the actual number, determines the winner with the smallest difference, and
  allows the user to play again or exit the game.
 */

public class GuesserGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        

        // Welcome message
        System.out.println("Welcome to the Guesser Game!");
        System.out.println("In this game, three players will take turns guessing a random number between 1 and 10.");
        System.out.println("The player who guesses closest to the actual number wins!");
        

        // Get player names

        System.out.print("Enter Player 1 name: ");
        String player1Name = scanner.nextLine();

        System.out.print("Enter Player 2 name: ");
        String player2Name = scanner.nextLine();
        
        System.out.print("Enter Player 3 name: ");
        String player3Name = scanner.nextLine();
        
        // Game loop
        boolean continuePlaying = true;
        while (continuePlaying) {

            // Generate random number
            int actualNumber = random.nextInt(9) + 1;
            

            // Get player guesses
            System.out.println("\nThe actual number is between 1 and 10. Players, make your guesses!");
            System.out.print(player1Name + ", enter your guess: ");
            int player1Guess = scanner.nextInt();
            System.out.print(player2Name + ", enter your guess: ");
            int player2Guess = scanner.nextInt();
            System.out.print(player3Name + ", enter your guess: ");
            int player3Guess = scanner.nextInt();
            

            // Calculate differences
            int player1Diff = Math.abs(player1Guess - actualNumber);
            int player2Diff = Math.abs(player2Guess - actualNumber);
            int player3Diff = Math.abs(player3Guess - actualNumber);
            

            // Determine winner
            String winnerName;
            int winnerDiff;
            if (player1Diff < player2Diff && player1Diff < player3Diff) {
                winnerName = player1Name;
                winnerDiff = player1Diff;
            } else if (player2Diff < player1Diff && player2Diff < player3Diff) {
                winnerName = player2Name;
                winnerDiff = player2Diff;
            } else {
                winnerName = player3Name;
                winnerDiff = player3Diff;
            }
            

            // Display results
            System.out.println("\nThe actual number was " + actualNumber);
            System.out.println(player1Name + " guessed " + player1Guess + " (difference of " + player1Diff + ")");
            System.out.println(player2Name + " guessed " + player2Guess + " (difference of " + player2Diff + ")");
            System.out.println(player3Name + " guessed " + player3Guess + " (difference of " + player3Diff + ")");
            System.out.println(winnerName + " wins with a difference of " + winnerDiff + "!");
            

            // Ask user if they want to play again
            System.out.print("\nDo you want to play again? (y/n): ");
            String playAgain = scanner.next();
            continuePlaying = playAgain.equalsIgnoreCase("y");
        }

        // Goodbye message
        System.out.println("Thanks for playing the Guesser Game!");
        scanner.close();
    }

}