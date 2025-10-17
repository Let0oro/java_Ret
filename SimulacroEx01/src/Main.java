import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        double r, rM, g, h, vol, area;

        rM = in.leerDouble("Radio de la base mayor: ");
        r = in.leerDouble("Radio de la base menor: ");
        h = in.leerDouble("Altura: ");

        vol = rM * rM + r * r + rM * r;
        vol = Math.PI * h / 3 * vol;
        vol = Math.round(vol * 1000) / 1000.0;

        System.out.println("Volumen: " + vol);

        g = rM - r;
        g *= g;
        g = h * h + g;

        // Raíz cuadrada Math vs babilónica
//        g = Math.sqrt(g);
        double guess = g;

        guess = (guess + g / guess) / 2.0;
        guess = (guess + g / guess) / 2.0;
        guess = (guess + g / guess) / 2.0;
        guess = (guess + g / guess) / 2.0;
        guess = (guess + g / guess) / 2.0;
        guess = (guess + g / guess) / 2.0;
        guess = (guess + g / guess) / 2.0;

        g = guess;

        System.out.println(g);

        area = rM + r;
        area *= g;
        area = area + rM * rM + r * r;
        area *= Math.PI * h;
        area = Math.round(area * 1000) / 1000.0;

        System.out.println("Area: " + area);
    }
}
