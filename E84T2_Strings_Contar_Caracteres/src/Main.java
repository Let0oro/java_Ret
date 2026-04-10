

// Contar el número de letras de las A a la Z, ambas inclusive, introducidas en una frase.
class Main {
    static void main(String[] args) {
        String str = jmb.in.leerLine().toLowerCase();
        int times;
        for (char ch = 'a'; ch <= 'z'; ch++)
            if ((times = countOf(ch, str)) > 0)
                System.out.printf("\n%c: %d", ch, times);
    }
    
    static int countOf(char ch, String str) {
        return str.replace("[^"+ch+"]", "").length();
    }

    static int countOfStr(String substr, String str) {
        return str.length() - str.replace(substr, "").length();
    }
}
