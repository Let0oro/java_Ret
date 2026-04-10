import static jmb.arrays.fillArrWitRandom;
import static jmb.arrays.showSimpleSeparatedBy;
import static jmb.auxMath.*;

public class Main {
    public static void main(String[] args) {
        final int[] arr = createArr();
        fillArr(arr);
        final int[] valuesOneDigit = getValuesWithNDigitsFromArr(arr, 1);
        final int[] valuesTwoDigit = getValuesWithNDigitsFromArr(arr, 2);
        final int[] valuesThreeDigit = getValuesWithNDigitsFromArr(arr, 3);
        showArr(arr);
        showArr(valuesOneDigit);
        showArr(valuesTwoDigit);
        showArr(valuesThreeDigit);
    }

    static int[] createArr(){
        return new int[genRandomInt(10, 100)];
    }

    static void showArr(final int[] arr){
        System.out.print("[");
        showSimpleSeparatedBy(arr, ":");
        System.out.println("]");
    }

    static void fillArr(final int[] arr) {
        fillArrWitRandom(arr, 1, 999);
    }

    static int countValueDigitsFromArr(final int[] arr, final int n) {
        if (arr.length == 0) return 0;
        int count = 0;
        for (int num : arr) if (haveNDigits(num, n)) count++;
        return count;
    }

    static boolean haveNDigits(final int number, final int nDig){
        int min = (int) Math.pow(10, nDig-1);
        int max = (int) Math.pow(10, nDig)-1;
        return isBetweenIncluded(number, min, max);
    }

    static int[] getValuesWithNDigitsFromArr(final int[] arr, int n) {
        int len = countValueDigitsFromArr(arr, n);
        if (arr.length == 0 || len == 0) return new int[0];
        int[] res = new int[len];
        int index = 0;
        for (int num : arr) if (haveNDigits(num, n)) res[index++] = num;
        return res;
    }
}