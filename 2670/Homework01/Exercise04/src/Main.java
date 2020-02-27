//        Programming Project 4 from Chapter 2 of Reges. The number of stairs printed should be controlled by the first
//        command line argument. Ensure that this value an integer between 0 and 20. If it is not, or no argument is
//        given, print an informative error message.
//                              O  *******
//                             /|\ *     *
//                             / \ *     *
//                         O  ******     *
//                        /|\ *          *
//                        / \ *          *
//                    O  ******          *
//                   /|\ *               *
//                   / \ *               *
//               O  ******               *
//              /|\ *                    *
//              / \ *                    *
//          O  ******                    *
//         /|\ *                         *
//         / \ *                         *
//        ********************************

public class Main {

    //constants
    public static final int DEFAULT_NUMBER_OF_STAIRS = 5;
    public static final int NOT_A_NUMBER_ERROR = 1;
    public static final int OUT_OF_BOUNDS_ERROR = 2;
    public static final int LOWER_BOUND = 0;
    public static final int UPPER_BOUND = 20;

    public static void main(String[] arguments) {

        int numberOfStairs = errorChecking(arguments, DEFAULT_NUMBER_OF_STAIRS);
        int stairWidth = numberOfStairs * 5;
        printStairs(numberOfStairs, stairWidth);

    }

    //checks command line arguments to make sure they are a single number and returns numberOfStairs because this is
    //where the passed in command line argument is set equal to numberOfStairs
    private static int errorChecking(String[] arguments, int numberOfStairs) {
        if (arguments.length > 0) {
            try {
                numberOfStairs = Integer.parseInt(arguments[0]);
            }
            catch (NumberFormatException ex) {
                System.err.println(arguments[0] + " is not a number.");
                System.exit(NOT_A_NUMBER_ERROR);
            }

            if (numberOfStairs < LOWER_BOUND || numberOfStairs > UPPER_BOUND){
                System.err.println(arguments[0] + " is not a single number between " + LOWER_BOUND + " and " +
                        UPPER_BOUND);
                System.exit(OUT_OF_BOUNDS_ERROR);
            }
        }

        return numberOfStairs;

    }

    //method that calls the printCharacter method and numberOfStairs printed
    private static void printStairs(int numberOfStairs, int stairWidth) {

        //for loop that runs as many times as numberOfStairs
        for (int counter = 1; counter <= numberOfStairs; counter++) {

                printHead(stairWidth, counter);
                printArms(stairWidth, counter);
                printLegs(stairWidth, counter);

        }

        //prints the base of the stairs
        printCharacter("*", stairWidth + 7);
        System.out.println();
    }

    //method that prints out the character passed to the method however many the numberOfTimes
    private static void printCharacter(String displayedCharacter, int numberOfTimes) {

        for (int counter = 0; counter < numberOfTimes; counter++) {
            System.out.print(displayedCharacter);
        }
    }

    //prints out the head of the person on the stairs
    private static void printHead(int stairWidth, int counter) {
        printCharacter(" ", stairWidth - counter * 5);
        printCharacter("  O  ******", 1);
        printCharacter(" ", counter * 5 - 5);
        printCharacter("*", 1);
        System.out.println();
    }

    //prints out the arms and body of the person on the stairs
    private static void printArms(int stairWidth, int counter) {
        printCharacter(" ", stairWidth - counter * 5);
        printCharacter(" /|\\ *", 1);
        printCharacter(" ", counter * 5);
        printCharacter("*", 1);
        System.out.println();
    }

    //prints out the legs of the person on the stairs
    private static void printLegs(int stairWidth, int counter) {
        printCharacter(" ", stairWidth - counter * 5);
        printCharacter(" / \\ *", 1);
        printCharacter(" ", counter * 5);
        printCharacter("*", 1);
        System.out.println();
    }
}