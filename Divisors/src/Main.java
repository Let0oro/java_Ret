import lib.in;

public class Main
{
    public static void main(String[] args) {
        int num = in.leerInt("NÚMERO: ", v -> v > 0);

        String divisores = "1";

        for (int i = 2; i <= num; i++) if (num%i==0) divisores+=(","+i);

        System.out.println(divisores);
    }
}