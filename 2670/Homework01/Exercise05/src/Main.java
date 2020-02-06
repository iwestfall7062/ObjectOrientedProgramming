//        Programming Project 1 from Chapter 3 of Reges. The number of segments (an integer from 1 to 10) should be
//        controlled by the first command line argument. The height of each segments (an integer from 1 to 10) should be
//        controlled by the second command line argument. In the case of erroneous input, print an informative error
//        message.

public class Main {

    //constants
    public static final int DEFAULT_SEGMENTS = 3;
    public static final int DEFAULT_HEIGHT = 4;
    public static final int NOT_A_NUMBER_ERROR = 1;
    public static final int OUT_OF_BOUNDS_ERROR = 2;
    public static final int NOT_MUCH_OF_A_TREE_ERROR = 3;
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 10;
    public static final String INSTRUCTIONS = "Enter 2 numbers between 1 and 10, separated by a space.";

    public static void main(String[] arguments){

        int numberOfSegments = errorChecking(arguments, 0, DEFAULT_SEGMENTS);
        int heightOfSegments = errorChecking(arguments, 1, DEFAULT_HEIGHT);

        if (numberOfSegments == 1 && heightOfSegments == 1){
            System.out.println("1 x 1? That's not much of a tree...");
            System.exit(NOT_MUCH_OF_A_TREE_ERROR);
        }

        printTree(numberOfSegments, heightOfSegments);
    }

    //checks command line arguments to make sure they are a single number and returns segmentOrHeight because this is
    //where the passed in command line arguments are set equal to the variables
    private static int errorChecking(String[] arguments, int indexNumber, int segmentOrHeight) {
        if (arguments.length > 0) {
            try {
                segmentOrHeight = Integer.parseInt(arguments[indexNumber]);
            }
            catch (NumberFormatException ex) {
                System.err.println(arguments[indexNumber] + " is not a number.");
                System.out.println(INSTRUCTIONS);
                System.exit(NOT_A_NUMBER_ERROR);
            }

            if (segmentOrHeight < LOWER_BOUND || segmentOrHeight > UPPER_BOUND){
                System.err.println(arguments[indexNumber] + " is not a number between " + LOWER_BOUND + " and " +
                        UPPER_BOUND);
                System.out.println(INSTRUCTIONS);
                System.exit(OUT_OF_BOUNDS_ERROR);
            }
        }

        return segmentOrHeight;

    }

    private static void printTree(int numberOfSegments, int heightOfSegments){

        //calculates the widest part of the tree at the very bottom
        int treeWidth = (2 * numberOfSegments) + (2 * heightOfSegments) - 3;

        //controls movement to each segment
        for (int segmentCount = 0; segmentCount < 2 * numberOfSegments; segmentCount += 2) {

            printSegment(heightOfSegments, treeWidth, segmentCount);

        }

        printTrunk(treeWidth);
    }

    //method to print a single line
    private static void printLine(int treeWidth, int stars) {
        int spaces = (treeWidth - stars) / 2;
        printCharacter(" ", spaces);
        printCharacter("*", stars);
        System.out.println();

    }

    //method that print a segment of the tree with a for loop and the printLine method
    private static void printSegment(int heightOfSegments, int treeWidth, int segmentCount) {
        for (int segmentLine = 0; segmentLine < 2 * heightOfSegments; segmentLine += 2) {
            printLine(treeWidth, 1 + segmentCount + segmentLine);
        }
    }

    //prints the trunk of the tree, has if statements for special cases where the tree is too small
    private static void printTrunk(int treeWidth) {

            printLine(treeWidth, 1);
            printLine(treeWidth, 1);
            if (treeWidth == 3) {
                printLine(3, 3);
            }
            else if (treeWidth == 5) {
                printLine(5, 5);
            }
            else {
                printLine(treeWidth, 7);
            }
    }

    //method that prints out the character passed to the method however many the numberOfTimes
    private static void printCharacter(String displayedCharacter, int numberOfTimes) {

        for (int counter = 0; counter < numberOfTimes; counter++) {
            System.out.print(displayedCharacter);
        }
    }
}