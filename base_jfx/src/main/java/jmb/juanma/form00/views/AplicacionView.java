package jmb.juanma.form00.views;

import jmb.juanma.form00.contracts.AplicacionContract;
import javafx.fxml.FXML;

final public class AplicacionView implements AplicacionContract.View {
    private AplicacionContract.Actions acciones;

    @FXML
    void initialize() {

    }


    @Override
    public void setPresentador(AplicacionContract.Actions acciones) {
        this.acciones = acciones;
    }
}