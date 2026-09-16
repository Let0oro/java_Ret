public interface IMascota extends Comparable<IMascota> {

    enum Animal {

    }

    String getNombre();
    Animal getAnimal();
    IMascota setNombre();
    Object setAnimal();
    String toString();
    Object clone();

    boolean equals(Object imascota);

    default String getNombreUpperCase(){
        return getNombre().toUpperCase();
    }
}