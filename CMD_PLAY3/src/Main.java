import static lib.in.dormir;

public class Main {
    static void main() {
        final int fin = 20, time = 100, numCab = 6;
        int movC = 0;
        int[] cab = new int[numCab];

        System.out.println("\033[2J\033[H");
        for (int i = 1; i <= numCab; i++) System.out.printf("\33[H\33[%dB%d", i, i);

        while (cab[movC] < fin) {
            dormir(time);
            movC = (int) (Math.random() * 6);
            System.out.printf("\33[H\33[%dB\33[%dC\33[0K_♘ [%d]", movC+1, ++cab[movC], cab[movC]);
        }
        System.out.printf("\33[H\33[7B\n--- Ha ganado el caballo %d!!! ---\n", movC+1);
    }
}