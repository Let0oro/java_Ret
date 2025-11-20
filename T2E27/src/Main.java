import static java.lang.Math.max;
import static lib.in.leerInt;

public class Main {
    static void main() {
        int num =  leerInt();
        int tot = 0;

        while (num != 0) {
            tot += max(num, 0);
            num = leerInt();
        }

        System.out.println(tot);

    }
}