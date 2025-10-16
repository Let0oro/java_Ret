import lib.in;

// Juan Manuel Montero Benavides
public class Ejercicio2 {
    public static void main(String[] args) {
        int num, sumDig, prodDig, sum, udad, dec, cen, mil;

        num = in.leerInt("Escribe un entero entre 1000 y 9999: ");

        udad = num % 10;
        dec = num % 100 / 10;
        cen = num % 1000 / 100;
        mil = num / 1000;

        sumDig = mil + cen + dec + udad;
        prodDig = mil * cen * dec * udad;

        sum = sumDig + prodDig;

        System.out.printf("%-26s VALOR\n", "CONCEPTO");
        System.out.println("========================== =====");
        System.out.printf("%-26s  %04d\n", "Suma de los dígitos", sumDig);
        System.out.printf("%-26s  %04d\n", "Producto de los dígitos", prodDig);
        System.out.println("                           =====");
        System.out.printf("%26s  %04d", "TOTAL", sum);
    }
}
