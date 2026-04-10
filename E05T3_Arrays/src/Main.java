import java.util.Arrays;

import static jmb.in.leerDouble;

public class Main {
  static void main(String[] args) {
    double[] temp = getTemps();
    showTemps(temp);
    System.out.println(getMax(temp));
    System.out.println(getMin(temp));
    System.out.println(getAvgWithoutEdges(temp));
    System.out.println(getAvgWithoutMaxAndMin(temp));
  }

  static double[] getTemps() {
    double[] temp = new double[10];
    Arrays.setAll(temp, i -> readTemp());
    return temp;
  }

  static double readTemp () {
    return leerDouble("Escribe una temperatura: ", v -> jmb.auxMath.isBetweenIncluded(v, -10, 50));
  }

  static void showTemps(double[] temps) {
    jmb.arrays.showSimple(temps);
  }

  static double getMax(double[] arr) {
    // Arrays.stream(arr).max();
    double max = arr[0];
    for (double t : arr) max = Math.max(max, t);
    return max;
  }

  static double getMin(double[] arr) {
    // Arrays.stream(arr).min();
    double min = arr[0];
    for (double t : arr) min = Math.min(min, t);
    return min;
  }

  static double getAvg(double[] arr) {
    if (arr.length == 0) return 0;
    double avg = 0;
    for (double t : arr) avg = avg + t;
    return jmb.auxMath.roundCstm(avg, 2);
  }

  static double getAvgWithoutEdges(double[] arr) {
    int len = arr.length;
    if (len == 0) return 0;
    double avg = 0;
    for (int i = 1; i < len-2; i++) avg = avg + arr[i];
    return jmb.auxMath.roundCstm(avg, 2);
  }

  static double getAvgWithoutMaxAndMin(double[] arr) {
    double avg = getAvg(arr);
    int len = arr.length;
    avg -= getMax(arr) - getMin(arr);
    avg /= len;
    return jmb.auxMath.roundCstm(avg, 2);
  }
}