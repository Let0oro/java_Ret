import jmb.in;

//TODO: Comprobar si una frase es un palíndromo.
class Main {
    static void main(String[] args) {
        String str = in.leerLine("Escribe una frase:\n");
        System.out.println(
                (str.strip().toUpperCase().contentEquals(new StringBuilder(str.strip().toUpperCase()).reverse())
                        ? "E" : "No e") + "s palíndromo"
        );
    }
}