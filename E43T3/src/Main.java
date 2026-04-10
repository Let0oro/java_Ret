/*
43. Hágase un programa que lea enteros entre -9999 y 9999 hasta introducir el valor 0.
Los datos se almacenarán en un ArrayList. El programa ordenará el ArrayList de
forma que primero aparezcan los valores con menos de 3 dígitos ordenados de menor
a mayor y luego el resto de valores ordenados de mayor a menor.
(OrdenarArrayListEnteros)
*/

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.abs;
import static jmb.arrays.showSimple;
import static jmb.in.leerInt;

public class Main {
    static void main(String[] args) {
        ArrayList<Integer> entradas = new ArrayList<Integer>();
        Integer in;
        while ((in = leerEntero()) != 0) entradas.add(in);
        entradas.sort(Main::compare);
        System.out.println(Arrays.toString(entradas.toArray()));
    }

    static Integer leerEntero (){
        return leerInt("Escribe un entero entre -9999 y 9999: ", v -> v >= -9999 && v <= 9999);
    }

    static int compare(Integer a, Integer b) {
            boolean aLessThree = abs(a) < 100;
            boolean bLessThree = abs(b) < 100;

            // grupos distintos -> a es menor de 3 cifras pero b es mayor o viceversa
            if (aLessThree && !bLessThree) return -1; // a, que es primero, va antes, se devuelve -1
            if (!aLessThree && bLessThree) return 1; // caso contrario al anterior

            // mismo grupo (a y b son menores de 3 cifras o al revés)
            if (aLessThree) return a.compareTo(b); // si a es menor de 3 cifras, b también lo será, ya que lo contrario está contenido en lo anteriormente hecho
            else return b.compareTo(a);
    }


}