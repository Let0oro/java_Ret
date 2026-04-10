package clases;

/**
 * Clase utilitaria con comandos y códigos ANSI para manipulación de terminal
 */
public class CMD {

    // === CÓDIGOS DE CONTROL ===
    public static final String RESET = "\033[0m";
    public static final String CLEAR_SCREEN = "\033[2J";
    public static final String CLEAR_LINE = "\033[2K";
    public static final String HIDE_CURSOR = "\033[?25l";
    public static final String SHOW_CURSOR = "\033[?25h";

    // === COLORES DE TEXTO ===
    public static final String BLACK = "\033[30m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
    public static final String MAGENTA = "\033[35m";
    public static final String CYAN = "\033[36m";
    public static final String WHITE = "\033[37m";

    // === COLORES BRILLANTES ===
    public static final String BRIGHT_BLACK = "\033[90m";
    public static final String BRIGHT_RED = "\033[91m";
    public static final String BRIGHT_GREEN = "\033[92m";
    public static final String BRIGHT_YELLOW = "\033[93m";
    public static final String BRIGHT_BLUE = "\033[94m";
    public static final String BRIGHT_MAGENTA = "\033[95m";
    public static final String BRIGHT_CYAN = "\033[96m";
    public static final String BRIGHT_WHITE = "\033[97m";

    // === COLORES DE FONDO ===
    public static final String BG_BLACK = "\033[40m";
    public static final String BG_RED = "\033[41m";
    public static final String BG_GREEN = "\033[42m";
    public static final String BG_YELLOW = "\033[43m";
    public static final String BG_BLUE = "\033[44m";
    public static final String BG_MAGENTA = "\033[45m";
    public static final String BG_CYAN = "\033[46m";
    public static final String BG_WHITE = "\033[47m";

    // === ESTILOS ===
    public static final String BOLD = "\033[1m";
    public static final String DIM = "\033[2m";
    public static final String ITALIC = "\033[3m";
    public static final String UNDERLINE = "\033[4m";
    public static final String BLINK = "\033[5m";
    public static final String REVERSE = "\033[7m";

    /**
     * Mueve el cursor a una posición específica
     */
    public static String moveTo(int row, int col) {
        return "\033[" + row + ";" + col + "H";
    }

    /**
     * Mueve el cursor hacia arriba
     */
    public static String moveUp(int lines) {
        return "\033[" + lines + "A";
    }

    /**
     * Mueve el cursor hacia abajo
     */
    public static String moveDown(int lines) {
        return "\033[" + lines + "B";
    }

    /**
     * Mueve el cursor hacia la derecha
     */
    public static String moveRight(int cols) {
        return "\033[" + cols + "C";
    }

    /**
     * Mueve el cursor hacia la izquierda
     */
    public static String moveLeft(int cols) {
        return "\033[" + cols + "D";
    }

    /**
     * Limpia la pantalla y mueve el cursor al inicio
     */
    public static void clearScreen() {
        System.out.print(CLEAR_SCREEN + moveTo(1, 1));
        System.out.flush();
    }

    /**
     * Oculta el cursor
     */
    public static void hideCursor() {
        System.out.print(HIDE_CURSOR);
        System.out.flush();
    }

    /**
     * Muestra el cursor
     */
    public static void showCursor() {
        System.out.print(SHOW_CURSOR);
        System.out.flush();
    }

    /**
     * Dibuja en una posición específica con color
     */
    public static void drawAt(int row, int col, String text, String color) {
        System.out.print(moveTo(row, col) + color + text + RESET);
        System.out.flush();
    }

    /**
     * Borra una región específica
     */
    public static void eraseAt(int row, int col, int width) {
        System.out.print(moveTo(row, col) + " ".repeat(width));
        System.out.flush();
    }

    /**
     * Espera un tiempo en milisegundos
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
