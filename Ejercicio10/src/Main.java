import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        int numSeg = in.leerInt("Número de segundos: ");

        /*
         Por cada división, vamos a un nivel mayor,
         pero el resto nos deja el mismo nivel pero
         acotados hasta el máximo valor de su nivel
        */

        int hours = numSeg / 60 / 60, // -> seg/1 / seg/h
            min = numSeg / 60 % 60, // -> seg/1 / seg/min % min/h
            seg = numSeg % 60 % 60 % 60; // -> seg/1 % seg/min % min/h % seg/min

        System.out.println("Horas: " + hours);
        System.out.println("Minutos: " + min);
        System.out.println("Segundos: " + seg);
    }
}
