import static lib.in.leerInt;

public class Main {
    static void main(String[] args) {
        int numMaxRondas = leerInt("Número máximo de rondas: ", v -> v > 1, "El número ha de ser superior a 1\n");
        int contadorRonda = 0;
        int pDavid = 0, pJulia = 0;

        System.out.println("DADO        PUNTOS      TOTAL");
        System.out.println("Julia David Julia David Julia David");
        System.out.println("===== ===== ===== ===== ===== =====");

        while (contadorRonda < numMaxRondas){
            contadorRonda++;

            int rondaDavid = 0, rondaJulia = 0;
            int dadoDavid = (int) (Math.random() * 6 + 1);
            int dadoJulia = (int) (Math.random() * 6 + 1);

            boolean dadoJuliaEsPar = dadoJulia % 2 == 0;
            boolean dadoDavidEsPar = dadoDavid % 2 == 0;

            if (dadoJuliaEsPar && !dadoDavidEsPar) rondaJulia++;
            if (!dadoJuliaEsPar && dadoDavidEsPar) rondaDavid++;

            if (dadoJuliaEsPar && dadoDavidEsPar) rondaJulia--;
            if (!dadoJuliaEsPar && !dadoDavidEsPar) rondaDavid--;

            pJulia += rondaJulia;
            if (pJulia < 0) pJulia = 0;

            pDavid += rondaDavid;
            if (pDavid < 0) pDavid = 0;

            System.out.printf("%5d %5d %5d %5d %5d %5d\n", dadoJulia, dadoDavid, rondaJulia, rondaDavid, pJulia, pDavid);

            int diferenciaPuntos = Math.max(pJulia, pDavid) - Math.min(pJulia, pDavid);
            if (diferenciaPuntos >= 5) break;
        }

        System.out.print("***********************************\n");
        System.out.println("Número de rondas jugadas: " + contadorRonda);

        if (pJulia == pDavid) System.out.println("Se ha producido un empate!");
        else System.out.printf("Ha ganado %s", (pJulia > pDavid) ? "Julia" : "David");
    }
}