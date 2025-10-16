import lib.in;

public class Main {
    public static void main(String[] args) {
        int val1 = in.leerInt("ENTERO: ");
        int val2 = in.leerInt("ENTERO: ");
        int val3 = in.leerInt("ENTERO: ");
        int val4 = in.leerInt("ENTERO: ");
        int val5 = in.leerInt("ENTERO: ");

        int aux = val1;
        System.out.printf("%02d %02d %02d %02d %02d\n", val1, val2, val3, val4, val5);

        val1 = val2;
        val2 = val3;
        val3 = val4;
        val4 = val5;
        val5 = aux;
        System.out.printf("%02d %02d %02d %02d %02d\n", val1, val2, val3, val4, val5);

        in.detener();
    }
}
