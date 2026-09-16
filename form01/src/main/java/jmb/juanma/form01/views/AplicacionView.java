package jmb.juanma.form01.views;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import jmb.juanma.form01.contracts.AplicacionContract;
import javafx.fxml.FXML;

final public class AplicacionView implements AplicacionContract.View {
    private AplicacionContract.Actions acciones; //presentador

    @FXML private TextField numero, estado;
    @FXML private Button duplicar;
    @FXML
    void initialize() {
        duplicar.setOnAction(event -> acciones.onDuplicarClick());
        numero.textProperty().addListener((lis, numero_ant, numero_nue) -> acciones.onNumeroTextChange(numero_ant, numero_nue));
    }

    @Override
    public String getNumeroText() {
        return numero.getText();
    }

    @Override
    public void setNumero(String text) {
        numero.setText(text);
    }

    @Override
    public void setEstadoText(String text) {
        estado.setText(text);
    }

    @Override
    public void setDuplicarDisable(boolean disable) {
        duplicar.setDisable(disable);
    }

    @Override
    public void setPresentador(AplicacionContract.Actions acciones) {
        this.acciones = acciones;
    } // Esto sucede en el Main
}