import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        int num, uni_mil, cen, dec, uni;

        num = in.leerInt("Escribe un número entre 0 y 10000: ");

        uni_mil = num / 1000;
        System.out.println("Unidades de mil: " + uni_mil);

        cen = num % 1000 / 100;
        System.out.println("Centenas: " + cen);

        dec = num % 100 / 10;
        System.out.println("Decenas: " + dec);

        uni = num % 10;
        System.out.println("Unidades: " + uni);
    }
}
