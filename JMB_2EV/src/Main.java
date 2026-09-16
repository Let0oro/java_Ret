import jmb.viajes.Cohete;
import jmb.viajes.ViajeEspacial;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) {

        ViajeEspacial viaje1 = new ViajeEspacial("luna", 300000.76);
        Cohete cohete1 = new Cohete("marte", 797.65, 34, 21);
        Cohete cohete2 = new Cohete("jupiter", 878766.76, 1, 987);


        ArrayList<ViajeEspacial> a = new ArrayList<>();
        a.add(viaje1);
        a.add(cohete1);
        a.add(cohete2);

        Cohete.viaje(a);

    }
}