import static java.lang.Math.max;
import static jmb.arrays.fillArrWitRandom;
import static jmb.arrays.showSimpleSeparatedBy;

/*
8. Considérese un array de enteros con valores aleatorios entre 0 y 99, que se mostrarán
separados por un espacio. Se obtendrá el o los valores que más veces se repitan
separados por un espacio con un texto del tipo “Los valores que más se repiten son”
o “El valor que más veces se repite es el”. (MasSeRepite)
 */

public class Main {
    static void main(String[] args) {
        int[] arr = new int[10];
        fillArrWitRandom(arr, 0, 99);
        showSimpleSeparatedBy(arr, " ");
        int[] arrMaxViewed = getMostViewed(arr);
        showMostViewed(arrMaxViewed);
    }

    static int[] getMostViewed(final int[] arr) {
        int[] counts = countReps(arr);
        int max = getMaxValue(counts);
        return getMostViewedByCounts(arr, counts, max);
    }

    static int[] getMostViewedByCounts(final int[] original, final int[] counts, int max) {
        int sizeArrMaxViewed = 0;
        for (int countMax : counts) if (countMax == max) sizeArrMaxViewed++;
        int[] arrMaxViewed = new int[sizeArrMaxViewed];
        for (int i = 0, j = 0; i < counts.length; i++) if (counts[i] == max) arrMaxViewed[j++] = original[i];
        return arrMaxViewed;
    }

    static int getMaxValue(final int[] arr) {
        int max = 0;
        for (int n : arr) max = max(n, max);
        return max;
    }

    static int[] countReps(final int[] arr) {
        int[] counts = new int[arr.length];
        for (int i = 0; i < arr.length - 1; i++) for (int n : arr) if (arr[i] == n) counts[i]++;
        return counts;
    }

    static void showMostViewed(final int[] arr) {
        System.out.println();
        if (arr.length == 0) throw new IllegalArgumentException("No se puede calcular con un array vacío");
        if (arr.length == 1) System.out.print("El valor que más veces se repite es el: ");
        else System.out.print("Los valores que más se repiten son: ");
        showSimpleSeparatedBy(arr, ", ");
    }


}