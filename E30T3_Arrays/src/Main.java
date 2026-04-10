import static jmb.arrays.*;

/*
30. Cada vez que se ejecute una aplicación se rellenará una tabla de 5 x 5 de reales con
valores aleatorios entre 0.00 y 0.99, se mostrará por consola dicha tabla y se obtendrá:
a) La suma de las celdas de cada fila.
b) La suma de las celdas de cada columna.
c) El o los números que más veces se repite.
d) La suma de los elementos de la diagonal principal
e) La suma de los elementos de la diagonal secundaría
(RecorreFilasColumnas)
 */

public class Main {
    public static void main(String[] args) {
        final int len = 5;
        double sum, arr[][] = genArr2DEqDec(len);
        for (double[] v : arr) fillArrWitRandom(v, 0, 1);

        showSimple2D(arr);
        System.out.println();

        for (int i = 0; i < len; i++) {
            sum = 0;
            for (double m : arr[i]) sum += m;
            System.out.printf("Fila %d = %4.2f\n", i, sum);
        }
        System.out.println();

        double[] sumCols = new double[len];
        for (int i = 0; i < len; i++) for (int j = 0; j < len; j++) sumCols[i] += arr[j][i];
        for (int i = 0; i < len; i++) System.out.printf("Columna %d = %4.2f\n", i, sumCols[i]);
        System.out.println();

        sum = 0;
        for (int i = 0; i < len; i++) for (int j = 0; j < len; j++) if (j == i) sum += arr[i][j];
        System.out.printf("Suma de la diagonal principal: %4.2f\n\n", sum);

        sum = 0;
        for (int i = 0; i < len; i++) for (int j = 0; j < len; j++) if (j - i == 0) sum += arr[i][j];
        System.out.printf("Suma de la diagonal secundaria: %4.2f\n\n", sum);

    }
}