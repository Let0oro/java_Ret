import java.util.Arrays;
import static jmb.auxMath.genRandomDouble;
import static jmb.in.leerInt;

public class Main {
    static void main(String[] args) {
        double[] arr = genArr();
        showArrWithPosition(arr);
        final int from = leerDesde(arr);
        final int until = leerHasta(from, arr);
        sumArr(arr, from, until);
    }

    static double[] genArr() {
        double[] arr = new double[20];
        fillArr(arr);
        return arr;
    }

    static int leerDesde(double[] arr){
        return leerInt("Desde ("+ 0 + " - " + (arr.length - 1) + "): ", v -> v >= 0 && v <= arr.length - 1, "Se superan los límites del array");
    }
    static int leerHasta(final int from, double[] arr){
        return leerInt("Hasta ("+ from + " - " + (arr.length - 1) + "): ", v -> v >= from && v <= arr.length - 1, "Se superan los límites del array");
    }

    static void fillArr(final double[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("No se puede imprimir un array vacío");
        Arrays.setAll(arr, i -> genRandomDouble(0, 10));
    }

    static void showArrWithPosition(final double[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("No se puede imprimir un array vacío");
        for (int i = 0; i < arr.length; i++) System.out.printf("%d: %4.2f", i, arr[i]);
    }

    static double sumArr(final double[] arr, int from, int until) {
        if (from > arr.length - 1 || until > arr.length - 1 || from < 0 || until < 0) throw new IllegalArgumentException("Límites del array superados");
        if (from == until) return arr[from];
        if (from > until) return sumArr(arr, until, from);
        double sum = 0;
        for (int i = from; i <= until; i++) sum += arr[i];
        return sum;
    }
}