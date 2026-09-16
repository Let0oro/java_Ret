package jmb.juanma.form00.presenters;

import jmb.juanma.form00.contracts.AplicacionContract;
import jmb.juanma.form00.models.AplicacionModel;

final public class AplicacionPresenter implements AplicacionContract.Actions {
    private final AplicacionModel modelo;
    private final AplicacionContract.View vista;

    public AplicacionPresenter(AplicacionModel modelo, AplicacionContract.View vista){
        this.modelo = modelo;
        this.vista = vista;

        vista.setPresentador(this);
    }
}

