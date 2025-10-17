import lib.in;

// Juan Manuel Montero Benavides
public class Ejercicio1 {
    public static void main(String[] args) {
        final double g = 9.8;
        double v0, h, v, t, hmax, tmax;

        v0 = in.leerDouble("Velocidad inicial: ");

        hmax = v0 * v0 / (2 * g);
        hmax = Math.round(hmax * 100) / 100.0;
        System.out.println("Altura máxima: " + hmax);

        tmax = v0 / g;
        tmax = Math.round(tmax * 100) / 100.0;
        System.out.println("Tiempo máximo: " + tmax);

        t = in.leerDouble("Tiempo (entre 0 y " + tmax + "): ");

        v = v0 - g * t;
        v = Math.round(v * 100) / 100.0;
        System.out.println("Velocidad: " + v);

        h = v0 * t - g * t * t / 2;
        h = Math.round(h * 100) / 100.0;
        System.out.println("Altura: " + h);
    }
}
