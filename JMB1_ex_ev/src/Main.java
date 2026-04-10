import static java.lang.Math.pow;
import static java.lang.Math.round;
import static jmb.in.leerDouble;

class Main {
    static void main(String[] args) {

        double x0 = leerDouble("Posición inicial: ");
        double v0 = leerDouble("Velocidad inicial: ");
        double a  = leerDouble("Aceleración: ");
        double t  = leerDouble("Tiempo: ");

        System.out.println("Velocidad final: " + rCent(mov_unif_cont_v(v0, a, t)));
        System.out.println("Posición final: " + rCent(mov_unif_cont_pos(x0, v0, t, a)));
    }

    static double mov_unif_cont_v(double v0, double a, double t) {
        return v0 + a * t;
    }

    static double mov_unif_cont_pos(double x0, double v0, double t, double a) {
        return x0 + v0 * t + 0.5 * a * pow(t, 2);
    }

    static double rCent(double number){
        double n = (int) round(number * 100);
        return n / 100;
    }
}