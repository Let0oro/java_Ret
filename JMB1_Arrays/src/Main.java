import jmb.in;

import static jmb.in.leerString;

public class Main {
    public static void main(String[] args) {
        String input = readString();

        checkMatricula(input);

        int digitOne = countDigitOne(input);
        System.out.printf("Número de veces que aparece en la cadena el dígito 1: %d\n", digitOne);

        int pairs = countPairs(input);
        System.out.printf("Número de veces que aparecen parejas de letras consecutivas en la cadena : %d\n", pairs);
    }

    static String readString() {
        return leerString(
                "Escribe una cadena de 7 caracteres alfanuméricos: ",
                v -> v.matches("[A-Z0-9]{7}"),
                "Has de introducir 7 caracteres, sin espacios, en mayúsculas, sin diéresis ni acentos\n"
        );
    }

    static void checkMatricula(final String str) {
        if (esMatricula(str)) System.out.println("Es una matrícula");
        else System.out.println("No es una matrícula");
    }

    static boolean esMatricula(final String str) {
        return str.matches("[0-9]{4}[A-Z]{3}");
    }

    static int countDigitOne(final String str) {
        //for (char s : str.toCharArray()) countOnes += (s == '1' ? 1 : 0);
        return str.replaceAll("[^1]", "").length();
    }

    static int countPairs(final String str) {
        int countPair = 0;
        for (char c = 'A'; c < 'Z'; c++)
            countPair += str.length() - str.replaceAll(c+""+(char)(c+1), "").length();
//        for (int i = 0; i < str.length()-1; i++) {
//            char c = str.charAt(i);
//            char next = str.charAt(i+1);
//            if ((""+c).matches("[0-9]")) continue;
//            countPair += ((""+next).equals(""+(char)(c+1)) ? 1 : 0);
//        };
        return countPair;
    }

}