package jmb;

public class Strings {

    public String MATRICULAS = "[0-9]{4}[A-Z]{3}";
    public static int countChars(final String str, char c) {
        int count = 0;
        for (char s : str.toCharArray()) count += (s == c ? 1 : 0);
        return count;
    }

    static int countPairLetter(final String str) {
        int countPair = 0;
        for (int i = 0; i < str.length()-1; i++) {
            char c = str.charAt(i);
            char next = str.charAt(i+1);
            if ((""+c).matches("[0-9]")) continue;
            countPair += ((""+next).equals(""+(char)(c+1)) ? 1 : 0);
        };
        return countPair;
    }

    static int countPairNumber(final String str) {
        int countPair = 0;
        for (int i = 0; i < str.length()-1; i++) {
            char c = str.charAt(i);
            char next = str.charAt(i+1);
            if ((""+c).matches("[^0-9]")) continue;
            countPair += ((""+next).equals(""+(char)(c+1)) ? 1 : 0);
        };
        return countPair;
    }
}
