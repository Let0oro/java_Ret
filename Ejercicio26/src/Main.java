public class Main {
{
    public static void main(String[] args)
    {
        int a = 23, b = -8, c = 13;
        boolean check;

        check = a-b>2*c && a == c+10 || b > 10;
        System.out.println("a) a-b>2*c && a == c+10 || b > 10 -> " + check);

        check = a == b*-2 || a-c == 10 || a < b;
        System.out.println("b) a == b*-2 || a-c == 10 || a < b -> " + check);

        check = c-b > 20 && a >b && a+10 == 2*b;
        System.out.println("c) c-b > 20 && a >b && a+10 == 2*b -> " + check);

        check = a-5 == c + 5 && (a>b || c<a);
        System.out.println("d) a-5 == c + 5 && (a>b || c<a) -> " + check);

    }
}
