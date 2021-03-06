//        Make a program that outputs the pattern:
//        *
//        **
//        ***
//        ****
//        *****
//        The number of rows print should be controlled by the rst command line argument. Ensure that this value an integer
//        between 1 and 80. If it is not, or no argument is given, print an informative error message.

public class Main {

    //constants
    public static final int DEFAULT_NUMBER_OF_LINES = 5;
    public static final int NOT_A_NUMBER_ERROR = 1;
    public static final int OUT_OF_BOUNDS_ERROR = 2;
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 80;


    public static void main(String[] arguments) {

        int numberOfLines = errorChecking(arguments, DEFAULT_NUMBER_OF_LINES);
        printTriangle(numberOfLines);

    }

    //checks command line arguments to make sure they are a single number and returns numberOfLines because this is
    //where the passed in command line argument is set equal to numberOfLines
    private static int errorChecking(String[] arguments, int numberOfLines) {

        if (arguments.length > 0) {
            try {
                numberOfLines = Integer.parseInt(arguments[0]);
            }
            catch (NumberFormatException ex) {
                System.err.println(arguments[0] + " is not a number.");
                System.exit(NOT_A_NUMBER_ERROR);
            }

            if (numberOfLines < LOWER_BOUND || numberOfLines > UPPER_BOUND){
                System.err.println(arguments[0] + " is not a single number between " + LOWER_BOUND + " and " +
                        UPPER_BOUND);
                System.exit(OUT_OF_BOUNDS_ERROR);
            }
        }

        return numberOfLines;
    }

    //for loop that calls the printCharacter method and passes which character should be displayed and a equation that
    //controls how many times and then moves to the next line the number of times entered in the command line argument
    private static void printTriangle(int numberOfLines) {
        for (int rowNumber = 0; rowNumber < numberOfLines; rowNumber++) {

            printCharacter("*", rowNumber + 1);

            System.out.println();
        }
    }

    //for loop that takes in what character should be displayed and how many times and runs the loop that many times
    private static void printCharacter(String displayedCharacter, int numberOfTimes) {

        for (int counter = 0; counter < numberOfTimes; counter++) {
            System.out.print(displayedCharacter);
        }
    }
}