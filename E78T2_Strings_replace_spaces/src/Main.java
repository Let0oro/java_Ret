import static jmb.in.leerLine;

//TODO: Leer un nombre y un apellido y separarlo por un solo espacio.
class Main {
    static void main(String[] args) {

//        System.out.println(
//                leerLine("Escribe tu nombre y apellidos: ")
//                        .trim()
//                        .replaceAll("\\s+", " ")
//        );

        String str = leerLine("Escribe tu nombre y apellidos: ");
        str = str.trim();
        while (str.contains("  ")) str = str.replace("  ", " ");
        System.out.println(str);

    }
}