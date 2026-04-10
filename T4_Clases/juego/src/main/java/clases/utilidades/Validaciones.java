package clases.utilidades;

import java.util.ArrayList;

public class Validaciones {

    public static void validar(String ...mensajes) {
        // Array de tamaño variable
        ArrayList<String> errores = new ArrayList<>();

        // Si un mensaje no está vacío ni es null, lo guardamos como error
        for (String mensaje : mensajes)
            if (mensaje != null && !mensaje.isBlank())
                errores.add(mensaje);

        // Si tenemos errores (el ArrayList no está vacío),
        // los lanzamos todos unidos en una sola cadena
        if (!errores.isEmpty())
            throw new IllegalArgumentException(
                    String.join("\n", errores)
            );
    }

}
