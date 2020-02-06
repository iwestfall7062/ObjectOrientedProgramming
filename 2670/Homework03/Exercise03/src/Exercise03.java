//Write a program that allows the user to play Rock-paper-scissors-lizard-Spock
//(en.wikipedia.org/wiki/Rock-paper-scissors-lizard-Spock) against the computer. The user should be able to play as many
//games as they wish without restarting your program. The program should keep track of the score for the current session
//of the game and the overall total score for all sessions played. Think about how you can efficiently represent the
//rules for winning.

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Exercise03 {

    //constants
    private static Scanner KEYBOARD_INPUT = new Scanner(System.in);
    private static String INSTRUCTIONS = "Placeholder for instructions.";
    private static int COMPUTER_SCORE = 0;
    private static int PLAYER_SCORE = 0;

    public static void main(String[] arguments) {

        System.out.println(INSTRUCTIONS);

        boolean continuePlaying = true;

        do {

            System.out.print("\nRock = 1, Paper = 2, Scissors = 3, Spock = 4 and Lizard = 5\nPlease make a choice: ");

            try {
                int playerChoice = KEYBOARD_INPUT.nextInt();

                if (playerChoice >= 1 && playerChoice <= 5) {
                    calculateScore(decideWinner(computerRoll(), playerChoice));
                } else {
                    System.out.print(playerChoice + " is not a valid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("That's not a valid choice.");
            }

        } while (continuePlaying);

    }

    private static int decideWinner(int computerRoll, int playerChoice) {

        int winner = 0;
        String playerPlay = "";
        String computerPlay = "";

        if (playerChoice == computerRoll) {
            System.out.print("You tied.");
            winner = 1;
        } else if (playerChoice == 1 && (computerRoll == 3 || computerRoll == 5)) {
            System.out.print("You won.");
            winner = 1;
        } else if (playerChoice == 2 && (computerRoll == 1 || computerRoll == 4)) {
            System.out.print("You won.");
            winner = 1;
        } else if (playerChoice == 3 && (computerRoll == 2 || computerRoll == 5)) {
            System.out.print("You won.");
            winner = 1;
        } else if (playerChoice == 4 && (computerRoll == 1 || computerRoll == 3)) {
            System.out.print("You won.");
            winner = 1;
        } else if (playerChoice == 5 && (computerRoll == 2 || computerRoll == 4)) {
            System.out.print("You won.");
            winner = 1;
        } else {
            System.out.print("You lost.");
        }

        return winner;
    }

    private static int computerRoll() {
        Random randomRoll = new Random();
        return randomRoll.nextInt(4) + 1;
    }

    private static void calculateScore(int winner) {

        if (winner == 1) {
            PLAYER_SCORE++;
        } else {
            COMPUTER_SCORE++;
        }

        System.out.print("Player wins: " + PLAYER_SCORE + " | Computer wins: " + COMPUTER_SCORE);

    }

    private static String
}