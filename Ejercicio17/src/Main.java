import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        int dec_mil, uni_mil, cen, dec, uni, num_final;

        dec_mil = in.leerInt("Decenas de mil: ");
        uni_mil = in.leerInt("Unidades de mil: ");
        cen = in.leerInt("Centenas: ");
        dec = in.leerInt("Decenas: ");
        uni = in.leerInt("Unidades: ");

        dec_mil = dec_mil * 10000;
        uni_mil = uni_mil * 1000;
        cen = cen * 100;
        dec = dec * 10;

        num_final = dec_mil + uni_mil + cen + dec + uni;


        System.out.println("Numero introducido: " + num_final);
    }
}
