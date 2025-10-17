import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        int num = in.leerInt();
        num = num == 0
              ? num + 10
              : num > 0
                    ? num > 10
                        ? num + 2
                        : num + 1
                    : num - 1
        ;

        System.out.println(num);
    }
}
