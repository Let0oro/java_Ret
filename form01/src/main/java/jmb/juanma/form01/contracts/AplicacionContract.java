package jmb.juanma.form01.contracts;

public interface AplicacionContract {
    interface View{
        String getNumeroText();

        void setNumero(String text);

        void setEstadoText(String text);

        void setDuplicarDisable(boolean disable);

        void setPresentador(Actions acciones);
    }

    interface Actions{
        void onDuplicarClick();
        void onNumeroTextChange(String numero_antiguo, String numero_nuevo);
    }
}
