import lib.in;

public class Main {
    static void main() {
        int alto = in.leerInt("Proporcione el alto de la tabla: ", v -> v >= 2);
        int ancho = in.leerInt("Proporcione el ancho de la tabla: ", v -> v >= 2);
        String salida = "";
        
        alto = 2 * alto + 1;
        ancho = 4 * ancho + 1;

        int limitAlto = alto - 1;
        int limitAncho = ancho - 1;
        
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if (i == 0) {
                    if (j == 0) salida += "┌";
                    else if (j == limitAncho) salida += "┐";
                    else if (j % 4 == 0) salida += "┬";
                    else salida += "─";
                } else if (i == limitAlto) {
                    if (j == 0) salida += "└";
                    else if (j == limitAncho) salida += "┘";
                    else if (j % 4 == 0) salida += "┴";
                    else salida += "─";
                } else if (i % 2 == 0) {
                    if (j == 0) salida += "├";
                    else if (j == limitAncho) salida += "┤";
                    else if (j % 4 == 0) salida += "┼";
                    else salida += "─";
                } else {
                    if (j % 4 == 0) salida += "│";
                    else if (j % 4 == 2) salida += (int) (Math.random() * 2);
                    else salida += " ";
                }
            }
            salida += "\n";
        }

        System.out.println(salida);
    }
}