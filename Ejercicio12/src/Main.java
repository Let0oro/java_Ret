import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        double num = in.leerDouble("Número real: ");

        int floor = (int) num;
        System.out.println("Truncar: " + floor);

        int roundedMath = (int) Math.round(num);
        System.out.println("Redondear: " + roundedMath);

        double roundedMilsMath = Math.round(num * 1000) / 1000.0;
        System.out.println("Redondear a las milésimas: " + roundedMilsMath);

        int floorDecens = (int) (num / 100) * 100;
        System.out.println("Truncar a las decenas: " + floorDecens);
    }
}