import java.util.Scanner;

public class Main {
{
    static public void main(String[] args)
    {
        // -- CONSTANTES LOCALES --
        final Scanner sc = new Scanner(System.in);

        // -- VARIABLES --
        String ciclo;
        String name;
        int age;
        double weight;
        char dniLetter;
        boolean driver;

        // -- FUNCIONAMIENTO --
        System.out.println("ENTRADA/SALIDA (I/O)");

        System.out.print("Nombre del ciclo: ");
        ciclo = sc.nextLine();

        System.out.print("Nombre: ");
        name = sc.nextLine();

        System.out.print("Edad: ");
        age = sc.nextInt();
        sc.nextLine(); //TIP: Limpieza de buffer, no usar después de Scanner.nextLine, porque el buffer ya estaría limpio y esperaría otra entrada

        System.out.print("Peso: ");
        weight = sc.nextDouble();
        sc.nextLine();

        System.out.print("Letra del DNI: ");
        dniLetter = sc.next().charAt(0);
        sc.nextLine();

        System.out.print("Carnet de conducir (true/false): ");
        driver = sc.nextBoolean();
        sc.nextLine();

        System.out.println(ciclo + " " + name + " " + age + " " + weight + " " + dniLetter + " " + driver);
        System.out.println("Pulsa enter para continuar...");
    }
}
