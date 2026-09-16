package jmb.juanma.form00.views;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import jmb.juanma.form00.contracts.AplicacionContract;
import javafx.fxml.FXML;

final public class AplicacionView implements AplicacionContract.View {
    private AplicacionContract.Actions acciones; //presentador

    @FXML private TextField numero1, numero2, estado, resultado;
    @FXML private Button sumar, restar, multiplicar, dividir;
    @FXML
    void initialize() {
        sumar.setOnAction(event -> acciones.onSumarClick());
        restar.setOnAction(event -> acciones.onRestarClick());
        multiplicar.setOnAction(event -> acciones.onMultiplicarClick());
        dividir.setOnAction(event -> acciones.onDividirClick());

        numero1.textProperty().addListener((lis, vi, nu) -> acciones.onNumero1TextChange(vi, nu));
        numero2.textProperty().addListener((lis, vi, nu) -> acciones.onNumero2TextChange(vi, nu));
    }


    @Override
    public String getNumero1Text() {
        return numero1.getText();
    }

    @Override
    public String getNumero2Text() {
        return numero2.getText();
    }

    @Override
    public void setNumero1(String text) {
        numero1.setText(text);
    }

    @Override
    public void setNumero2(String text) {
        numero2.setText(text);
    }

    @Override
    public void setEstadoText(String text) { estado.setText(text); }

    @Override
    public void setResultado(String text) { resultado.setText(text); }

    @Override
    public void setSumarDisable(boolean disable) { sumar.setDisable(disable); }

    @Override
    public void setRestarDisable(boolean disable) { restar.setDisable(disable); }

    @Override
    public void setMultiplicarDisable(boolean disable) { multiplicar.setDisable(disable); }

    @Override
    public void setDividirDisable(boolean disable) { dividir.setDisable(disable); }

    @Override
    public void setPresentador(AplicacionContract.Actions acciones) {
        this.acciones = acciones;
    } // Esto sucede en el Main
}