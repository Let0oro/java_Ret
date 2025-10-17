import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        int radius = in.leerInt("Escribe un radio entero: ");

        double longCircle = 2 * Math.PI * radius;
        double areaCircle = Math.PI * (radius * radius);

        System.out.println("Longitud de la circunferencia: " + longCircle);
        System.out.println("Area de circulo: " + areaCircle);
    }
}
