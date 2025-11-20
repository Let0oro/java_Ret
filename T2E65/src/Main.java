import lib.in;

import static lib.in.leerEuros;

public class Main {
    public static void main() {
        double euros = leerEuros("Escribe la cantidad de euros: ");
        double cambio = leerCambioEurosADolares("Escribe el cambio de un euro a dólares: ");
        double dolar = cambioEurosADolares(euros, cambio);
        String linea = lineaEurosADolares(euros, cambio, dolar);
        System.out.println(linea);

    }

    static double leerCambioEurosADolares(String mensaje){
        return in.leerDouble(mensaje, v -> v > 0);
    }

    static double cambioEurosADolares(double euros, double cambio){
        return (int)(euros * cambio * 100 / 100.0);
    }

    static String lineaEurosADolares (double euros, double cambio, double dolar){
        return "EUROS: " + euros + " EURO/DÓLAR: " + dolar + " CAMBIO: " + cambio;
    }

}