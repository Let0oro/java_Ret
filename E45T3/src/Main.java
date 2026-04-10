
/*

MENU ACCION
==== ======
1.    Apilar un entero
2.    Desplazar un enteri
3.    Mostrar la pila
4.    Sumar los elementos de la lista
otra  Finalizar
*/


import static java.lang.System.out;
import static jmb.in.*;

public class Main {
  static void main(String[] args) {

  }

          ArrayList<Integer> numeros = new ArrayList<>();
        String menu = """
                OPCION  ACCION
                ======  =================================================
                   1    Insertar un nuevo numero
                   2    Mostrar los numeros
                   3    Eliminar un número
                   4    Vaciar
                 otra   Finalizar""";
        menu(menu,numeros,Main::insertar, Main::mostrar, Main::eliminar,Main::vaciar);
    }

    private static void vaciar(ArrayList<Integer> a) {
        cls();
        out.println("VACIAR                   ");
        out.println("=========================");
        if(a.isEmpty()) out.println("No hay datos");
        else{
            a.clear();
            out.println("Datos vaciados");
        }
        out.println("=========================");
        detener("Pulsa enter para continuar ...");
    }

    private static void eliminar(ArrayList<Integer> a) {
        cls();
        out.println("ELIMINAR                 ");
        out.println("=========================");
        Integer numero = leerInt("Escribe un entero a eliminar: ");
        if(!a.contains(numero)) out.println("No existe el numero a eliminar");
        else{
            a.remove(numero);
            out.println("Numero eliminado");
        }
        detener("Pulsa enter para continuar ...");
    }

    private static void mostrar(ArrayList<Integer> a) {
        cls();
        out.println("MOSTRAR                   ");
        out.println("=========================");
        out.println(a.toString().replaceAll("[\\[\\]]",""));
        out.println("Datos mostrados");
        out.println("=========================");
        detener("Pulsa enter para continuar ...");
    }

    private static void insertar(ArrayList<Integer> a) {
        cls();
        out.println("INSERTAR                 ");
        out.println("=========================");
        int numero = leerInt("Escribe un entero: ");
        if(a.contains(numero)) out.println("Ya existe el numero");
        else{
            a.add(numero);
            out.println("Numero añadido");
        }
        out.println("=========================");
        detener("Pulsa enter para continuar ...");
    }

}