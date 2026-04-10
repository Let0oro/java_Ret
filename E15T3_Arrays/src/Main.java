import static java.lang.Math.max;
import static jmb.arrays.fillArrWitRandom;
import static jmb.arrays.showSimple;

//15. Se considera un array de 10 elementos con valores entre 0 y 99 aleatorios, y otro array
//de las mismas características. Se mostrarán los dos arrays. Se podrán obtener los
//siguientes arrays y valores:
//a) El producto escalar (multiplicar los valores de los dos arrays que ocupan la
//misma posición y sumarlos)
//b) Sumar los dos arrays (array de 10 elementos cuyos elementos son la suma de
//los elementos que ocupan la misma posición en los dos arrays)
//c) Multiplicar los dos arrays (array de 10 elementos cuyos elementos son el
//producto de los elementos que ocupan la misma posición en los dos arrays)
//(OperarArrays)

public class Main {
    static void main(String[] args) {
        int[] arr = createArr();
        int[] arrB = createArr();
        showSimple(arr);
        showSimple(arrB);
        int scalarArr = scalar(arr, arrB);
        int[] sumaTwoArr = sumAxB(arr, arrB);
        int[] multTwoArr = mulAxB(arr, arrB);
    }

    static int[] createArr() {
        int[] arr = new int[10];
        fillArr(arr);
        return arr;
    }

    static void fillArr(final int[] arr) {
        fillArrWitRandom(arr, 0, 99);
    }

    static int scalar(int[] arrA, int[] arrB) {
        int[] mul = mulAxB(arrA, arrB);
        int suma = sumArr(mul);
        return suma;
    }

    static int[] mulAxB(int[] arrA, int[] arrB) {
        int len = max(arrA.length, arrB.length);
        int[] result = new int[len];
        for (int i = 0; i < len - 1; i++) result[i] = arrA[i] * arrB[i];
        return result;
    }

    static int[] sumAxB(int[] arrA, int[] arrB) {
        int len = max(arrA.length, arrB.length);
        int[] result = new int[len];
        for (int i = 0; i < len - 1; i++) result[i] = arrA[i] + arrB[i];
        return result;
    }

    static int sumArr(final int[] arr) {
        int aux = 0;
        for (int a : arr) aux += a;
        return aux;
    }
}