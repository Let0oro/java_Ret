package clases.figuras;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static clases.figuras.Rectangulo.ANCHO_POR_DEFECTO;
import static java.lang.Math.sqrt;
import static jmb.auxMath.roundCstm;
import static org.junit.jupiter.api.Assertions.*;
class RectanguloTest {
    @Test
    void probarAtributosPorDefecto(){

        Rectangulo r = new Rectangulo();
        assertEquals( ANCHO_POR_DEFECTO,r.getAncho());
        assertEquals('*',r.getBorde());
        assertEquals('+',r.getRelleno());
        assertEquals(ANCHO_POR_DEFECTO, r.ANCHO_INICIAL);
        assertEquals(2, r.ALTO_INICIAL);
    }

    @Test
    void probarSetAncho(){
        Rectangulo r = new Rectangulo();
        r.setAncho(10);
        assertEquals(10,r.getAncho());
    }

    @Test
    void probarSetAnchoIncorrecto(){
        Rectangulo r = new Rectangulo();

        //menor que 2
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->{
            r.setAncho(1);
        });
        assertEquals("ancho", e.getMessage());

        Assertions.assertDoesNotThrow(()->{
            r.setAncho(2);
            r.setAncho(Integer.MAX_VALUE);
        });
    }

    @Test
    void probarSetAlto(){
        Rectangulo r = new Rectangulo();
        r.setAlto(10);
        assertEquals(10,r.getAlto());
    }

    @Test
    void probarSetAltoIncorrecto(){
        Rectangulo r = new Rectangulo();

        //menor que 2
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->{
            r.setAlto(1);
        });

        assertEquals("alto", e.getMessage());

        Assertions.assertDoesNotThrow(()->{
            r.setAlto(2);
            r.setAlto(Integer.MAX_VALUE);
        });
    }

    @Test
    void probarSetBorde(){
        Rectangulo r = new Rectangulo();
        r.setBorde('*');
        assertEquals('*',r.getBorde());
    }

    @Test
    void probarSetBordeIncorrecto(){
        Rectangulo r = new Rectangulo();

        //distinto de '+', '*', '-'
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->{
            r.setBorde(' ');
        });
        assertEquals("borde", e.getMessage());

        Assertions.assertDoesNotThrow(()->{
            r.setBorde('*');
            r.setBorde('+');
            r.setBorde('-');
        });
    }

    @Test
    void probarSetRelleno(){
        Rectangulo r = new Rectangulo();
        r.setRelleno('*');
        assertEquals('*',r.getRelleno());
    }

    @Test
    void probarSetRellenoIncorrecto(){
        Rectangulo r = new Rectangulo();

        //distinto de '+', '*', '-', ' '
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->{
            r.setRelleno('a');
        });
        assertEquals("relleno", e.getMessage());

        Assertions.assertDoesNotThrow(()->{
            r.setRelleno('*');
            r.setRelleno('+');
            r.setRelleno('-');
            r.setRelleno(' ');
        });
    }


    @Test
    void area() {
        Rectangulo r = new Rectangulo(3, 4);
        assertEquals(12, r.area()    );
    }
    @Test
    void perimetro() {
        Rectangulo r = new Rectangulo(3, 4);
        assertEquals(14, r.perimetro());
    }

    @Test
    void diagonal() {
        Rectangulo r = new Rectangulo(2, 3);
        assertEquals(sqrt(13), r.diagonal());
    }

    @Test
    void esCuadrado() {
        Rectangulo r = new Rectangulo(2, 3);
        Assertions.assertFalse(r.esCuadrado());

        r.setAncho(3);
        Assertions.assertTrue(r.esCuadrado());
    }


    @Test
    void plus() {
        Rectangulo r = new Rectangulo(2, 3);
        assertEquals(2, r.getAncho());
        assertEquals(3, r.getAlto());

        r.plus();
        assertEquals(3, r.getAncho());
        assertEquals(4, r.getAlto());

        r.setAlto(Integer.MAX_VALUE);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, r::plus);
        assertTrue(e.getMessage().contains("alto"));


        r.setAlto(5);
        r.setAncho(Integer.MAX_VALUE);
        e = assertThrows(IllegalArgumentException.class, r::plus);
        assertTrue(e.getMessage().contains("ancho"));
    }

    @Test
    void invertir() {
        Rectangulo r = new Rectangulo(2, 3);

        r.invertir();
        assertEquals(3, r.getAncho());
        assertEquals(2, r.getAlto());

        r.invertir().invertir();
        assertEquals(3, r.getAncho());
        assertEquals(2, r.getAlto());

    }

    @Test
    void restaurar() {
        Rectangulo r = new Rectangulo(2, 3);

        r.setAncho(30);
        r.setAlto(50);
        r.restaurar();
        assertEquals(2, r.getAncho());
        assertEquals(3, r.getAlto());
    }

    @Test
    void diagonalParametro() {
        Rectangulo r = new Rectangulo(2, 3);

        assertEquals(roundCstm(sqrt(13), 1), r.diagonal(1));
        assertEquals(roundCstm(sqrt(13), 2), r.diagonal(2));
        assertEquals(roundCstm(sqrt(13), 1), r.diagonal(-1));

        assertEquals(r.diagonal(3), r.diagonal(-3));

        assertDoesNotThrow(() -> r.diagonal(10));
    }

    @Test
    void dibujar() {
        Rectangulo r = new Rectangulo(3, 4);
        String s = r.dibujar();
        Assertions.assertEquals("***\n*+*\n*+*\n***", s);

        s = r.dibujar("RECTANGULO\n");
        Assertions.assertEquals("RECTANGULO\n***\n*+*\n*+*\n***", s);
    }


    @Test
    void dimension() {
        Rectangulo r = new Rectangulo(3, 4);
        String s = r.dimension();
        Assertions.assertEquals("3 x 4", s);
    }

    @Test
    void equals() {
        Rectangulo r = new Rectangulo(3, 4);
        Rectangulo r1 = new Rectangulo(3, 4);

        assertEquals(r1, r);
    }


    @Test
    void distinct() {
        Rectangulo r = new Rectangulo(2, 4);
        Rectangulo r1 = new Rectangulo(3, 4);

        assertNotEquals(r1, r);

        Rectangulo r2 = new Rectangulo(2, 3);

        assertNotEquals(r2, r);
        assertNotEquals(r2, r1);
    }

    @Test
    void toStringTest() {
        Rectangulo r = new Rectangulo(2, 4);
        assertEquals("Rectangulo{ANCHO_INICIAL=2, ALTO_INICIAL=4, ancho=2, alto=4, borde=*, relleno=+}", r.toString());
    }

    @Test
    void hash() {
        Rectangulo r = new Rectangulo(5, 3);
        Rectangulo r1 = new Rectangulo(5, 3);

        int n = r.hashCode();
        int n1 = r1.hashCode();

        assertEquals(n, n1);
    }


    @Test
    void compareTo() {
        Rectangulo r = new Rectangulo(2, 3);
        Rectangulo r1 = new Rectangulo(1, 2);
        Rectangulo r2 = new Rectangulo(3, 4);
        Rectangulo r3 = new Rectangulo(2, 3);

        assertTrue(r.compareTo(r1) > 0);
        assertTrue(r.compareTo(r2) < 0);
        assertEquals(0, r.compareTo(r3));
    }

}