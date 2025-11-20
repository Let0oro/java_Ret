import lib.in;

import static java.lang.Math.max;

public class Main {
    static void main() {
        int a, b, mcm;

        a = in.leerInt("Primer número (1-100): ", v -> v > 0 && v <= 100);
        b = in.leerInt("Segundo número (1-100): ", v -> v > 0 && v <= 100);

        mcm = max(a,b);

        while (mcm % a != 0 || mcm % b != 0) mcm++;

        System.out.println(mcm);
    }
}