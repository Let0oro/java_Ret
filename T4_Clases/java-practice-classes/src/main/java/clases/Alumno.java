package clases;

public class Alumno extends Persona{

    //region CONSTANTS
    public final static String DEFAULT_CENTRO = "Retamar";
    //endregion

    //region VARIABLES
    final private String centro;

    //endregion

    public Alumno () {
        super();
        this.centro = DEFAULT_CENTRO;
    }

    public Alumno(int edad, double peso, String nombre, String centro){
        super(nombre, peso, edad);
        this.centro = centro;
    }

    
}
