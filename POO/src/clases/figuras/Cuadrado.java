package clases.figuras;

final public class Cuadrado extends Rectangulo {

    @Override
    public int getAlto() {
        return super.getAlto();
    }

    @Override
    public Cuadrado setAlto(int alto) {
        super.setAlto(alto);
        if (getAlto() != getAncho()) setAncho(getAlto());
        return this;
    }

    @Override
    public Cuadrado setAncho(int ancho) {
        super.setAncho(ancho);
        if (getAlto() != getAncho()) setAlto(getAncho());
        return this;
    }

    @Override
    public Cuadrado plus() {
        return setAncho(getAncho()+1);
    }
}
