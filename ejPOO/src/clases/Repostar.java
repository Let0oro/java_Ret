package clases;
import clases.enumerados.Semana;
import org.jetbrains.annotations.NotNull;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class Repostar {
    private Semana dia = Semana.LUNES;
    private double cantidad = 1.0;
    private double precio = 0.5;

    public Repostar(Semana dia, double cantidad, double precio) {
        this.dia = dia;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Repostar(double cantidad, Semana dia, double precio) {
        this(dia,cantidad, precio);
    }

    public Repostar(double cantidad, double precio, Semana dia) {
        this(dia,cantidad, precio);
    }


    public Semana getDia() {
        return dia;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public Repostar setDia(@NotNull Semana dia) {
        if (cantidad <= 1) throw new IllegalArgumentException("cantidad");
        this.dia = dia;
        return this;
    }

    public Repostar setCantidad(double cantidad) {
        if (cantidad <= 1) throw new IllegalArgumentException("cantidad");
        this.cantidad = cantidad;
        return this;
    }

    public Repostar setPrecio(double precio) {
        if (cantidad <= 0.5) throw new IllegalArgumentException("cantidad");
        this.precio = precio;
        return this;
    }

    public double coste(int deep) {
        double c = coste();
        double d = pow(10, deep);
        return (double) round(c * d) / d;
    }

    public double coste(){
        return cantidad * precio;
    }


}
