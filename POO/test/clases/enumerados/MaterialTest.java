package clases.enumerados;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaterialTest {

    @Test
    void getPrecio() {
    }

    @Test
    void getCalidad() {
    }

    @Test
    void setCalidad() {
    }

    @Test
    void setPrecio() {
        Material m = Material.HIERRO;

        assertEquals(1.8, m.getPrecio());

//        m.setPrecio(5.6);

//        assertEquals(5.6, m.getPrecio());
    }
}