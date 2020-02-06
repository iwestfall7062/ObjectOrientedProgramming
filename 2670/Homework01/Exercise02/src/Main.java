//        Make a program that outputs the pattern:
//        *
//        **
//        * *
//        *  *
//        *   *
//        ******
//        The number of rows print should be controlled by the rst command line argument. Ensure that this value an integer
//        between 1 and 80. If it is not, or no argument is given, print an informative error message.

public class Main {

    //constants
    public static final int DEFAULT_NUMBER_OF_LINES = 6;
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

    //method that calls the printCharacter method and how many lines should be printed
    private static void printTriangle(int numberOfLines) {

            //prints the first character
            printCharacter("*", 1);

        //for loop that calls the printCharacter method and prints out the body of the triangle the numberOfLines
        //minus 2 to omit the first line of characters, and the last line of characters
        for (int rowNumber = 0; rowNumber < numberOfLines - 2; rowNumber++) {

            System.out.println();
            printCharacter("*", 1);
            printCharacter(" ", rowNumber);
            printCharacter("*", 1);
        }

        //if statement so that a second star is not printed if the argument entered is only 1
        if (numberOfLines != 1) {
            System.out.println();
            printCharacter("*", numberOfLines);
        }

        System.out.println();

    }

    //method that prints out the character passed to the method however many the numberOfTimes
    private static void printCharacter(String displayedCharacter, int numberOfTimes) {

        for (int counter = 0; counter < numberOfTimes; counter++) {
            System.out.print(displayedCharacter);
        }
    }
}