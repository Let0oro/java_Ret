package clases.figuras;

import clases.enumerados.Material;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Predicate;

import static java.lang.Math.*;
import static lib.pre.in;
import static lib.pre.min;

public class Rectangulo implements Comparable<Rectangulo>, Cloneable{
    //region ATRIBUTOS DE CLASE/ESTATICOS
    public final static Predicate<Integer> ANCHO = min(2);
    public final static Predicate<Integer> ALTO = min(2);
    public final static Predicate<Character> BORDE = in('*','+','-');
    public final static Predicate<Character> RELLENO = in('*','+','-',' ');
    public final static int ANCHO_POR_DEFECTO = 2;
    public final static int ALTO_POR_DEFECTO = 2;
    public final static char BORDE_POR_DEFECTO = '*';
    public final static char RELLENO_POR_DEFECTO = '+';
    //endregion

    //region ATRIBUTOS

    //region CONSTANTES
    final public int ANCHO_INICIAL;
    final public int ALTO_INICIAL;

    //endregion
    private int ancho = ANCHO_POR_DEFECTO;
    private int alto = ALTO_POR_DEFECTO;
    private char borde = BORDE_POR_DEFECTO;
    private char relleno = RELLENO_POR_DEFECTO;
    //endregion

    //region GET
    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public char getBorde() {
        return borde;
    }

    public char getRelleno() {
        return relleno;
    }
    //endregion

    public Rectangulo setAncho(int ancho) {
        //if(ancho<2)
        if(!ANCHO.test(ancho))
            throw new IllegalArgumentException("ancho");
        this.ancho = ancho;
        return this;
    }

    public Rectangulo setAlto(int alto) {
        if(!ALTO.test(alto))
            throw new IllegalArgumentException("alto");
        this.alto = alto;
        return this;
    }

    public Rectangulo setBorde(char borde) {
        if(!BORDE.test(borde) )
            throw new IllegalArgumentException("borde");
        this.borde = borde;
        return this;
    }

    public Rectangulo setRelleno(char relleno) {
        if(!RELLENO.test(relleno))
            throw new IllegalArgumentException("relleno");
        this.relleno = relleno;
        return this;
    }

    //region CONSTRUCTORES
    public Rectangulo() {
        this(ANCHO_POR_DEFECTO,ALTO_POR_DEFECTO,BORDE_POR_DEFECTO,RELLENO_POR_DEFECTO);
    }

    public Rectangulo(int ancho, int alto, char borde, char relleno) {
        this.ancho = ancho;
        this.alto = alto;
        this.borde = borde;
        this.relleno = relleno;

        String s;
        if(!(s = validarObjeto()).isEmpty())
            throw new IllegalArgumentException(s);

        ALTO_INICIAL = this.alto;
        ANCHO_INICIAL = this.ancho;
    }

    public Rectangulo(int ancho, int alto) {
        this(ancho,alto,BORDE_POR_DEFECTO,RELLENO_POR_DEFECTO);
    }

    public Rectangulo(char borde, char relleno) {
        this(ANCHO_POR_DEFECTO,ALTO_POR_DEFECTO,borde,relleno);
    }

    public Rectangulo(int ancho, char borde, char relleno) {
        this(ancho,ALTO_POR_DEFECTO,borde,relleno);
    }

    public Rectangulo(int ancho, int alto, char borde) {
        this(ancho,alto,borde,RELLENO_POR_DEFECTO);
    }

    //endregion

    //region METODOS DE CÁLCULO
    public int area(){
        return ancho*alto;
    }

    public int perimetro(){
        return 2*(ancho+alto);
    }

    public double diagonal(){
        return sqrt(pow(ancho,2)+pow(alto,2));
    }

    public boolean esCuadrado(){
        return ancho==alto;
    }

    public double diagonal(int n){
        return round(diagonal()*pow(10,abs(n)))/pow(10,abs(n));
    }

    public String dibujar(){
        StringBuilder s = new StringBuilder();
        for(int i=0;i<alto;i++){
            for(int j=0;j<ancho;j++)
                if(i==0||i==alto-1||j==0||j==ancho-1)
                    s.append(borde);
            else s.append(relleno);
            if(i<alto-1) s.append("\n");
        }

        return s.toString();
    }

    public String dimension(){
        return ancho+" x "+alto;
    }

    public String dibujar(String mensaje)
    {
        return mensaje + dibujar();
    }
    //endregion

    //region METODOS DE CAMBIO ESTADO
    public Rectangulo plus(){
        setAncho(ancho+1);
        setAlto(alto+1);
        return this;
    }

    public Rectangulo invertir(){
        int aux = ancho;
        setAncho(alto);
        setAlto(aux);
        return this;
    }

    public Rectangulo restaurar(){
        setAncho(ANCHO_INICIAL);
        setAlto(ALTO_INICIAL);
        return this;
    }
    //endregion

    //region METODOS DE CALCULO REEMPLAZADOS O IMPLEMENTADOS

    @Override
    public String toString() {
        return "Rectangulo{" +
                "relleno=" + relleno +
                ", borde=" + borde +
                ", alto=" + alto +
                ", ancho=" + ancho +
                ", ALTO_INICIAL=" + ALTO_INICIAL +
                ", ANCHO_INICIAL=" + ANCHO_INICIAL +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangulo that = (Rectangulo) o;
        return ancho == that.ancho && alto == that.alto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ancho, alto);
    }


//region

    //region METODOS AUXILIARES
    private String validarObjeto() {
        StringJoiner s = new StringJoiner("|");

        if(!ANCHO.test(ancho)) s.add("ancho");
        if(!ALTO.test(alto)) s.add("alto");
        if(!BORDE.test(borde)) s.add("borde");
        if(!RELLENO.test(relleno)) s.add("relleno");
        return s.toString();
    }
    //end region

    //region desorganizado
    private Material material = Material.MADERA;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(@NotNull Material material) {
        this.material = material;
    }

    @Override
    public int compareTo(@NotNull Rectangulo o) {
        return Double.compare(area(),o.area());
    }

    @Override
    public Rectangulo clone() {
        try {
            return (Rectangulo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
//endregion
}
