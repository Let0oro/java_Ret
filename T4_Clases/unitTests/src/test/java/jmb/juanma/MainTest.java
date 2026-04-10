package jmb.juanma;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    // A A A
    // Organizar, Acción, Afirmar
    @Test
    void sumar(){
        final int valor;
        valor = Main.sumar(3, 5);
        assertEquals(8, valor, "");
    }

    @Test
    void dividir() {
        final int valor;
        valor = Main.dividir(7, 2);
        assertEquals(3, valor);
    }

    @Test
    void dividirEntreCero() {

        IllegalArgumentException e = assertThrows(
            IllegalArgumentException.class,
            () -> Main.dividir(7, 0)
        );

        assertEquals("No se puede dividir entre 0", e.getMessage());
        assertTrue(e.getMessage().contains("No se puede dividir entre 0"));
    }

    @Test
    void dibujar(){
        String s = Main.dibujar(8);
        assertEquals(
                """
                * * * * * * * *\s
                * * * * * * * *\s
                * * * * * * * *\s
                * * * * * * * *\s
                * * * * * * * *\s
                * * * * * * * *\s
                * * * * * * * *\s
                * * * * * * * *\s
                """,
                s
        );
    }


}