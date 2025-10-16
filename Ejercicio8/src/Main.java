import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        int a = in.leerInt("ENTERO: ");
        int b = in.leerInt("ENTERO: ");

        System.out.println("Suma: " + (a + b));
        System.out.println("Resta: " + (a - b));
        System.out.println("Producto: " + a * b);
        System.out.println("Division entera: " + a / b);
        System.out.println("Resto entero: " + a % b);
        System.out.println("Division real: " + 1.0 * a / b);
        System.out.println("Resto real: " + 1.0 * a % b);
    }
}
