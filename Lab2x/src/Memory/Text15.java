package Memory;

import java.util.Scanner;


class Text15 {
    public static void main(String[] u) {
        Boardgame thegame = new MemoryGame();                 // new
        System.out.println("\nV�lkommen till MEMORY\n");
        int count = 0;
        while (count < 1) {
        	count++;
            // Skriv ut aktuell st�llning
            for (int i=0; i<4; i++) {
                for (int j=0; j<4; j++)
                    System.out.print("  " + thegame.getStatus(i,j)); // getStatus
                System.out.println();
            }
            System.out.println();
            System.out.println(thegame.getMessage());	     // getMessage
        }
    }
}
