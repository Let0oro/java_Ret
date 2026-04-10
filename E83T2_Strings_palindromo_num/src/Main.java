import static jmb.in.leerDouble;
import static jmb.in.leerInt;

//Comprobar si un número es capicúa.
class Main {
    static void main(String[] args) {

        double num = leerDouble("Escribe un número natural: ");
        String numStr = String.valueOf(num).replaceAll("(\\.|0+$)", "");
        num = Integer.parseInt(numStr);

//        System.out.println(numStr.contentEquals(new StringBuilder(num).reverse()) ? "Es capicúa" : "No es capicúa");
        System.out.println(num == Integer.parseInt(new StringBuilder(numStr).reverse().toString()) ? "Es capicúa" : "No es capicúa");

    }
}