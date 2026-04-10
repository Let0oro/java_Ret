package clases;

import java.util.Date;

public class Usuario {
    //region ERRORS
    public static final String ERR_NOMBRE = "El nombre ha de ser una cadena, no estar vacía y tener el primer carater en mayúscula";
    public static final String ERR_EDAD_NEG = "Nonamed";
//    public static final String DEFAULT_NOMBRE = "Nonamed";
//    public static final String DEFAULT_NOMBRE = "Nonamed";
//    public static final String DEFAULT_NOMBRE = "Nonamed";
//    public static final String DEFAULT_NOMBRE = "Nonamed";
//    public static final String DEFAULT_NOMBRE = "Nonamed";
    //enregion

    //region DEFAULT
    public static final String DEFAULT_NOMBRE = "Nonamed";
    public static final int DEFAULT_EDAD = 16;
    public static final double DEFAULT_ALTURA = 1.80;
    //endregion

    //region VARIABLES CLASE
    static int count = 0;
    //endregion

    //region CONSTANTES OBJETO
    private final Date date_created;
    private final int number_user;
    //endregion

    //region VARIABLES
    private final String nombre;
    private int edad;
    private double altura;
    //endregion

    //region BUILDERS

    public Usuario(){
        this.nombre = DEFAULT_NOMBRE;
        this.edad = DEFAULT_EDAD;
        this.altura = DEFAULT_ALTURA;
        this.date_created = new Date();
        this.number_user = count++;
    }

    public Usuario(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.date_created = new Date();
        this.number_user = count++;
    }

    //endregion

    //region GETTERS
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getAltura() {
        return altura;
    }

    public static int getCount() {
        return count;
    }

    public Date getDate_created() {
        return date_created;
    }

    public int getNumber_user() {
        return number_user;
    }

    //endregion

    //region SETTERS
    public Usuario setEdad(int edad) {
        if (nombre == null || nombre.isEmpty() || !nombre.matches("[A-Z][a-z]+")) throw new IllegalArgumentException(ERR_NOMBRE);
        this.edad = edad;
        return this;
    }

    public Usuario setAltura(double altura) {
        this.altura = altura;
        return this;
    }

    //endregion

    //region VALIDATORS
//    String validarNombre(){
//
//    }
    //endregion


}
