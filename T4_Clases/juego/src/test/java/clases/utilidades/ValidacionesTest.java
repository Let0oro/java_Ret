package clases.utilidades;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidacionesTest {

    @Test
    void validaError(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> Validaciones.validar(
                "El número tiene que ser positivo",
                "La cadena no puede estar vacía",
                "",
                null
                )
        );

        assertEquals(
                "El número tiene que ser positivo\nLa cadena no puede estar vacía",
                e.getMessage()
        );

        assertTrue(e.getMessage().contains("El número tiene que ser positivo"));
        assertTrue(e.getMessage().contains("La cadena no puede estar vacía"));

    }

    @Test
    void validarCorrecto() {
        assertDoesNotThrow(
                () -> Validaciones.validar("", null, "    ")
        );
    }
}