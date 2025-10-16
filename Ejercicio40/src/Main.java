import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        int num = in.leerInt();
        num += num > 100 ? num : 100;

        System.out.println(num);
    }
}
