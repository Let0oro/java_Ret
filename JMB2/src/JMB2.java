public class JMB2 {
    static void main() {

        int numeroCaras = 0;
        int numeroCruces = 0;
        String resultados = "";
        boolean saleCara;

        boolean pedroEligeCara = (int) (Math.random() * 2) == 1;

        if (pedroEligeCara) {
            System.out.println("Pedro apuesta por cara");
            System.out.println("Antonio apuesta por cruz");
        } else {
            System.out.println("Pedro apuesta por cruz");
            System.out.println("Antonio apuesta por cara");
        }

        saleCara = (int) (Math.random() * 2) == 1;
        if (saleCara) {
            resultados += "c";
            numeroCaras++;
        } else {
            resultados += "+";
            numeroCruces++;
        };

        saleCara = (int) (Math.random() * 2) == 1;
        if (saleCara) {
            resultados += "c";
            numeroCaras++;
        } else {
            resultados += "+";
            numeroCruces++;
        };

        saleCara = (int) (Math.random() * 2) == 1;
        if (saleCara) {
            resultados += "c";
            numeroCaras++;
        } else {
            resultados += "+";
            numeroCruces++;
        };

        saleCara = (int) (Math.random() * 2) == 1;
        if (saleCara) {
            resultados += "c";
            numeroCaras++;
        } else {
            resultados += "+";
            numeroCruces++;
        };

        saleCara = (int) (Math.random() * 2) == 1;
        if (saleCara) {
            resultados += "c";
            numeroCaras++;
        } else {
            resultados += "+";
            numeroCruces++;
        };

        System.out.println(resultados);

        if (numeroCaras > numeroCruces) System.out.printf("Ha ganado %s", pedroEligeCara ? "Pedro" : "Antonio");
        else System.out.printf("Ha ganado %s", pedroEligeCara ? "Antonio" : "Pedro");
    }
}