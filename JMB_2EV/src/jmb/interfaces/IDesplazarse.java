package jmb.interfaces;

public interface IDesplazarse {
    int MAXIMA_DISTANCIA = 8000;
    Object irse();
    Object regresar();
    Object desplazarse(double km);
    boolean estaLejos();
}
