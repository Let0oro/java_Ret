import java.util.Arrays;
import static jmb.arrays.showSimple;


//16. Se considera un array de 10 elementos con valores aletaorios entre -10 y 10. Se
//mostrará el array, y se obtendrá un array con los valores positivos y otro con los
//valores negativos. Se mostrarán los dos arrays anteriores. (ArraysPositivosNegativos)
public class Main{
    static void main(String[] args) {
        int[] arr = createArr();
        showSimple(arr);
        showSimple(positives(arr));
        showSimple(negatives(arr));
    }

    static int[] createArr() {
        int[] arr = new int[10];
        fillArr(arr);
        return arr;
    }

    static void fillArr(final int[] arr) {
        jmb.arrays.fillArrWitRandom(arr, -10, 10);
    }

    static int[] negatives(final int[] arr){
        int[] neg = new int[arr.length];
        int iNeg = 0;
        for (int n: arr) if (n < 0) neg[iNeg++] = n;
        return Arrays.copyOfRange(neg, 0, iNeg+1);
    }

    static int[] positives(final int[] arr){
        int[] pos = new int[arr.length];
        int iPos = 0;
        for (int n: arr) if (n > 0) pos[iPos++] = n;
        return Arrays.copyOfRange(pos, 0, iPos+1);
    }


}