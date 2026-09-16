package clases;

public class C extends B {
    @Override
    public void a() {
        b();
        System.out.print("8");
        super.a();
    }
}
