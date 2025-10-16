import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        int numPos, numNeg;
        String mes, errMes;

        mes = "Entero entre 0 y 99999: ";
        errMes = "El valor debe estar entre 0 y 99999, ambos incluidos";
        numPos = in.leerInt( mes, v -> 0 < v && v <= 99999, errMes );

        mes = "Entero entre -10 y 10 distinto de cero: ";
        errMes = "El valor debe estar entre -10 y 10, ambos incluidos y ser distinto de 0";
        numNeg = in.leerInt( mes, v ->  -10 <= v && v <= 10 && v != 0, errMes );
    }
}
