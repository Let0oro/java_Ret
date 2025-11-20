import static lib.in.dormir;

import static java.lang.Math.max;

public class Main {
    static void main() {
        final int fin = 20, time = 250;
        int max = 0;
        System.out.println("\033[2J\033[H");
        int c1, c2, c3, c4, c5, c6;
        c1 = c2 = c3 = c4 = c5 = c6 = 0;
        
        while (max < fin) {
            dormir(time);
            System.out.println("\033[2J\33[H");
            c1 += (int) (Math.random() * 2);
            c2 += (int) (Math.random() * 2);
            c3 += (int) (Math.random() * 2);
            c4 += (int) (Math.random() * 2);
            c5 += (int) (Math.random() * 2);
            c6 += (int) (Math.random() * 2);
            for (int i = 0; i < c1; i++) System.out.print("*");
            System.out.println();
            for (int i = 0; i < c2; i++) System.out.print("*");
            System.out.println();
            for (int i = 0; i < c3; i++) System.out.print("*");
            System.out.println();
            for (int i = 0; i < c4; i++) System.out.print("*");
            System.out.println();
            for (int i = 0; i < c5; i++) System.out.print("*");
            System.out.println();
            for (int i = 0; i < c6; i++) System.out.print("*");
            System.out.println();

            max = max(c1, c2);
            max = max(max, c3);
            max = max(max, c4);
            max = max(max, c5);
            max = max(max, c6);
        }

        System.out.println();
        if (c1 == 20) System.out.println("--- Ha ganado el caballo 1!!! ---");
        if (c2 == 20) System.out.println("--- Ha ganado el caballo 2!!! ---");
        if (c3 == 20) System.out.println("--- Ha ganado el caballo 3!!! ---");
        if (c4 == 20) System.out.println("--- Ha ganado el caballo 4!!! ---");
        if (c5 == 20) System.out.println("--- Ha ganado el caballo 5!!! ---");
        if (c6 == 20) System.out.println("--- Ha ganado el caballo 6!!! ---");

        System.out.print("___________________________");
        dormir(2000);
        System.out.print("\33[3D\33[0K");
        dormir(1000);
        System.out.print("------------");

    }
}