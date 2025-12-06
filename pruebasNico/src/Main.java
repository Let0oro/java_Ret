import jmb.*;

public class Main {
    static void main(String[] args) {
        int inicioLote, finLote, criterioSeleccion, criterioSeleccionado;

        criterioSeleccionado=0;

        int aux= inicioLote= in.leerInt("Inicio lote: ");
        finLote= in.leerInt("Fin lote: ");
        criterioSeleccion=in.leerInt("Criterio selección: ");

        if (finLote<inicioLote){
            System.out.println("--------- ERROR ---------");
            System.out.println("VALOR DE VARIABLE ILÓGICO");
            System.out.println("Pulse enter para repetir el proceso:");

            inicioLote= in.leerInt("Inicio lote: ");
            finLote= in.leerInt("Fin lote: ", v-> v>aux );
            criterioSeleccion=in.leerInt("Criterio selección: ");

            for(int i= inicioLote; i<=finLote; i++){
                System.out.println("Caja " + i);

                if(i%criterioSeleccion==0){
                    System.out.println("Caja " +i+ " ✨");
                }
            }
        } else {
            for(int i= inicioLote; i<=finLote; i++){
                System.out.println("Caja " + i);
                if(i%criterioSeleccion==0){
                    System.out.println("Caja " +i+ " ✨");
                }
            }

        }


    }
}