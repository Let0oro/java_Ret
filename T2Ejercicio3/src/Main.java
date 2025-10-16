import static lib.in.*;

public class Main {
    public static void main(String[] args) {
        int num1,  num2;

        num1 = leerInt();
        num2 = leerInt();

        if (num1 > num2) {
            System.out.println("El primero es mayor que el segundo");
        } else {
            System.out.println("El primero no es mayor que el segundo");
        }
    }
}