import static java.lang.Math.*;
import static java.lang.System.out;
import static lib.in.leerInt;

public class Main
    {
        public static void main(String[] args)
        {
            int num1 = leerInt("ENTERO: ");
            int num2 = leerInt("ENTERO: ");
            int M = max(num1, num2);
            int m = min(num1, num2);

            out.println((int) (random() * (M - m + 1) + m));
            out.println((int) (random() * (M - m + 1) + m));
            out.println((int) (random() * (M - m + 1) + m));
            out.println((int) (random() * (M - m + 1) + m));
            out.println((int) (random() * (M - m + 1) + m));

            for (int i = 0; i < 5; i++) out.println((int) (random() * (M - m + 1) + m));

        }
    }
