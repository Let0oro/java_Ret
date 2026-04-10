//Hágase un programa que lea un número natural (se validará que es un número natural)
//y lo convierta a binario, octal y hexadecimal. (IntegerConvertir)

import static jmb.in.leerInt;

public class Main {
    public static void main(String[] args) {
        int numero = leerInt("Escribe un número natural", v -> v >= 0, "No es un número natural");
        System.out.println("Número: " + numero);
        System.out.println("Binario:  " + Integer.toBinaryString(numero));
        System.out.println("Octal:  " + Integer.toOctalString(numero));
        System.out.println("Hexadecimal: " + Integer.toHexString(numero).toUpperCase());
    }
}