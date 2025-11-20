import lib.in;

import static java.lang.Math.random;
import static lib.in.leerInt;

public class Main {
    public static void main() {tablero();};

    public static void ej40() {
        int res = 1, num = in.leerInt("NÚMERO: ", v -> v >= 0);
        for (int i = res; i <= num; i++) res *= i;
        System.out.println(res);
    }

    public static void ej41() {
        int res, base = in.leerInt("NÚMERO: ", v -> v >= 0 && v < 6);
        int exponente = in.leerInt("NÚMERO: ", v -> v >= 0 && v < 6);
        if (exponente == 0 && base == 0) System.out.println("Error");
        else {
        res = base;
        for (int i = 1; i < exponente; i++) res *= base;
        System.out.printf("%02d^%02d = %02d", base, exponente, exponente == 0 ? 1 : res);
        }
    }

    public static void ej42() {
        int res = 1, num = in.leerInt("NÚMERO: ", v -> v >= 0);
        for (int i = res; i <= num; i++) res *= i;
        System.out.println(res);
    }

    public static void tablero() {
        final int limit = 5;
        for (int i = 0; i < (limit*limit); i++) System.out.printf("%s%s", i / 5 % 2 == 0 ? "*" : "+", ((i+1) % limit) == 0 ? "\n" : "");
    }


}