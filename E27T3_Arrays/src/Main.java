import static java.lang.Math.max;
import static java.lang.Math.min;
import static jmb.arrays.*;

/*
Cada vez que se ejecute una aplicación se rellenará una tabla de 5 x 5 de enteros con
valores aleatorios entre 0 y 99, se mostrará por consola dicha tabla y se obtendrá:

    a) El producto de los pares.
    b) El mayor y el menor número generado.
*/

public class Main {
    public static void main(String[] args) {
        int[][] arr = genArr2DEq(5);
        showSimple2DWithSeparatedBy(arr, " ");

        int prodEven = getProdEvens(arr);
        System.out.printf("Producto de los números en las columnas pares: %d\n", prodEven);

        int maxNumber = getMaxNum(arr);
        System.out.printf("Número mayor de entre los generados: %d\n", maxNumber);

        int minNumber = getMinNum(arr);
        System.out.printf("Número menor de entre los generados: %d\n", minNumber);

    }

    static int[][] genArr2DEq(final int len) {
        int[][] arr = new int[len][len];
        for (int[] y : arr) fillArrWitRandom(y, 0,99);
        return arr;
    }

    static int getProdEvens(final int[][] arr) {
        int prod = 1;
        for (int[] row : arr) for (int icol = 0; icol < row.length; icol+=2) prod *= row[icol];
        return prod;
    }

    static int getMaxNum(final int[][] arr) {
        int max = arr[0][0];
        for (int[] row : arr) for (int num : row) max = max(max, num);
        return max;
    }

    static int getMinNum(final int[][] arr) {
        int min = arr[0][0];
        for (int[] row : arr) for (int num : row) min = min(min, num);
        return min;
    }
}