package clases;

import java.math.BigDecimal;
import java.util.StringJoiner;

import static java.lang.Math.round;

public class Rebajas {
    /**
     *
     * precio, guarda el precio actual de la rebaja
     * porcentaje de la rebaja
     *
     */

    private double precio = 1.0;
    private int porcentaje = 10;

    //region GETTERS

    public double getPrecio() {
        return precio;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    //endregion

    //region SETTERS

    public Rebajas setPrecio(double precio) {
        if (new BigDecimal(""+precio).scale() < 2 || precio <= 0)
            throw new IllegalArgumentException("El precio debe ser positivo y contar con dos decimales");
        this.precio = precio;
        return this;
    }

    public Rebajas setPorcentaje(int porcentaje) {
        if (porcentaje < 10 || porcentaje > 80)
            throw new IllegalArgumentException("El porcentaje debe estar entre 10 y 80");
        this.porcentaje = porcentaje;
        return this;
    }

    //endregion

    //region BUILDER

    public Rebajas(double precio, int porcentaje) {
        this.precio = precio;
        this.porcentaje = porcentaje;

        StringJoiner s = new StringJoiner("|");
        if (new BigDecimal(""+precio).scale() < 2 || precio <= 0) s.add("El precio debe ser positivo y contar con dos decimales");
        if (porcentaje < 10 || porcentaje > 80) s.add("El porcentaje debe estar entre 10 y 80");
        if (!s.toString().isEmpty()) throw new IllegalArgumentException(s.toString());
    }


    public Rebajas(int porcentaje) {
        this(1.0, porcentaje);
    }

    public Rebajas(double precio) {
        this(precio, 10);
    }

    //endregion


    //region METODOS DE CALCULO

    /**
     * Función para obtener el precio antes de la rebaja
     * @return precio redondeado a dos decimales
     */
    public double precioSinRebaja() {
        double precioSinRebaja = precio/(1-porcentaje)/100;
        return round(precioSinRebaja * 100) / 100.0;
    }

    //endregion


}
