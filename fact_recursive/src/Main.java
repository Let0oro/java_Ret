public class Main {
    static void main() {
        System.out.println(hanoi(3));
    }

    static int fact(int num){
        return num == 1 ? 1 : num * fact(num-1);
    }

    static int hanoi(int num){
        // return num == 1 ? 1 : num + hanoi(num-1);
        // return num == 1 ? 1 : (int) Math.pow(2, num) - (num-1);

    }

    static int fibbonacci(int num) {
        return (num == 0 || num == 1) ? 1 : fibbonacci(num - 1) + fibbonacci(num - 2);
    }
}