// Juan Manuel Montero Benavides

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static java.lang.System.out;
import static jmb.arrays.*;
import static jmb.in.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final String FICHERO = "JuanManuelMonteroBenavides.jmb";
        if (!new File(FICHERO).isFile()) grabar(FICHERO, new ArrayList<>());
        ArrayList<Integer> numeros = leer(FICHERO);
        String menu = """
                OPCION  ACCION
                ++++++  ++++++++++++++++++++++++++++++++++++++++++++++++
                   1    Reinicializar
                   2    Ordenar
                   3    Mostrar
                   4    Valor medio 5 primeros y 5 últimos
                   5    Eliminar mínimo (solo si hay más de 10 elementos)
                   6    Eliminar valores pares
                 otra   Finalizar""";
        menu(menu, numeros, Main::reinicializar, Main::ordenar, Main::mostrar, Main::valorMedio, Main::deleteMin, Main::deleteEvens);
        grabar(FICHERO,numeros);
    }

    //region REINICIALIZAR

    private static void reinicializar(final ArrayList<Integer> arr) {
        showHeader("Reinicializar");

        if (!arr.isEmpty()) arr.clear();
        Integer[] a = new Integer[20];
        fillArrWithRandom(a, 10, 99);
        arr.addAll(List.of(a));
        out.println("La colección ha sido reinicializada");

        showFooter();
    }

    //endregion

    //region ORDENAR

    private static void ordenar(final ArrayList<Integer> datos) {
        showHeader("Ordenar");

        Integer[] a = datos.toArray(new Integer[]{});
        Arrays.sort(a, Main::criterioDeOrdenacion);
        datos.clear();
        datos.addAll(List.of(a));
        out.println("La colección ha sido ordenada");

        showFooter();
    }

    private static int criterioDeOrdenacion(Integer a, Integer b) {
        boolean dentroA = a>=10 && a<=30;
        boolean dentroB = b>=10 && b<=30;
        boolean dentro2A = a>=31 && a<=60;
        boolean dentro2B = b>=31 && b<=60;

        if(dentroA && !dentroB) return -1;
        if(!dentroA && dentroB) return 1;
        if(dentroA) {
            if(a<b) return -1;
            if(a>b) return 1;
            return 0;
        }
        if(dentro2A && !dentro2B) return -1;
        if(!dentro2A && dentro2B) return 1;
        if (dentro2A) {
            if(a<b) return 1;
            if(a>b) return -1;
            return 0;
        }

        boolean aPar = a % 2 == 0;
        boolean bPar = b % 2 == 0;

        if(aPar && !bPar) return -1;
        if(!aPar && bPar) return 1;
        return 0;
    }

    //endregion

    //region MOSTRAR

    private static void mostrar(ArrayList<Integer> a) {
        mostrar(a, false);
    }

    private static void mostrar(ArrayList<Integer> a, boolean withFooter) {
        if (!withFooter) cls();

        StringBuilder aCopy = new StringBuilder();
        for (int i = 1; i <= a.size(); i++)
            if (i % 5 == 0) aCopy.append(a.get(i-1) + "\n");
            else aCopy.append(a.get(i-1) + " ");

        out.println(aCopy);

        if (!withFooter) dormir(5000);
    }



    //endregion

    //region VALOR MEDIO

    private static void valorMedio (final ArrayList<Integer> arr) {
        showHeader("Valor medio 5 primeros y 5 últimos");

        int len = arr.size();
        Integer[] first = arr.subList(0, 5).toArray(new Integer[0]);
        Integer[] last = arr.subList(len-6,len-1).toArray(new Integer[0]);

        int avgFirst = valorMedio(first);
        int avgLast = valorMedio(last);

        out.println("Media de 5 primeros: " + avgFirst);
        out.println("Media de 5 últimos:  " + avgLast);

        showFooter();
    }

    //endregion

    //region DELETE MIN

    private static void deleteMin (final ArrayList<Integer> arr) {
        cls();
        showHeader("Eliminar mínimo (solo si hay más de 10 elementos)");

        if (arr.size() <= 10) {
            out.println("La colección no tiene más de 10 datos");

            showFooter();
            return;
        }

        int minInt = valorMin(arr.toArray(new Integer[0]));
        int ix = arr.indexOf(minInt);
        arr.remove(ix);

        out.println("Mínimo valor encontrado: " + minInt);
        out.println("Índice del mínimo valor:  " + ix);

        showFooter();
    }

    //endregion

    //region ELIMINAR PARES

    private static void deleteEvens (final ArrayList<Integer> arr) {
        showHeader("Eliminar valores pares");

        int lenIni = arr.size();
        arr.removeIf(el -> el % 2 == 0);
        int lenFin = arr.size();

        mostrar(arr, true);
        out.println();

        while (arr.size() < 10) arr.add(10);

        if (lenFin == lenIni) out.println("No se ha podido eliminar el dato");
        else {
            out.print("Se han eliminado los pares");
            if (lenFin < 10) out.println(" y se ha completado la colección");
        }

        showFooter();
    }

    //endregion

    //region HELPERS

    private static int valorMedio (Integer ...nums) {
        int sum = 0;
        for (Integer num : nums) sum += num;
        return Math.round((float) sum / nums.length);
    }

    private static Integer valorMin (Integer ...nums) {
        int min = nums[0];
        for (Integer num : nums) min = min < num ? min : num;
        return min;
    }

    private static void showHeader(String title) {
        cls();
        out.println(title.toUpperCase());
        out.println();
    }

    private static void showFooter() {
        out.println();
        out.println("++++++++++ Juan Manuel Montero Benavides ++++++++++");
        dormir(5000);
    }

    //endregion

    //region MENU

    static <T> void menu(String menu, T datos, Consumer<T>... acciones){
        int opcion;

        while(true){
            cls();
            out.println(menu);
            opcion = leerInt("OPCION: ");
            if(opcion<=0 || opcion>=acciones.length+1) break;
            acciones[opcion-1].accept(datos);
        }
    }

    //endregion

    // region PERSISTENCIA

    static <T> void grabar(final String FICHERO, T objeto) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))){
            oos.writeObject(objeto);
        }
    }

    @SuppressWarnings("unchecked")
    static <T> T leer(final String FICHERO) throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))){
            return  (T) ois.readObject();
        }
    }

    //endregion
}