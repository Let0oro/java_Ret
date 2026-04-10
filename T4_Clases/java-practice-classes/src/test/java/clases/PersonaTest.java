package clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    /* ************************************************ */
    /* COMPROBAR CONSTRUCTOR POR DEFECTO */
    /* ************************************************ */
    @Test
    void Persona(){
        Persona p = new Persona();
    }

    /* ************************************************ */
    /* COMPROBAR CONSTRUCTOR CON ARGUMENTOS */
    /* ************************************************ */
    @Test
    void PersonaConArgumentos(){
        Persona p = new Persona("PEDRO", 25.0, 22);

        assertEquals("PEDRO", p.getNombre());
        assertEquals(25.0, p.getPeso());
        assertEquals(22, p.getEdad());
    }

    /* ************************************************ */
    /* COMPROBAR CONSTRUCTOR CON ARGUMENTOS INVALIDOS */
    /* ************************************************ */
    @Test
    void PersonaConArgumentosInvalidos(){
        Persona p = new Persona(null, 25.0, 22);

        assertEquals("PEDRO", p.getNombre());
        assertEquals(25, p.getNombre());
        assertEquals("PEDRO", p.getNombre());

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Persona("ErroR", ));
        assertEquals(Persona.ERROR_EDAD_NEG, e.getMessage());
    }

    /* ************************************************ */
    /* COMPROBAR LOS GET */
    /* ************************************************ */
    @Test
    void get() {
        Persona p = new Persona();
        assertEquals(Persona.EDAD_DEFAULT, p.getEdad());
        assertEquals(Persona.NOMBRE_DEFAULT, p.getNombre());
        assertEquals(Persona.PESO_DEFAULT, p.getPeso());
    }

    /* ************************************************ */
    /* COMPROBAR LOS SET */
    /* ************************************************ */
    @Test
    void set() {
        Persona p = new Persona();
        p.setPeso(65.0);
        p.setEdad(30);
        assertEquals(30, p.getEdad());
        assertEquals(65.0, p.getPeso());

        // Valor incorrecto por ser negativo
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> p.setEdad(-10));
        assertEquals(Persona.ERROR_EDAD_NEG, e.getMessage());

        // Valor incorrecto por ser menor que la actual
        e = assertThrows(IllegalArgumentException.class, () -> p.setEdad(20));
        assertEquals(Persona.ERROR_EDAD_INF, e.getMessage());

    }

}