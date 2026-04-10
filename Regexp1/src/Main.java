import static jmb.in.leerLine;

public class Main {

    static void main() {
        String input = leerLine(
                "Escribe una línea en la que aparezcan 3 unos: ",
//                v -> v.matches("[^1]*1[^1]*1[^1]*1[^1]*"),
                v -> v.matches("[^1]*(1[^1]*){3}"),
                "No aparecen exactamente 3 unos entre el texto\n"
                );

    }
}
