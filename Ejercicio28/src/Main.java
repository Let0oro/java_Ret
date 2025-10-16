import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        int age, level, pay;
        boolean check;

        age = in.leerInt("Edad (0-100): ");
        level = in.leerInt("Nivel de estudios (0-10): ");
        pay = in.leerInt("Ingresos (0-25.000): ");

        check = age > 40;
        check &= level >= 5 && level <= 8;
        check &= pay < 15000;

        System.out.println("Mas de 40 años y estudios entre 5 y 8 y gana menos de 15000: " + check);
    }
}
