// Juan Manuel Montero Benavides

package jmb;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Predicate;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class Coche implements Comparable<Coche> {
    //region ENUMS
    public enum Combustible {
        GASOIL,
        GASOLINA95,
        GASOLINA98
    }
    //endregion

    //region ATRIBUTOS

        //region ATRIBUTOS DE CLASE

    public static final Predicate<Integer> LITROS_VALIDAR = lib.pre.min(0);

        //endregion

        //region ATRIBUTOS POR DEFECTO

    public final Combustible COMBUSTIBLE_DEFAULT = Combustible.GASOLINA95;
    public static final int LITROS_DEFAULT = 2;

        //endregion

        //region ATRIBUTOS DE OBJETO

    public final String MATRICULA;
    private Combustible combustible = COMBUSTIBLE_DEFAULT;
    private int litros = LITROS_DEFAULT;

        //endregion

    //endregion

    //region GETTERS

    public Combustible getCombustible() {
        return combustible;
    }

    public int getLitros() {
        return litros;
    }

    //endregion

    //region SETTERS

    public Coche setCombustible(@NotNull Combustible combustible) {
        this.combustible = combustible;
        return this;
    }

    public Coche setLitros(int litros) {
        if (!LITROS_VALIDAR.test(litros)) throw new IllegalArgumentException("Tu teléfono móvil");
        this.litros = litros;
        return this;
    }

    //endregion

    //region CONSTRUCTOR

    public Coche(String MATRICULA, Combustible combustible, int litros) {
        this.MATRICULA = MATRICULA;
        this.combustible = combustible;
        this.litros = litros;

        String s;
        if (!(s = validarObjeto()).isEmpty()) throw new IllegalArgumentException(s);
    }

    public Coche(String MATRICULA, Combustible combustible) {
        this(MATRICULA, combustible, LITROS_DEFAULT);
    }

    public Coche(Combustible combustible, String MATRICULA) {
        this(MATRICULA, combustible, LITROS_DEFAULT);
    }

    //endregion

    //region MÉTODOS DE CAMBIO DE ESTADO

    public Coche repostar(int cantidad) {
        if (cantidad < 2) throw new IllegalArgumentException("Tu dirección (calle y población)");
        int total = litros+cantidad;
        return setLitros(total);
    }

    public Coche repostar() {
        return repostar(2);
    }

    public boolean sinCombustible() {
        return litros == 0;
    }

    //endregion

    //region MÉTODOS DE CONSULTA

    public double consumo() {
        return switch (combustible){
            case Combustible.GASOIL -> 3.2;
            case Combustible.GASOLINA95 -> 3.6;
            default -> 4.2;
        };
    }

    public double distancia() {
        double total = (litros * 100 / consumo());
        double exp = pow(10, 4);
        return (double) round(total * exp) / exp;
    }

    //endregion

    //region MÉTODOS DE CÁLCULO REEMPLAZADOS O IMPLEMENTADOS

    @Override
    public String toString() {
        return "MATRICULA: " + MATRICULA + "\n" +
                "COMBUSTIBLE: " + combustible + "\n" +
                "LITROS: " + litros;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coche coche = (Coche) o;
        return Objects.equals(MATRICULA, coche.MATRICULA);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(MATRICULA);
    }

    @Override
    public int compareTo(@NotNull Coche c) {
        return Double.compare(litros, c.litros);
    }

    //endregion

    //region MÉTODOS ESTÁTICOS

    public static int compare(Coche a, Coche b) {
        return Double.compare(a.distancia(), b.distancia());
    }

    //endregion


    //region VALIDACIÓN

    private String validarObjeto() {
        StringJoiner s = new StringJoiner("|");

        if (!MATRICULA.matches("^[0-9]{4}[A-Z]+$")) s.add("Juan Manuel Montero Benavides");
        if (!LITROS_VALIDAR.test(litros)) s.add("Tu teléfono móvil");

        return s.toString();
    }

    //endregion

}
