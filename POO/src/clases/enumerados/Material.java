package clases.enumerados;

import org.jetbrains.annotations.NotNull;

public enum Material {
    MADERA(0.5, 4),
    LATON(1.2, 5),
    HIERRO(1.8, 7),
    ACERO(2.25, 9);

    private double precio = 1.0;
    private int calidad = 1;

    Material(double precio, int calidad) {
        this.precio = precio;
        this.calidad = calidad;
    }

    Material(int calidad, double precio) {
        this(precio, calidad);
    }

    public double getPrecio() {
        return precio;
    }

    public int getCalidad() {
        return calidad;
    }
//
//    public void setCalidad(@NotNull int calidad) {
//        this.calidad = calidad;
//    }
//
//    public void setPrecio(@NotNull double precio) {
//        this.precio = precio;
//    }
}
