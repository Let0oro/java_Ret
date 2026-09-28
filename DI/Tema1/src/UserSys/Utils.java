package UserSys;

import java.util.Scanner;

public class Utils {

    static Scanner sc = new Scanner(System.in);

    public static String getString(String msg)
    {
        System.out.print(msg + ": ");
        return sc.nextLine();
    }

    public static boolean getBool(String msg)
    {
        return !getString(msg + " [Y/n]").equalsIgnoreCase("n");
    }

    public static int getInt(String msg)
    {
        int option;
        System.out.print(msg + ": ");
        option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static int newOpt()
    {
        return newOpt("OPTION");
    }


    public static int newOpt(String msg)
    {
        return getInt(msg);
    }

}
