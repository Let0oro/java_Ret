import jmb.Vec2D;
import jmb.cmd;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.*;
import static jmb.arrays.genTable2D;
import static jmb.auxMath.genRandomInt;
import static jmb.in.*;
import static jmb.tables.paintPrettyTableWAids;


public class Main {
    static void main(String[] args) {
        int[][] arr = table();
        gameloop(arr);
    }

    //region GAME LOOP & GAME LOGIC

    static void gameloop(final int[][] arr) {
        int turnsYet = 20;
        ArrayList<Vec2D> shootsFailed = new ArrayList<>();
        ArrayList<Vec2D> shootsSuccess = new ArrayList<>();
        while (turnsYet > 0) {
            boolean canPass = gameTurn(turnsYet, arr, shootsFailed, shootsSuccess);
            if (canPass) turnsYet--;
            genTablero(arr);
            dormir(1000);
            if (turnsYet > 0) cls();
        }
    }

    static boolean gameTurn(int turn, int[][] arr, ArrayList<Vec2D> fshoots, ArrayList<Vec2D> sshoots) {
        if (turn % 2 == 0) gameLogic(arr);

        Vec2D lastShoot = genRandomShoot(arr);

        if (getIsShooted(lastShoot, fshoots, sshoots)) return false;

        if (shoot(arr, lastShoot)) sshoots.add(lastShoot); else fshoots.add(lastShoot);
        return true;
    }


    static void gameLogic(int[][] arr) {
        boolean isV, coll;
        int sz;
        Vec2D pos;
        int[][] fragments;
        int tries = 10;
        do {
            isV = genIsV();
            sz = genSize();
            pos = genPos(arr, isV, sz);
            fragments = getFragmentsOfTable(arr, pos, sz, isV);
            coll = collide(fragments);
            tries--;
        } while (coll && tries > 0);
        if (tries > 0) addToTable(arr, sz, pos, isV);
    }

    //endregion


    //region GENERADORES

    static int[][] table() {
        return genTable2D(10, 10);
    }


    static void genTablero(int[][] table) {
        System.out.println(paintPrettyTableWAids(12, 12, (i, j) -> {
            if (i >= 11 || j >= 11 || i < 1 || j < 1) return cmd.color("0", cmd.BLUE);
            int num = table[i - 1][j - 1];
            String val = String.valueOf(num);
            int[] colors = {cmd.BLUE, cmd.GREEN, cmd.YELLOW, cmd.RED, cmd.MAGENTA};
            return cmd.color(val, colors[min(max(0, num), colors.length - 1)]);
        }));
    }

        //region RANDOM GENERATORS

    static Vec2D genRandomShoot(int[][] arr) {
        int l = arr.length - 1;
        int x = genRandomInt(0, l);
        int y = genRandomInt(0, l);
        Vec2D pos = new Vec2D(x, y);

        System.out.println("SHOOT: " + "(" + x + "," + y + ")");

        return pos;
    }

    static boolean getIsShooted(Vec2D pos, ArrayList<Vec2D> fshoots, ArrayList<Vec2D> sshoots){
        boolean shootDone = false;
        for (Vec2D p : fshoots) shootDone = shootDone || (p.x == pos.x && p.y == pos.y);
        for (Vec2D p : sshoots) shootDone = shootDone || (p.x == pos.x && p.y == pos.y);
        if (shootDone) System.out.println("Disparo ya realizado");
        return shootDone;
    }

    static boolean genIsV() {
        return random() < 0.5;
    }

    static int genSize() {
        return genRandomInt(1, 4);
    }

    static Vec2D genPos(int[][] arr, boolean isV, int sz) {
        int rows = arr.length;
        int cols = arr[0].length;

        int x = genRandomInt(0, isV ? cols - 1 : cols - sz);
        int y = genRandomInt(0, isV ? rows - sz : rows - 1);

        return new Vec2D(x, y);
    }

        //endregion



    //endregion


    //region OBTENER DATOS DE LA TABLA

    static int[][] getFragmentsOfTable(int[][] arr, Vec2D pos, int sz, boolean isV) {
        int h = isV ? sz : 1;
        int w = isV ? 1 : sz;
        int[][] fragments = genTable2D(h + 2, w + 2);
        for (int i = -1; i <= h; i++) {
            for (int j = -1; j <= w; j++) {
                int col = pos.x + j;
                int row = pos.y + i;
                if (col < 0 || col >= arr[0].length) continue;
                if (row < 0 || row >= arr.length) continue;
                fragments[i + 1][j + 1] = arr[row][col];
            }
        }
        return fragments;
    }

    static Vec2D[] getShipPositions(int[][] table, int x, int y, int num) {
        Vec2D[] positions = new Vec2D[num];

        if (num == 1) {
            positions[0] = new Vec2D(x, y);
            return positions;
        }

        boolean isV = (y + 1 < table.length && table[y + 1][x] == num)
                || (y - 1 >= 0 && table[y - 1][x] == num);

        int idx = 0;
        if (isV) {
            int start = y;
            while (start - 1 >= 0 && table[start - 1][x] == num) start--;
            int cur = start;
            while (cur < table.length && table[cur][x] == num)
                positions[idx++] = new Vec2D(x, cur++);
        } else {
            int start = x;
            while (start - 1 >= 0 && table[y][start - 1] == num) start--;
            int cur = start;
            while (cur < table[0].length && table[y][cur] == num)
                positions[idx++] = new Vec2D(cur++, y);
        }

        return positions;
    }




        //region CONTROL DE COLISIONES

    static boolean collide(int[][] fragments) {
        for (int[] frg : fragments)
            if (collideOne(frg)) return true;
        return false;
    }

    static boolean collideOne(int[] fragment) {
        for (int p : fragment)
            if (p != 0) return true;
        return false;
    }

        //endregion

    //endregion


    //region AÑADIR DATOS A LA TABLA

    static void addToTable(final int[][] table, int sz, Vec2D pos, boolean isV) {
        int[] fragment = new int[sz];
        Arrays.fill(fragment, sz);
        int x = pos.x;
        int y = pos.y;
        int leny = isV ? y + sz : y + 1;
        int lenx = isV ? x + 1 : x + sz;

        int idx = 0;
        for (int i = y; i < leny; i++)
            for (int j = x; j < lenx; j++)
                table[i][j] = fragment[idx++];
    }

    //endregion


    //region LÓGICA DISPAROS


    static boolean shoot(int[][] table, Vec2D shot) {
        int x = shot.x;
        int y = shot.y;
        int num = table[y][x];

        if (num == 0) return false;

        Vec2D[] toSink = getShipPositions(table, x, y, num);
        sinkShip(table, toSink);
        return true;
    }


        //region HUNDIR BARCO

    static void sinkShip(int[][] table, Vec2D[] positions) {
        for (Vec2D p : positions)
            table[p.y][p.x] = 0;
    }

        //endregion

    //endregion


    //region INPUT USUARIO

    static int getTamBarco() {
        return leerInt(
                "Escoge el tamaño del barco: [1](1x1) - [2](2x2) - [3](3x3) - [4](4x4)",
                v -> v >= 1 && v <= 4,
                "El tamaño ha de estar entre 1 y 4"
        );
    }

    static Vec2D getPosBarco() {
        int x = leerInt("Escoge la posición x: ");
        int y = leerInt("Escoge la posición y: ");
        return new Vec2D(x, y);
    }

    //endregion
}
