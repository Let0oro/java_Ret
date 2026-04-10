import jmb.wrap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import static jmb.auxMath.genRandomInt;
import static jmb.in.leerInt;

/*
    Se considera un array de enteros cuyo tamaño se introduce por consola y se rellena
    con valores aleatorios entre 0 y 9, ambos inclusive. Se mostrarán los datos separados
    por una coma y un espacio. Se modificará el array de la manera indicada en cada
    apartado, y se mostrará de nuevo.

    a) Mover los datos una posición hacia la derecha (el primero pasa al segundo, el
    segundo al tercero, …, y el último al primero)
    b) Invertir el array
    c) Mostrar la posición del primer par y del último impar.
 */


public class Main {
    static void main(String[] args) {
        int len = leerInt("Introduce el tamaño del array: ");
        int[] arr = new int[len];
        Arrays.setAll(arr, i ->  genRandomInt(0, 9));
        printArray(arr);
        moveToLeft(arr, 2);
        printArray(arr);
        reverseArr(arr);
        printArray(arr);
        System.out.println("Posición del primer par y el último impar: " + firstEvenAndLastOdd(arr));
    }

    public static void printArray(int[] arr) {
        System.out.println((Arrays.toString(arr)));
    }

    public static void moveToRight(final int[] arr, int positions) {
        if (positions == 0) return;
        if (positions < 0) moveToLeft(arr, Math.abs(positions));
        int len = arr.length - 1;

        for (int i = 0; i < positions; i++) {
            int aux = arr[len];
            for (int j = len; 0 < j; j--) arr[j] = arr[j-1];
            arr[0] = aux;
        }
    }

    public static void moveToLeft(final int[] arr, int positions) {
        if (arr.length == 0) throw new IllegalArgumentException("No se puede introducir un array vacío");
        if (positions == 0) return;
        if (positions < 0) moveToRight(arr, Math.abs(positions));
        int len = arr.length - 1;

        for (int i = 0; i < positions; i++) {
            int aux = arr[0];
            for (int j = 0; j < len; j++) arr[j] = arr[j+1];
            arr[len] = aux;
        }

    }

    public static void reverseArr(final int[] arr) {
        //fillWithAL(arr, createALFromArr(arr));
        if (arr.length == 0) return;
        int len = arr.length-1;
        int[] aux = arr.clone();
        Arrays.setAll(arr, i -> aux[len-i]);
    }

    public static int[] getAllPositionsOf(final int[] arr, Predicate<Integer> v) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) if (v.test(arr[i])) res.add(i);
        int[] ret = new int[res.size()];
        fillWithAL(ret, res);
        return ret;
    };

    public static int getFirstPositionOf(final int[] arr, Predicate<Integer> v) {
        int res[] = getAllPositionsOf(arr, v);
        if (res.length == 0) return -1;
        return res[0];
    }


    public static int getLastPositionOf(final int[] arr, Predicate<Integer> v) {
        int[] res = getAllPositionsOf(arr, v);
        if (res.length == 0) return -1;
        return res[res.length-1];
    }

    public static void fillWithAL(final int[] arr, final ArrayList<Integer> alist) {
        if (arr.length != alist.size()) throw new IllegalArgumentException("No se pueden intercambiar valores entre array y arraylist de distintos tamaños");
        Arrays.setAll(arr, i -> alist.get(i).intValue());
    }

    public static ArrayList<Integer> createALFromArr(final int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int x : arr) res.add(x);
        return res;
    }

    static wrap firstEvenAndLastOdd(int[] arr) {
        return new wrap(
                getFirstPositionOf(arr, v -> v % 2 == 0),
                getLastPositionOf(arr, v -> v % 2 != 0)
        );
    }


}