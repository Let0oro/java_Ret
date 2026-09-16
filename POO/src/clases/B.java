package clases;

public class B extends A{
    @Override
    public void b() {
        System.out.print("5");
        super.b();
    }

    @Override
    public void a() {
        super.b();
        System.out.print("6");
        super.a();
    }
}
