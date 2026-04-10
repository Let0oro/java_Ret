


//17. Léase una frase y conviértase cada letra (mayúscula o minúscula) en su letra siguiente
//del abecedario siempre que sea posible (la letra ‘z’ no tiene siguiente, ni las vocales
//acentuadas ni la letra ‘u’ con diéresis). Se observa que la letra ‘n’ se convertirá en ‘ñ’,
//y la ‘ñ’ en ‘o’. (FraseConvertir)

import java.util.Arrays;

import static jmb.in.leerLine;

public class Main {
    static void main(String[] args) {
        String line = leer();
        final char[] arr = line.toCharArray();
        setCharArr(arr);
        showSimple(arr);
    }

    static String leer () {
        return leerLine("Escribe una frase");
    }

    static void setCharArr(final char[] arr) {
        for (int i = 0; i < arr.length; i++) arr[i] = checkLetters(arr, i);
    }

    static char checkLetters(final char[] arr, int i) {
            String letter = arr[i] + "";
            if (letter.equalsIgnoreCase("n")) return 'ñ';
            if (letter.equalsIgnoreCase("ñ")) return 'o';
            if (letter.toLowerCase().matches("[záéíóúäëïöü]")) return arr[i];
            return (char) (arr[i]+1);
    }

    static void showSimple(char[] arr) {
        for (char c : arr) System.out.printf("%c ", c);
    }


}