import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        final double priceDrink = 1.25;
        final double priceSandwich = 2.05;

        System.out.println("Las bebidas cuestan 1.25€, los bocadillos, 2.05€, escoge:");

        int numDrinks = in.leerInt("Número de bebidas: ");
        int numSandwich = in.leerInt("Número de bocadillos: ");

        double totalDrinks = numDrinks * priceDrink;
        System.out.println("Coste de las bebidas: " + totalDrinks);

        double totalSandwich = numSandwich * priceSandwich;
        System.out.println("Coste de los bocadillos: " + totalSandwich);

        System.out.println("Coste consumición: " + (totalDrinks + totalSandwich));
    }
}
