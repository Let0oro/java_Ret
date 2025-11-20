import lib.in;

public class JMB1 {
    static void main() {

        int num = in.leerInt("Escribe un número a descomponer en centenas, decenas y unidades: ", v -> 1 <= v && v <= 999, "Escribe un número entre 1 y 999");

        int unidades = num % 10;
        int decenas = num / 10 % 10;
        int centenas = num / 100;

        String solucion = "";

        solucion += switch (centenas) {
            case 0 -> "";
            case 1 -> "una centena";
            case 2 -> "dos centenas";
            case 3 -> "tres centenas";
            case 4 -> "cuatro centenas";
            case 5 -> "cinco centenas";
            case 6 -> "seis centenas";
            case 7 -> "siete centenas";
            case 8 -> "ocho centenas";
            default -> "nueve centenas";
        };

        if (centenas > 0) solucion += " ";

        solucion += switch (decenas) {
            case 0 -> "";
            case 1 -> "una decena ";
            case 2 -> "dos decenas ";
            case 3 -> "tres decenas ";
            case 4 -> "cuatro decenas ";
            case 5 -> "cinco decenas ";
            case 6 -> "seis decenas ";
            case 7 -> "siete decenas ";
            case 8 -> "ocho decenas ";
            default -> "nueve decenas ";
        };

        if (decenas > 0) solucion += " ";

        solucion += switch (unidades) {
            case 0 -> "";
            case 1 -> "una unidad";
            case 2 -> "dos unidades";
            case 3 -> "tres unidades";
            case 4 -> "cuatro unidades";
            case 5 -> "cinco unidades";
            case 6 -> "seis unidades";
            case 7 -> "siete unidades";
            case 8 -> "ocho unidades";
            default -> "nueve unidades";
        };

        System.out.println(solucion);
    }

}