public class Main {
{
    public static void main(String[] args)
    {

        System.out.println("ENTRADA / SALIDA (I/O)");
        final String name = "Juan Manuel Montero Benavides";
        final String address = "C/Porto Lagos";
        final int numberPortal = 9;
        final int numberDoor = 9;
        final char letterDoor = 'A';
        final String postalCode = "28924";
        final String localidad = "Alcorcón";
        final String provincia = "Madrid";
        final String country = "España";

        System.out.println(name);
        System.out.println(address + " " + numberPortal + ", " + numberDoor + letterDoor + "\n"
            + postalCode + " " + localidad + " " + provincia + "\n"
            + country
        );

    }
}
