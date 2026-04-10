package clases;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    /* ********************** */
    /* DEFAULT BUILDER */
    /* ********************** */
    @Test
    void defBuilder(){
        Usuario u = new Usuario();

        //assertEquals(Usuario.DEFAULT_NOMBRE, u.nombre);
    }

    @Test
    void argsBuilder(){
        Usuario u = new Usuario("Jose", 1.25, 12);
    }


    @Test
    void argsBuilderInvalid(){
        Usuario u = new Usuario("jose", 0.25, -12);



    }
}