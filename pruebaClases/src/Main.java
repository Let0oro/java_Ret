
public class Main {
    static void main(String[] args) {
        new B().a();
    }

}


class A {
    public void b(){
        System.out.print("9");
    }

    public void a(){
        b();
        System.out.print("7");
    }
}

class B extends A{
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

class C extends B {
    @Override
    public void a() {
        b();
        System.out.print("8");
        super.a();
    }
}
