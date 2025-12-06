package jmb;

public class auxMath {
    public static int genRandomInt(int from, int until) {
        return (int) genRandomDouble(from, until);
    }

    public static double genRandomDouble(int from, int until) {
        return Math.random() * (until+1) + from;
    }

    public static double maxDouble(double ...numbers){
        double max = numbers[0];
        for (int i = 1; i < numbers.length; i++) max = Math.max(max, numbers[i]);
        return max;
    }

    public static double maxInt(int ...numbers){
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) max = Math.max(max, numbers[i]);
        return max;
    }

    public static double minDouble(double ...numbers){
        double min = numbers[0];
        for (int i = 1; i < numbers.length; i++) min = Math.min(min, numbers[i]);
        return min;
    }

    public static double minInt(int ...numbers){
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) min = Math.min(min, numbers[i]);
        return min;
    }
}
