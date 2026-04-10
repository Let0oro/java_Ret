//Hágase un programa que genere 10 reales con dos decimales entre -99.99 y 99.99. Se
//mostrará el array separando los datos con comas. Se ordenará de forma que primero
//se mostrarán los valores entre -10.00 y 10.00 en orden ascendente y luego el resto de
//los valores en orden descendente. (OrdenarArrayReales)


import java.util.Arrays;

import static jmb.arrays.fillArrWithRandom;
import static jmb.arrays.showSimpleSeparatedBy;

public class Main {
    static void main(String[] args) {

        Double[] arr = genArr();
        showSimpleSeparatedBy(arr, ", ");
        Arrays.sort(arr, );

    }

    static Double[] genArr(){
        Double[] arr = new Double[10];
        fillArrWithRandom(arr, -9999, 9999);
        Arrays.setAll(arr, i -> arr[i] / 100);
        return arr;
    }

    @Override
    static boolean



}