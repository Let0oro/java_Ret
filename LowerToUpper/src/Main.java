import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        char lower = '\0', upper = '\0';

        int asciiCode = 0, offset = 0;

        lower = in.leerChar("Escribe una letra en minúsucla: ");
        System.out.println("lower: " + lower);

        offset = lower - 'a'; // (número o posición en código ascii en negativo)
        System.out.println("char 'a' position: " + ('a'));

        System.out.println("offset (lower " + lower + "(ASCII: " + (lower) + ")" + " - 'a'(97 ASCII)): " + offset);

        asciiCode = 'A' + offset;
        System.out.println("char 'A' position: " + ('A'));
        System.out.println("AsciiCode ('A'(65 ASCII) + offset): " + asciiCode);

        upper = (char) asciiCode; // transform the position or negative number into char in ascii code
        System.out.println("La letra mayśucula es: " + upper);
    }
}
