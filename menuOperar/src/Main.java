import lib.Wrap;
import lib.in;

import java.math.BigDecimal;

public class Main {
    static void main() {
//        int opcion = in.menuOpcion("Aspa", "Coste", "Armstrong", "Operar Enteros");
//        switch (opcion){
//            case 1 -> aspa();
//            case 2 -> tablaCoste();
//            case 3 -> armstrong();
//            case 4 -> calc();
//            default -> in.detener();
//        }
        Wrap nums = returnwrap();
        System.out.println(nums);
    }

    static Wrap returnwrap(){
        int a = in.leerInt();
        int b = in.leerInt();
        return new Wrap(a, b);
    }

    static void armstrong() {
        int aux, arm, num;
        aux = arm = num = in.leerInt("Introduce un número para averiguar si es un número armstrong: ", v -> v > 0 && v <= 999999);
        int nCifras = 0;
        do {
            aux /= 10;
            nCifras++;
        } while (aux > 0);

        int calcArm = 0;
        for (int i = 0; i < nCifras; i++) {
            calcArm += (int)(Math.pow(arm%10, nCifras));
            arm /= 10;
        }
        if (calcArm == num) System.out.println(num + " es número armstrong");
        else System.out.println(num + " no es número armstrong, número resultante -> " + calcArm);
    }

    static String calcCliente(int nCliente){
        int nConsumiciones = in.leerInt("¿Cuántas consumiciones ha pedido? ", v -> v > 0 && v <= 10);
        double precioConsumiciones = in.leerDouble("Precio de la consumición: ",  v-> new BigDecimal(""+v).scale() <= 2 && v >= 1 && v <= 2.5);
        double totalCliente = nConsumiciones * precioConsumiciones;

        return String.format("%-12s %8d %7.2f %6.2f\n", nCliente, nConsumiciones, precioConsumiciones, totalCliente);
    }

    static void tablaCoste(){
        int nClientes = in.leerInt("¿Cuántos clientes son?: ");
        String str = "";

        for (int i = 0; i < nClientes; i++) str += calcCliente(i);

        System.out.printf("\n%-12s %-7s %-7s %-6s\n", "Nº CLIENTE", "CANTIDAD", "PRECIO", "TOT. CLIENTE");
        System.out.println("============ ======== ======= ======");
        System.out.println(str);
    }

    static void calc(){
        int opcion = in.menuOpcion("Suma", "Resta", "Multiplicar", "Dividir");
        switch (opcion){
            case 1 -> calcOp("suma");
            case 2 -> calcOp("resta");
            case 3 -> calcOp("multiplicación");
            case 4 -> calcOp("división");
            default -> in.detener();
        }
    }

    static void calcOp(String op){
        in.header(op);
        int a = in.leerInt("Escribe un entero: ");
        int b = in.leerInt("Escribe un entero: ", v -> op.equalsIgnoreCase("división") && v != 0,"No se puede dividir entre 0");
        switch (op.toLowerCase()){
            case "suma" -> System.out.printf("La %s vale %d", op.toLowerCase(), a + b);
            case "resta" -> System.out.printf("La %s vale %d", op.toLowerCase(), a - b);
            case "multiplicación" -> System.out.printf("La %s vale %d", op.toLowerCase(), a * b);
            case "división" -> System.out.printf("La %s vale %d", op.toLowerCase(), a / b);
            default -> {}
        }
    }


    static void aspa(){
        int lado = in.leerInt("introduce el lado: ", v -> v >= 3 && v % 2 != 0);

        String salida = "";

        for (int i = 0; i < lado; i++) {
            salida = "";
            for (int j = 0; j < lado; j++) {
                if (j == i || j == (lado-1-i)) salida += "* ";
                else salida += "  ";
            }
            System.out.println(salida);
        }
    }
}