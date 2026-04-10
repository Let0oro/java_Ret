package jmb;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class auxMath {
    public static int genRandomInt(int from, int until) {
        return (int) genRandomDouble(from, until);
    }

    public static double genRandomDouble(int from, int until) {
        return Math.random() * (until - from + 1) + from;
    }

    public static double maxDouble(double ...numbers){
        double max = numbers[0];
        for (int i = 1; i < numbers.length; i++) max = Math.max(max, numbers[i]);
        return max;
    }

    public static double maxInt(int ...numbers){
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) max = Math.max(max, numbers[i]);
        return max;
    }

    public static double minDouble(double ...numbers){
        double min = numbers[0];
        for (int i = 1; i < numbers.length; i++) min = Math.min(min, numbers[i]);
        return min;
    }

    public static double minInt(int ...numbers){
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) min = Math.min(min, numbers[i]);
        return min;
    }

    public static double randomWDec(int deep) {
        int num, deepNum = (int) pow(10, deep);
        do num = genRandomInt(0,  deepNum - 1); while (num % 10 == 0);
        return num / (double) deepNum;
    }

    public static String formatNumber(double v, int deep) {
        double deepNum = pow(10, deep);
        long complete = round(v * deepNum);
        boolean isNeg = v < 0;
        if (isNeg) complete = -complete;
        long integer = complete / (int) deepNum;
        long frac = complete % (int) deepNum;
        String fracStr = (frac < 10 ? "00" : (frac < 100 ? "0" : "")) + frac;
        return (isNeg ? "-" : "") + integer + "," + fracStr;
    }

    public static boolean isBetween(double num, double min, double max, boolean included) {
        return included ? min <= num && num <= max : min < num && num < max;
    }

    public static boolean isBetweenIncluded(double num, double min, double max) {
        return isBetween(num, min, max, true);
    }

    public static boolean isBetweenNotIncluded(double num, double min, double max) {
        return isBetween(num, min, max, false);
    }

    public static double roundCstm(double num, int deep) {
        if (deep < 0) return roundCstm((int) num, deep);
        if (deep == 0) return num;
        double aux = pow(10, deep);
        return (int) round(num * aux) / aux;
    }

    public static int roundCstm(int num, int deep) {
        double aux = 1 / pow(10, deep);
        return (int) (round(num * aux) / aux);
    }


    public static void fillRandomCellsArr2dEq(final int[][] arr, int number, int times){
        for (int _ : new int[times]) arr[genRandomInt(0, arr[0].length)][genRandomInt(0, arr[0].length)] = number;
    }

    public static int countIntArr2d(final int[][] arr, int search) {
        int count = 0;
        for (int[] n : arr) count += countIntArr(n, search);
        return count;
    }

    public static int countIntArr(final int[] arr, int search) {
        int count = 0;
        for (int m : arr) if (m == search) count++;
        return count;
    }


    

}
