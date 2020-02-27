//Write a program that reads data about the changing popularity of baby names and displays the data about a particular
//name. Prompt the user for a name and gender. The data files for this project can be found at
//www.ssa.gov/oact/babynames/limits.html. The data files are named for the year of birth e.g. the file yob1992.txt has
//data for the year 1992. Each line a data file has a name, gender, and number in a comma-separated list. For example:
//
//Jennifer,F,56709
//
//Display a nicely formatted table that shows the changing popularity of the name the user entered over time. Think
//about what would make a good measure of popularity over time. Your program should start with a welcome message
//explaining the program and how it measures popularity. Also, display the year(s) with highest and lowest popularity.
//Do not include the data files in your submission. You may assume that your program will be run inside of a folder with
//all of the data files. Do not assume what years of data will be given (i.e. I may test on a subset of the data or use
//my own test files).

import java.io.*;
import java.util.Scanner;

public class Exercise04 {

    public static String instructions = "-------------------------------------------------------------------------------\n" +
            "-------------------------------- Instructions ---------------------------------\n" +
            "-------------------------------------------------------------------------------\n" +
            "This program reads in data from files provided by the Social Security\n" +
            "Administration about the changing popularity of baby names and displays the\n" +
            "data about a given baby name and gender. When prompted, please enter the baby\n" +
            "name and gender you would like to search for. Both entries are case sensitive,\n" +
            "M or F for gender, and the appropriately capitalized baby name.\n" +
            "-------------------------------------------------------------------------------";
    public static Scanner keyboardInput = new Scanner(System.in);

    public static void main(String[] arguments) {

        System.out.println(instructions);

        System.out.print("Enter a name: ");
        String name = keyboardInput.nextLine();

        System.out.print("Enter a gender (M/F): ");
        String gender = keyboardInput.nextLine();

        calculateNames(name, gender);
    }

    public static void calculateNames(String name, String gender) {

        int yearWithLeastNamed = 0;
        int maximumNamed = 0;
        int yearWithMostNamed = 0;
        int minimumNamed = 100000;
        int filesProcessed = 0;

        for (int yearCounter = 1880; yearCounter <= 2018; yearCounter++) {

            Scanner yobFiles = null;
            String fileName = "yob" + yearCounter + ".txt";

            try {
                yobFiles = new Scanner(new FileReader(fileName));
            } catch (FileNotFoundException e) {
            }

            if (yobFiles != null) {
                while (yobFiles.hasNextLine()) {
                    String currentFileLine = yobFiles.nextLine();
                    Scanner fileData = new Scanner(currentFileLine);
                    while (fileData.hasNext()) {
                        fileData.useDelimiter(",");

                        String nameFromFile = fileData.next();
                        String genderFromFile = fileData.next();

                        int nameCount = fileData.nextInt();

                        if (nameFromFile.equals(name) && genderFromFile.equals(gender)) {

                            if (nameCount < minimumNamed) {
                                minimumNamed = nameCount;
                                yearWithLeastNamed = yearCounter;
                            }

                            if (nameCount > maximumNamed) {
                                maximumNamed = nameCount;
                                yearWithMostNamed = yearCounter;
                            }

                            System.out.println("Year: " + yearCounter + "  |  Babies named " + nameFromFile + ": "
                                    + nameCount);

                            filesProcessed++;
                        }
                    }
                }
            }
        }

        if (filesProcessed == 0) {
            System.out.println("No files were found. Example file name = yob2018.txt");
            System.exit(0);
        }

        System.out.println("------------------------------------------------------------------------------");
        System.out.println(yearWithMostNamed + " had the most babies named " + name + " at " + maximumNamed +
                " babies.");
        System.out.println(yearWithLeastNamed + " had the least babies named " + name + " at " + minimumNamed +
                " babies.");
    }
}