package jmb.juanma.form00.models;

final public class AplicacionModel {
    private int numero1;
    private int numero2;

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public void setNumero2(int numero1) {
        this.numero2 = numero1;
    }

    public int sumar(){
        return Math.addExact(numero1, numero2);
    }

    public int restar(){
        return Math.subtractExact(numero1, numero2);
    }

    public int multiplicar(){
        return Math.multiplyExact(numero1, numero2);
    }

    public int dividir(){
        return Math.divideExact(numero1, numero2);
    }



}