package clases.figuras;

import java.util.Objects;

public class Caja extends Rectangulo {
    private int largo;



    public int volumen() {
        return area()*largo;
    }

    public Caja setLargo(int largo) {
        this.largo = largo;
        return this;
    }

    @Override
    public Caja plus() {
        super.plus();
        return setLargo(largo+1);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Caja caja)) return false;
        if (getAncho()!= caja.getAncho() || getAlto()!=caja.getAlto()) return false;
        return largo == caja.largo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), largo);
    }
}
