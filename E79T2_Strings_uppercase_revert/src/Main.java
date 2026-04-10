import static jmb.in.leerLine;

//TODO: Léase una frase, póngase en mayúsculas, inviértase la cadena, y muéstrese.
class Main {
    static void main(String[] args) {

//        String str = leerLine();
//        str = str.toUpperCase();
//        System.out.println(str);
//        StringBuilder strB = new StringBuilder(str);
//        System.out.println(strB.reverse());

//        System.out.println(
//                new StringBuilder(leerLine().toUpperCase()).reverse()
//        );

        String str = "", strrev = "";
        str = leerLine().toUpperCase();
        for (int i = str.length() - 1; i > 0; i--) strrev = (strrev.concat(str.charAt(i) + ""));
        System.out.println(strrev);
    }
}