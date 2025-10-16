import lib.in;

public class Main {
{
    public static void main(String[] args) {


        String message = "Edad (entre 0 y 120): ";
        String errMessage = "Edad incorrecta";
        in.leerInt(message, v -> v <= 120 && v >= 0, errMessage);

        message = "Real positivo: ";
        errMessage = "Valor incorrecto";
        in.leerDouble(message, v -> v > 0.0, errMessage);

        message = "Peso (entre 1.0 y 140.0): ";
        errMessage = "El peso tiene que ser un valor entre 1 y 140 con un decimal como máximo";
        in.leerDouble(message, v -> (int) (v * 10) / 10.0 == v && v <= 140 && v >= 1 , errMessage);

        message = "Escribe una vocal sin acentos ni diéresis: ";
        errMessage = "Valor incorrecto";
        in.leerChar(message, v ->
                v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u' ||
                v == 'A' || v == 'E' || v == 'I' || v == 'O' || v == 'U'
                , errMessage);

        message = "Escribe una letra en minúscula: ";
        errMessage = "Valor incorrecto";
        in.leerInt(message,
                v -> v >= 'a' && v <= 'z' || v == 'ñ'
                , errMessage);
    }
}
