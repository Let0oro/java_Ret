package jmb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static jmb.auxMath.*;

public class arrays {

    public static void showSimple(final int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void showSimple(final double[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void showSimpleSeparatedBy(final int[] arr, String str) {
        int len = arr.length - 1;
        for (int i = 0; i <= len; i++) System.out.printf("%d%s", arr[i], (i == len ? "" : str));
    }

    public static void showSimpleSeparatedBy(final double[] arr, String str) {
        int len = arr.length - 1;
        for (int i = 1; i <= len; i++) System.out.printf("%4.2f%s", arr[i], (i == len ? "" : str));
    }


    public static void showSimpleSeparatedBy(final Double[] arr, String str) {
        int len = arr.length - 1;
        for (int i = 1; i <= len; i++) System.out.printf("%4.2f%s", arr[i], (i == len ? "" : str));
    }

    public static void fillArrWith(final int[] arr, int num) {
        Arrays.setAll(arr, i -> num);
    }

    public static void fillArrWith(final double[] arr, double num) {
        Arrays.setAll(arr, i -> num);
    }

    public static void fillArrWithRandom(final int[] arr, int from, int until) {
        Arrays.setAll(arr, i -> genRandomInt(from, until));
    }

    public static void fillArrWithRandom(final double[] arr, int from, int until) {
        Arrays.setAll(arr, i -> genRandomDouble(from, until));
    }

    public static void fillArrWithRandom(final Double[] arr, int from, int until) {
        Arrays.setAll(arr, i -> genRandomDouble(from, until));
    }

    public static void fillArrWithRandom(final Integer[] arr, int from, int until) {
        Arrays.setAll(arr, i -> genRandomInt(from, until));
    }

    public static int[] range(int from, int until) {
        int[] arr = new int[until - from];
        Arrays.setAll(arr, i -> i + from);
        return arr;
    }

    public static int[] range(int until) {
        int[] arr = new int[until];
        Arrays.setAll(arr, i -> i);
        return arr;
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


    public static int countValuesWNDigitsFromArr(final int[] arr, final int n) {
        if (arr.length == 0) return 0;
        int count = 0;
        for (int num : arr) if (haveNDigits(num, n)) count++;
        return count;
    }

    public static boolean haveNDigits(final int number, final int nDig){
        int min = (int) Math.pow(10, nDig-1);
        int max = (int) Math.pow(10, nDig)-1;
        return isBetweenIncluded(number, min, max);
    }

    public static int[] getValuesWithNDigitsFromArr(final int[] arr, int n) {
        int len = countValuesWNDigitsFromArr(arr, n);
        if (arr.length == 0 || len == 0) return new int[0];
        int[] res = new int[len];
        int index = 0;
        for (int num : arr) if (haveNDigits(num, n)) res[index++] = num;
        return res;
    }


    public static int[][] genArr2DEqInt(final int len) {
        int[][] arr = new int[len][len];
        for (int[] y : arr) fillArrWithRandom(y, 0,99);
        return arr;
    }

    public static double[][] genArr2DEqDec(final int len) {
        double[][] arr = new double[len][len];
        for (double[] y : arr) fillArrWithRandom(y, 0,99);
        return arr;
    }

    public static int getProdEvensArr2D(final int[][] arr) {
        int prod = 1;
        for (int[] row : arr) for (int icol = 0; icol < row.length; icol+=2) prod *= row[icol];
        return prod;
    }

    public static int getMaxNumArr2D(final int[][] arr) {
        int max = arr[0][0];
        for (int[] row : arr) for (int num : row) max = max(max, num);
        return max;
    }

    public static int getMinNumArr2D(final int[][] arr) {
        int min = arr[0][0];
        for (int[] row : arr) for (int num : row) min = min(min, num);
        return min;
    }


    public static void showSimple2DWithSeparatedBy(final double[][] arr, String separator){
        showSimple2DSeparatedByWithStartEnd(arr, separator, "", "");
    }

    public static void showSimple2D(final double[][] arr){
        showSimple2DWithSeparatedBy(arr, ", ");
    }

    public static void showSimple2DSeparatedByWithBrackets(final double[][] arr, String separator){
        showSimple2DSeparatedByWithStartEnd(arr, separator, "[", "]");
    }

    public static void showSimple2DWithBrackets(final double[][] arr){
        showSimple2DSeparatedByWithBrackets(arr, ", ");
    }

    public static void showSimple2DWithSeparatedBy(final int[][] arr, String separator){
        showSimple2DSeparatedByWithStartEnd(arr, separator, "", "");
    }

    public static void showSimple2D(final int[][] arr){
        showSimple2DWithSeparatedBy(arr, ", ");
    }

    public static void showSimple2DSeparatedByWithBrackets(final int[][] arr, String separator){
        showSimple2DSeparatedByWithStartEnd(arr, separator, "[", "]");
    }

    public static void showSimple2DWithBrackets(final int[][] arr){
        showSimple2DSeparatedByWithBrackets(arr, ", ");
    }

    public static void showSimple2DSeparatedByWithStartEnd(final int[][] arr, String separator, String start, String end){
        for (int[] row : arr) {
            System.out.print(start);
            for (int i = 0; i < row.length; i++)
                System.out.printf(
                        "%02d%s",
                        row[i],
                        (i == row.length - 1 ? String.format("%s\n", end) : separator)
                );
        }
    }

    public static void showSimple2DSeparatedByWithStartEnd(final double[][] arr, String separator, String start, String end){
        for (double[] row : arr) {
            System.out.print(start);
            for (int i = 0; i < row.length; i++)
                System.out.printf(
                        "%.2f%s",
                        row[i],
                        (i == row.length - 1 ? String.format("%s\n", end) : separator)
                );
        }
    }


    public static int[][] genTable2D(int h, int w){
        if (h < 0 || w < 0)
            throw new IllegalArgumentException("No se pueden tomar medidas negativas");
        return (new int[h][w]);
    }

    public static double[][] genTable2DDec(int h, int w){
        if (h < 0 || w < 0)
            throw new IllegalArgumentException("No se pueden tomar medidas negativas");

        return (new double[h][w]);
    }

    public static  void fillRandom2DArr(final int[][] arr, int from, int until){
        for (int[] col : arr) fillArrWithRandom(col, from, until);
    }

    public static  int[] sumDiagsArrLR(final int[][] arr){
        int[] diagsLR = new int[arr.length + arr[0].length];
        for (int i = 0; i < arr.length-1; i++) for (int j = 0; j < arr[i].length-1; j++) diagsLR[i + j] += arr[i][j];
        return diagsLR;
    }

    public static int[] sumDiagsArrRL(final int[][] arr){
        int[] diagsRL = new int[arr.length + arr[0].length];
        for (int i = 0; i < arr.length-1; i++) for (int j = 0; j < arr[i].length-1; j++) diagsRL[j-i+arr.length-1]+=arr[i][j];
        return diagsRL;
    }

}
