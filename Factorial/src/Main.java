import lib.in;

public class Main {
    static void main() {
        int i, aux, number;
        i = aux = number = in.leerInt("Introduce un número para hacer el factorial: ", v -> v >= 0 && v <= 20);
        for (; i - 1 > 0; i--) number *= i - 1;
        System.out.println("Factorial de " + aux + " -> " + (aux == 0 ? 1 : number));
    }
}