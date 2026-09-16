package jmb.juanma.form00.presenters;

import jmb.juanma.form00.contracts.AplicacionContract;
import jmb.juanma.form00.models.AplicacionModel;

final public class AplicacionPresenter implements AplicacionContract.Actions {
    private final AplicacionModel modelo;
    private final AplicacionContract.View vista;

    public AplicacionPresenter(AplicacionModel modelo, AplicacionContract.View vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.setPresentador(this);
    }

    @Override
    public void onSumarClick() {
        vista.setEstadoText("Suma realizada");
    }

    @Override
    public void onRestarClick() {
        vista.setEstadoText("Resta realizada");
    }

    @Override
    public void onMultiplicarClick() {
        vista.setEstadoText("Multiplicacion realizada");
    }

    @Override
    public void onDividirClick() {
        vista.setEstadoText("División realizada");
    }

    @Override
    public void onNumero1TextChange(String vi, String nu) {
        if (!isValidNumber(nu)) {
            vista.setNumero1(vi);
            return;
        }
        try {
            modelo.setNumero1(Integer.parseInt(nu));
            vista.setEstadoText("Primer número modificado");
        } catch (NumberFormatException e) {
            vista.setEstadoText("Formato incorrecto");
        }
        vista.setResultado("");
    }

    @Override
    public void onNumero2TextChange(String vi, String nu) {
        if (!isValidNumber(nu)) {
            vista.setNumero2(vi);
            return;
        }
        try {
            modelo.setNumero2(Integer.parseInt(nu));
            vista.setEstadoText("Segundo número modificado");
        } catch (NumberFormatException e) {
            vista.setEstadoText("Formato incorrecto");
        }
        vista.setResultado("");
    }

    private boolean isValidNumber(String n) {
        try {
            Integer.parseInt(n);
            return !n.isEmpty() && n.matches("-?[1-9][0-9]*|0");
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void hablitarDshabilitaarBotones() {
        
    }

}

