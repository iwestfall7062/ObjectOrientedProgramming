import java.util.Scanner;
import java.util.StringTokenizer;

public class MethodsAndConstants {

    //CONSTANTS
    public static final String INSTRUCTIONS = "write program instructions here";

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //METHODS
//prints out a given character a given number of times to the console window
    public static void writeCharacters(char character, int numberOfTimes) {
        for (int counter = 1; counter <= numberOfTimes; counter++) {
            System.out.print(character);
        }
    }

    //rounds the given number to two decimal places and returns it
    public static double roundToTwoDecimalPlaces(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    //checks if a number is even by modulus 2, if it is even it  returns 0, if it's odd it returns 1
    public static int evenNumberCheck(int number) {
        number = number % 2;
        return number;
    }

    //evaluates all given values and returns the highest value
    public static int findMaximumValue(int value, int lengthOfData) {
        int maximum = 0;
        for (int counter = 1; counter <= lengthOfData - 1; counter ++) {
            if (value > maximum) {
                maximum = value;
            }
        }
        return maximum;
    }

    //evaluates all given values and returns the lowest value
    public static int findMinimumValue(int value, int lengthOfData) {
        int minimum = 0;
        for (int counter = 1; counter <= lengthOfData - 1; counter ++) {
            if (value > minimum) {
                minimum = value;
            }
        }
        return minimum;
    }

    public static int getInt(Scanner keyboardInput, String prompt, String error) {
        System.out.print(prompt);
        while (!keyboardInput.hasNextInt()) {
            keyboardInput.next();
            System.out.println(error);
            System.out.print(prompt);
        }
        return keyboardInput.nextInt();
    }

    public static void checkForSingleIntToken(Scanner keyboardInput, String prompt) {

        String tokenString;
        int numberOfTokens;
        int input;

        do {
            System.out.println(prompt);
            tokenString = keyboardInput.nextLine();
            numberOfTokens = new StringTokenizer(tokenString, " ").countTokens();
            try {
                input = Integer.parseInt(tokenString);
            } catch(NumberFormatException e) {
                numberOfTokens = 0;
                input = -1;
            }
        } while (numberOfTokens != 1);
        keyboardInput.close();

        System.out.println(input);
    }

}