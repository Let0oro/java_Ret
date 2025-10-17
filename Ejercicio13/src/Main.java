import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        double value = in.leerDouble("Valor de la compra (entre 0.00 y 500.00): ");
        int iva = in.leerInt("IVA (entre 0 y 25%): ");

        double withoutIva = value * 100 / (100 + iva);
        double valueIva = value - withoutIva;

        withoutIva = Math.round(withoutIva * 100) / 100.0;
        valueIva = Math.round(valueIva * 100) / 100.0;

        value = Math.round((withoutIva + valueIva) * 100) / 100.0;

        System.out.printf("%-10s %6s", "Compra: ", withoutIva);
        System.out.printf("\n%-10s %6s", "IVA: ", valueIva);
        System.out.printf("\n%-10s ======", "");
        System.out.printf("\n%-10s %6s", "", value);

    }
}
