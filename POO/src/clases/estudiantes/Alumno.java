package clases.estudiantes;

import interfaces.IMascota;
import clases.Persona;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Predicate;

public class Alumno extends Persona {

    //region ATRIBUTOS FINALES

    static final Predicate<Integer> T_NIA = nia -> nia >= 0;
    static final Predicate<ArrayList<Integer>> T_LISTA_NOTAS = Objects::nonNull;

    //endregion

    //region ATRIBUTOS PRIVADOS
    private int nia = 0;
    private ArrayList<Integer> listaNotas = new ArrayList<>();
    //endregion

    //region BUILDER

    public Alumno(String nombre, int edad, double altura, double peso, IMascota mascota, ArrayList<Integer> listaNotas, int nia) {
        super(nombre, edad, altura, peso);
        this.nia = nia;
        this.listaNotas = listaNotas;

        if (getClass().equals(Alumno.class)){
            String s = validarObjeto();
            if (!s.isEmpty()) throw new  IllegalArgumentException(s);
        }


    }


    //endregion


    //region REPLACE METHODS

    @Override
    protected String validarObjeto() {

        StringJoiner s = new StringJoiner("|");
        s.add(super.validarObjeto());
        if (!T_NIA.test(nia)) s.add("nia");
        if (!T_LISTA_NOTAS.test(listaNotas)) s.add("notas");

        return s.toString();
    }


    //endregion



}
