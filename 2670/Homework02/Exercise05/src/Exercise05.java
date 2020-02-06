//Simulate a 2D random walk starting at (0,0). At each step print out the current location then move one step to the
//right, left, up, or down, chosen at random. The simulation stops when you have returned to the origin (0,0). thus, the
//simulation could stop quickly or run until terminated. Note this is not a GUI program you are just printing each point
//visited. It is also a random walk so it could terminate quickly or run forever.

import java.util.Random;

public class Exercise05 {
    public static void main(String[] arguments) {

        Random random = new Random();
        int x = 0;
        int y = 0;

        System.out.printf("You begin your walk.          (%d,%d)\n\n", x, y);

        do {

            int direction = random.nextInt(3);

            if (direction == 0){
                y = y + 1;
                System.out.print("You take a step forward.      ");
                }
            else if (direction == 1) {
                x = x + 1;
                System.out.print("You take a step to the right. ");
            }
            else if (direction == 2) {
                y = y - 1;
                System.out.print("You take a step back.         ");
            }
            else if (direction == 3) {
                x = x - 1;
                System.out.print("You take a step to the left.  ");
            }

            System.out.printf("(%d,%d)\n", x, y);

            try{Thread.sleep(1000);}catch(InterruptedException ex){}

        } while (x!=0 || y!=0);

        System.out.printf("\nYou end your walk.            (%d,%d)", x, y);

    }
}