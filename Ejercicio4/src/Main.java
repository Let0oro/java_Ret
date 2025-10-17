import lib.in;

public class Main {
    public static void main(String[] args) {

        // Primer usuario
        System.out.println("Primer usuario:");
        String name = in.leerLine("Nombre y apellidos: ");

        int age = in.leerInt("Edad: ");

        double height = in.leerDouble("Altura: ");

        boolean driver = in.leerBoolean("Carnet de conducir (true/false): ");

        char dniLetter = in.leerChar("Letra del DNI: ");
        System.out.println(">----------<");

        // Segundo usuario

        System.out.println("Segundo usuario:");
        String name2 = in.leerLine("Nombre y apellidos: ");

        int age2 = in.leerInt("Edad: ");

        double height2 = in.leerDouble("Altura: ");

        boolean driver2 = in.leerBoolean("Carnet de conducir (true/false): ");

        char dniLetter2 = in.leerChar("Letra del DNI: ");

        // printf("%[flags][size]type", v1, v2, ..., vn);

        System.out.printf("\n%-16s %-5s %s %s %s\n", "NOMBRE", "EDAD", "ALTURA", "CARNET", "LETRA");
        System.out.println("================ ===== ====== ====== =====");
        System.out.printf( "%-16s %05d %,6.2f %-6B %5C\n", name2, age2, height2, driver2, dniLetter2);
        System.out.printf( "%-16s %05d %,6.2f %-6B %5C\n", name, age, height, driver, dniLetter);
        System.out.println("-------------------------------------------");

        in.detener();

    }


}
