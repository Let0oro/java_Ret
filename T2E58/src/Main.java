//import lib.in;
//public class Main {
//    static void main() {
//        int alto = in.leerInt("introduce el alto: ", v -> v >= 2);
//        int ancho = in.leerInt("introduce el ancho: ", v -> v >= 2);
//
//        String salida = "";
//
//        for (int i = 0; i < alto; i++) {
//            salida = "";
//            for (int j = 0; j < ancho; j++) {
//                if (j == i || j == (ancho-1-i)) salida += "*";
//                else salida += " ";
//            }
//            System.out.println(salida);
//        }
//    }
//
//}

class Main {
    static void main() {
        int alto = 5;
        int ancho = 5;

        String salida = "";

        for (int i = 0; i < alto; i++) {
            salida = "";
            for (int j = 0; j < ancho; j++) {
                if (j == i || j == (ancho-1-i)) {
                    salida += "*";
                }
                else {
                    salida += " ";
                }
            }
            System.out.println(salida);
        }
    }
}