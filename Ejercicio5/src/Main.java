import lib.in;

public class Main {
{
    public static void main(String[] args)
    {

        // a) Leer 5 variables enteras (int)
        int val1 = in.leerInt("ENTERO: ");
        int val2 = in.leerInt("ENTERO: ");
        int val3 = in.leerInt("ENTERO: ");
        int val4 = in.leerInt("ENTERO: ");
        int val5 = in.leerInt("ENTERO: ");


        System.out.printf("\n%02d %02d %02d %02d %02d\n", val1, val2, val3, val4, val5);

        // b) Rotar los valores hacia la izquierda
        System.out.printf("%02d %02d %02d %02d %02d\n", val2, val3, val4, val5, val1);

        // Imprimir a
        System.out.printf("%02d %02d %02d %02d %02d\n", val1, val2, val3, val4, val5);

        in.detener();
    }
}
