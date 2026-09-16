package jmb.juanma.form01.models;

final public class AplicacionModel {
    private int numero;

        public void setNumero(int numero) {
        this.numero = numero;
    }

    public int duplicar(){
        return Math.multiplyExact(2, numero);
    }

}