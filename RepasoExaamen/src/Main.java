import jmb.auxMath;
import jmb.in;
import java.util.Scanner;

import static jmb.auxMath.genRandomDouble;
import static jmb.auxMath.genRandomInt;

public class Main {
    static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        menuDosOpciones();

    }


    static int tryCatchScannerLeerInt(Scanner sc, String msg) {
        if (msg.isEmpty()) throw new IllegalArgumentException("El mensaje no puede estar vacío");
        
        int num;
        while (true)
            try {
                System.out.print(msg);
                num = sc.nextInt();
                String resto = sc.nextLine();
                if (resto.isEmpty()) {
                    if (num >= 0 && num <= 120) break;
                    System.out.println("Valor inválido");
                } else 
                    System.out.println("Pulsa Enter después de introducir el dato");
            } catch (Exception e) {
                System.out.println("Valor inválido");
                sc.nextLine();
            }

//        System.out.println("num = " + num);
        return num;
    }

    static String tryCatchScannerLeerString(Scanner sc, String msg) {
        if (msg.isEmpty()) throw new IllegalArgumentException("El mensaje no puede estar vacío");

        String str;
        while (true)
            try {
                System.out.print(msg);
                str = sc.next();
                String resto = sc.nextLine();
                if (resto.isEmpty()) break;
                else System.out.println("Pulsa Enter después de introducir el dato");
            } catch (Exception e) {
                System.out.println("Valor inválido");
                sc.nextLine();
            }

//        System.out.println("num = " + num);
        return str;
    }

    static public void menuDosOpciones() {
        int opcion, len = 2;
        do {
            String salida = ("OPCION ACCION\n====== ====================================\n");
            salida += String.format("%4d   %s\n", 1, "Opcion A");
            salida += String.format("%4d   %s\n", 2, "Opcion B");
            salida += "otro  Terminar\n";
            salida += "-------------------------------------------";
            System.out.println(salida);
            opcion = in.leerInt("OPCION: ");
            switchMenuDosOpciones(opcion);
        } while (opcion > 0 && opcion <= len);
    }

    public static void switchMenuDosOpciones(int opcion) {
        switch (opcion) {
            case 1 -> {
                header("get random int");
                genRandomInt(0, 10);
            }
            case 2 -> {
                header("get random double");
                genRandomDouble(0, 20);
            }
            default -> {}
        }
    }

    public static void header(String op){
        System.out.println("* ***************************** *");
        System.out.printf ("* %-29s *\n", op.toUpperCase());
        System.out.println("* ***************************** *");
    }

    static void acumularAvg() {
        int total = 0, len = 10;
        System.out.println("Paso | Current N | Avg total");
        for (int cant = 1; cant <= len; cant++){
            int current = genRandomInt(0, 10);
            total += current;
            double avg = (double) total / cant;
            System.out.printf("%4d | %09d | %09f", cant, current, avg);
        }

        System.out.println("=============================");
        System.out.printf("TOTAL: %07d | AVG: %07f", total, (double) total / len);

    }





}