import lib.in;

import java.math.BigDecimal;

public class Main {
    public static void main() {
        buclePresentar(10);
    }

    public static double leerPeso() {
        return in.leerDouble("Escribe un peso: ", v -> v >=2 && new BigDecimal(""+v).scale() <= 2);
    }

    public static double leerAltura() {
        return in.leerDouble("Escribe una altura: ", v -> v >=0.2 && v <= 2.2 && new BigDecimal(""+v).scale() <= 2);
    }

    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static String interpretarIMC(double imc) {
        if (imc < 18.5) return "Peso insuficiente";
        if (imc < 25) return "Normopeso";
        if (imc < 27) return "Sobrepeso grado I";
        if (imc < 30) return "Sobrepeso grado II (preobesidad)";
        if (imc < 35) return "Obesidad de tipo I";
        if (imc < 40) return "Obesidad de tipo II";
        if (imc < 50) return "Obesidad de tipo III (mórbida)";
        return "Obesidad de tipo IV (extrema)";
    }

    public static void presentarInfo(int num, double peso, double altura, double imc, String interpretacion){
        detenerSegs(5);
        System.out.print("\033[2J\033[H");
        String str = "************************************************\n";
        str += "INFORME DE INDICE DE MASA CORPORAL\n";
        str += "************************************************\n";
        str += "PERSONA NUMERO: " + num + "\n";
        str += "PESO: " + peso + "\n";
        str += "ALTURA: " + altura + "\n";
        str += "IMC: " + imc + "\n";
        str += "INTERPRETACION: " + interpretacion + "\n";
        str += "************************************************";
        System.out.println(str);
    }

    public static void buclePresentar(int nPersonas){
        for (int i = 0; i < nPersonas; i++) {
            double peso = leerPeso();
            double altura = leerAltura();
            double imc = calcularIMC(peso, altura);
            String interpretacion = interpretarIMC(imc);
            presentarInfo(i, peso, altura, imc, interpretacion);
        }
    }

    public static void detenerSegs(int segundos){
        in.dormir(segundos*1000L);
    }


}