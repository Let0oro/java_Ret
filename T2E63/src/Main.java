import lib.in;

public class Main {
    static void main() {
        int random = aleatorio(2, 8);
        System.out.println(random);

        random = aleatorio(1, 30);
        System.out.println(random);

        random = aleatorio(2, -10);
        System.out.println(random);
    }

    static int aleatorio(int desde, int hasta) {
        if (desde > hasta) {
            int temp = desde;
            desde = hasta;
            hasta = temp;
        };
        return (int)(Math.random() * (hasta - desde + 1) + desde);
    }
}