package BrawlStars;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

    public static ArrayList<Brawler> brawlers;
    static Scanner sc;
    static int opt;
    static boolean exit = false;

    public static void main(String[] args) {
        brawlers = new ArrayList<>();
        sc = new Scanner(System.in);
        menu();
    }

    static void showOpts(){
        System.out.println("""
1. Ver brawlers
2. Crear brawler legendario
3. Crear brawler épico
4. Combatir
5. Salir
""");
    }

    static String getString(String msg)
    {
        System.out.print(msg + ": ");
        return sc.nextLine();
    }

    static int getInt(String msg)
    {
        int option;
        System.out.print(msg + ": ");
        option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    static void newOpt()
    {
        newOpt("OPTION");
    }


    static void newOpt(String msg)
    {
        opt = getInt(msg);
    }

    static void selectByOpt()
    {
        switch (opt)
        {
            case 1 -> viewAll();
            case 2 -> createLegendary();
            case 3 -> createEpic();
            case 4 -> combat();
            default -> {exit = true;}
        }
    }

    private static void combat()
    {
        if (brawlers.size() < 2) {
            System.out.println("\nNo hay suficientes brawlers para combatir...\n");
            return;
        }
        String brawler1 = getString("Nombre del brawler 1");
        String brawler2 = getString("Nombre del brawler 2");

        Brawler b1 = null, b2 = null;
        for (Brawler brawler : brawlers)
        {
            if (brawler.getName().equals(brawler1)) b1 = brawler;
            if (brawler.getName().equals(brawler2)) b2 = brawler;
        }
        if (b1 != null && b2 != null) {
            System.out.println(b1);
            System.out.println(b2);
            System.out.println();
            b1.actionByType(b2);
            System.out.println();
            b2.actionByType(b1);
        }
        else System.out.println("Uno de los brawlers no se ha encontrado...");
        System.out.println();
    }

    private static void createEpic()
    {
        String name = getString("Nombre");
        int health = getInt("Vida");
        int suply = getInt("Suministros");

        Epico epic = new Epico(name, health, suply);
        brawlers.add(epic);
        System.out.println();
    }

    private static void createLegendary()
    {
        String name = getString("Nombre");
        int health = getInt("Vida");
        int damage = getInt("Daño");

        Legendario leg = new Legendario(name, health, damage);
        brawlers.add(leg);
        System.out.println();
    }

    private static void viewAll()
    {
        System.out.println();
        if (brawlers.isEmpty())
        {
            System.out.println("No hay brawlers que mostrar...\n");
            return;
        }
        for (Brawler brawler : brawlers) System.out.println(brawler);
        System.out.println();
    }

//    static void sleep() throws InterruptedException
//    {
//        String msg = switch (opt)
//        {
//            case 2, 3 -> "Creando...";
//            case 1, 4 -> "Volviendo...";
//            default -> "Saliendo...";
//        };
//        System.out.println(msg + "\n");
//        Thread.sleep(1000);
//    }

    static void menu() {
        while (!exit)
        {
            showOpts();
            newOpt();
            selectByOpt();
        }
    }
}
