package clases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static jmb.auxMath.roundCstm;
import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test
    void probarAtributosPorDefecto() {
        Persona p = new Persona("Pablo");

        Assertions.assertEquals(0,p.getEdad());
        Assertions.assertEquals(0.5,p.getAltura());
        Assertions.assertEquals(2.5,p.getPeso());
        Assertions.assertEquals("Pablo",p.NOMBRE);
        Assertions.assertEquals(0,p.EDAD_INICIAL);
    }

    @Test
    void probarSetEdad(){
        Persona p = new Persona("Pablo");
        p.setEdad(10);

        Assertions.assertEquals(10,p.getEdad());
    }

    @Test
    void probarSetEdadIncorrecto(){
        Persona p = new Persona("Pablo");

        //menor que 0
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,()->{
            p.setEdad(-1);
        });
        Assertions.assertEquals("edad",e.getMessage());

        //mayor que 120
        e = Assertions.assertThrows(IllegalArgumentException.class,()->{
            p.setEdad(121);
        });
        Assertions.assertEquals("edad",e.getMessage());

        //entre 0 y 120
        Assertions.assertDoesNotThrow(()->{
            p.setEdad(0);
            p.setEdad(118);
            p.setEdad(120);
        });
    }

    @Test
    void probarSetAltura(){
        Persona p = new Persona("Pablo");
        p.setAltura(1.72);

        Assertions.assertEquals(1.72,p.getAltura());
    }

    @Test
    void probarSetAlturaIncorrecta(){
        Persona p = new Persona("Pablo");

        //menor que 0.3
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,()->{
            p.setAltura(0.29);
        });
        Assertions.assertEquals("altura",e.getMessage());

        //mayor que 120
        e = Assertions.assertThrows(IllegalArgumentException.class,()->{
            p.setAltura(2.3);
        });
        Assertions.assertEquals("altura",e.getMessage());

        //con mas de dos decimales
        e = Assertions.assertThrows(IllegalArgumentException.class,()->{
            p.setAltura(1.876);
        });
        Assertions.assertEquals("altura",e.getMessage());

        //entre 0,3 y 2,2 y un maximo de dos decimales
        Assertions.assertDoesNotThrow(()->{
            p.setAltura(0.3);
            p.setAltura(1.78);
            p.setAltura(2.2);
        });
    }

    @Test
    void probarSetPeso(){
        Persona p = new Persona("Pablo");
        p.setPeso(87.2);

        Assertions.assertEquals(87.2,p.getPeso());
    }

    @Test
    void probarSetPesoIncorrecta(){
        Persona p = new Persona("Pablo");

        //menor que 1.7
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,()->{
            p.setPeso(1.6);
        });
        Assertions.assertEquals("peso",e.getMessage());

        //mayor que 140
        e = Assertions.assertThrows(IllegalArgumentException.class,()->{
            p.setPeso(140.1);
        });
        Assertions.assertEquals("peso",e.getMessage());

        //con mas de un decimal
        e = Assertions.assertThrows(IllegalArgumentException.class,()->{
            p.setPeso(87.34);
        });
        Assertions.assertEquals("peso",e.getMessage());

        //entre 1,7 y 140,0 y un máximo de un decimal
        Assertions.assertDoesNotThrow(()->{
            p.setPeso(1.7);
            p.setPeso(67.5);
            p.setPeso(140);
        });
    }

    @Test
    void probarConstructorError(){
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Persona("Hola", -2, 2.0, 1.3453);
        });

        Assertions.assertTrue(e.getMessage().contains("nombre"));
        Assertions.assertTrue(e.getMessage().contains("edad"));
        Assertions.assertFalse(e.getMessage().contains("altura"));
        Assertions.assertTrue(e.getMessage().contains("peso"));

    }


    @Test
    void imc() {
        Persona p = new Persona("PEPE", 12, 1.8, 65);
        Assertions.assertEquals((double) Math.round(65 * (1.8 * 1.8) * 10) / 10, p.imc());
    }
    
    
    @Test
    void serInfantil(){
        Persona p = new Persona("PEPE", 12, 1.8, 65);

        Assertions.assertFalse(p.serInfantil());
        
        p.setEdad(3);
        Assertions.assertTrue(p.serInfantil());
    }

    @Test
    void serNiño(){
        Persona p = new Persona("PEPE", 12, 1.8, 65);

        Assertions.assertFalse(p.serNiño());

        p.setEdad(8);
        Assertions.assertTrue(p.serNiño());

        p.setEdad(3);
        Assertions.assertFalse(p.serNiño());
    }


    @Test
    void serAdolescente(){
        Persona p = new Persona("PEPE", 12, 1.8, 65);
        Assertions.assertTrue(p.serAdolescente());

        p.setEdad(8);
        Assertions.assertFalse(p.serAdolescente());

        p.setEdad(21);
        Assertions.assertFalse(p.serAdolescente());
    }


    @Test
    void serJoven(){
        Persona p = new Persona("PEPE", 12, 1.8, 65);
        Assertions.assertFalse(p.serJoven());

        p.setEdad(8);
        Assertions.assertFalse(p.serJoven());

        p.setEdad(21);
        Assertions.assertTrue(p.serJoven());
    }


    @Test
    void serAdulto(){
        Persona p = new Persona("PEPE", 12, 1.8, 65);
        Assertions.assertFalse(p.serAdulto());

        p.setEdad(67);
        Assertions.assertFalse(p.serAdulto());

        p.setEdad(37);
        Assertions.assertTrue(p.serAdulto());
    }


    @Test
    void serAnciano(){
        Persona p = new Persona("PEPE", 12, 1.8, 65);
        Assertions.assertFalse(p.serAnciano());

        p.setEdad(67);
        Assertions.assertTrue(p.serAnciano());

        p.setEdad(37);
        Assertions.assertFalse(p.serAnciano());
    }

    @Test
    void cumplir() {
        Persona p = new Persona("PEPE", 12, 1.8, 65);
        Assertions.assertEquals(12, p.getEdad());
        p.cumplir();
        Assertions.assertEquals(13, p.getEdad());

        p.setEdad(120);
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, p::cumplir);
        Assertions.assertTrue(e.getMessage().contains("edad"));

    }

    @Test
    void engordar() {
        Persona p = new Persona("PEPE", 12, 1.8, 65);
        Assertions.assertEquals(65, p.getPeso());
        p.engordar(10);
        Assertions.assertEquals(75, p.getPeso());

        p.setPeso(3.3);
        p.engordar(0.3);
        assertEquals(3.6, p.getPeso());


        p.setPeso(120);
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> p.engordar(30));
        Assertions.assertTrue(e.getMessage().contains("peso"));

        e = Assertions.assertThrows(IllegalArgumentException.class, () -> p.engordar(-30));
        Assertions.assertTrue(e.getMessage().contains("engordarIncremento"));
    }

    @Test
    void adelgazar() {
        Persona p = new Persona("PEPE", 12, 1.8, 65);
        Assertions.assertEquals(65, p.getPeso());
        p.adelgazar(10);
        Assertions.assertEquals(55, p.getPeso());

        p.setPeso(3.3);
        p.adelgazar(0.3);
        assertEquals(3.0, p.getPeso());

        p.setPeso(20);
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> p.adelgazar(30));
        Assertions.assertTrue(e.getMessage().contains("peso"));

        e = Assertions.assertThrows(IllegalArgumentException.class, () -> p.adelgazar(-30));
        Assertions.assertTrue(e.getMessage().contains("adelgazarDecremento"));
    }



    @Test
    void equals() {
        Persona p = new Persona("PEPE");
        Persona p1 = new Persona("PEPE");

        assertEquals(p1, p);
    }


    @Test
    void distinct() {
        Persona p = new Persona("PEPE");
        Persona p1 = new Persona("JUAN");

        assertNotEquals(p1, p);
    }

    @Test
    void toStringTest() {
        Persona p = new Persona("PEPE");
        assertEquals("Persona{NOMBRE='PEPE', edad=0, altura=0.5, peso=2.5, nombre='PEPE'}", p.toString());
    }

    @Test
    void compareTo() {
        Persona p = new Persona("PEDRO");
        Persona p1 = new Persona("ANA");
        Persona p2 = new Persona("YOLANDA");
        Persona p3 = new Persona("PEDRO");

        assertTrue(p.compareTo(p1) > 0);
        assertTrue(p.compareTo(p2) < 0);
        assertEquals(0, p.compareTo(p3));
    }

    @Test
    @SuppressWarnings("unchecked")
    void sortPersonas() {
        Persona p = new Persona("PEDRO");
        Persona p1 = new Persona("ANA");
        Persona p2 = new Persona("YOLANDA");
        Persona p3 = new Persona("PEDRO");

        List<Persona> personas = new ArrayList<>(List.of(p, p1, p2, p3));

        Collections.sort(personas);

        assertIterableEquals(List.of(p1, p, p3, p2), personas);
    }


    @Test
    @SuppressWarnings("unchecked")
    void sortPersonasByEdad() {
        Persona p = new Persona("PEDRO", 13);
        Persona p1 = new Persona("ANA", 23);
        Persona p2 = new Persona("YOLANDA", 10);

        List<Persona> personas = new ArrayList<>(List.of(p, p1, p2));

        personas.sort(Persona.EDAD_ASC);

        assertIterableEquals(List.of(p2, p, p1), personas);
    }




}