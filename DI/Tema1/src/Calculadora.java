import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // io_basic(sc);
        // loops();
        // io_int(sc);
        // out_fmt(sc);
        calculator(sc);

        sc.close();
    }

    static void io_basic(Scanner sc) {

        System.out.print("Escribe tu género [f/m]: ");
        char gender = ' ';

        gender = sc.next().charAt(0);
        sc.nextLine();

        if (gender == 'f') {
            System.out.println("Bienvenida");
        } else {
            System.out.println("Bienvenido");
        }

    }

    static void loops() {
        for (int i = 0; i < 5; i += 2) {
            System.out.println(i);
        }
    }

    static int readInt(Scanner sc, String message) {
        int num = 0;
        System.out.print(message);
        num = sc.nextInt();
        sc.nextLine();
        return num;

    }

    public static void io_int(Scanner sc) {
        int n1 = readInt(sc, "Número 1: ");
        int n2 = readInt(sc, "Número 2: ");
        System.out.println(n1 + n2);
    }

    public static void out_fmt(Scanner sc) {
        int n1 = readInt(sc, "Número 1: ");
        int n2 = readInt(sc, "Número 2: ");
        int suma = n1 + n2;
        System.out.printf("%d + %d = %d\n", n1, n2, suma);
    }

    static void calculator(Scanner sc) {
        int opt = 0;
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Salir");

        while (true) {

            opt = readInt(sc, "Elige un operador 1[+] 2[-] 3[*] 4[/] 5[exit]: ");
            if (opt < 1 || opt > 4) break;
            System.out.println();
            int n1 = readInt(sc, "Número 1: ");
            int n2 = readInt(sc, "Número 2: ");
            int sol = 0;

            switch (opt) {
                case 1:
                    sol = n1 + n2;
                    System.out.printf("%d + %d = %d\n", n1, n2, sol);
                    break;
                case 2:
                    sol = n1 - n2;
                    System.out.printf("%d - %d = %d\n", n1, n2, sol);
                    break;
                case 3:
                    for (int i = 0; i < n2; i++) {
                        sol += n1;
                    }
                    System.out.printf("%d * %d = %d\n", n1, n2, sol);
                    break;
                default:
                    sol = n1 / n2;
                    System.out.printf("%d / %d = %d\n", n1, n2, sol);
                    break;
            }

        }
        ;

    }

}
