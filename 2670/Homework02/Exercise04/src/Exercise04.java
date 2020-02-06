//Write a program that prompts (using a Scanner for parsing input) for the homework average and exam average for a
//student in this class. Your program should then print a nicely formatted table of the final exam scores needed to
//receive each possible letter grade. Make sure that your output makes sense and only possible outcomes are displayed
//(e.g. it is not possible to get a negative score on the final). Be sure to follow all of the rules of the syllabus and
//validate your input (prompting the user again if needed). Include a text file (testcases.txt) in your project with the
//valid test cases, with expected results, you used. Of course, you should also test invalid cases, but you only have to
//report the valid ones.

import java.util.Scanner;

public class Exercise04 {

    //constants
    private static Scanner keyboardInput = new Scanner(System.in);
    private static String INSTRUCTIONS = "Please enter in the relevant grade when prompted using only a single number" +
            " between 0 and 100. (may include decimals)\n";

    public static void main(String[] arguments) {

        System.out.println(INSTRUCTIONS);
        double homeworkAverage = inputGrades("Homework Average: ");
        double examAverage = inputGrades("    Exam Average: ");
        calculateNeededScore(homeworkAverage, examAverage);

    }

    private static double inputGrades(String whichGrade) {

        double gradePercent = 0;

        do {

            System.out.print(whichGrade);

            while (!keyboardInput.hasNextDouble()) {

                System.out.println("Please enter a single number between 0 and 100. (can include decimals)");
                keyboardInput.next();
                System.out.print(whichGrade);

            }

            gradePercent = keyboardInput.nextDouble();

        } while (gradePercent < 0 || gradePercent > 100);

        return gradePercent;
    }

    private static void calculateNeededScore(double homeworkAverage, double examAverage) {

        double scoreNeededForA = ((90 - (homeworkAverage * .3 + examAverage * .4)) / .3);
        double scoreNeededForB = ((80 - (homeworkAverage * .3 + examAverage * .4)) / .3);
        double scoreNeededForC = ((70 - (homeworkAverage * .3 + examAverage * .4)) / .3);
        double scoreNeededForD = ((60 - (homeworkAverage * .3 + examAverage * .4)) / .3);
        double scoreNeededForF = ((50 - (homeworkAverage * .3 + examAverage * .4)) / .3);

        System.out.println(" -----------------");
        System.out.printf("| Grade A | %5.1f |\n", scoreNeededForA);
        System.out.printf("| Grade B | %5.1f |\n", scoreNeededForB);
        System.out.printf("| Grade C | %5.1f |\n", scoreNeededForC);
        if (scoreNeededForD >= 0) System.out.printf("| Grade D | %5.1f |\n", scoreNeededForD);
        if (scoreNeededForF >= 0) System.out.printf("| Grade F | %5.1f |\n", scoreNeededForF);
        System.out.println(" -----------------");

    }
}