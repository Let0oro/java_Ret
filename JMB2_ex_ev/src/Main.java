import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.round;

class Main {
    static void main(String[] args) {

        int n1 = leerNota();
        int p1 = leerPeso();

        int n2 = leerNota();
        int p2 = leerPeso();

        int n3 = leerNota();
        int p3 = leerPeso();

        mostrarInforme(n1, n2, n3, p1, p2, p3);
    }

    static double media(int n1, int n2, int n3, int p1, int p2, int p3) {
        return rDec((double) (n1*p1 + n2*p2 + n3*p3) / (p1+p2+p3) );
    }

    static int leerNota() {
        return leerInt(10, "Nota: ", "Nota incorrecta o desbordada");
    }

    static int leerPeso() {
        return leerInt(5, "Peso: ", "Peso incorrecto o desbordado");
    }

    static int leerInt(int until, String msg, String errorMsg){
        Scanner sc = new Scanner(System.in);
        int num;
        while (true)
            try {
                System.out.print(msg);
                num = sc.nextInt();
                String resto = sc.nextLine();
                if (resto.isEmpty()) {
                    if (num >= 0 && num <= until) break;
                }
                System.out.println(errorMsg);
            } catch (Exception e) {
                System.out.println(errorMsg);
                sc.nextLine();
            }
        return num;
    }

    static double rDec(double number){
        double n = (int) round(number * 10);
        return (n / 10);
    }

    static void mostrarInforme(int n1, int n2, int n3, int p1, int p2, int p3){
        System.out.println("\nNOTA PESO NOTA PESO NOTA PESO MEDIA");
        System.out.println("==== ==== ==== ==== ==== ==== =====");
        double mediaTotal = media(n1, n2, n3, p1, p2, p3);
        System.out.printf ("%4d %4d %4d %4d %4d %4d %5s", n1, p1, n2, p2, n3, p3, mediaTotal);
    }

}