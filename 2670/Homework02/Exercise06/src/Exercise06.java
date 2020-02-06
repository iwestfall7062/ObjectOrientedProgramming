//Write a program that displays pascal's triangle (see Programming Project 7 from Chapter 4 of Reges or
//http://en.wikipedia.org/wiki/Pascal%27s_triangle for examples). Your program should take two command line arguments.
//The first is the number of rows of the triangle to display. The second is an optional argument for the modulus. If no
//modulus is given generate Pascal's triangle as normal. Otherwise, reduce each entry in the triangle mod the given
//modulus. Use System.out.printf() to format (or manually format) the output into appropriately sized fields so the
//triangle is displayed correctly (e.g. such as in the example for Project 7 in Chapter 4 of Reges). Be sure not to have
//either too little or too much space in between each field. As a hint, you may want to generate the triangle twice.
//Once to find the maximum value (to set the field size) and once to print the triangle.
//
//Write a program that displays Pascal's triangle:
//
//Use System.out.printf to format the output into fields of width 4.

public class Exercise06 {

    public static final int defaultLines = 11;

    public static void main(String[] arguments) {

        int rowsToDisplay = defaultLines;
        int modulus = 0;

        String secondArgument = "";
        boolean hasModulus = false;

        if (arguments.length > 0) {
            try {
                rowsToDisplay = Integer.parseInt(arguments[0]);
            } catch (NumberFormatException ex) {
            }

            try {
                secondArgument = arguments[1];
            } catch (ArrayIndexOutOfBoundsException e) {
            }

            if (secondArgument.length() > 0) {
                modulus = Integer.parseInt(arguments[1]);
                hasModulus = true;
            }
        }

        for (int linesPrinted = 0; linesPrinted < rowsToDisplay; linesPrinted++) {

            int number = 1;
            System.out.printf("%" + (rowsToDisplay - linesPrinted) * 2 + "s", "");

            for (int counter = 0; counter <= linesPrinted; counter++) {

                if (hasModulus) {
                    System.out.printf("%4d", number % modulus);
                } else {
                    System.out.printf("%4d", number);
                }
                number = number * (linesPrinted - counter) / (counter + 1);

            }

            System.out.println();

        }
    }
}