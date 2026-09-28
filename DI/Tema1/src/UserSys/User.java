package UserSys;

import BrawlStars.Brawler;

import java.util.Objects;

public abstract class User {

    public enum Status {
        Active,
        Inactive
    }

    private SystemGame session = null;
    private String name = "Unknown";
    private String pass;
    private Status status = Status.Inactive;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
        if (this.getSession() == null) this.session = new SystemGame(this);
    }

    public String getName() {
        return name;
    }

    public SystemGame getSession() {
        return session;
    }

    public Status getStatus() {
        return status;
    }

    public abstract void actionByRole(int opt);

    public abstract void showOptionsByRole();

    public void logout(){ status = Status.Inactive; }
    public void remove(){
        SystemGame.removeUser(this);
    }
    public void login(){ status = Status.Active; }

    public boolean isValidPass(String pass) {
        return this.pass.equals(pass);
    }

    private void changePass(String old, String newp) {
        if (!isValidPass(old)) throw new IllegalArgumentException("Incorrect password");
        this.pass = newp;
    }

    public static void viewAll()
    {
        java.lang.System.out.println();
        if (SystemGame.brawlers.isEmpty())
        {
            java.lang.System.out.println("No hay brawlers que mostrar...\n");
            return;
        }
        for (Brawler brawler : SystemGame.brawlers) java.lang.System.out.println(brawler);
        java.lang.System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
