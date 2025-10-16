import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        int numA, numB, numC;
        boolean check, numAEven, numBEven, numCEven;

        numA = in.leerInt("Escribe un número entre 0 y 9: ");
        numB = in.leerInt("Escribe un número entre 0 y 9: ");
        numC = in.leerInt("Escribe un número entre 0 y 9: ");

        check = numA == numB && numB == numC;
        System.out.println("a) Los tres valores son iguales: " + check);

        check = numA != numB && numA != numC && numB != numC;
        System.out.println("b) Dos a dos los valores son distintos: " + check);

        numAEven = numA % 2 == 0;
        numBEven = numB % 2 == 0;
        numCEven = numC % 2 == 0;

        check = numAEven && numBEven || numAEven && numCEven || numBEven && numCEven;

        System.out.println("c) Hay más pares que impares: " + check);

        check = numA * numB == numC || numA * numC == numB || numB * numC == numA;
        System.out.println("d) Uno es el producto de los otros dos: " + check);
    }
}
