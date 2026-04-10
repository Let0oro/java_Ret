import jmb.wrap;

import java.util.Arrays;
import static jmb.arrays.showSimple;
import static jmb.auxMath.genRandomInt;

//26. Genérese un array de 10 enteros entre 0 y 9, ambos inclusive. ordénese de forma que
//aparezcan primeros los pares ascendentemente y luego los impares ascendentemente.
//(enterosordenarparesimpares)


public class Main {
    public static void main(String[] args) {
        int[] arr = genArr(10);
        showSimple(arr);
        sortArrEvenOdd(arr);
        showSimple(arr);

    }

    static int[] genArr(int len) {
        int[] arr = new int[len];
        fillArr(arr);
        return arr;
    }

    static void fillArr(final int[] arr){
        Arrays.setAll(arr, i -> genRandomInt(0, 9));
    }

    static void sortArrEvenOdd(final int[] arr) {
        int[] evens = getEven(arr);
        sortArr(evens);
        int[] odds = getOdd(arr);
        sortArr(odds);
        for (int i = 0; i < evens.length; i++) arr[i] = evens[i];
        for (int i = evens.length; i < arr.length; i++) arr[i] = odds[i - evens.length];
    }

    static int[] getOdd(final int[] arr) {
        int auxCount = 0;
        int[] auxArr = new int[arr.length];
        for (int n : arr) if (n % 2 != 0) auxArr[auxCount++] = n;
        return Arrays.copyOfRange(auxArr, 0, auxCount);
    }

    static int[] getEven(final int[] arr) {
        int auxCount = 0;
        int[] auxArr = new int[arr.length];
        for (int n : arr) if (n % 2 == 0) auxArr[auxCount++] = n;
        return Arrays.copyOfRange(auxArr, 0, auxCount);
    }

    static void sortArr(final int[] arr) {
//        int[] aux = Arrays.stream(arr).sorted().toArray();
//        Arrays.setAll(arr, i -> aux[i]);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                int a = arr[j-1], b = arr[j];
                if (a < b) continue; // condición, por ejemplo, si queremos lo contrario, solo hay que cambiar el signo.
                // Si le pasamos una función o un Predict/@FunctionalInterface mejor como argumento, podemos pasar a y b
                // como argumentos y resolverlo.
                arr[j-1] = b;
                arr[j] = a;
            }
        }
    }
}