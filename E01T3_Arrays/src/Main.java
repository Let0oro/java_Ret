import java.util.Arrays;
import static jmb.in.leerDouble;

/*
Hágase un programa en el que se declare un array de reales de tamaño 3. En el
programa se hará lo siguiente;
 */
public class Main {
    public static void main(String[] args) {
        double[] numbers = askDataArray();
        showArray(numbers);
        generateSumToRandom(numbers);
//        e) Se mostrará de nuevo las celdas con el formato del apartado c)
        showArray(numbers);
        rebootArrayWInts(numbers);
        showTableMode(numbers);
        interchangeCells(numbers);
        showSimple(numbers);
    }

    /*
    a) Se introducirán los datos del array por la consola.
    b) Si el valor de la segunda celda es mayor que el de la primera celda, se incrementará
    en un uno el valor de la tercera celda; si no, se le asignará a la tercera celda un
    valor aleatorio real entre 0 y 1 (este último sin incluir).
    */
    static double[] askDataArray(){
        double[] ret = new double[3];
        Arrays.setAll(ret, i -> leerDouble("Escribe un real: "));
        if (ret[1] > ret[0]) ret[2]++; else ret[2] = Math.random();
        return ret;
    }

    //c) Se mostrarán los valores de las tres celdas en una misma línea separados por comas
    static void showArray(double[] numbers){
        int len = numbers.length;
        for (int i = 0; i < len; i++) System.out.printf("%.1f%s", numbers[i], (i == len-1 ? "" : ", "));
        System.out.println();
    }

    /*
    d) Se generará una posición aleatoria del array (un valor entre 0 y 2, ambos
    inclusive). La celda aleatoria generada se le asignará como valor la suma de las
    otras dos celdas.
    */
    static void generateSumToRandom (double[] numbers) {
        int rand = (int) (Math.random() * numbers.length);
        double sum = Arrays.stream(numbers).sum() - numbers[rand];
        numbers[rand] = sum;
    }

    /*
    f) Se reinicializará el array a uno de tamaño 2 con valores aleatorios de números
    enteros entre 0 y 9, ambos inclusive.
     */
    static void rebootArrayWInts(double[] nums){
        nums = new double[2];
        Arrays.fill(nums, (int) (Math.random() * 10));
    }

    /* g) Se mostrará el contenido de las dos celdas con el siguiente formato:
    |---|---|
    | 5 | 0 |
    |---|---|
    (Se observa que los valores reales de las celdas a mostrar se han truncado a entero)
    */
    static void showTableMode(double[] nums) {
        final double[] numbers = Arrays.stream(nums).limit(2).toArray();
        Arrays.setAll(numbers, i -> (int) numbers[i]);
        System.out.printf("%s|\n", "|---".repeat(2));
        for (double num : numbers) System.out.printf("| %d ", (int) num);
        System.out.printf("|\n%s|\n", "|---".repeat(2));
    }

//    h) Se intercambiarán el contenido de las dos celdas
    static void interchangeCells(double[] numbers) {
        double aux = numbers[0];
        numbers[0] = numbers[1];
        numbers[1] = aux;
    }

    /*
    Se mostrará el contenido de las dos celdas con el siguiente formato
    0 5
    */
    static void showSimple(double[] nums){
        for (double num : nums) System.out.printf("%d ", (int) num);
    }


}