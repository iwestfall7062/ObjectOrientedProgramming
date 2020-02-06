//Do Programming Exercise 1 (note that the Programming Projects and Programming Exercises are different) from Chapter 4
//of Reges. Take n to be the value of the first command line argument and print the resulting sum.
//
//Write a method called fractionSum that accepts an integer parameter n and returns as a double the sum of the first n
//terms of the sequence. In other words, the method should generate the following sequence 1+(1/2)+(1/3)+(1/4)+(1/5)+...
//You may assume that the parameter n is nonnegative.

public class Exercise02 {

    //constants
    public static final int DEFAULT_NUMBER = 5;
    public static final int NOT_A_NUMBER_ERROR = 1;
    public static final int OUT_OF_BOUNDS_ERROR = 2;
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 2147483647;
    public static final String INSTRUCTIONS = "Enter a single number between 1 and 100.";

    public static void main(String[] arguments) {

        int integerParameterN = errorChecking(arguments, DEFAULT_NUMBER);

        System.out.println("The sum of the first N in terms of sequence is: " + fractionSum(arguments,
                integerParameterN));

    }

    //checks command line arguments to make sure they are a single number and returns segmentOrHeight because this is
    //where the passed in command line arguments are set equal to the variables
    private static int errorChecking(String[] arguments, int integerParameterN) {
        if (arguments.length > 0) {
            try {
                integerParameterN = Integer.parseInt(arguments[0]);
            }
            catch (NumberFormatException ex) {
                System.err.println(arguments[0] + " is not a number.");
                System.out.println(INSTRUCTIONS);
                System.exit(NOT_A_NUMBER_ERROR);
            }

            if (integerParameterN < LOWER_BOUND || integerParameterN > UPPER_BOUND){
                System.err.println(arguments[0] + " is not a number between " + LOWER_BOUND + " and " +
                        UPPER_BOUND);
                System.out.println(INSTRUCTIONS);
                System.exit(OUT_OF_BOUNDS_ERROR);
            }
        }

        return integerParameterN;

    }
    //method that prints out the character passed to the method however many the numberOfTimes
    private static void printCharacter(String displayedCharacter, int numberOfTimes) {

        for (int counter = 0; counter < numberOfTimes; counter++) {
            System.out.print(displayedCharacter);
        }
    }

    public static double fractionSum(String[] arguments, int integerParameterN){
        double sumOfTheFirstN = 0;

        for (double counter = 1; counter <= integerParameterN; counter++) {

            sumOfTheFirstN += (1 / counter);

        }

        return sumOfTheFirstN;
    }

}