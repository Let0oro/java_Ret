import lib.in;

public class Main {
{
    public static void main(String[] args)
    {
        int bebida, bocadillo, nAlumnos;
        double precioBebida, precioBocadillo, totalBebidas, totalBocadillos, total, cantidadPorAlumno;

        bebida = in.leerInt("Número de bebidas (entre 0 y 20): ");
        bocadillo = in.leerInt("Número de bocadillos (entre 0 y 20): ");

        precioBebida = in.leerDouble("Precio de cada bebida (entre 0,00 y 3,00): ");
        precioBocadillo = in.leerDouble("Precio de cada bocadillo (entre 0,00 y 3,00): ");

        nAlumnos = in.leerInt("Número de alumnos (entre 1 y 10): ");

        totalBebidas = bebida * precioBebida;
        totalBocadillos = bocadillo * precioBocadillo;

        total = totalBebidas + totalBocadillos;

        cantidadPorAlumno = total / nAlumnos;

        System.out.printf("\n%-12s %-7s %-7s %-6s\n", "ARTICULO", "CANTIDAD", "PRECIO", "COSTE");
        System.out.println("============ ======== ======= ======");
        System.out.printf("%-12s %8d %7.2f %6.2f\n", "Bebida", bebida, precioBebida, totalBebidas);
        System.out.printf("%-12s %8d %7.2f %6.2f\n", "Bocadillo", bocadillo, precioBocadillo, totalBocadillos);
        System.out.println("                              ======");
        System.out.printf("%-12s %8s %-7s %6.2f\n", "TOTAL", "", "", total);
        System.out.println("------------------------------------");
        System.out.printf("Cantidad a poner por cada alumno: %,.2f", cantidadPorAlumno);
    }
}
