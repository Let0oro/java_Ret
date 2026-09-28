package BrawlStars;

import UserSys.SystemGame;
import UserSys.Admin;
import UserSys.Guest;
import UserSys.User;

import static UserSys.Utils.*;
import static java.lang.System.out;

public class Main
{
    static int opt;
    static int userOpt;
    static boolean exit = false;
    static User usr;
    static SystemGame system;

    static void createUser(){
        createUser("No existen administradores, escoja un nombre, nuevo admin", true);
    }

    static void setUsr(User now, boolean isFirst) {
        boolean wantToChange = false;
        if (!isFirst) wantToChange = getBool("Quieres cambiar a este usuario?");
        if (wantToChange || isFirst) {
            if (usr != null) usr.logout();
            usr = now;
            usr.login();
        };
    }

    static void createUser(String msg, boolean isAdmin) {
        if (isAdmin && SystemGame.adminExits()) {
            out.println("No se puede crear otro usuario administrador, antes elimina el actual");
            return;
        }
        String name = getString(msg);
        String pass, surePass;
        boolean isFirst = SystemGame.sessions.isEmpty();
        User now;
        do {
            pass = getString("New password");
            surePass = getString("Write new password again to confirm");
            if (!pass.equals(surePass)) out.println("Try again...");
        } while(!pass.equals(surePass));
        try {
            if (isAdmin) now = new Admin(name, pass);
            else now = new Guest(name, pass);
            system = now.getSession();
            setUsr(now, isFirst);
        } catch (IllegalAccessError e) {
            out.println(e.getMessage());
        }
    }

    static void changeUser() {
        changeUser(false);
    }

    static void changeUser(boolean showMsgLogin){
        User other = null;
        if (showMsgLogin) out.println("Se ha cerrado su sesión, ha de iniciar sesión de nuevo");
        String name = getString("Nombre de usuario");
        for (User us : SystemGame.sessions) if (us.getName().equalsIgnoreCase(name)) {
            if (usr != null) usr.logout();
            other = us;
        };
        if (other == null) {
            out.println("No se encuentra el usuario...");
            if (showMsgLogin) changeUser(true);
            return;
        }
        String pass = "";
        int times;
        for (times = 3; times > 0; times--) {
            pass = getString("Contraseña");
            if (other.isValidPass(pass)) {
                setUsr(other, false);
                break;
            }
            else out.println("Contraseña incorrecta, intentos restantes: " + times);
        }
        if (times == 0) {
            out.println("Tres intentos incorrectos, saliendo del sistema por seguridad...");
            exit = true;
        };
    }

    static void firstUser() {
        createUser();
    }

    static void showOptions(){
        out.println("""
1. Ver usuarios
2. Crear usuario admin
3. Crear usuario guest
4. Cerrar sesión
5. Cambiar de usuario
6. Eliminar usuario actual (si es admin, se creeará otro)
7. Acciones de usuario
Otro. Salir
""");
    }

    static void removeUser() {
        boolean admin = usr.getClass().equals(Admin.class);
        if (SystemGame.sessions.isEmpty()) {
            out.println("No hay más usuarios, no se puede eliminar el actual");
            return;
        }
        out.println("Usuario " + usr.getName() + " eliminado...");
        usr.remove();
        if (admin) createUser();
    }

    public static void main(String[] args) {
        if (SystemGame.brawlers.isEmpty()) firstUser();
        menuUser();
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

    static void selectByOptUser(){
        switch (userOpt) {
            case 1 -> system.viewAll();
            case 2 -> createUser("Nombre de administrador", true);
            case 3 -> createUser("Nombre de invitado", false);
            case 4 -> usr.logout();
            case 5 -> changeUser();
            case 6 -> removeUser();
            case 7 -> menu();
            default -> {exit = true;}
        }
        if (SystemGame.allSessionInactive()) changeUser(true);
    }

    static void menu() {
        while (!SystemGame.exit)
        {
            if (usr == null) {
                out.println("Ha habido un problema al seleccionar su usuario, por favor, vuelva a iniciar sesión");
                changeUser(true);
                return;
            }
            out.println("Ha iniciado sesión como " + usr.getName());
            out.println("--- MENU DE USUARIO ---");
            usr.showOptionsByRole();
            opt = newOpt();
            usr.actionByRole(opt);

        }
    }

    static void menuUser() {
        while (!exit)
        {
            SystemGame.exit = false;
            out.println();
            if (usr != null) out.println("Ha iniciado sesión como " + usr.getName());
            out.println("--- MENU DE SISTEMA ---");
            showOptions();
            userOpt = newOpt();
            selectByOptUser();
        }
    }

}
