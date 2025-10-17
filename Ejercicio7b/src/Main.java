import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        String finalText = "Me llamo ";

        finalText = finalText + in.leerString("Nombre: ");
        finalText = finalText + " " + in.leerString("Primer apellido: ");
        finalText = finalText + " " + in.leerString("Segundo apellido: ");

        finalText = finalText + " y nací el ";

        finalText = finalText + in.leerInt("Día de nacimiento: ") + "-";
        finalText = finalText + in.leerInt("Mes de nacimiento: ") + "-";
        finalText = finalText + in.leerInt("Año de nacimiento: ");

        System.out.println(finalText);
    }
}
