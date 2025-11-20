import static lib.in.dormir;
import static lib.in.leerInt;

public class Main
{
    static void main()
    {
        int tiempo = 0, h = 0, min = 0, seg = 0, pomodoro = leerInt("Establece el tiempo en segundos: ", v -> v >= 0);

        while (tiempo <= pomodoro) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            // \033[H moves the cursor to the top-left corner.
            // \033[2J clears the entire screen.

            System.out.printf("%02d:%02d:%02d\n", h, min, seg);
            tiempo++;
            seg += 1;

            if (seg == 60) {
                min += 1;
                seg = 0;
            }

            if (min == 60) {
                h += 1;
                min = 0;
            }

            if (tiempo % (60 * 60 * 24) == 0) h = min = seg = 0;

            dormir(1000);
        }

    }
}