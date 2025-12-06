public class Main {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            int a = auxMath.genRandomInt(-5, 5);
            int b = auxMath.genRandomInt(-5, 5);
            System.out.println(numberProof(a, b));
        }
        ;
    }

    static int numberProof(int a, int b) throws Exception {
        try {
            return a / b;
        } catch (ArithmeticException error) {
            System.out.println(error.getMessage());
            throw new ArithmeticException("No se puede dividir entre 0");
        } catch (Exception error) {
            System.out.println(error.getMessage());
            throw new Exception("Error desconocido");
        }
    }
}