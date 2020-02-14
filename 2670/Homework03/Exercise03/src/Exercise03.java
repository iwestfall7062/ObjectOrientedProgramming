//Write a program that allows the user to play Rock-paper-scissors-lizard-Spock
//(en.wikipedia.org/wiki/Rock-paper-scissors-lizard-Spock) against the computer. The user should be able to play as many
//games as they wish without restarting your program. The program should keep track of the score for the current session
//of the game and the overall total score for all sessions played. Think about how you can efficiently represent the
//rules for winning.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Exercise03 {

    private static String instructions = "-------------------------------------------------------------------------------\n" +
            "-------------------------------- Instructions ---------------------------------\n" +
            "-------------------------------------------------------------------------------\n" +
            "Rock Paper Scissors Spock Lizard is a variation of the classic game Rock Paper\n" +
            "Scissors with two additional weapons added. Select which weapon you would like\n" +
            "to play with the numbers 1 through 5 and then see which weapon the computer\n" +
            "chose. To stop playing enter 6.\n" +
            "-------------------------------------------------------------------------------";
    private static int overallPlayerScore = 0;
    private static int sessionPlayerScore = 0;
    private static int overallComputerScore = 0;
    private static int sessionComputerScore = 0;
    private static Scanner keyboardInput = new Scanner(System.in);

    public static void main(String[] arguments) {

        System.out.println(instructions);

        checkForSaveData();
        boolean continuePlaying = true;

        do {
            try {
                System.out.println("\n1 = Rock, 2 = Paper, 3 = Scissors, 4 = Spock, 5 = Lizard and 6 = Exit");
                System.out.print("Enter your choice: ");
                int playerChoice = keyboardInput.nextInt();
                keyboardInput.nextLine();
                if (playerChoice >= 1 && playerChoice <= 5) {
                    calculateWinner(computerRoll(), playerChoice);
                } else if (playerChoice == 6) {
                    System.exit(0);
                } else {
                    System.out.println(playerChoice + " Is not a single whole number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Only whole numbers are accepted as input.");
                keyboardInput.nextLine();
            }
            saveData();
        } while (continuePlaying);
    }

    public static void checkForSaveData() {
        File saveData = new File("SaveData.txt");
        boolean exists = saveData.exists();

        if (exists) {
            loadData();
        }
    }

    public static void loadData() {
        String[] overallScores = new String[2];
        try {
            File saveData = new File("SaveData.txt");

            Scanner readSaveData = new Scanner(saveData);
            for (int counter = 0; counter <= 1; counter++) {
                overallScores[counter] = readSaveData.nextLine();
            }
            overallPlayerScore = Integer.parseInt(overallScores[0]);
            overallComputerScore = Integer.parseInt(overallScores[1]);
            System.out.println("Overall total score for all sessions played: Player = " + overallPlayerScore + " and" +
                    " Computer = " + overallComputerScore);
        } catch (IOException e) {
            System.out.println("An error occurred while trying to load save data.");
        }
    }

    public static void saveData() {
        try {
            PrintWriter writeSaveData = new PrintWriter(new FileWriter("SaveData.txt"));

            writeSaveData.println(overallPlayerScore);
            writeSaveData.println(overallComputerScore);
            writeSaveData.close();

        } catch (IOException e) {
            System.out.println("An error occurred while trying to create or write save data.");
        }
    }

    public static int computerRoll() {
        Random random = new Random();
        return (random.nextInt(5));
    }

    public static void calculateWinner(int computerChoice, int userChoice) {
        int winner;
        String computersRoll = findComputersPlay(computerChoice);

        if (userChoice == computerChoice + 1) {
            System.out.println("You tied with " + computersRoll + ".");
            winner = 2;
        } else if (userChoice == 1 && (computerChoice == 2 || computerChoice == 4)) {
            System.out.println("You won against " + computersRoll + ".");
            winner = 1;
        } else if (userChoice == 2 && (computerChoice == 0 || computerChoice == 3)) {
            System.out.println("You won against " + computersRoll + ".");
            winner = 1;
        } else if (userChoice == 3 && (computerChoice == 1 || computerChoice == 4)) {
            System.out.println("You won against " + computersRoll + ".");
            winner = 1;
        } else if (userChoice == 4 && (computerChoice == 0 || computerChoice == 2)) {
            System.out.println("You won against " + computersRoll + ".");
            winner = 1;
        } else if (userChoice == 5 && (computerChoice == 1 || computerChoice == 3)) {
            System.out.println("You won against " + computersRoll + ".");
            winner = 1;
        } else {
            System.out.println("You lost against " + computersRoll + ".");
            winner = 0;
        }
        calculateScore(winner);
    }

    public static String findComputersPlay(int computerChoice) {
        switch (computerChoice) {
            case 0:
                return "Rock";
            case 1:
                return "Paper";
            case 2:
                return "Scissors";
            case 3:
                return "Spock";
            case 4:
                return "Lizard";
            default:
                return "Error";
        }
    }

    public static void calculateScore(int winner) {
        if (winner == 1) {
            overallPlayerScore++;
            sessionPlayerScore++;
        } else if (winner == 0) {
            overallComputerScore++;
            sessionComputerScore++;
        }
        System.out.println("Current session score: Player = " + sessionPlayerScore + " Computer = " +
                sessionComputerScore);
    }
}