package clases.figuras;

import clases.Persona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static clases.figuras.Circunferencia.RADIO_POR_DEFECTO;
import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

class CircunferenciaTest {
    @Test
    void probarAtributosPorDefecto(){
        Circunferencia c = new Circunferencia();

        Assertions.assertEquals(RADIO_POR_DEFECTO,c.getRadio());
        Assertions.assertEquals(RADIO_POR_DEFECTO,c.RADIO_INICIAL);
    }

    @Test
    void probarSetRadio(){
        Circunferencia c = new Circunferencia();
        c.setRadio(2.0);

        Assertions.assertEquals(2.0,c.getRadio());
    }

    @Test
    void probarSetRadioIncorrecto(){
        Circunferencia c = new Circunferencia();
        c.setRadio(2.0);

        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,()->{
            c.setRadio(0);
        });

        Assertions.assertEquals("radio",e.getMessage());

        Assertions.assertDoesNotThrow(()->{
            c.setRadio(0.1);
            c.setRadio(1.787345);
        });
    }


    @Test
    void probarConstructorError(){
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Circunferencia(-10);
        });
        Assertions.assertTrue(e.getMessage().contains("radio"));
    }


    @Test
    void area(){
        Circunferencia c = new Circunferencia(5);
        Assertions.assertEquals(PI * 25, c.area());
    }

    @Test
    void longitud(){
        Circunferencia c = new Circunferencia(5);
        Assertions.assertEquals(PI * 10, c.longitud());
    }

    @Test
    void esUnitario(){
        Circunferencia c = new Circunferencia(5);
        Assertions.assertFalse(c.esUnitaria());

        c.setRadio(1);
        Assertions.assertTrue(c.esUnitaria());
    }


    @Test
    void equals() {
        Circunferencia c = new Circunferencia(3);
        Circunferencia c1 = new Circunferencia(3);

        assertEquals(c1, c);
    }


    @Test
    void distinct() {
        Circunferencia c = new Circunferencia(2);
        Circunferencia c1 = new Circunferencia(3);

        assertNotEquals(c1, c);
    }

    @Test
    void toStringTest() {
        Circunferencia c = new Circunferencia(2);
        assertEquals("Circunferencia{radio=2.0}", c.toString());
    }



}