package jmb.juanma;

public class Main {
    static void main() {

    }

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static int dividir(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("No se puede dividir entre 0");
        return a / b;
    }

    public static String dibujar(int n){
        String s = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s += "* ";
            }
            s += "\n";
        }
        return s;
    }
}
