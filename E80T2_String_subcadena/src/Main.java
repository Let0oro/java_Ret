import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static jmb.in.*;

//TODO: Contar las veces que una cadena aparece como subcadena en otra cadena con solapamiento.
class Main {
    static void main(String[] args) {
        String str = leerLine("Escribe una frase: ");
        int currentIndex = -1, count = 0;
        String subStr = leerString("Escribe la subcadena a buscar: ");

//        while ((currentIndex = str.indexOf(subStr, currentIndex+1)) != -1) count++;

        Pattern pattern = Pattern.compile("(" + subStr + ")");
        Matcher match = pattern.matcher(str);

        while (match.find()) count += match.group() != null ? 1 : 0;
        System.out.printf("Número de veces que aparece la subcadena en la frase: %d\n", count);
        detener();



    }
}