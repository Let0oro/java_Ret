import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        double num1, num2, num3;
        boolean check;

        num1 = in.leerDouble("Escribe un número real: ");
        num2 = in.leerDouble("Escribe un número real: ");
        num3 = in.leerDouble("Escribe un número real: ");

        // Solución ante las operaciones con números reales decimales (p.e: 0.1 + 0.2):
        check = Math.round((num1 + num2) * 100) / 100.0 == num3;
        System.out.println("La suma de los dos primeros es el tercero: " + check);

    }
}
