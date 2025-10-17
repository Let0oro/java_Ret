import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        String weekDay, mes, errMes;

        mes = "Introduzca un día de la semana: ";
        errMes = "Por favor, introduzca un día de la semana, puede introducirlo en minúsculas con la primera letra mayúscula";
        weekDay = in.leerString(
                mes,
                v -> v.equals("Lunes") || v.equals("Martes") || v.equals("Miércoles") ||
                          v.equals("Jueves") || v.equals("Viernes") || v.equals("Sábado") || v.equals("Domingo") ||
                           v.equals("lunes") || v.equals("martes") || v.equals("miércoles") ||
                          v.equals("jueves") || v.equals("viernes") || v.equals("sábado") || v.equals("domingo"),
                errMes
        );
    }
}
