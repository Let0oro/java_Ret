import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        String str1, str2;
        boolean checkEq, checkGr, checkDiff;

        str1 = in.leerString("Escribe una palabra: ");
        str2 = in.leerString("Escribe una palabra: ");

        checkEq = str1.equals(str2);
        checkGr = str1.compareTo(str2) < 0;
        checkDiff = !checkEq;

        System.out.println("Son iguales: " + checkEq);
        System.out.println("La primera es menor que la segunda: " + checkGr);
        System.out.println("Son distintas: " + checkDiff);
    }
}
