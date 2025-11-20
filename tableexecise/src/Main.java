import lib.in;

public class Main {
    static void main() {
        int h = in.leerInt("Introduce la altura: ", v -> v >= 2);
        int w = in.leerInt("Introduce la anchura: ", v -> v >= 2);
        String str = "";
        h+=3;
        w*=3;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (j == 0) {
                    if (i == 0) str+="┌";
                    else if (i == h-1) str+="└";
                    else if (i % 2 == 0) str+="│";
                    else str+="├";
                } else if (j == w-1) {
                    if (i == 0) str+="┐";
                    else if (i == h-1) str+="┘";
                    else if (i % 2 == 0) str+="│";
                    else str+="┤";
                } else {
                    if (i == h-1) str+= "─";
                    else if (i % 2 == 0) str+= "─";
                    else {
                        if (j % 2 == 0) str += "─";
                        else str+="│";
                    }
                };
            }
            str+="\n";
        }
        System.out.println(str);

    }
}