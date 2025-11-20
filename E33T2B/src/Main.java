import lib.in;

import java.util.Arrays;

import static java.lang.Math.random;
import static lib.in.leerInt;

public class Main {
    static void main() {
        final int lenNumber = 4, tries = 10;
        int[] randomArrNumber = new int[lenNumber];
        int count = 0, userNumber;
        boolean isEqual = false;

        for (int i = 0; i < randomArrNumber.length; i++ ) randomArrNumber[i] = (int) (random() * 10);

        String randomNumber = ""+randomArrNumber[0]+randomArrNumber[1]+randomArrNumber[2]+randomArrNumber[3];
        while (count < tries) {
            int numM = 0, numH = 0;

            count++;
            userNumber = leerInt("Adivina el número, escoge un número del 0 al 9999, tienes " + tries + " intentos: ",
                    v -> v >= 0 && v <= 9999,
                    "Error: el número introducido debe ser del 0 al 9999"
            );

            isEqual = ("" + userNumber).equals(randomNumber);
            if (isEqual) break;

            int[] userArrNumber = new int[4];

            userArrNumber[0] = userNumber / 1000;
            userArrNumber[1] = userNumber / 100 % 10;
            userArrNumber[2] = userNumber / 10 % 10;
            userArrNumber[3] = userNumber % 10;

            for (int n = 0; n < lenNumber; n++) {
                if (randomArrNumber[n] == userArrNumber[n]) numM++;
                else {
                    for (int j = 0; j < lenNumber; j++) {
                        if (n != j && userArrNumber[n] == randomArrNumber[j]) {
                            numH++;
                            break;
                        };
                    }
                }
            }

            System.out.printf("%dH %dM\n", numH, numM);
        }
        if (isEqual) System.out.println("Has adivinado el número en "+ count +"!");
        else System.out.println("Más suerte la próxima vez, el número aleatorio es " + randomNumber);
    }
}