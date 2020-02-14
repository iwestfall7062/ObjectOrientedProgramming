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

import java.io.File;
import java.util.Scanner;

public class Exercise04 {

    //constants
    public static String INSTRUCTIONS = "This program displays the changing popularity of an entered baby name and\n" +
            "gender. The program will also display the years with highest and lowest\npopularity. When prompted" +
            " please enter the name and gender you would like to\nsee data for.\n";
    public static Scanner KEYBOARD_INPUT = new Scanner(System.in);

    public static void main(String[] arguments) {

        System.out.println(INSTRUCTIONS);

        System.out.print("Please enter a name (ex. Emma): ");
        String nameToSearch = KEYBOARD_INPUT.nextLine();
        String genderToSearch = getGender();

        File namesFile = new File("yob1880.txt");

    }

    public static String getGender() {
        String genderToSearch;
        do {
            System.out.print("Please enter M or F for gender: ");
            genderToSearch = KEYBOARD_INPUT.nextLine();

        } while (genderToSearch.equals('M') || genderToSearch.equals('F'));
        return genderToSearch;
    }

    public static void processNamesFiles(){
        for (int counter = 1880; counter <= 2018; counter++) {
            File namesFile = new File("yob" + counter + ".txt");
        }
    }
}