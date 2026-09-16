package clases;

import clases.enumerados.Profesion;
import clases.estudiantes.Alumno;
import clases.figuras.Rectangulo;
import interfaces.IMascota;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Predicate;

import static java.lang.Math.pow;
import static java.lang.Math.round;
import static lib.pre.*;

public class Persona implements Comparable<Persona>,Cloneable {
    //region ATRIBUTOS ESTATICOS
    public final static Comparator<Persona> EDAD_ASC = Comparator.comparingInt(Persona::getEdad);
    public final static Comparator<Persona> EDAD_DESC = EDAD_ASC.reversed();
    public final static Comparator<Persona> PESO_ASC = Comparator.comparingDouble(Persona::getPeso);
    public final static Comparator<Persona> PESO_DESC = PESO_ASC.reversed();
    public final static Comparator<Persona> EDAD_ASC_PESO_DESC = EDAD_ASC.thenComparing(PESO_DESC);


    public static Predicate<String> NOMBRE_VAL = patron("[A-ZÑ]+");
    public static Predicate<Integer> EDAD = entre(0,120);
    public static Predicate<Double> ALTURA = entre(0.3,2.2).and(decimales(2));
    public static Predicate<Double> PESO = entre(1.7,140.0).and(decimales(1));
    public static int EDAD_POR_DEFECTO = 0;
    public static double ALTURA_POR_DEFECTO = 0.5;
    public static double PESO_POR_DEFECTO = 2.5;
    //endregion

    //region ATRIBUTOS
    public final String NOMBRE;
    public int EDAD_INICIAL;
    private int edad = EDAD_POR_DEFECTO;
    private double altura = ALTURA_POR_DEFECTO;
    private double peso = PESO_POR_DEFECTO;
    //endregion

    //region GET
    public int getEdad() {
        return edad;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }
    //endregion

    //region SET
    public void setEdad(int edad) {
        if(!EDAD.test(edad))
            throw new IllegalArgumentException("edad");
        int anterior = this.edad;
        this.edad = edad;
        setTotal_edad(total_edad-anterior+this.edad);
    }

    public void setAltura(double altura) {
        if(!ALTURA.test(altura))
            throw new IllegalArgumentException("altura");
        this.altura = altura;
    }

    public void setPeso(double peso) {
        if(!PESO.test(peso))
            throw new IllegalArgumentException("peso");
        this.peso = peso;
    }
    //endregion

    //region CONSTRUCTOR
    public Persona(String nombre) {
        this(nombre,EDAD_POR_DEFECTO,ALTURA_POR_DEFECTO,PESO_POR_DEFECTO);
    }

    public Persona(String nombre, IMascota mascota,int edad, double altura, double peso){
        NOMBRE = nombre;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.mascota = mascota;

        if (getClass().equals(Persona.class)){
            String s;
            if(!(s = validarObjeto()).isEmpty())
                throw new IllegalArgumentException(s);
            setVivos(vivos+1);
            setTotal_edad(total_edad+edad);
            EDAD_INICIAL = this.edad;
        }

    }

    public Persona(String nombre, int edad, double altura, double peso) {
        this(nombre,null,edad,altura,peso);
    }

    public Persona(String nombre, int edad){
        this(nombre, edad,ALTURA_POR_DEFECTO,PESO_POR_DEFECTO);
    }

    public Persona(String nombre, double altura){
        this(nombre,EDAD_POR_DEFECTO,altura,PESO_POR_DEFECTO);
    }

    public Persona(String nombre, int edad, double peso){
        this(nombre,edad,ALTURA_POR_DEFECTO,peso);
    }
    public Persona(String nombre,double peso, int edad){
        this(nombre,edad,peso);
    }

    public Persona(int edad, String nombre, double peso){
        this(nombre,edad,ALTURA_POR_DEFECTO,peso);
    }

    public Persona(int edad, double peso, String nombre){
        this(nombre,edad,ALTURA_POR_DEFECTO,peso);
    }

    public Persona(double peso, String nombre, int edad){
        this(nombre,edad,ALTURA_POR_DEFECTO,peso);
    }

    public Persona(double peso, int edad, String nombre){
        this(nombre,edad,ALTURA_POR_DEFECTO,peso);
    }
    //endregion

    //  region METODOS DE CALCULO

    public double imc()
    {
        double imc = peso / pow(altura, 2);
        return round(imc * 10) / 10.0;
    }

    public boolean isInfantil() {
        return edad >= 0 && edad <= 6;

    }

    public boolean isNino() {
        return edad >= 7 && edad <= 11;

    }
    public boolean isAdolescente() {
        return edad >= 12 && edad <= 18;

    }
    public boolean isJoven() {
        return edad >= 19 && edad <= 25;

    }
    public boolean isAdulto() {
        return edad >= 26 && edad <= 64;

    }

    public boolean isAnciano()
    {
        return edad >= 65;
    }

    //  endregion

    //region METODOS CAMBIO DE ESTADO
    public Persona cumplir(){
        setEdad(edad+1);
        return this;
    }

    public void engordar(double incremento){
        if(incremento<0)
            throw new IllegalArgumentException("engordarIncremento");
        double nuevoPeso = peso+incremento;
        nuevoPeso = round(nuevoPeso*10)/10.0;
        setPeso(nuevoPeso);
    }

    public void engordar(){
        engordar(1);
    }

    public void adelgazar(double decremento){
        if(decremento<0)
            throw new IllegalArgumentException("adelgazarDecremento");
        double nuevoPeso = peso-decremento;
        nuevoPeso = round(nuevoPeso*10)/10.0;
        setPeso(nuevoPeso);
    }

    public void adelgazar(){
        adelgazar(1);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "NOMBRE='" + NOMBRE + '\'' +
                ", "+mascota.toString()+
                ", EDAD_INICIAL=" + EDAD_INICIAL +
                ", edad=" + edad +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return EDAD_INICIAL == persona.EDAD_INICIAL && edad == persona.edad && Double.compare(altura, persona.altura) == 0 && Double.compare(peso, persona.peso) == 0 && Objects.equals(NOMBRE, persona.NOMBRE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NOMBRE, EDAD_INICIAL, edad, altura, peso);
    }

    //endregion

    //region METODOS AUXILIARES
    protected String validarObjeto(){
        StringJoiner s = new StringJoiner("|");

        if (!NOMBRE_VAL.test(NOMBRE)) s.add("nombre");
        if (!EDAD.test(edad)) s.add("edad");
        if (!ALTURA.test(altura)) s.add("altura");
        if (!PESO.test(peso))
            s.add("peso");

        return s.toString();
    }
    //endregion

    //region desorganizado
    private Profesion profesion = Profesion.DESCONOCIDO;

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(@NotNull Profesion profesion) {
        this.profesion = profesion;
    }

    @Override
    public int compareTo(@NotNull Persona p) {
        return NOMBRE.compareTo(p.NOMBRE);
    }


    public enum EstadoCivil
    {
        soltero,
        casado,
        divorciado,
        separado,
        viudo
    }

    private EstadoCivil estadoCivil = EstadoCivil.soltero;

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(@NotNull EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public Persona clone()  {
        try {
            Persona p = (Persona) super.clone();
            p.cuadro = p.cuadro.clone();
            p.mascota = p.mascota!=null? (IMascota) p.mascota.clone():null;
            return p;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private final Rectangulo RECTANGULO_POR_DEFECTO = new Rectangulo(2,2);

    public Rectangulo getRECTANGULO_POR_DEFECTO() {
        return RECTANGULO_POR_DEFECTO.clone();
    }

    private Rectangulo cuadro = RECTANGULO_POR_DEFECTO;

    public Rectangulo getCuadro() {
        return cuadro.clone();
    }

    public void setCuadro(Rectangulo cuadro) {
        this.cuadro = cuadro.clone();
    }
    //endregion


    //region DELEGACION DE METODOS DEL CUADRO

    public char getBorde() {
        return cuadro.getBorde();
    }

    public int getAlto() {
        return cuadro.getAlto();
    }

    public int getAncho() {
        return cuadro.getAncho();
    }

    public char getRelleno() {
        return cuadro.getRelleno();
    }

    public Rectangulo setAncho(int ancho) {
        return cuadro.setAncho(ancho);
    }

    public Rectangulo setAlto(int alto) {
        return cuadro.setAlto(alto);
    }


    private IMascota mascota;

    public IMascota getMascota() {
        return mascota;
    }

    public void setMascota(IMascota mascota) {
        this.mascota = mascota;
    }

    public Persona(String nombre, IMascota imascota){
        this(nombre,imascota,EDAD_POR_DEFECTO,ALTURA_POR_DEFECTO,PESO_POR_DEFECTO);
    }

    //atributos estaticos
    private static int vivos = 0;
    private static int total_edad = 0;

    public static int getVivos() {
        return vivos;
    }



    public static int getTotal_edad() {
        return total_edad;
    }

    private static void setVivos(int vivos) {
        Persona.vivos = vivos;
    }
    private static void setTotal_edad(int total_edad) {
        Persona.total_edad = total_edad;
    }
    //endregion
}
