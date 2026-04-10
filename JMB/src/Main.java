// Juan Manuel Montero Benavides

import static jmb.arrays.*;
import static jmb.auxMath.genRandomInt;

public class Main {
    static void main(String[] args) {

        boolean conditionSuccess;
        do {
            int val = genRandom();
            int[][] table = genTable();
            conditionSuccess = getConditions(table, val);
            String enunciado = val == 0 ? "más pares que impares" : "alguna fila con exactamente tres unos";
            System.out.printf("%d: Comprobar si hay %s\n", val, enunciado);
            showTable(table);
        } while (!conditionSuccess);
    }


    static int[][] genTable(){
        int[][] arr = new int[5][5];
        fillRandom2DArr(arr, 0, 9);
        return arr;
    }

    static void showTable(int[][] arr){
        for (int[] r : arr)
            for (int i = 0; i < r.length; i++)
                System.out.printf("%d%s", r[i], (i == r.length-1 ? "\n" : ""));
    }

    static int genRandom(){
        return genRandomInt(0, 1);
    }

    static boolean getConditions(int[][] arr, int val){
        int evens = 0;
        boolean areThreeOnes = false;
        int ones;
        for (int[] r : arr) {
            ones = 0;
            for (int n : r) {
                if (n == 1) ones++;
                if (n % 2 == 0) evens++;
            }
            areThreeOnes = areThreeOnes || (ones == 3);
        }
        return val == 0 && evens > 12 || val == 1 && areThreeOnes;
    }

}
