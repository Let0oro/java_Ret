package lib;
import java.util.Scanner;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.io.IOException;
import java.util.function.Predicate;
public class in
{
    final static public Scanner in = new Scanner(System.in);

    static public void detener()
    {
        detener("Pulsa enter para continuar ... ");
    }

    static public void detener(String mensaje)
    {
        System.out.print(mensaje);
        in.nextLine();
    }

    static public byte leerByte(String mensaje)
    {
        byte valor = 0;
        while(true)
            try
            {
                System.out.print(mensaje);
                valor = in.nextByte();
                if(!in.nextLine().equals("")) System.out.println("Pulsa enter al escribir el dato");
                else break;
            }
            catch(Exception e)
            {
                System.out.println("Valor incorrecto o desbordado");
                in.nextLine();
            }

        return valor;
    }

    static public byte leerByte()
    {
        return leerByte("ESCRIBE UN ENTERO DE 1 BYTE: ");
    }

    static public short leerShort(String mensaje)
    {
        short valor = 0;
        while(true)
            try
            {
                System.out.print(mensaje);
                valor = in.nextShort();
                if(!in.nextLine().equals("")) System.out.println("Pulsa enter al escribir el dato");
                else break;
            }
            catch(Exception e)
            {
                System.out.println("Valor incorrecto o desbordado");
                in.nextLine();
            }

        return valor;
    }

    static public short leerShort()
    {
        return leerShort("ESCRIBE UN ENTERO CORTO: ");
    }


    static public int leerInt(String mensaje)
    {
        int valor = 0;
        while(true)
            try
            {
                System.out.print(mensaje);
                valor = in.nextInt();
                if(!in.nextLine().equals("")) System.out.println("Pulsa enter al escribir el dato");
                else break;
            }
            catch(Exception e)
            {
                System.out.println("Valor incorrecto o desbordado");
                in.nextLine();
            }

        return valor;
    }

    static public int leerInt()
    {
        return leerInt("ESCRIBE UN ENTERO: ");
    }

    static public long leerLong(String mensaje)
    {
        long valor = 0;
        while(true)
            try
            {
                System.out.print(mensaje);
                valor = in.nextLong();
                if(!in.nextLine().equals("")) System.out.println("Pulsa enter al escribir el dato");
                else break;
            }
            catch(Exception e)
            {
                System.out.println("Valor incorrecto o desbordado");
                in.nextLine();
            }

        return valor;
    }

    static public long leerLong()
    {
        return leerLong("ESCRIBE UN ENTERO LARGO: ");
    }

    static public float leerFloat(String mensaje)
    {
        float valor = 0;
        while(true)
            try
            {
                System.out.print(mensaje);
                valor = in.nextFloat();
                if(!in.nextLine().equals("")) System.out.println("Pulsa enter al escribir el dato");
                else break;
            }
            catch(Exception e)
            {
                System.out.println("Valor incorrecto o desbordado");
                in.nextLine();
            }

        return valor;
    }

    static public float leerFloat()
    {
        return leerFloat("ESCRIBE UN REAL DE SIMPLE PRECISION: ");
    }

    static public double leerDouble(String mensaje)
    {
        double valor = 0;
        while(true)
            try
            {
                System.out.print(mensaje);
                valor = in.nextDouble();
                if(!in.nextLine().equals("")) System.out.println("Pulsa enter al escribir el dato");
                else break;
            }
            catch(Exception e)
            {
                System.out.println("Valor incorrecto o desbordado");
                in.nextLine();
            }

        return valor;
    }

    static public double leerDouble()
    {
        return leerDouble("ESCRIBE UN REAL: ");
    }

    static public BigInteger leerBigInteger(String mensaje)
    {
        BigInteger valor = new BigInteger("0");
        while(true)
            try
            {
                System.out.print(mensaje);
                valor = in.nextBigInteger();
                if(!in.nextLine().equals("")) System.out.println("Pulsa enter al escribir el dato");
                else break;
            }
            catch(Exception e)
            {
                System.out.println("Valor incorrecto o desbordado");
                in.nextLine();
            }

        return valor;
    }

    static public BigInteger leerBigInteger()
    {
        return leerBigInteger("ESCRIBE UN ENTERO GRANDE: ");
    }

    static public BigDecimal leerBigDecimal(String mensaje)
    {
        BigDecimal valor = new BigDecimal("0");
        while(true)
            try
            {
                System.out.print(mensaje);
                valor = in.nextBigDecimal();
                if(!in.nextLine().equals("")) System.out.println("Pulsa enter al escribir el dato");
                else break;
            }
            catch(Exception e)
            {
                System.out.println("Valor incorrecto o desbordado");
                in.nextLine();
            }

        return valor;
    }

    static public BigDecimal leerBigDecimal()
    {
        return leerBigDecimal("ESCRIBE UN REAL GRANDE: ");
    }


    static public boolean leerBoolean(String mensaje)
    {
        boolean valor = false;
        while(true)
        {
            System.out.print(mensaje);
            try
            {
                valor = in.nextBoolean();
            }
            catch(Exception e)
            {
                in.nextLine();
                System.out.println("Valor incorrecto");
                continue;
            }
            if(!in.nextLine().equals("")) System.out.println("Pulsa enter al escribir el dato");
            else break;
        }

        return valor;
    }

    static public boolean leerBoolean()
    {
        return leerBoolean("ESCRIBE TRUE/FALSE: ");
    }

    static public String leerString(String mensaje)
    {
        String valor = "";
        while(true)
        {
            System.out.print(mensaje);
            valor = in.next();
            if(!in.nextLine().equals("")) System.out.println("Pulsa enter al escribir el dato");
            else break;
        }

        return valor;
    }

    static public String leerString()
    {
        return leerString("ESCRIBE UNA PALABRA: ");
    }

    static public String leerLine(String mensaje)
    {
        String valor = "";
        System.out.print(mensaje);
        valor = in.nextLine();
        return valor;
    }

    static public String leerLine()
    {
        return leerLine("ESCRIBE UNA LINEA: ");
    }

    static public char leerChar(String mensaje)
    {
        String valor = "";

        while(true)
        {
            System.out.print(mensaje);
            valor = in.next();
            if(valor.length()!=1) System.out.println("Escribe un caracter");
            else if(!in.nextLine().equals("")) System.out.println("Pulsa enter al escribir el dato");
            else break;
        }

        return valor.charAt(0);
    }

    static public char leerChar()
    {
        return leerChar("ESCRIBE UN CARACTER: ");
    }

    static public void dormir(long tiempo)
    {
        try
        {
            Thread.sleep(tiempo);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    static public void proceso(String ... s)
    {
        try
        {
            ProcessBuilder pb = new ProcessBuilder(s);
            pb.inheritIO().start().waitFor();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }


    static public void cls()
    {
        String so = System.getProperty("os.name");
        if(so.indexOf("Window")!=-1)
            proceso("cmd","/c","cls");
        else
            for(int i=0;i<100;i++)
                System.out.println("");
    }

    /* ***************************************************** */
    /* VALIDACION                                            */
    /* ***************************************************** */
    static public byte leerByte(String mensaje, Predicate<Byte> v, String ... error)
    {
        byte valor = 0;

        while(true)
            if(v.test(valor=leerByte(mensaje))) break;
            else if(error.length>0) System.out.print(error[0]);
            else System.out.println("Valor incorrecto");

        return valor;
    }

    static public short leerShort(String mensaje, Predicate<Short> v, String ... error)
    {
        short valor = 0;

        while(true)
            if(v.test(valor=leerShort(mensaje))) break;
            else if(error.length>0) System.out.print(error[0]);
            else System.out.println("Valor incorrecto");

        return valor;
    }

    static public int leerInt(String mensaje, Predicate<Integer> v, String ... error)
    {
        int valor = 0;

        while(true)
            if(v.test(valor=leerInt(mensaje))) break;
            else if(error.length>0) System.out.print(error[0]);
            else System.out.println("Valor incorrecto");

        return valor;
    }

    static public long leerLong(String mensaje, Predicate<Long> v, String ... error)
    {
        long valor = 0;

        while(true)
            if(v.test(valor=leerLong(mensaje))) break;
            else if(error.length>0) System.out.print(error[0]);
            else System.out.println("Valor incorrecto");

        return valor;
    }

    static public float leerFloat(String mensaje, Predicate<Float> v, String ... error)
    {
        float valor = 0;

        while(true)
            if(v.test(valor=leerFloat(mensaje))) break;
            else if(error.length>0) System.out.print(error[0]);
            else System.out.println("Valor incorrecto");

        return valor;
    }

    static public double leerDouble(String mensaje, Predicate<Double> v, String ... error)
    {
        double valor = 0;

        while(true)
            if(v.test(valor=leerDouble(mensaje))) break;
            else if(error.length>0) System.out.print(error[0]);
            else System.out.println("Valor incorrecto");

        return valor;
    }

    static public BigInteger leerBigInteger(String mensaje, Predicate<BigInteger> v, String ... error)
    {
        BigInteger valor = new BigInteger("0");

        while(true)
            if(v.test(valor=leerBigInteger(mensaje))) break;
            else if(error.length>0) System.out.print(error[0]);
            else System.out.println("Valor incorrecto");

        return valor;
    }

    static public BigDecimal leerBigDecimal(String mensaje, Predicate<BigDecimal> v, String ... error)
    {
        BigDecimal valor = new BigDecimal("0");

        while(true)
            if(v.test(valor=leerBigDecimal(mensaje))) break;
            else if(error.length>0) System.out.print(error[0]);
            else System.out.println("Valor incorrecto");

        return valor;
    }

    static public boolean leerBoolean(String mensaje, Predicate<Boolean> v, String ... error)
    {
        boolean valor = false;

        while(true)
            if(v.test(valor=leerBoolean(mensaje))) break;
            else if(error.length>0) System.out.print(error[0]);
            else System.out.println("Valor incorrecto");

        return valor;
    }

    static public String leerString(String mensaje, Predicate<String> v, String ... error)
    {
        String valor = "";

        while(true)
            if(v.test(valor=leerString(mensaje))) break;
            else if(error.length>0) System.out.print(error[0]);
            else System.out.println("Valor incorrecto");

        return valor;
    }

    static public String leerLine(String mensaje, Predicate<String> v, String ... error)
    {
        String valor = "";

        while(true)
            if(v.test(valor=leerLine(mensaje))) break;
            else if(error.length>0) System.out.print(error[0]);
            else System.out.println("Valor incorrecto");

        return valor;
    }

    static public char leerChar(String mensaje, Predicate<Character> v, String ... error)
    {
        char valor = '\0';

        while(true)
            if(v.test(valor=leerChar(mensaje))) break;
            else if(error.length>0) System.out.print(error[0]);
            else System.out.println("Valor incorrecto");

        return valor;
    }
}