import lib.in;

public class Main {
    public static void main(String[] args) {
        // Otra manera:
        String numbersStr = "";
        int first = in.leerInt("ENTERO: ");

        numbersStr += in.leerInt("ENTERO: ") + " ";
        numbersStr += in.leerInt("ENTERO: ") + " ";
        numbersStr += in.leerInt("ENTERO: ") + " ";
        numbersStr += in.leerInt("ENTERO: ");

        System.out.println(first + " " + numbersStr);
        System.out.println(numbersStr + " " + first);
        System.out.println(first + " " + numbersStr);
        in.detener();
    }
}
