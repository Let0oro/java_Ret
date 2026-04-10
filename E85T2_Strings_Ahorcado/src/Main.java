import static jmb.in.*;

/*
Simúlese el juego del ahorcado. El usuario introducirá la phrase a adivinar. Las palabras
estarán en mayúsculas, sin acentos y separadas por un espacio. El otro jugador tendrá
12 oportunidades para adivinar la phrase, introduciendo cada vez una letra.
*/
public class Main {

    public static void main(String[] args) {

        String phrase = askPhrase(), introduced = "", letter;
        int phase = 1, end = 13;
        while (true) {
            cls();
            showIntroduced(introduced, phrase);
            showAhorcado(phase);
            showPhrase(phrase, introduced);
            if (reviewBreak(phase, end, introduced, phrase)) break;
            letter = askLetter(introduced);
            introduced = newIntroducedLetters(introduced, letter);
            phase = reviewLetter(letter, phrase, phase);
        }
        reviewFinal(phase, end, phrase);
        detener();
        
    }

    static int reviewLetter(String letter, String phrase, int phase){
        return (!introducedMatch(letter, phrase)) ? phase + 1 : phase;
    }

    static void reviewFinal(int phase, int end, String phrase) {
        if (phase == end) gameOver(phrase); else success();
    }

    static String askPhrase(){
        return leerLine(
                "Escribe una phrase en mayúsculas, sin acentos ni diéresis:\n",
                v -> v.replaceAll("[a-zAA-ZñÑ ]", "").isEmpty()
                ).toLowerCase();
    }

    static String askLetter(String introduced) {
        return leerChar(
                "Escribe una letra: ",
                v -> !introduced.contains(v+"".toLowerCase())
                        && (""+v).replaceAll("[a-zAA-ZñÑ ]", "").isEmpty(),
                "Por favor, introduzca una letra no introducida anteriormente\n"
        )+"".toLowerCase();
    }

    static void showIntroduced(String introduced, String phrase) {
        String info = "\nLETRAS INTRODUCIDAS: ";
        for (int i = 0; i < introduced.length(); i++){
            String ch = introduced.charAt(i)+"";
            info = info.concat("\033[1;");
            if (phrase.contains(ch)) info = info.concat("32m"+ch.toUpperCase());
            else info = info.concat("31m"+ch.toUpperCase());
            info = info.concat("\033[0m");
        }
        System.out.println(info);
    }

    static void showAhorcado (int phase) {
        System.out.println("fase = " + phase);
        StringBuilder paint = new StringBuilder();
        paint.append("* * * * * * * *\n*             *\n");

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 7; j++) {
                if (j == 0 || j == 7) paint.append("*");
                else if (phase > 1 && i > 4 - phase && j == 5) paint.append("|");
                else if (phase >= 6 && i == 0 && j == 4) paint.append("-");
                else if ((phase >= 7 && i == 0 && j == 3) || (phase >= 9 && i == 2 && j == 3)) paint.append("|");
                else if (phase >= 8 && i == 1 && j == 3) paint.append("0");
                else if (((phase >= 10 && j == 4) || (phase >= 11 && j == 2)) && i == 2) paint.append("-");
                else if (phase >= 12 && i == 3 && j == 2) paint.append("/");
                else if (phase >= 13 && j == 4 && i == 3) paint.append("\\");
                else paint.append(" ");
                paint.append(" ");
            }
            paint.append("\n");
        }
        paint.append("*             *\n* * * * * * * *\n");
        System.out.println(paint);
    }

    static void showPhrase(String phrase, String introduced) {
        System.out.println("PALABRA A ADIVINAR:");
        phrase = phrase.replaceAll("(\\w)", "$1 ");
        phrase = phrase.replaceAll("[^"+introduced+" ]", "_");
        System.out.println(phrase.toUpperCase()+"\n");
    }

    static boolean everyLetterMatch (String introduced, String phrase) {
        return phrase.replaceAll("["+introduced+" ]", "").isEmpty();
    }

    static boolean introducedMatch(String letra, String phrase) {
        return phrase.toLowerCase().contains(letra.toLowerCase());
    }

    static boolean reviewBreak(int phase, int end, String introduced, String phrase) {
        return phase >= end || everyLetterMatch(introduced, phrase);
    }

    static String newIntroducedLetters (String originalIntroduced, String newLetter) {
        return originalIntroduced.concat(newLetter);
    }

    static void gameOver (String phrase) {
        System.out.println("La phrase a adivinar era \"" + phrase.toUpperCase()+"\"");
    }

    static void success() {
        System.out.println("HAS ADIVINADO LA PALABRA");
    }
}