import static java.lang.Math.max;
import static java.lang.Math.min;
import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        double notaMax, notaMin, notaAcum, aux;
        notaAcum = in.leerDouble("Nota 1: ");

        aux = in.leerDouble("Nota 2: ");
        notaMax = max(notaAcum, aux);
        notaMin = min(notaAcum, aux);
        notaAcum += aux;

        aux = in.leerDouble("Nota 3: ");
        notaMax = max(notaMax, aux);
        notaMin = min(notaMin, aux);
        notaAcum += aux;

        aux = in.leerDouble("Nota 4: ");
        notaMax = max(notaMax, aux);
        notaMin = min(notaMin, aux);
        notaAcum += aux;

        aux = in.leerDouble("Nota 5: ");
        notaMax = max(notaMax, aux);
        notaMin = min(notaMin, aux);
        notaAcum += aux;

        aux = in.leerDouble("Nota 6: ");
        notaMax = max(notaMax, aux);
        notaMin = min(notaMin, aux);
        notaAcum += aux;

        aux = in.leerDouble("Nota 7: ");
        notaMax = max(notaMax, aux);
        notaMin = min(notaMin, aux);
        notaAcum += aux;

        aux = in.leerDouble("Nota 8: ");
        notaMax = max(notaMax, aux);
        notaMin = min(notaMin, aux);
        notaAcum += aux;

        aux = in.leerDouble("Nota 9: ");
        notaMax = max(notaMax, aux);
        notaMin = min(notaMin, aux);
        notaAcum += aux;

        aux = in.leerDouble("Nota 10: ");
        notaMax = max(notaMax, aux);
        notaMin = min(notaMin, aux);
        notaAcum += aux;

        notaAcum = (notaAcum - notaMax - notaMin) / 8;

        System.out.println("Puntuación: " + notaAcum);

    }
}
