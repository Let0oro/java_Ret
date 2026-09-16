package jmb.juanma.form01.presenters;

import jmb.juanma.form01.contracts.AplicacionContract;
import jmb.juanma.form01.models.AplicacionModel;

public final class AplicacionPresenter implements AplicacionContract.Actions {
    private final AplicacionModel modelo;
    private final AplicacionContract.View vista;

    public AplicacionPresenter(AplicacionModel modelo, AplicacionContract.View vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setPresentador(this);
    }

    @Override
    public void onDuplicarClick() {
        try {
            String texto = vista.getNumeroText();

            if (!isValidNumber(texto)) {
                throw new NumberFormatException();
            }

            modelo.setNumero(Integer.parseInt(texto));
            int resultado = modelo.duplicar();

            vista.setNumero(String.valueOf(resultado));
            vista.setEstadoText("Número duplicado");
            vista.setDuplicarDisable(false);

        } catch (NumberFormatException e) {
            vista.setEstadoText("Formato incorrecto");
            vista.setDuplicarDisable(true);

        } catch (ArithmeticException e) {
            modelo.setNumero(0);
            vista.setNumero("0");
            vista.setEstadoText("Límite superado, reinicio a 0");
            vista.setDuplicarDisable(false);
        }
    }

    @Override
    public void onNumeroTextChange(String numero_antiguo, String numero_nuevo) {
        if (numero_nuevo == null || numero_nuevo.isEmpty() || numero_nuevo.equals("-")) {
            vista.setEstadoText("Introduce un número");
            vista.setDuplicarDisable(true);
            return;
        }

        if (!isValidNumber(numero_nuevo)) {
            vista.setNumero(numero_antiguo);
            return;
        }

        try {
            modelo.setNumero(Integer.parseInt(numero_nuevo));
            vista.setEstadoText("Número modificado");
            vista.setDuplicarDisable(false);
        } catch (NumberFormatException e) {
            vista.setEstadoText("Formato incorrecto");
            vista.setDuplicarDisable(true);
        }
    }

    private boolean isValidNumber(String n) {
        if (n == null || n.isEmpty()) return false;
        return n.matches("-?(0|[1-9][0-9]*)");
    }
}