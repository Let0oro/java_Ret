package clases;


public class Superheroe extends Persona {

    private String colorCapa;

    public Superheroe(String nombre, int x, int y, String colorPelo, String colorOjos,
                      String colorRopa, String colorCapa) {
        super(nombre, x, y, colorPelo, colorOjos, colorRopa);
        this.colorCapa = colorCapa;
    }

    @Override
    public void dibujar() {
        // Cabeza y pelo
        CMD.drawAt(y, x + 2, "___", colorPelo);
        CMD.drawAt(y + 1, x + 1, "/", colorPelo);
        CMD.drawAt(y + 1, x + 2, " o", colorOjos);
        CMD.drawAt(y + 1, x + 4, "o ", colorOjos);
        CMD.drawAt(y + 1, x + 6, "\\", colorPelo);

        // Nariz y boca
        CMD.drawAt(y + 2, x + 1, "|", CMD.BRIGHT_BLACK);
        CMD.drawAt(y + 2, x + 2, "  >", CMD.YELLOW);
        CMD.drawAt(y + 2, x + 6, "|", CMD.BRIGHT_BLACK);
        CMD.drawAt(y + 3, x + 1, "\\", CMD.BRIGHT_BLACK);
        CMD.drawAt(y + 3, x + 3, "\\_/", CMD.RED);
        CMD.drawAt(y + 3, x + 6, "/", CMD.BRIGHT_BLACK);

        // Capa superior
        CMD.drawAt(y + 4, x, "|", colorCapa);
        CMD.drawAt(y + 4, x + 2, "/", colorRopa);
        CMD.drawAt(y + 4, x + 3, "|", colorRopa);
        CMD.drawAt(y + 4, x + 4, "|", colorRopa);
        CMD.drawAt(y + 4, x + 5, "\\", colorRopa);
        CMD.drawAt(y + 4, x + 7, "|", colorCapa);

        // Brazos con capa
        CMD.drawAt(y + 5, x, "|", colorCapa);
        CMD.drawAt(y + 5, x + 1, "/", colorRopa);
        CMD.drawAt(y + 5, x + 3, "|", colorRopa);
        CMD.drawAt(y + 5, x + 4, "|", colorRopa);
        CMD.drawAt(y + 5, x + 6, "\\", colorRopa);
        CMD.drawAt(y + 5, x + 7, "|", colorCapa);

        // Capa media
        CMD.drawAt(y + 6, x, "\\", colorCapa);
        CMD.drawAt(y + 6, x + 2, "/", CMD.BLUE);
        CMD.drawAt(y + 6, x + 3, " ", CMD.RESET);
        CMD.drawAt(y + 6, x + 5, "\\", CMD.BLUE);
        CMD.drawAt(y + 6, x + 7, "/", colorCapa);

        // Piernas con capa
        CMD.drawAt(y + 7, x, " \\", colorCapa);
        CMD.drawAt(y + 7, x + 2, "/", CMD.BLACK);
        CMD.drawAt(y + 7, x + 6, "\\", CMD.BLACK);
        CMD.drawAt(y + 7, x + 7, "/", colorCapa);

        System.out.flush();
    }

    @Override
    public void borrar() {
        for (int i = 0; i < 8; i++) {
            CMD.eraseAt(y + i, x, 10);
        }
        System.out.flush();
    }

    public void cambiarColorCapa(String nuevoColor) {
        this.colorCapa = nuevoColor;
        dibujar();
    }

    public void volar(int destX, int destY, int pasos) {
        int deltaX = (destX - x) / pasos;
        int deltaY = (destY - y) / pasos;

        for (int i = 0; i < pasos && running; i++) {
            mover(x + deltaX, y + deltaY);
            CMD.sleep(50);
        }
    }
}
