import java.util.Arrays;

import static jmb.auxMath.genRandomInt;

/*
    Se considera un array con 10 enteros con valores aleatorios entre 0 y 9, ambos
    inclusive. Se mostrarán los datos separados por una coma y un espacio. Se modificará
    el array de la manera indicada en cada apartado, y se mostrará de nuevo.
    a) Incrementar en 1 los valores pares y en -1 los impares.
    b) Duplicar los valores positivos menores que 5
    c) Sumar a cada valor un valor entero aleatorio entre -5 y 5.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Arrays.fill(arr, genRandomInt(0, 10));
        showSimple(arr);
        incremDecremArr(arr);
        dupLowerFive(arr);
        sumRandom(arr);
    }

    static void showSimple(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void incremDecremArr(int[] arr) {
        Arrays.setAll(arr, i -> arr[i] + (i % 2 == 0 ? 1 : -1));
    }

    static void dupLowerFive(int[] arr) {
        Arrays.setAll(arr, i -> arr[i] * (arr[i] < 5 ? 2 : 1));
    }

    static void sumRandom(int[] arr) {
        Arrays.setAll(arr, i -> arr[i] + genRandomInt(-5, 5));
    }
}