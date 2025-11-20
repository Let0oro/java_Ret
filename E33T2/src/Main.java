import static java.lang.Math.random;
import static lib.in.leerInt;

public class Main {
    static void main() {
        final int lenNumber = 4, tries = 10;
        int[] randomArrNumber = new int[lenNumber];
        int count = 0, userNumber, numH = 0, numM = 0;
        boolean isEqual = false;
        String result = "";

        for (int i = 0; i < randomArrNumber.length; i++) randomArrNumber[i] = (int) (random() * 10);

        String randomNumber = "";
        for (int i = 0; i < lenNumber; i++) randomNumber += randomArrNumber[i];

        System.out.println(randomNumber);
        while (count < tries) {

            count++;
            userNumber = leerInt("NUMERO: ", v -> v >= 0 && v <= 9999);
            isEqual = ("" + userNumber).equals(randomNumber);
            if (isEqual) break;

            int[] userArrNumber = new int[4];

            userArrNumber[0] = userNumber / 1000;
            userArrNumber[1] = userNumber / 100 % 10;
            userArrNumber[2] = userNumber / 10 % 10;
            userArrNumber[3] = userNumber % 10;

            int rMatch = -1, match = -1, none = -1;
            boolean countMatch = false;

            for (int n = 0; n < lenNumber; n++) {
                if (randomArrNumber[n] == userArrNumber[n]) rMatch = userArrNumber[n];
                else {
                    for (int j = 0; j < lenNumber; j++) {
                        if (n != j && userArrNumber[n] == randomArrNumber[j]) {
                            match = userArrNumber[n];
                            break;
                        } else none = userArrNumber[n];
                    }
                }
                for (int i = 0; i < n; i++) {
                    countMatch = userArrNumber[n] == userArrNumber[i];
                    if (countMatch) break;
                };

                if (match >= 0) {
                    if (countMatch) numH++;
                    System.out.printf("\33[1;96m%d\33[0m", match);
                }
                if (rMatch >= 0) {
                    numM++;
                    System.out.printf("\33[1;32m%d\33[0m", rMatch);
                }
                if (none >= 0 && none != match) System.out.printf("%d", none);
                rMatch = match = none = -1;
                countMatch = false;
            }
// [1;96m%2dM[0m
            System.out.printf(" \u001B[1;96m%2dM\u001B[0m\u001B[1;32m%2dH\u001B[0m ", numM, numH);
            numM = numH = 0;
        }
        if (isEqual) System.out.println("Has adivinado el número en "+ count +" intento!");
        else System.out.println("Más suerte la próxima vez, el número aleatorio es " + randomNumber);
    }
}