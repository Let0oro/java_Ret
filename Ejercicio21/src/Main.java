import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        int question;
        boolean checkEven, checkGreaterThan50;

        question = in.leerInt("Escribe un entero entre 0 y 100: ");

        checkEven = question % 2 == 0;
        checkGreaterThan50 = question > 50;

        System.out.println("Par: " + checkEven);
        System.out.println("Mayor que 50: " + checkGreaterThan50);
    }
}
