package lib;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ask {
    static String dataQuestion = "Escribe tu";

    public static void forString(String dataAsked) {
        String input = in.leerString(dataQuestion +" "+ dataAsked);
        System.out.println("Tu " + dataAsked + " es -> " + input);
    }

    public static void forLine(String dataAsked) {
        String input = in.leerLine(dataQuestion +" "+ dataAsked);
        System.out.println("Tu " + dataAsked + " es -> " + input);
    }

    public static void forInt(String dataAsked) {
        int input = in.leerInt(dataQuestion + " " + dataAsked);
        System.out.println("Tu " + dataAsked + " es -> " + input);
    }

    public static void forBool(String question, String dataAsked) {
        boolean input = in.leerBoolean(question);
        System.out.println(dataAsked + " -> " + input);
    }

    public static void forDouble(String dataAsked) {
        double input = in.leerDouble(dataQuestion +" "+ dataAsked);
        System.out.println("Tu " + dataAsked + " es -> " + input);
    }

    public static void forFloat(String dataAsked) {
        float input = in.leerFloat(dataQuestion +" "+ dataAsked);
        System.out.println("Tu " + dataAsked + " es -> " + input);
    }

    public static void forShort(String dataAsked) {
        short input = in.leerShort(dataQuestion +" "+ dataAsked);
        System.out.println("Tu " + dataAsked + " es -> " + input);
    }

    public static void forLong(String dataAsked) {
        long input = in.leerLong(dataQuestion +" "+ dataAsked);
        System.out.println("Tu " + dataAsked + " es -> " + input);
    }

    public static void forBigInt(String dataAsked) {
        BigInteger input = in.leerBigInteger(dataQuestion +" "+ dataAsked);
        System.out.println("Tu " + dataAsked + " es -> " + input);
    }

    public static void forBigDec(String dataAsked) {
        BigDecimal input = in.leerBigDecimal(dataQuestion +" "+ dataAsked);
        System.out.println("Tu " + dataAsked + " es -> " + input);
    }

    public static void forByte(String dataAsked) {
        byte input = in.leerByte(dataQuestion +" "+ dataAsked);
        System.out.println("Tu " + dataAsked + " es -> " + input);
    }

    public static void stop(){
        in.detener();
    }

}
