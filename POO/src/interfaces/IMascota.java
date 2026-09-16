package interfaces;

public interface IMascota extends Comparable<IMascota>, Cloneable {
    enum Animal{
        perro,
        gato,
        tortuga,
        hamster,
        pajaro,
        pez
    }
    String getNombre();
    Animal getAnimal();
    IMascota setNombre(String nombre);
    Object setAnimal(Animal animal);
    String toString();
    Object clone();
    boolean equals(Object imascota);
    default String getNombreEnMayusculas(){
        return getNombre().toUpperCase();
    }
}
