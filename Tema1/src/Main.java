import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        calculator(sc);

        sc.close();
    }

    static int readInt(Scanner sc, String message) {
        int num = 0;
        System.out.print(message);
        num = sc.nextInt();
        sc.nextLine();
        return num;
    }
    
    static void calculator (Scanner sc) {
        int opt = 0;
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

        };

    }
    
}
