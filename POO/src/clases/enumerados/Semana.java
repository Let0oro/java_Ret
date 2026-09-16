package clases.enumerados;

public enum Semana {
    LUNES(1),
    MARTES(2),
    MIERCOLES(3),
    JUEVES(4),
    VIERNES(5),
    SABADO(6),
    DOMINGO(7);

    private final int dia;

    Semana(int dia){this.dia = dia;}

    public int getDia() {
        return dia;
    }
}
