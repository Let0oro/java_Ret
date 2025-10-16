import lib.in;
import static java.lang.System.out;

public class Main {
{
    public static void main(String[] args)
    {
        double centigrades = in.leerDouble("Grados centígrados: ");
        double farenheit = centigrades * 9 / 5 + 32;
        double kelvin = centigrades + 273.15;

        farenheit = Math.round(farenheit * 100) / 100.0;
        kelvin = Math.round(kelvin * 100) / 100.0;

        out.printf("Farenheit: %,.2f %11s Kelvin: %,.2f\n", farenheit, "", kelvin);

        farenheit = in.leerDouble("Grados Farenheit: ");

        centigrades = 5 * (farenheit - 32) / 9;
        kelvin = centigrades + 273.15;

        centigrades = Math.round(centigrades * 100) / 100.0;
        kelvin = Math.round(kelvin * 100) / 100.0;

        out.printf("Centígrados: %,.2f %10s Kelvin: %,.2f\n", centigrades, "", kelvin);

        kelvin = in.leerDouble("Grados Kelvin: ");

        centigrades = kelvin - 273.15;
        farenheit = centigrades * 9 / 5 + 32;

        centigrades = Math.round(centigrades * 100) / 100.0;
        farenheit = Math.round(farenheit * 100) / 100.0;

        out.printf("Centígrados: %,.2f %9s Farenheit: %,.2f", centigrades, "", farenheit);

    }
}
