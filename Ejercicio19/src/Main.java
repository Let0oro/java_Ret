import lib.in;

public class Main {
    public static void main(String[] args) {
        int quantity_dev, mon2, mon1, mon50c, mon20c, mon10c, mon5c, mon2c, mon1c;

        final int val_2 = 200;
        final int val_1 = 100;
        final int val_50c = 50;
        final int val_20c = 20;
        final int val_10c = 10;
        final int val_5c = 5;
        final int val_2c = 2;

        quantity_dev = (int) (100 * in.leerDouble("Cantidad a devolver (entre 0.00 y 4.99): "));

        mon2 = quantity_dev / val_2;
        quantity_dev = quantity_dev % val_2;
        System.out.println("Monedas de 2 euros: " + mon2);

        mon1 = quantity_dev / val_1;
        quantity_dev = quantity_dev % val_1;
        System.out.println("Monedas de 1 euro: " + mon1);

        mon50c = quantity_dev / val_50c;
        quantity_dev = quantity_dev % val_50c;
        System.out.println("Monedas de 50 céntimos: " + mon50c);

        mon20c = quantity_dev / val_20c;
        quantity_dev = quantity_dev % val_20c;
        System.out.println("Monedas de 20 céntimos: " + mon20c);

        mon10c = quantity_dev / val_10c;
        quantity_dev = quantity_dev % val_10c;
        System.out.println("Monedas de 10 céntimos: " + mon10c);

        mon5c = quantity_dev / val_5c;
        quantity_dev = quantity_dev % val_5c;
        System.out.println("Monedas de 5 céntimos: " + mon5c);

        mon2c = quantity_dev / val_2c;
        quantity_dev = quantity_dev % val_2c;
        System.out.println("Monedad de 2 céntimos: " + mon2c);

        System.out.println("Monedas de 1 céntimo: " + quantity_dev);
    }
}
