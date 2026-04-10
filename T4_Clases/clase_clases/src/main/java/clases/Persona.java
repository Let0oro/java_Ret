package clases;

public class Persona implements Runnable {

    protected int x;
    protected int y;
    protected String colorPelo;
    protected String colorOjos;
    protected String colorRopa;
    protected String nombre;
    protected volatile boolean running;
    protected Thread thread;

    public Persona(String nombre, int x, int y, String colorPelo, String colorOjos, String colorRopa) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.colorPelo = colorPelo;
        this.colorOjos = colorOjos;
        this.colorRopa = colorRopa;
        this.running = false;
    }

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

        // Cuerpo
        CMD.drawAt(y + 4, x + 2, "/", colorRopa);
        CMD.drawAt(y + 4, x + 3, "|", colorRopa);
        CMD.drawAt(y + 4, x + 4, "|", colorRopa);
        CMD.drawAt(y + 4, x + 5, "\\", colorRopa);

        // Brazos
        CMD.drawAt(y + 5, x + 1, "/", colorRopa);
        CMD.drawAt(y + 5, x + 3, "|", colorRopa);
        CMD.drawAt(y + 5, x + 4, "|", colorRopa);
        CMD.drawAt(y + 5, x + 6, "\\", colorRopa);

        // Piernas
        CMD.drawAt(y + 6, x + 2, "/", CMD.BLUE);
        CMD.drawAt(y + 6, x + 3, " ", CMD.RESET);
        CMD.drawAt(y + 6, x + 5, "\\", CMD.BLUE);
        CMD.drawAt(y + 7, x + 1, "/", CMD.BLACK);
        CMD.drawAt(y + 7, x + 6, "\\", CMD.BLACK);

        System.out.flush();
    }

    public void borrar() {
        for (int i = 0; i < 8; i++) {
            CMD.eraseAt(y + i, x, 8);
        }
        System.out.flush();
    }

    public void mover(int newX, int newY) {
        borrar();
        this.x = newX;
        this.y = newY;
        dibujar();
    }

    public void cambiarColorPelo(String nuevoColor) {
        this.colorPelo = nuevoColor;
        dibujar();
    }

    public void cambiarColorOjos(String nuevoColor) {
        this.colorOjos = nuevoColor;
        dibujar();
    }

    public void cambiarColorRopa(String nuevoColor) {
        this.colorRopa = nuevoColor;
        dibujar();
    }

    public void iniciar() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public void detener() {
        running = false;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void run() {
        while (running) {
            dibujar();
            CMD.sleep(100);
        }
    }

    // Getters
    public int getX() { return x; }
    public int getY() { return y; }
    public String getNombre() { return nombre; }
}
