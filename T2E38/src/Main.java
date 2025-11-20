import lib.in;

public class Main {
    static void main() {
        final int tableUntil = 10;
        int userNumber = in.leerInt("INTRODUCE UN NÚMERO ENTRE 0 Y 10: ", v -> v >= 0 && v <= 10);

        for (int i = 0; i <= tableUntil; i++) System.out.println(userNumber + " x " + i + " = " + userNumber * i);
    }
}
