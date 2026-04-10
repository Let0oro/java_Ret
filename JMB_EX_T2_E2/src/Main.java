import jmb.in;
import static jmb.tables.paintPrettyTable;

public class Main {
    static void main(String[] args) {
        int size = in.leerInt("Proporcione el alto de la tabla: ", v -> v >= 2 && v%2!=0);

        String table = paintPrettyTable(size, size, (i, j) -> {
            if (j == size-1-i || j == i) return "*";
            else return " ";
        });
        System.out.println(table);
    }

}

