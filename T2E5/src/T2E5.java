import static lib.in.leerInt;

public class T2E5
{
    public static void main(String[] args) {
        int num = leerInt();

        System.out.println();
        if (num % 20 == 0) {
            System.out.print("Es");
        } else {
            System.out.print("No es");
        };

        System.out.print(" múltiplo de 20 y ");

        if (!(-100 < num && num < 100)) {
            System.out.print("no ");
        };

        System.out.println("está entre -100 y 100");
    }
}
