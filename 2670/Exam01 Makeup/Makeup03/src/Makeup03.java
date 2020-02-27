//3) Create a complete Java program that produces formatted girds of the following form. Prompt the user for the number
//of rows and columns to print. A row or column size is valid if it is an integer in the range [1, 100]. If a size is
//found to be invalid print an error message but keep prompting until a valid value is given.
//
//Row: 4 Column: 6
//
// 1  5  9 13 17 21
// 2  6 10 14 18 22
// 3  7 11 15 19 23
// 4  8 12 16 20 24

//rows = 4
//columns = 6
//
//// 1  5  9 13 17 21
//// 2  6 10 14 18 22
//// 3  7 11 15 19 23
//// 4  8 12 16 20 24
//
//line number
//previous number add rows (columns - 1) times

import java.util.Scanner;

public class Makeup03 {

    public static final String INSTRUCTIONS = "";
    public static  final Scanner keyboardInput = new Scanner(System.in);

    public static void main(String[] arguments) {

        System.out.print(INSTRUCTIONS);
        System.out.print("Please enter the number of rows: ");
        keyboardInput.hasNextInt();
        int rows = keyboardInput.nextInt();
        System.out.print("Please enter the number of columns: ");
        keyboardInput.hasNextInt();
        int columns = keyboardInput.nextInt();

        System.out.println("Rows: " + rows + " Columns: " + columns);

        for (int rowNumber = 1; rowNumber <= rows; rowNumber++) {

            System.out.print(rowNumber + " ");

            int rowAddition = rowNumber;

            for (int columnNumber = 0; columnNumber < columns - 1; columnNumber++) {

                rowAddition += rows;

                System.out.print(rowAddition + " ");
            }

            System.out.println();

        }

    }
}