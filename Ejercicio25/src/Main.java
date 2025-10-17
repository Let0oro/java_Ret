import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        int numA, numB;
        boolean check;

        numA = in.leerInt("Escribe un número entre 0 y 9: ");
        numB = in.leerInt("Escribe un número entre 0 y 9: ");

        check = numA % 2 == 0 && numB % 2 != 0;
        System.out.println("El primero es par y el segundo impar: " + check);

        check = numA > numB*2 && numA < 8;
        System.out.println("El primero es superior al doble del segundo e inferior a 8: " + check);

        check = numA == numB || numA - numB < 2;
        System.out.println("Son iguales o la diferencia entre el primero y el segundo es menor que 2: " + check);
    }
}
