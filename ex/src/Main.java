import lib.in;

public class Main {
{
    public static void main(String[] args) {

        int sign;
        double num, aux, mod;

        num = in.leerDouble();
        mod = num % 1;

        sign = (int) num;
        sign = sign >> 31 | -sign >>> 31;
        System.out.println("sign: " + sign);

        mod = aux = mod + sign * 0.5;
        mod *= (double) (sign + 1) / 2; // si es negativo da 0

        aux = aux % 1 - 0.5;
        aux *= (double) -(sign - 1) / 2; // si es positivo da 0

        System.out.println("mod: " + mod);
        System.out.println("aux: " + aux);
        mod = mod + aux;
        System.out.println("mod + aux: " + mod);
        num = (int) ((int) num + mod);

        System.out.println(num);
    }

}
