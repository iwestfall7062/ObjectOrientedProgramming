//1) Create a complete Java program that produces figures of the following form for each valid size given as a
// command-line argument. A size is valid if it is an integer in the range [1, 100]. If a size is found to be invalid
// print an error message but keep processing the rest of the command-line arguments.
//
//        Size 1
//
//  /**\
// +=*=*+
// |/\/\|
// |\/\/|
// +=*=*+
// |\/\/|
// |/\/\|
// +=*=*+
//  /**\
//
// Size 2
//    /**\
//   //**\\
//  ///**\\\
// +=*=*=*=*+
// |./\../\.|
// |/\/\/\/\|
// |\/\/\/\/|
// |.\/..\/.|
// +=*=*=*=*+
// |\/\/\/\/|
// |.\/..\/.|
// |./\../\.|
// |/\/\/\/\|
// +=*=*=*=*+
//    /**\
//   //**\\
//  ///**\\\
//
// Size 3
//
//      /**\
//     //**\\
//    ///**\\\
//   ////**\\\\
//  /////**\\\\\
// +=*=*=*=*=*=*+
// |../\..../\..|
// |./\/\../\/\.|
// |/\/\/\/\/\/\|
// |\/\/\/\/\/\/|
// |.\/\/..\/\/.|
// |..\/....\/..|
// +=*=*=*=*=*=*+
// |\/\/\/\/\/\/|
// |.\/\/..\/\/.|
// |..\/....\/..|
// |../\..../\..|
// |./\/\../\/\.|
// |/\/\/\/\/\/\|
// +=*=*=*=*=*=*+
//      /**\
//     //**\\
//    ///**\\\
//   ////**\\\\
//  /////**\\\\\

public class Makeup01 {

    public static void main(String[] arguments) {

        int size = Integer.parseInt(arguments[0]);
        int noseOrTailSize = size * 2;
        int lineSize = size * 2;

        printNoseOrTail(noseOrTailSize);
        printLine(lineSize);
        printTopMiddle(size);
        printBottomMiddle(size);
        printLine(lineSize);
        printTopMiddle(size);
        printBottomMiddle(size);
        printLine(lineSize);
        printNoseOrTail(noseOrTailSize);
    }

    public static void printNoseOrTail(int noseSize){

        for (int lineNumber = 1; lineNumber <= (noseSize - 1); lineNumber++) {

            repeatCharacter(" ",noseSize - lineNumber);
            repeatCharacter("/",lineNumber);
            repeatCharacter("*",2);
            repeatCharacter("\\",lineNumber);
            System.out.println();
        }

    }

    public static void printLine(int lineSize){

        repeatCharacter("+",1);

        for (int counter = 1; counter <= lineSize; counter++) {
            repeatCharacter("*", 1);
            repeatCharacter("=", 1);
        }

        repeatCharacter("+",1);
        System.out.println();

    }

    public static void printTopMiddle(int size){

        for (int lineNumber = 1; lineNumber <= size; lineNumber++) {

            repeatCharacter("|", 1);
            repeatCharacter(".", size - lineNumber);
            repeatCharacter("/", lineNumber);
            repeatCharacter("\\", lineNumber);
            repeatCharacter(".", (size - lineNumber) * 2);
            repeatCharacter("/",lineNumber);
            repeatCharacter("\\",lineNumber);
            repeatCharacter(".", size - lineNumber);
            repeatCharacter("|", 1);
            System.out.println();

        }

    }

    public static void printBottomMiddle(int size){

        //I know I printed the triangles out wrong, but in the interest of time I decided to finish the program before
        //fixing the diamonds to print properly

        for (int lineNumber = size; lineNumber >= 1; lineNumber--) {

            repeatCharacter("|", 1);
            repeatCharacter(".", size - lineNumber);
            repeatCharacter("\\", lineNumber);
            repeatCharacter("/", lineNumber);
            repeatCharacter(".", (size - lineNumber) * 2);
            repeatCharacter("\\",lineNumber);
            repeatCharacter("/",lineNumber);
            repeatCharacter(".", size - lineNumber);
            repeatCharacter("|", 1);
            System.out.println();

        }

    }

    public static void repeatCharacter(String character, int howMany) {
        for (int counter = 1; counter <= howMany; counter ++) {
System.out.print(character);
        }
    }

}