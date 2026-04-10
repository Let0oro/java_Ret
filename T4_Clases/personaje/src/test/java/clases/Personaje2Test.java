package clases;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Personaje2Test {

    @Test
    void testAnnotation(){
        Personaje2 p2 = new Personaje2(10, 20, "PEPE", 12.3);

//        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> p2.setX(-1));
//        assertTrue(e.getMessage().contains("La posición x tiene que estar entre 0 y 100"));
    }

    @Test
    void constructorSuperBuilder(){
        Personaje2 p = Personaje2.builder()
                .y(20)
                .NOMBRE("PEDRO")
                .build();

        assertEquals(0, p.getX());
        assertEquals(20, p.getY());
        assertEquals("PEDRO", p.NOMBRE);
        assertEquals(0.0, p.getAtaque());
    }

    @Test
    void posicionarse (){
        Personaje2 p = Personaje2.builder().build();
        assertThrows(IllegalArgumentException.class, () -> p.)
    }

}
