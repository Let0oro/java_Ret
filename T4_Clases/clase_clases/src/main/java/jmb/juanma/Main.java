package jmb.juanma;

import clases.*;

/**
 * Clase principal para demostración del sistema de dibujo con threads
 */
public class Main {

    public static void main(String[] args) {
        CMD.clearScreen();
        CMD.hideCursor();

        try {
            // Crear personas y superhéroes con diferentes colores
            Persona persona1 = new Persona(
                "Juan",
                5, 5,
                CMD.BRIGHT_YELLOW,  // Pelo rubio
                CMD.BLUE,           // Ojos azules
                CMD.GREEN           // Ropa verde
            );

            Superheroe heroe1 = new Superheroe(
                "Superman",
                25, 5,
                CMD.BLACK,          // Pelo negro
                CMD.BRIGHT_BLUE,    // Ojos azul brillante
                CMD.BLUE,           // Traje azul
                CMD.RED             // Capa roja
            );

            Superheroe heroe2 = new Superheroe(
                "Batman",
                45, 5,
                CMD.BRIGHT_BLACK,   // Pelo negro
                CMD.BRIGHT_WHITE,   // Ojos blancos
                CMD.BRIGHT_BLACK,   // Traje negro
                CMD.YELLOW          // Capa amarilla
            );

            // Dibujar personajes iniciales
            persona1.iniciar();
            heroe1.iniciar();
            heroe2.iniciar();

            // Información en la parte superior
            CMD.drawAt(1, 1, "=== DEMO: Personas y Superhéroes en Terminal ===", CMD.BRIGHT_CYAN);
            CMD.drawAt(2, 1, "Observa los cambios de colores y movimientos...", CMD.WHITE);

            CMD.sleep(2000);

            // Demostración de cambios de color
            CMD.drawAt(15, 1, "Cambiando color de pelo de Juan...", CMD.YELLOW);
            persona1.cambiarColorPelo(CMD.RED);
            CMD.sleep(1000);

            CMD.drawAt(16, 1, "Cambiando color de ojos de Superman...", CMD.YELLOW);
            heroe1.cambiarColorOjos(CMD.GREEN);
            CMD.sleep(1000);

            CMD.drawAt(17, 1, "Cambiando color de capa de Batman...", CMD.YELLOW);
            heroe2.cambiarColorCapa(CMD.MAGENTA);
            CMD.sleep(1000);

            // Movimiento
            CMD.drawAt(18, 1, "Moviendo personajes...", CMD.YELLOW);
            for (int i = 0; i < 3; i++) {
                persona1.mover(persona1.getX() + 2, persona1.getY());
                heroe1.mover(heroe1.getX(), heroe1.getY() + 1);
                heroe2.mover(heroe2.getX() - 2, heroe2.getY());
                CMD.sleep(500);
            }

            CMD.sleep(2000);

            // Limpiar y finalizar
            persona1.detener();
            heroe1.detener();
            heroe2.detener();

            persona1.borrar();
            heroe1.borrar();
            heroe2.borrar();

            CMD.drawAt(20, 1, "¡Demo completada! Presiona Enter para salir...", CMD.BRIGHT_GREEN);
            System.in.read();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CMD.clearScreen();
            CMD.showCursor();
            CMD.drawAt(1, 1, "", CMD.RESET);
        }
    }
}

