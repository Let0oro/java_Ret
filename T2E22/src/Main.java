import static lib.in.leerInt;

public class Main {
    static void main() {
        int month = leerInt("Escribe un número correspondiente a un mes del año: ", v -> 0 <= v && v <= 12);
        String finalMonth = "";

        finalMonth = switch (month) {
            case 1 -> "Enero";
            case 2 -> "Febrero";
            case 3 -> "Marzo";
            case 4 -> "Abril";
            case 5 -> "Mayo";
            case 6 -> "Junio";
            case 7 -> "Julio";
            case 8 -> "Agosto";
            case 9 -> "Septiembre";
            case 10 -> "Octube";
            case 11 -> "Noviembre";
            default -> "Diciembre";
        };

        System.out.println("El mes escogido es: " + finalMonth);

    }
}