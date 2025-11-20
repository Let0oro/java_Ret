class Main {
    public static void main() {

        System.out.println("Escribe las filas y las columnas");
        int alto = 5;
        int ancho = 5;

        int medio = alto/2;
        System.out.println("Cálculo de la mitad de medida: " + medio);
        for (int i = -1; i < alto; i++) {
            if (i == -1) {
                System.out.print("     ");
                for (int j = 0; j < ancho; j++) {
                    System.out.print(j + " ");
                }
                System.out.print("\n"); // Índice de cada columna
                continue; // saltamos a la siguiente para que no se confundan los índices
            }

            System.out.printf("%d -> ", i); // Índice de cada fila

            for (int j = 0; j < ancho; j++) {
                if (i == medio || j == medio) System.out.print("* "); // alto = medida
                else System.out.print(". ");
            }

            System.out.print("\n"); // Salto de linea al final de cada línea
        }
    }
}