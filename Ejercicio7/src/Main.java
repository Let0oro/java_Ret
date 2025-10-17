import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        String name = in.leerString("Nombre: ");
        String surname = in.leerString("Primer apellido: ");
        String surname2 = in.leerString("Segundo apellido: ");

        int birthDay = in.leerInt("Día de nacimiento: ");
        int birthMonth = in.leerInt("Mes de nacimiento: ");
        int birthYear = in.leerInt("Año de nacimiento: ");

        System.out.printf("\nMe llamo " + name + " " + surname + " " + surname2 +
                " y nací el " + birthDay + "-" + birthMonth + "-" + birthYear);
    }
}
