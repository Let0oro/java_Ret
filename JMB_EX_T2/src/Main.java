import static lib.in.leerInt;

public class Main {
    public void main(String[] args) {

        int n = leerInt("Numero de enteros: ");
        if (n < 2 || n > 10) n = 2;
        int aleatorio = (int) (Math.random() * 2);
        System.out.println("Aleatorio: " + aleatorio);
        int resultado;

        if (aleatorio == 0) {
            int pNumNeg = 0;
            int uNumPos = 0;
            for (int i = 0; i < n; i++) {
                int numLeido = leerInt("Escribe un entero: ");
                if (numLeido < 0 && pNumNeg == 0) pNumNeg = numLeido;
                if (numLeido > 0) uNumPos = numLeido;
            };
            resultado = pNumNeg * uNumPos;
        } else {
            int uNumNeg = 0;
            int pNumPos = 0;
            for (int i = 0; i < n; i++) {
                int numLeido = leerInt("Escribe un entero: ");
                if (numLeido < 0) uNumNeg = numLeido;
                if (numLeido > 0 && pNumPos == 0) pNumPos = numLeido;
            };
            resultado = uNumNeg * pNumPos;
        }

        System.out.println(resultado);
    }
}