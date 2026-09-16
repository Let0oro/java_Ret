package clases;

import interfaces.IMascota;
import org.jetbrains.annotations.NotNull;

public class Mascota implements IMascota {
    public String saludar(){
        return "Hola, me llamo "+getNombre();
    }
    @Override
    public String getNombreEnMayusculas() {
        return IMascota.super.getNombreEnMayusculas()+";"+getNombre().toLowerCase();
    }

    @Override
    public String getNombre() {
        return "";
    }

    @Override
    public Animal getAnimal() {
        return null;
    }

    @Override
    public IMascota setNombre(String nombre) {
        return null;
    }

    @Override
    public Object setAnimal(Animal animal) {
        return null;
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public int compareTo(@NotNull IMascota o) {
        return 0;
    }
}
