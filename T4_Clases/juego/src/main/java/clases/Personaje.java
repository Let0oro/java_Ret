package clases;


import clases.utilidades.Validaciones;

import java.math.BigDecimal;
import java.util.Objects;

import static clases.utilidades.Validaciones.validar;

public class Personaje {

    //region CONSTANTES o números mágicos

    public static final int X_DEFAULT = 50;
    public static final int Y_DEFAULT = 0;
    public static final double ATAQUE_DEFAULT = 0.0;
    public static final String NOMBRE_DEFAULT = "SINNOMBRE";

        //region CONSTANTES DE ERROR
    public static final String Y_ERROR_NEG = "No se admiten valores negativos para avanzar verticalmente";
        //endregion

    //endregion

    //region ATTR
    private int x;
    private int y;
    public final String NOMBRE;
    private double ataque;
    //endregion

    //region CONSTRUCTORES

    public Personaje() {
        this(X_DEFAULT, Y_DEFAULT, NOMBRE_DEFAULT, ATAQUE_DEFAULT);
    }

    public Personaje(int x, int y, String NOMBRE, double ataque) {
        validar(
                validarX(x),
                validarY(y),
                validarNombre(NOMBRE),
                validarAtaque(ataque)
        );
        this.x = x;
        this.y = y;
        this.NOMBRE = NOMBRE;
        this.ataque = ataque;
    }

    //endregion

    //region GETTER
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getAtaque() {
        return ataque;
    }
    //endregion

    //region SETTER

    public void setX(int x) {
        validar(validarX(x));
        this.x = x;
    }

    public void setY(int y) {
        validar(validarY(y));
        this.y = y;
    }

    public void setAtaque(double ataque) {
        validar(validarAtaque(ataque));
        this.ataque = ataque;
    }
    //endregion

    //region validar

    public static String validarX(int x) {
        if (x < 0)
            return "No se admiten valores negativos para avanzar horizontalmente";
        if (x > 100)
            return "No se admiten valores superiores a 100 para avanzar horizontalmente";
        return "";
    }

    public static String validarY(int y) {
        if (y < 0)
            return Y_ERROR_NEG;
        if (y > 100)
            return "No se admiten valores superiores a 100 para avanzar verticalmente";
        return "";
    }

    public static String validarAtaque(double ataque) {
        if (new BigDecimal(""+ataque).scale() >= 2)
            return "El ataque no puede tener más de un decimal";
        if (ataque < 0)
            return "No se admiten valores negativos para el ataque";
        return "";
    }

    public static String validarNombre(String nombre) {
        if (!nombre.matches("[A-ZÑÁÉÍÓÚ]{2,}"))
            return "El nombre ha de tener entre 2 y más letras en mayúsculas";
        return "";
    }

    //endregion

    //region EQUALS

    @Override // Por defecto, solo si son alias, al redefinirlo,se usa @Overrides, que lo sobreescribe
    public boolean equals(Object o) {
        // ¿Es de tipo Personaje o cualquier cosa que derive de personaje (Ej: animal -> perro)? -> instanceof
        if (!(o instanceof Personaje personaje)) return false;
        return x == personaje.x && y == personaje.y && Objects.equals(NOMBRE, personaje.NOMBRE);
    }

    @Override
    public int hashCode() {
        // Calcula a partir de todo el objeto, un número que va a servir para descartar rápidamente la igualdad entre dos, como la letra del DNI, si no son iguales, el número completo no lo va a serr
        return Objects.hash(x, y, NOMBRE);
    }


    //endregion

    //region TOSTRING

    @Override
    public String toString() {
        return "Personaje{" +
                "x=" + x +
                ", y=" + y +
                ", NOMBRE='" + NOMBRE + '\'' +
                ", ataque=" + ataque +
                '}';
    }

    //endregion
}
