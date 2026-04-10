import static jmb.arrays.genArr2DEq;
import static jmb.arrays.showSimple2D;
import static jmb.auxMath.genRandomInt;
/*
29. Se considera una tabla de 10 x 10 de enteros cuyas celdas se inicializan a 0. Se
generarán 100 celdas aleatorias a las cuales se les asigna el valor de 1. Se mostrará el
total de celdas con 0, con 1 y el número de celdas aleatorias que se han repetido.
(TablaCerosUnos)
*/

public class Main {
    public static void main(String[] args) {
        int arr[][] = genArr2DEq(10), zeros = 0;

        for (int _ : new int[100]) arr[genRandomInt(0, arr[0].length)][genRandomInt(0, arr[0].length)] = 1;

        showSimple2D(arr);

        for (int[] n : arr) for (int m : n) if (m == 0) zeros++;

        System.out.printf("Zeros: %d\n", zeros);
        System.out.printf("Repeats: %d\n", zeros);
        System.out.printf("Ones: %d\n", 100 - zeros);
    }
}