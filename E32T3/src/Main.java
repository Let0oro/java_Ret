
//Cónsidérese una tabla de 3 x 8 de enteros con valores entre 0 y 9. En el programa se
//rellenará la tabla, se mostrará y se obtendrá la suma de cada una de las diagonales.
//(TablaDiagonales)

import static jmb.arrays.*;

public class Main {
    public static void main(String[] args) {
        int[][] arr = generateTable2D(3, 8);
        fillRandom2DArr(arr, 0, 9);
        showSimple2DSeparatedByWithBrackets(arr, ", ");
        int[] a = sumDiagsArrLR(arr);
        showSimple(a);
        int[] b = sumDiagsArrRL(arr);
        showSimple(b);
    }

    static int[][] generateTable2D(int h, int w){
        return (new int[h][w]);
    }

    static  void fillRandom2DArr(int[][] arr, int from, int until){
        for (int[] col : arr) fillArrWitRandom(col, from, until);
    }

    static  int[] sumDiagsArrLR(int[][] arr){
        int[] diagsLR = new int[arr.length + arr[0].length];
        for (int i = 0; i < arr.length-1; i++) for (int j = 0; j < arr[i].length-1; j++) diagsLR[i + j] += arr[i][j];
        return diagsLR;
    }


    static int[] sumDiagsArrRL(int[][] arr){
        int[] diagsRL = new int[arr.length + arr[0].length];
        for (int i = 0; i < arr.length-1; i++) for (int j = 0; j < arr[i].length-1; j++) diagsRL[j-i+arr.length-1]+=arr[i][j];
        return diagsRL;
    }
}