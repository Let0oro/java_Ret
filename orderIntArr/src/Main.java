import java.util.Arrays;
import java.util.Comparator;

import static jmb.auxMath.genRandomInt;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = genIntegerArr(100);
        fillArrWithRandom(arr, -100, 100);
        showArrSimple(arr);
        sortInteger(arr);
        showArrSimple(arr);
    }

    public static Integer[] genIntegerArr(int size){
        return new Integer[100];
    }

    public static void fillArrWithRandom(final Integer[] arr, int from, int until){
        Arrays.setAll(arr, i -> genRandomInt(from, until));
    }

    public static void showArrSimple(final Integer[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void sortInteger(final Integer[] arr){
        orderEvensNegPos(arr);
    }

    public static void orderEvensNegPos(final Integer[] arr) {
        Arrays.sort(arr, Main::evensNegPos);
    }

    public static Integer evensNegPos(Integer a, Integer b){
        System.out.println("("+ a + ", " + b + ")");
        if (a%2==b%2) return 0;
        if (a%2==0) return 1;
        if (b%2==0) return -1;
        return a-b;
    }


}