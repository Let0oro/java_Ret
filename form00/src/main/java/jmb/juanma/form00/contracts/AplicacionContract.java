package jmb.juanma.form00.contracts;

public interface AplicacionContract {
    interface View{
        String getNumero1Text();
        String getNumero2Text();

        void setNumero1(String text);
        void setNumero2(String text);

        void setEstadoText(String text);

        void setResultado(String text);

        void setSumarDisable(boolean disable);
        void setRestarDisable(boolean disable);
        void setMultiplicarDisable(boolean disable);
        void setDividirDisable(boolean disable);

        void setPresentador(Actions acciones);
    }

    interface Actions{
        void onSumarClick();
        void onRestarClick();
        void onMultiplicarClick();
        void onDividirClick();
        void onNumero1TextChange(String vi, String nu);
        void onNumero2TextChange(String vi, String nu);
    }
}
