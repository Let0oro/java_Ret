

public class Main {
    public static void main(String[] args) {
        String str = jmb.in.leerString(
                "Escribe un número en formato hexadecimal: ",
                v -> !v.isBlank() && v.matches("[0-9a-fA-F]+"),
                "Ese no es un númro en formato hex"
        );
        System.out.println("Número introducido (hex): " + str);
        System.out.println("Núemro convertido: " + Long.parseLong(str, 16));
    }
}