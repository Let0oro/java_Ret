package clases;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Persona {
    //region CONSTANTES
    public static final int EDAD_DEFAULT = 18;
    public static final double PESO_DEFAULT = 40.0;
    public static final String NOMBRE_DEFAULT = "ANONIMO";

    public static final String ERROR_EDAD_NEG = "La edad ha de ser positiva o cero";
    public static final String ERROR_EDAD_INF = "La edad no puede ser inferior a la actual";
    public static final String ERROR_NOMBRE = "El nombre no puede estar vacío y ha de ser una cadena";
    public static final String ERROR_NOMBRE_MAYUS = "El nombre tiene que ser una palabra en mayúsculas";
    
    public static final String ERROR_PESO_DEC = "El peso ha de tener dos decimales";
    public static final String ERROR_PESO_MAX = "El peso ha de ser inferior a 150kg";
    //endregion

    //region VARIABLES
    private int edad = EDAD_DEFAULT;
    private double peso = PESO_DEFAULT;
    private final String nombre;
    //endregion
    
    //region BUILDERS
    public Persona() {
        this(NOMBRE_DEFAULT, PESO_DEFAULT, EDAD_DEFAULT);
    }
    
    public Persona(String nombre, double peso, int edad) {
        validar(validarEdad(edad, this.edad), validarNombre(nombre), validarPeso(peso));
        this.edad = edad;
        this.peso = peso;
        this.nombre = nombre;
    }
    //endregion

    //region GETTER
    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public String getNombre() {
        return nombre;
    }
    //endregion

    //region SETTER
    public Persona setEdad(int edad) {
        validar(validarEdad(edad, this.edad));
        this.edad = edad;
        return this;
    }

    public Persona setPeso(double peso) {
        this.peso = peso;
        return this;
    }
    //endregion

    //region VALIDADORES
    private static String validarEdad(int edad, int current) {
        if (edad < 0) return ERROR_EDAD_NEG;
        if (current >= edad) return ERROR_EDAD_INF;
        return "";
    }

    private static String validarPeso(double peso) {
        if (peso < 0) return ERROR_EDAD_NEG;
        if (new BigDecimal(""+peso).scale() <= 2) return ERROR_PESO_DEC;
        if (peso < 150) return ERROR_PESO_MAX;
        return "";
    }
    private static String validarNombre(String nombre) {
        if (nombre.isEmpty() || nombre == null) return ERROR_NOMBRE;
        if (!nombre.matches("[A-Z]+")) return ERROR_NOMBRE_MAYUS;
        return "";
    }


    //endregion

    //region VALIDACION_GEN
    public static void validar(String ... mensajes) {
        ArrayList<String> errores = new ArrayList<>();
        for (String mensaje : mensajes) {
            if (!mensaje.isEmpty() && mensaje != null) errores.add(mensaje);
            if (!errores.isEmpty()) throw new IllegalArgumentException(String.join("\n", errores));
        }
    }
    //endregion
}
