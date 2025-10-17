import lib.in;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
{
    public static void main(String[] args) {
        int num = in.leerInt("Escribe un número entero o en base 2: ");
        int base = in.leerInt("Escoge el número para que sea la base: ");

//        char res = in.leerChar("Quieres convertir de decimal a binario(y) o de binario a decimal(n)?",
//                v -> v == 'y' || v == 'Y' || v == 'n' || v == 'N',
//                "Por favor, responde 'y' o 'n'"
//        );
//
//        boolean toDec = res == 'y' || res == 'Y';
//        if (toDec) {
//            bin(num);
//        } else System.out.println("Próximamente...");

        bin(num, base);
    }

    public static void bin(int num, int base) {
        int aux = 0;
        System.out.println("\nBinario: ");
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> resNeg = res;

        if (num == 0) {
            System.out.println("Result: 0");
            return;
        }

        int len = (int) Math.ceil(
                Math.log10(Math.abs(num))
                /
                Math.log10(Math.abs(base))
        );
        System.out.println(Math.ceil(1.2));

        if (num < 0) {
            aux = num;
            num = Math.abs(num);
        }
        for (int i = 0; i <= len; i++) {
            int next = num / base;
            int mod = num%base;
            System.out.printf("%d / 2 = %d (Resto: %d)", num, next, mod);
            System.out.println();
            num = next;
            res.add(mod);
        }

        if (aux < 0) {
            int firstPosFromRight = res.indexOf(1);
            System.out.println(len);
            System.out.println(res.reversed());
            for (int i = 1; i <= len; i++) {
                boolean isBeforeLastOne = i < len - firstPosFromRight;
                boolean isLastOne = i == len - firstPosFromRight;
                int newBit = 0;
                if (isBeforeLastOne) {
                    newBit = res.get(i) == 1 ? 0 : 1;
                    resNeg.add(newBit);
                } else if (isLastOne) {
                    res.add(1);
                } else {
                    res.add(newBit);
                }
            }
            res = resNeg;
        }

        // 37 ->  0100101
        // -37 -> 1011011

        System.out.print("Result: ");
        for (int bit : res.reversed()) {
            System.out.print(bit);
        }
        System.out.println();
    }

}
