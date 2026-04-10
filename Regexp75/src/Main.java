import static jmb.in.leerLine;

public class Main {
    static void main() {
        String input = leerLine(
                "Escribe una cadena con la primera letra en mayúscula y las demás en minúsculas: ",
                v -> v.matches("[^a-z]*[A-Z][a-z]+[^A-Z]*")
        );
    }
}
