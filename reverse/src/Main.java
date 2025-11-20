import lib.in;

public class Main {
    static void main() {
        int number = in.leerInt("Escribe un número mayor que cero: ", v -> v > 0);

        /* No hay bajada de nota :) */

        if (isCapicua(number)) System.out.println(number + " -> Es capicua!");
        else System.out.println(number + " -> No es capicua...");


        /* finalMessage(number); // -> :( Bajada de nota... */
    }

    static int abs(int number) {
        return number > 0 ? number : -number;
    }

    public static int reverse(int number) {
        number = abs(number); // -> ¿mejor aquí "number > 0 ? number : -number"? Así lo guardo para la librería
        int inverso = 0;
        do {
            inverso = inverso * 10 + number % 10;
            number = number / 10;
        } while (number > 0);
        return inverso;
    }

    public static boolean isCapicua(int number) {
        return number == reverse(number);
    }

    /* ======= Bajada de nota a partir de aquí: ======= */
    /*
    public static boolean isCapicuaB(int number){
        String strNumber = number+"";
        int lenNumber = strNumber.length();
        boolean isReverse = true;
        for (int i = 0; i < lenNumber; i++)
            isReverse = isReverse && strNumber.charAt(i) == strNumber.charAt(lenNumber-1-i);
        return isReverse;
    }

    public static void finalMessage(int number){
        if (isCapicua(number)) successMessage(number); else failMessage(number);
    }

    public static void successMessage(int number){
        System.out.println(number + ": Es capicua!");
    }

    public static void failMessage(int number){
        System.out.println(number + ": No es capicua...");
    }
    */
}