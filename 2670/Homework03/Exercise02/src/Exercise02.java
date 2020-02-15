//Fortune files are text files with random sayings and quotes in them, where each entry is separated by a line
//containing only a percent sign (%). See the file /opt/local/share/games/fortune/fortunes in the lab for an example.
//Note there are also fortune files that end in -o that contain quotes that could be considered offensive. These files
//have had a trivial encryption applied to prevent accidental reading (it would be nice if they were not part of the
//fortune install at all). So do not go looking at them unless you are willing to be offended. Your task is to modify
//your cowsay program to display a random quote from the fortune file fortunes.txt in your program's current working
//directory (the directory it is run from, most IDEs will let you set this for testing as well). If the fortunes.txt
//file does not exists, then your program should print an informative error message and quit. Your cowsay program now
//has to handle multi-line messages (as most fortunes have a few lines). Your program also has to handle two optional
//command line arguments. If the String "debug" is given as an argument then information about the number of fortunes
//in the fortunes.txt file and which fortune number was selected must be printed along with the regular output (note
//fortune numbers start at 1). Additionally, if an integer is given as a command line argument, then that is the fortune
//number that should be printed (i.e. not a random one). All other command line arguments should be ignored. You can
//make and submit your own non-offensive fortunes.txt file or use one of the non-offensive files from the lab. However,
//you should expect that I will also test you program with my own files. Also, note that while the real fortune program
//uses precomputed offsets to make look ups fast, you can take multiple passes over the data file to get the information
//you need.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Exercise02 {

    public static String instructions = "-------------------------------------------------------------------------------\n" +
            "---------------------------------Instructions----------------------------------\n" +
            "-------------------------------------------------------------------------------\n" +
            "This program displays a random quote from the fortunes.txt file along with the\n" +
            "cow from the CowSay program. There are two optional command line arguments that\n" +
            "can be used as well. If \"debug\" is given as a command line argument then the\n" +
            "number of fortunes in the fortunes.txt file and the fortune number displayed\n" +
            "will be shown, along with the fortune itself. If a number is given as a command\n" +
            "line argument then that number fortune will be displayed.\n" +
            "-------------------------------------------------------------------------------";
    public static Random fortuneNumber = new Random();

    public static void main(String[] arguments) {

        System.out.println(instructions);
        Scanner fortunes = null;
        try {
            fortunes = getFortunesFile();
        } catch (FileNotFoundException e) {
        }

        String chosenFortune = "";
        int fortuneIndex = 0;
        String[] fortuneArray = new String[6770];

        fortunes.useDelimiter("%");
        while (fortunes.hasNext()) {
            fortuneArray[fortuneIndex] = fortunes.next();
            fortuneIndex++;
        }

        int randomFortune = fortuneNumber.nextInt(fortuneIndex);

        int argument = 0;
        if (arguments.length > 0) {
            try {
                argument = Integer.parseInt(arguments[0]);
            } catch (NumberFormatException e) {
            }
            if (argument > 0 && argument < fortuneIndex) {
                chosenFortune = (fortuneArray[argument]);
            } else {
                chosenFortune = (fortuneArray[randomFortune]);

            }
            if (arguments[0].equals("debug")) {
                System.out.println("There are " + fortuneIndex + " fortunes in the fortunes.txt file.");
                System.out.println("This fortune is number " + randomFortune + ".");
            }
        } else {
            chosenFortune = (fortuneArray[randomFortune]);
            fortunes.close();
        }

        String displayedFortune = chosenFortune;

        String[] displayedFortuneArray = displayedFortune.split("\n");

        int bubbleWidth = 0;
        for (int counter = 0; counter < displayedFortuneArray.length; counter++){
            if (displayedFortuneArray[counter].length() > bubbleWidth) {
                bubbleWidth = displayedFortuneArray[counter].length();
            }
        }

        printBubbleWidth("_", bubbleWidth);
        System.out.print(displayedFortune);
        printBubbleWidth("-", bubbleWidth);
        System.out.println();
        printCow();
    }

    public static Scanner getFortunesFile() throws FileNotFoundException {
        File fortunes = new File("fortunes");

        if (!fortunes.canRead()) {
            System.out.println("The fortunes file was not found.");
            System.exit(0);
        }
        return new Scanner(fortunes);
    }

    private static void printCow() {
        System.out.println("        \\   ^__^");
        System.out.println("         \\  (oo)\\_______");
        System.out.println("            (__)\\       )\\/\\");
        System.out.println("                ||----w |");
        System.out.println("                ||     ||");
    }

    private static void printBubbleWidth(String printedCharacter, int bubbleWidth) {
        for (int counter = 0; counter < bubbleWidth; counter++) {
            System.out.print(printedCharacter);
        }
    }
}