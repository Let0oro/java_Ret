package UserSys;

import BrawlStars.Brawler;

import static UserSys.SystemGame.brawlers;
import static UserSys.Utils.getString;

public class Guest extends User {
    public Guest(String name, String pass) {
        super(name, pass);
    }

    private static void combat()
    {
        if (brawlers.size() < 2) {
            java.lang.System.out.println("\nNo hay suficientes brawlers para combatir...\n");
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
            java.lang.System.out.println(b1);
            java.lang.System.out.println(b2);
            java.lang.System.out.println();
            b1.actionByType(b2);
            java.lang.System.out.println();
            b2.actionByType(b1);
        }
        else java.lang.System.out.println("Uno de los brawlers no se ha encontrado...");
        java.lang.System.out.println();
    }


    @Override
    public void actionByRole(int opt) {
        switch (opt)
        {
            case 1 -> viewAll();
            case 2 -> combat();
            default -> {
                SystemGame.exit = true;}
        }
    }

    @Override
    public void showOptionsByRole() {
        java.lang.System.out.println("""
1. Ver brawlers
2. Combatir
Otro. Salir
""");
    }

    @Override
    public String toString() {
        return getName() + ":Guest - " + getStatus();
    }
}
