package lab_2;

import java.util.*;
class Text15 {
    public static void main(String[] u) {
        Scanner scan = new Scanner(System.in);
        Boardgame thegame = new FifteenModel();                 // new
        System.out.println("\nV�lkommen till femtonspelet\n");
        while (true) {
            // Skriv ut aktuell st�llning
            for (int i=0; i<4; i++) {
                for (int j=0; j<4; j++)
                    System.out.print("  " + thegame.getStatus(i,j)); // getStatus
                System.out.println();
            }
            System.out.println();
            System.out.print("Ditt drag: ");
            int i = scan.nextInt();  // h�mta heltal fr�n terminalf�nstret
            int j = scan.nextInt();
            thegame.move(i,j);	                             // move
            System.out.println(thegame.getMessage());	     // getMessage
        }
    }
}