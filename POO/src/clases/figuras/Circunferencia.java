package clases.figuras;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Predicate;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static lib.pre.minExc;

public class Circunferencia implements Cloneable{
    //region ATRIBUTOS ESTATICOS
    final static public Predicate<Double> RADIO = minExc(0.0);
    static final public double RADIO_POR_DEFECTO = 1;
    //endregion

    //region ATRIBUTOS
    public final double RADIO_INICIAL;
    private double radio = RADIO_POR_DEFECTO ;
    //endregion

    //region GET
    public double getRadio(){
        return radio;
    }
    //endregion

    //region SET
    public void setRadio(double radio){
        if(!RADIO.test(radio))
            throw new IllegalArgumentException("radio");
        this.radio = radio;
    }
    //endregion

    //region CONSTRUCTOR
    public Circunferencia() {
        this(RADIO_POR_DEFECTO );
    }

    public Circunferencia(double radio) {
        this.radio = radio;

        String s;
        if(!(s = validarObjeto()).isEmpty())
            throw new IllegalArgumentException(s);

        RADIO_INICIAL = this.radio;
    }
    //endregion

    // region METODOS DE CALCULO
    public double area(){
        return PI*pow(radio,2);
    }
    public double longitud(){
        return 2*PI*radio;
    }

    public boolean esUnitaria(){
        return radio==1;
    }
    //endregion

    //region METODOS DE CAMBIO DE ESTADO
    public void duplicar(){
        setRadio(radio*2);
    }
    //endregion

    //region METDOS DE CALCULO REEMPLAZADOS O IMPLEMENTADOS

    @Override
    public String toString() {
        return "Circunferencia{" +
                "RADIO_INICIAL=" + RADIO_INICIAL +
                ", radio=" + radio +
                '}';
    }

    //endregion

    //region METODOS AUXILIARES
    private String validarObjeto(){
        StringJoiner s = new StringJoiner("|");
        if(radio<=0) s.add("radio");
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circunferencia that)) return false;
        return Double.compare(RADIO_INICIAL, that.RADIO_INICIAL) == 0
                && Double.compare(radio, that.radio) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(RADIO_INICIAL, radio);
    }

    @Override
    public Circunferencia clone() throws CloneNotSupportedException {
        return (Circunferencia) super.clone();
    }
//endregion
}
