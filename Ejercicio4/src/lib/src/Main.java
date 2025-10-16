import lib.in;

public class Main {
    public static void main(String[] args) {
// -- VARIABLES --
        String ciclo;
        String name;
        int age;
        double weight;
        char dniLetter;
        boolean driver;

        // -- FUNCIONAMIENTO --
        System.out.println("ENTRADA/SALIDA (I/O)");

        ciclo = in.leerLine("Nombre del ciclo: ");
        name = in.leerLine("Nombre: ");
        age = in.leerInt("Edad: ");
        weight = in.leerDouble("Peso: ");
        dniLetter = in.leerChar("Letra del DNI: ");
        driver = in.leerBoolean("Carnet de conducir (true/false): ");

        System.out.println(ciclo + " " + name + " " + age + " " + weight + " " + dniLetter + " " + driver);
        in.detener();
    }
}
