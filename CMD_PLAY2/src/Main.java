import static lib.in.dormir;

import static java.lang.Math.max;

public class Main {
    static void main() {
        final int fin = 20, time = 100;
        int movC, max, c1, c2, c3, c4, c5, c6;
        movC = max = c1 = c2 = c3 = c4 = c5 = c6 = 0;

        System.out.println("\033[2J\033[H");
        for (int i = 1; i <= 6; i++) System.out.printf("\33[H\33[%dB%d", i, i);

        while (max < fin) {
            dormir(time);
            movC = (int) (Math.random() * 6) + 1;
            switch (movC) {
                case 1  -> System.out.printf("\33[H\33[%dB\33[%dC\33[0K_♘ [%d]", movC, ++c1, c1);
                case 2  -> System.out.printf("\33[H\33[%dB\33[%dC\33[0K_♘ [%d]", movC, ++c2, c2);
                case 3  -> System.out.printf("\33[H\33[%dB\33[%dC\33[0K_♘ [%d]", movC, ++c3, c3);
                case 4  -> System.out.printf("\33[H\33[%dB\33[%dC\33[0K_♘ [%d]", movC, ++c4, c4);
                case 5  -> System.out.printf("\33[H\33[%dB\33[%dC\33[0K_♘ [%d]", movC, ++c5, c5);
                default -> System.out.printf("\33[H\33[%dB\33[%dC\33[0K_♘ [%d]", movC, ++c6, c6);
            }
            max = max(c1, max(c2, max(c3, max(c4, max(c5, c6)))));
        }

        System.out.printf("\33[H\33[7B\n--- Ha ganado el caballo %d!!! ---\n", movC);
    }
}