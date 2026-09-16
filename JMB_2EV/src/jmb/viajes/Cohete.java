package jmb.viajes;

import jmb.excepciones.XException;
import jmb.excepciones.ViajeException;
import jmb.excepciones.YException;
import jmb.interfaces.IDesplazarse;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.function.Predicate;

import static lib.pre.*;

final public class Cohete extends ViajeEspacial implements Comparable<Cohete>, IDesplazarse {

    //region STATIC_VALUES
    public static final int X_DEFAULT = 0;
    public static final int Y_DEFAULT = 0;

    public static final Predicate<Integer> X_VALIDAR = entre(-180, 180);
    public static final Predicate<Integer> Y_VALIDAR = entre(-90, 90);
    //endregion

    //region PRIVATE_VALUES
    private int x = X_DEFAULT;
    private int y = Y_DEFAULT;
    //endregion

    //region BUILDER
    public Cohete(String viaje, double longitud, int x, int y){
        super(viaje, longitud);
        this.x = x;
        this.y = y;

        String s = validarObjeto();
        if(!s.isEmpty())
            throw new IllegalArgumentException(s);
    }

    public Cohete(int x, int y){
        this(VIAJE_DEFAULT, LONGITUD_DEFAULT, x, y);
    }
    //endregion

    //region GETTER
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    //endregion

    //region SETTER
    public Cohete setX(int x) {
        if(!X_VALIDAR.test(x))
            throw new XException("X:juanmanuel");
        this.x = x;

        return this;
    }

    public Cohete setY(int y) {
        if(!X_VALIDAR.test(y))
            throw new YException("X:monterobenavides");
        this.y = y;

        return this;
    }
    //endregion

    //region  METODOS AUXILIARES
    protected String validarObjeto() {
        StringJoiner s = new StringJoiner("|");
        if(!X_VALIDAR.test(x))
            s.add("x");
        if(!Y_VALIDAR.test(y))
            s.add("y");
        return s.toString();
    }
    //endregion

    @Override
    public String toString() {
        System.out.println("El satélite está en una posición ("+x+","+y+")\n");
        return super.toString();
    }

    @Override
    public int compareTo(ViajeEspacial vuelo) {
        if (vuelo.getClass() == Cohete.class) return Integer.compare(x*y, ((Cohete) vuelo).x * ((Cohete) vuelo).y);
        return super.compareTo(vuelo);
    }

    @Override
    public Cohete irse() {
        setX(x+1);
        setY(y+1);
        super.irse();
        return this;
    }

    @Override
    public Cohete regresar() {
        setX(x-1);
        setY(y-1);
        super.regresar();
        return this;
    }

    public static void viaje(ArrayList<ViajeEspacial> a){
        for (ViajeEspacial celda : a) {
            celda.irse();
            if (celda.getClass() == Cohete.class) System.out.println("ES UN COHETE");
            else System.out.println("ES UN VIAJE ESPACIAL");
            System.out.println(celda);
        }
    }


}
