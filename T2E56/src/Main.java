import static lib.in.leerLong;

public class Main {
    static void main() {
        long number = leerLong("Introduce tu fecha de nacimiento en formato ddmmaaaa (Ej: 30/12/2004 -> 30122004): ", v -> v > 0);

        do number = number / 10 + number % 10; while (number >= 10);

        System.out.println("Número de la suerte: " + number);
    }
}