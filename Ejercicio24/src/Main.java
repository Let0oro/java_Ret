public class Main {
{
    public static void main(String[] args)
    {
        int a = 2,
            b = -5,
            c = 2;

        boolean check;

        check = a*5 == 5-b && a > 0;
        System.out.println("a) a*5 == 5-b && a > 0: " + check);

        check = a-b<6 && a*2 == b;
        System.out.println("b) a-b<6 && a*2 == b: " + check);

        check = a-b<6 & a*2 == b;
        System.out.println("c) a-b<6 & a*2 == b: " + check);

        check = a>b || c<a;
        System.out.println("d) a>b || c<a: " + check);

        check = a-1<b || a == b+7;
        System.out.println("e) a-1<b || a == b+7: " + check);

        check = a-1<b | a == b+7;
        System.out.println("f) a-1<b | a == b+7: " + check);

    }
}
