import lib.in;

public class Main {
{
    public static void main(String[] args) {
        double num = in.leerDouble("Escribe un número real: ");

        byte numByte = (byte) num;
        System.out.println("byte: " + numByte);

        short numShort = (short) num;
        System.out.println("short: " + numShort);

        int numInt = (int) num;
        System.out.println("int: " + numInt);

        long numLong = (long) num;
        System.out.println("long: " + numLong);

        float numFloat = (float) num;
        System.out.println("float: " + numFloat);

        char numChar = (char) num;
        System.out.println("char: " + numChar);

        in.detener();
    }
}
