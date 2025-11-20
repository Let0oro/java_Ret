import lib.in;

import static java.lang.Math.pow;

public class Main
{
    static void main()
    {
        int count = 0, num;

        num = in.leerInt("Introduce un número: ");

        if (num == 0) num = 1;
        if (num < 0) num *= -1;

        while ((int) pow(10, count) <= num) count++;

        System.out.println(count);
    }
}