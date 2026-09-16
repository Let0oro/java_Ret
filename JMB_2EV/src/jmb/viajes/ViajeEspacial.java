package jmb.viajes;

import jmb.excepciones.LongitudException;
import jmb.excepciones.ViajeException;
import jmb.interfaces.IDesplazarse;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Predicate;

import static java.lang.Math.round;
import static lib.pre.*;

public class ViajeEspacial implements Comparable<ViajeEspacial>, IDesplazarse {

    //region STATIC_VALUES
    public static final String VIAJE_DEFAULT = "juanmanuel";
    public static final double LONGITUD_DEFAULT = 0.0;

    public static final Predicate<String> VIAJE_VALIDAR = minusculasSinTilde();
    public static final Predicate<Double> LONGITUD_VALIDAR = min(0.0);
    //endregion

    //region PRIVATE_VALUES
    private String viaje = VIAJE_DEFAULT;
    private double longitud = LONGITUD_DEFAULT;
    //endregion

    //region BUILDER
    public ViajeEspacial(String viaje, double longitud){
        this.viaje = viaje;
        this.longitud = longitud;

        if(getClass()== ViajeEspacial.class){
            String s = validarObjeto();
            if(!s.isEmpty())
                throw new IllegalArgumentException(s);
        }
    }
    //endregion

    //region GETTER
    public String getViaje() {
        return viaje;
    }

    public double getLongitud() {
        return longitud;
    }
    //endregion

    //region SETTER
    public ViajeEspacial setViaje(String viaje) {
        if(!VIAJE_VALIDAR.test(viaje))
            throw new ViajeException("Viaje:juanmanuel");

        this.viaje = viaje;
        return this;
    }

    public ViajeEspacial setLongitud(double longitud) {
        if(!LONGITUD_VALIDAR.test(longitud))
            throw new LongitudException("Longitud:monterobenavides");
        this.longitud = longitud;

        return this;
    }
    //endregion

    //region  METODOS AUXILIARES
    protected String validarObjeto() {
        StringJoiner s = new StringJoiner("|");
        if(!VIAJE_VALIDAR.test(viaje))
            s.add("viaje");
        if(!LONGITUD_VALIDAR.test(longitud))
            s.add("longitud");
        return s.toString();
    }
    //endregion

    @Override
    public String toString() {
        return "El viaje "+viaje+ " está a una longitud de "+longitud+" km";
    }

    @Override
    public int compareTo(ViajeEspacial o) {
        if(o==null) return  1;
        return getViaje().compareTo(o.getViaje());
    }

    @Override
    public ViajeEspacial irse() {
        return desplazarse(1);
    }

    @Override
    public ViajeEspacial regresar() {
        return desplazarse(-1);
    }

    @Override
    final public ViajeEspacial desplazarse(double km) {
        return setLongitud(km);
    }

    @Override
    public boolean estaLejos() {
        return longitud > MAXIMA_DISTANCIA;
    }

}
