//Write a program that prompts (using a Scanner to parse input) for the homework average, exam average, and final exam
//score for a student in this class. Your program should then print the final average and letter grade the student will
//receive. Be sure to follow all of the rules of the syllabus and validate your input (prompting the user again if
//needed). Include a text file (testcases.txt) in your project with the valid test cases, with expected results, you
//used. Of course, you should also test invalid cases, but you only have to report the valid ones.

import java.util.Scanner;

public class Exercise03 {

    //constants
    private static Scanner keyboardInput = new Scanner(System.in);
    private static String INSTRUCTIONS = "Please enter in the relevant grade when prompted using only a single number" +
            " between 0 and 100. (may include decimals)\n";

    public static void main(String[] arguments) {

        System.out.println(INSTRUCTIONS);
        double homeworkAverage = inputGrades("Homework Average: ");
        double examAverage = inputGrades("    Exam Average: ");
        double finalExamScore = inputGrades("Final Exam Score: ");
        calculateFinalGrade(homeworkAverage, examAverage, finalExamScore);

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

            if (gradePercent < 0 || gradePercent > 100){
                System.out.println("Please enter a single number between 0 and 100. (can include decimals)");
            }

        } while (gradePercent < 0 || gradePercent > 100);


        return gradePercent;
    }

    private static void calculateFinalGrade(double homeworkAverage, double examAverage, double finalExamScore){

        double finalAverage = ((homeworkAverage * .3 + examAverage * .4 + finalExamScore * .3));

        char letterGrade;

            if (finalAverage >= 90) letterGrade = 'A';
            else if (finalAverage >= 80 && finalAverage < 90) letterGrade = 'B';
            else if (finalAverage >= 70 && finalAverage < 80) letterGrade = 'C';
            else if (finalAverage >= 60 && finalAverage < 70) letterGrade = 'D';
            else letterGrade = 'F';

        System.out.printf("\n   Final Average: %.1f", finalAverage);
        System.out.println("\n    Letter Grade: " + letterGrade);
    }
}