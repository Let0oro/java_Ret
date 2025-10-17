import static lib.in.leerInt;

public class Ejercicio4
{
    public static void main(String[] args) {
        int num1 = leerInt();
        int num2 = leerInt();
        int num3 = leerInt();

        if (num1 == num2 + num3) {
            System.out.printf("%d = %d + %d\n", num1, num2, num3);
        } else if (num2 == num1 + num3) {
            System.out.printf("%d = %d + %d\n", num2, num1, num3);
        } else if (num3 == num1 + num2) {
            System.out.printf("%d = %d + %d\n", num3, num1, num2);
        } else {
            System.out.println("Ninguno es suma de los otros dos");
        }

    }
}
