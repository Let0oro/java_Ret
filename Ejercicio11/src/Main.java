public class Main {
{
    public static void main(String[] args)
    {
        int a = 7, b = -5, c = 3;
        double d = 65.082;

        System.out.println("a) a*(2-c)+b = " + (a*(2-c)+b));
        System.out.println("b) 2*a-3+b%2 = " + (2*a-3+b%2));
        System.out.println("c) (int) (d*10 + 0.5) / 10.0 = " + (int) (d*10 + 0.5) / 10.0);
        System.out.println("d) a%b*(--a-b) = " + a%b*(--a-b));
        System.out.println("e) a++*--d%-2 = " + a++*--d%-2);

    }
}
