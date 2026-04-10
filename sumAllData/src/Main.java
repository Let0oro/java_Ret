import static java.lang.Math.pow;
import static java.lang.Math.round;

public class Main {

    static void main(String[] args) {
        double sum = sumAll(3, 3.5, 10.4, -3.1112, 28.3945);
        System.out.println(sum);
    }


    public static double sumAll(int deep, double ...nums) {
        if (nums.length == 0) return Double.NaN;

        double sum = 0.0;
        for (double num : nums) sum += num;
        roundCstm(sum, deep);
        return sum;
    }


    public static double sumAll(double ...nums){
        return sumAll(0, nums);
    }


    public static double roundCstm(double num, int deep) {
        if (deep == 0) return round(num);
        if (deep < 0) {
            double aux = pow(10, -deep);
            return round(num / aux) * aux;
        }
        double aux = pow(10, deep);
        return round(num * aux) / aux;
    }
}
