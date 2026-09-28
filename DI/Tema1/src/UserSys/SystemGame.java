package UserSys;

import BrawlStars.Brawler;

import java.util.ArrayList;

import static java.lang.System.*;


public class SystemGame {

    public static final ArrayList<User> sessions = new ArrayList<User>();
    public static final int MAX_SESSIONS = 5;
    public static final ArrayList<Brawler> brawlers = new ArrayList<>();
    public static boolean exit = false;

    public SystemGame(User usr) {
        if ((sessions.size() <= MAX_SESSIONS && adminExits()) || !adminExits())
            SystemGame.sessions.add(usr);
        else
            throw new IllegalArgumentException("No se pueden añadir más de 5 usuarios ni más de un Admin");
    }

    public static void endSession(User user){
        if (!SystemGame.sessions.contains(user))
            throw new IllegalArgumentException("No existe el usuario " + user.toString());
        user.logout();
    }

    public static void endOtherSessions(User user) {
        for (User usr : sessions) if (!usr.equals(user)) usr.logout();
    }

    public static boolean allSessionInactive() {
        for (User usr : sessions) if (usr.getStatus() == User.Status.Active) return false;
        return true;
    }

    public static void removeUser(User user){
        if (!SystemGame.sessions.contains(user))
            throw new IllegalArgumentException("No existe el usuario " + user.toString());
        SystemGame.sessions.remove(user);
    }

    public static int typeCount(String userClass) {
        int count = 0;
        for (User us : sessions) if (us.getClass().equals(userClass)) count++;
        return count;
    }


    public static boolean adminExits() {
        for (User usr : SystemGame.sessions) if (usr.getClass().equals(Admin.class)) return true;
        return false;
    }

    public void viewAll(){
        out.println();
        if (sessions.isEmpty())
        {
            out.println("No hay usuarios...\n");
            return;
        }
        for (User user : sessions) out.println(user);
        out.println();
    }

}
