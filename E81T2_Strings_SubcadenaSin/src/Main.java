import static jmb.in.leerLine;
import static jmb.in.leerString;

//TODO: Contar las veces que una cadena aparece como subcadena en otra cadena sin solapamiento.
class Main {
    static void main(String[] args) {
        System.out.println("Número de veces que aaparece la subcadena en la frase: " + (
                leerLine("Escriba una frase: ")
                        .split(leerString("Escribe la subcadena a buscar: ")
                        ).length));
    }
}