public class Main {
    static void main() {

        int conteoActual = Persona.cantidadPersonasCreadas();
        System.out.println(conteoActual);

        Persona nico = new Persona("NLow", 26);

        System.out.println(nico.edad);

        nico.escogerHobbies("Música");

        conteoActual = Persona.cantidadPersonasCreadas();
        System.out.println(conteoActual);
    }
}


class Persona {
    String nombre = "";
    int edad;

    static int counter = 0;

    public Persona (String nombre, int nuevaEdad) {
        counter++;
        this.nombre = nombre;
        this.edad = nuevaEdad;
    }

    public static void saludar(String saludo) {
        System.out.println(saludo);
    }

    public void escogerHobbies(String hobbieEscogido) {
        System.out.println(hobbieEscogido);
    }

    public static int cantidadPersonasCreadas() {
        return counter;
    }
}

class HelloWorldAdvanced {

    public static String helloWorldAdvanced(String name) {
// escribe el código aquí


        System.out.println(name);
        System.out.println(name=="");


        if(name==""){
            System.out.println("Hello,World");
        } else {
            System.out.println("Hello! " + name + " Welcome to Java.");
        }


        return"";
    }


}