package clases;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import clases.enumerados.Semana;

class RepostarTest {

    @Test
    void constructorGuardaValores() {
        Repostar r = new Repostar(Semana.MARTES, 10.0, 1.5);

        assertEquals(Semana.MARTES, r.getDia());
        assertEquals(10.0, r.getCantidad(), 0.0001);
        assertEquals(1.5, r.getPrecio(), 0.0001);
        assertTrue(r.getCantidad() > 1);
        assertTrue(r.getPrecio() > 0);
    }

    @Test
    void setDiaCambiaDia() {
        Repostar r = new Repostar(Semana.LUNES, 2.0, 1.0);

        assertDoesNotThrow(() -> r.setDia(Semana.DOMINGO));

        assertEquals(Semana.DOMINGO, r.getDia());
        assertTrue(r.getCantidad() > 1);
}

    @Test
    void setDiaLanzaExcepcionSiCantidadInvalida() {
        Repostar r = new Repostar(Semana.LUNES, 1.0, 1.0);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> r.setDia(Semana.MIERCOLES));

       assertNotNull(e);
       assertTrue(e.getMessage().contains("cantidad"));
       assertEquals("cantidad", e.getMessage());
    }

    @Test
    void setCantidadCambiaCantidad() {
        Repostar r = new Repostar(Semana.LUNES, 2.0, 1.0);

        assertDoesNotThrow(() -> r.setCantidad(5.5));

        assertEquals(5.5, r.getCantidad(), 0.0001);
        assertTrue(r.getCantidad() > 1);
    }

    @Test
    void setCantidadLanzaExcepcionSiInvalida() {
        Repostar r = new Repostar(Semana.LUNES, 2.0, 1.0);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> r.setCantidad(1.0));

        assertTrue(e.getMessage().contains("cantidad"));
    }

    @Test
    void setPrecioCambiaPrecio() {
        Repostar r = new Repostar(Semana.LUNES, 2.0, 1.0);

        assertDoesNotThrow(() -> r.setPrecio(3.25));

       assertEquals(3.25, r.getPrecio(), 0.0001);
       assertTrue(r.getPrecio() > 0);
    }

    @Test
    void setPrecioLanzaExcepcionSiCantidadInvalida() {
        Repostar r = new Repostar(Semana.LUNES, 0.5, 1.0);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> r.setPrecio(2.0));

        assertNotNull(e);
        assertTrue(e.getMessage().contains("cantidad"));
    }

    @Test
    void costeCalculaCorrectamente() {
        Repostar r = new Repostar(Semana.LUNES, 3.0, 2.0);

        assertDoesNotThrow(() -> r.coste());
        assertEquals(6.0, r.coste(), 0.0001);
        assertTrue(r.coste() > 0);
    }

    @Test
    void costeConDeepRedondea() {
        Repostar r = new Repostar(Semana.LUNES, 2.3456, 1.0);

        double coste2 = r.coste(2);
        double coste3 = r.coste(3);

        assertEquals(2.35, coste2, 0.0001);
        assertEquals(2.346, coste3, 0.0001);
        assertTrue(coste3 >= coste2);
    }

    @Test
    void costeNoLanzaExcepcion() {
        Repostar r = new Repostar(Semana.VIERNES, 8.0, 1.25);

        assertDoesNotThrow(() -> {
            double c = r.coste();
            assertTrue(c > 0);
        });
    }
}