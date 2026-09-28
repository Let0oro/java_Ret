package UserSys;

import BrawlStars.Epico;
import BrawlStars.Legendario;

import static UserSys.Utils.getInt;
import static UserSys.Utils.getString;

public class Admin extends User {

    public Admin(String name, String pass) {
        super(name, pass);
    }

    private static void createEpic()
    {
        String name = getString("Nombre");
        int health = getInt("Vida");
        int suply = getInt("Suministros");

        Epico epic = new Epico(name, health, suply);
        SystemGame.brawlers.add(epic);
        java.lang.System.out.println();
    }

    private static void createLegendary()
    {
        String name = getString("Nombre");
        int health = getInt("Vida");
        int damage = getInt("Daño");

        Legendario leg = new Legendario(name, health, damage);
        SystemGame.brawlers.add(leg);
        java.lang.System.out.println();
    }

    @Override
    public void actionByRole(int opt) {
        switch (opt) {
            case 1 -> viewAll();
            case 2 -> createLegendary();
            case 3 -> createEpic();
            default -> {
                SystemGame.exit = true;}
        }
    }

    @Override
    public void showOptionsByRole() {
        java.lang.System.out.println("""
1. Ver brawlers
2. Crear brawler legendario
3. Crear brawler épico
Otro. Salir
""");
    }

    @Override
    public String toString() {
        return getName() + ":Admin - " + getStatus();
    }
}
