public class Main {
{
    public static void main(String[] args)
    {
        int a = 10;
        int b = 12;

        boolean c1 = a*2>b+10;
        boolean c2 = a<b-3;
        boolean c3 = a+14 == 2*b;
        boolean c4 = a!=b-2;

        System.out.println("a) a*2>b+10: " + c1);
        System.out.println("b) a<b-3: " + c2);
        System.out.println("c) a+14 == 2*b: " + c3);
        System.out.println("d) a!=b-2: " + c4);
    }
}
