package jmb;

public class tables {

    @FunctionalInterface
    public interface Painter {
        String paint(int absRow, int absCol);
    }

    public static String paintPrettyTable(int height, int width, Painter userP){
        StringBuilder salida = new StringBuilder();

        int sizeTileW = 4;
        int sizeTileH = 2, firstContPosJ = 2;
        int firstContentPosI = 1;

        width = width * sizeTileW + 1;
        height = height * sizeTileH + 1;

        int boundW = width-1;
        int boundH = height-1;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (i == 0) {
                    if (j == 0) salida.append("┌");
                    else if (j == boundW) salida.append("┐");
                    else if (j % sizeTileW == 0) salida.append("┬");
                    else salida.append("─");

                } else if (i == boundH) {
                    if (j == 0) salida.append("└");
                    else if (j == boundW) salida.append("┘");
                    else if (j % sizeTileW == 0) salida.append("┴");
                    else salida.append("─");

                } else if (i % sizeTileH == 0) {
                    if (j == 0) salida.append("├");
                    else if (j == boundW) salida.append("┤");
                    else if (j % sizeTileW == 0) salida.append("┼");
                    else salida.append("─");

                } else {
                    if (j % sizeTileW == 0) salida.append("│");
                    else if (j % sizeTileW == firstContPosJ) {

                        // ----- Conversions -----
                        int absCol = (j - firstContPosJ) / sizeTileW;
                        int absRow = (i - firstContentPosI) / sizeTileH;
                        // --- End Conversions ---
                        salida.append(userP.paint(absRow, absCol));
                    }
                    else salida.append(" ");
                }
            }

            salida.append("\n");
        }
        return String.valueOf(salida);
    }
}

