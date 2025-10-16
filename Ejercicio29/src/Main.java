import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        char ch;
        boolean check;

        ch = in.leerChar("Letra: ");

        System.out.println("Dígito: " + Character.isDigit(ch));

//        ch = Character.toLowerCase(ch);
//        check = "aeiou".contains(String.valueOf(ch));
        check = ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
        check = check || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
        System.out.println("Vocal: " + check);

    }
}
