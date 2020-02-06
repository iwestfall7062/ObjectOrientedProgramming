//        Make your own simple version of cowsay, Your version should take a message from the command line (the message
//        will be given as just the rst argument) and print a simple character of your design saying that message. For
//        now you may assume that the message is small enough to t on one line (i.e. you do not have to handle
//        multi-line messages).

public class Main {

    public static void main(String[] arguments) {

        String cowSays = convertArguments(arguments);
        printMessage(cowSays, arguments);
        printCow();

    }

    //takes in all arguments, runs them through a for loop and concatenates them to cowSays and returns cowSays
    private static String convertArguments(String[] arguments){
        StringBuilder cowSays = new StringBuilder(" ");

        for (int counter = 0; counter < arguments.length; counter++) {
            String userInput = arguments[counter];
            cowSays.append(userInput).append(" ");
        }

        return cowSays.toString();
    }

    private static void printMessage(String cowSays, String[] arguments){

        System.out.print(" ");

        //checks cowSays length and prints out the top line of the message bubble that many times
        for (int counter = 0; counter < cowSays.length(); counter++) {
            System.out.print("_");
        }

        System.out.println();
        System.out.print("<");
        System.out.print(cowSays);
        System.out.println(">");
        System.out.print(" ");

        //checks cowSays length and prints out the bottom line of the message bubble that many times
        for (int counter = 0; counter < cowSays.length(); counter++) {
            System.out.print("-");
        }

        System.out.println();
    }

    private static void printCow() {
        System.out.println("        \\   ^__^");
        System.out.println("         \\  (oo)\\_______");
        System.out.println("            (__)\\       )\\/\\");
        System.out.println("                ||----w |");
        System.out.println("                ||     ||");
    }
}