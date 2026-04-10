package clases;

import org.junit.jupiter.api.Test;

import static clases.Personaje.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonajeTest {

    /* ******************************** */
    /* Creación por defecto */
    /* ******************************** */
    @Test
    void PersonajePorDefecto(){
        Personaje p = new Personaje();
        assertEquals(X_DEFAULT, p.getX());
        assertEquals(Y_DEFAULT, p.getY());
        assertEquals(ATAQUE_DEFAULT, p.getAtaque());
        assertEquals(NOMBRE_DEFAULT, p.NOMBRE);
    }

    /* ******************************** */
    /* Creación con argumentos válidos */
    /* ******************************** */
    @Test
    void PersonajeValido() {
        Personaje nico = new Personaje(10, 5, "Nico", 5.3);
        assertEquals(10, nico.getX());
        assertEquals(5, nico.getY());
        assertEquals(5.3, nico.getAtaque());
        assertEquals("Nico", nico.NOMBRE);
    }

        /* ******************************** */
    /* Creación con argumentos inválidos */
    /* ******************************** */
    @Test
    void PersonajeInvalido() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new Personaje(16, -23, "", -25.3)
        );
        assertTrue(e.getMessage().contains(Y_ERROR_NEG));
        assertTrue(e.getMessage().contains("El nombre ha de tener entre 2 y más letras en mayúsculas"));
        assertTrue(e.getMessage().contains("No se admiten valores negativos para el ataque"));

    }



    /* ******************************** */
    /* Comprobación setX */
    /* ******************************** */
    @Test
    void setX() {
        //Dato válido
        Personaje john = new Personaje();
        john.setX(10);
        assertEquals(10, john.getX());
        //Dato inválido
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> john.setX(-1)
        );

        assertTrue(e.getMessage().contains("No se admiten valores negativos"));
    }

    @Test
    void iguales(){
        Personaje a = new Personaje(10, 30, "PEPITO", 43.8);
        Personaje b = new Personaje(10, 30, "PEPITO", 18);
        Personaje c = a; // Misma dirección de memoria, es un "alias" de a
        Object d = new Personaje(10, 30, "PEPITO", 3);

        assertEquals(a, c); // .equals() -> son alias, son iguales siempre
        assertSame(a, c); // == -> son alias

        assertEquals(a, b); // Si son iguales, ha de estar programado para ello (tener .equals())
        // assertSame(a, b); // Revisa si son alias, si apuntan a la misma dirección de memoria

        assertEquals(a, d); // Son Personajes, con 'x', 'y', y 'NOMBRE' iguales, como lo hemos definido
        assertInstanceOf(Personaje.class, d);
    }

    @Test
    void conversionString(){
        Personaje a = new Personaje(10, 30, "PEPITO", 43.8);
        assertEquals("Personaje{x=10, y=30, NOMBRE='PEPITO', ataque=43.8}", a.toString()); // Por defecto -> clases.Personaje@8c761f34 (paquete.clase@direccionMemoria)
    }



}