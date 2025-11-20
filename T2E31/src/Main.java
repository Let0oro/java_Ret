import lib.in;

public class Main
{
    static void main()
    {
        int num, randomNum, count;

        randomNum = (int) (100 * Math.random());
        count = 0;

        do {
            num = in.leerInt("Adivina un número entre 1 y 100: ", v-> 0 < v && v <= 100);
            count++;

            if (num == randomNum) break;
            if (num > randomNum) System.out.println("Más bajo!");
            if (num < randomNum) System.out.println("Más alto!");

        } while (count < 10);

        if (count == 10) System.out.println("Diez intentos, diez errores, vuelve a intentarlo más tarde");
        else System.out.println("Correcto! El número es " + randomNum + ", te ha costado " + count + " intentos");

    }
}