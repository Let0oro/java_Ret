package jmb;

import org.junit.jupiter.api.Test;

import static java.lang.Math.pow;
import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.*;

class CocheTest {

    @Test
    void setLitros() {
        Coche c = new Coche("1234ABC", Coche.Combustible.GASOLINA95, 20);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->{
            c.setLitros(-10);
        });

        assertEquals("Tu teléfono móvil",e.getMessage());


        e = assertThrows(IllegalArgumentException.class,()->{
            c.setLitros(Integer.MIN_VALUE);
        });

        assertEquals("Tu teléfono móvil",e.getMessage());

        assertDoesNotThrow(()->{
            c.setLitros(10);
            c.setLitros(0);
            c.setLitros(Integer.MAX_VALUE);
        });
    }



    @Test
    void distancia() {
        Coche c = new Coche("1234ABC", Coche.Combustible.GASOLINA95, 20);

        double calc = 20 * 100 / 3.6;
        calc = (double) round(calc * pow(10, 4)) / pow(10, 4);
        assertEquals(c.distancia(), calc);

        c.setLitros(40);
        calc = 40 * 100 / 3.6;
        calc = (double) round(calc * pow(10, 4)) / pow(10, 4);
        assertEquals(c.distancia(), calc);
    }

    @Test
    void compareTo() {
        Coche c = new Coche("1234ABC", Coche.Combustible.GASOLINA95, 20);
        Coche c1 = new Coche("5423AC", Coche.Combustible.GASOIL, 640);
        Coche c2 = new Coche("1234ABC", Coche.Combustible.GASOLINA98, 40);
        Coche c3 = new Coche("1847DRC", Coche.Combustible.GASOIL, 10);
        Coche c4 = new Coche("9472JDH", Coche.Combustible.GASOLINA95, 40);

        assertNotEquals(c, c1);
        assertEquals(c, c2);
        assertNotEquals(c, c3);
        assertNotEquals(c, c4);

        assertNotEquals(c1, c2);
        assertNotEquals(c1, c3);
        assertNotEquals(c1, c4);

        assertNotEquals(c2, c3);
        assertNotEquals(c2, c4);

        assertNotEquals(c3, c4);
    }
}