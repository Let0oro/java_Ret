package jmb;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.lang.System.out;
import static jmb.in.*;

public class menu<T> {

    public static class MenuItem<T> {
        private final String texto;
        private final Runnable accionNoArgs;
        private final Consumer<T> accionUno;
        private final BiConsumer<T, T> accionDos;
        private final Supplier<T> accionSupplier;
        private final Function<T, T> accionFunction;

        public MenuItem(String texto, Runnable accion) {
            this(texto, accion, null, null, null, null);
        }
        public MenuItem(String texto, Consumer<T> accion) {
            this(texto, null, accion, null, null, null);
        }
        public MenuItem(String texto, BiConsumer<T, T> accion) {
            this(texto, null, null, accion, null, null);
        }
        public MenuItem(String texto, Supplier<T> accion) {
            this(texto, null, null, null, accion, null);
        }
        public MenuItem(String texto, Function<T, T> accion) {
            this(texto, null, null, null, null, accion);
        }

        private MenuItem(String texto, Runnable r, Consumer<T> c1, BiConsumer<T,T> c2, Supplier<T> s, Function<T,T> f) {
            this.texto = texto; this.accionNoArgs = r; this.accionUno = c1;
            this.accionDos = c2; this.accionSupplier = s; this.accionFunction = f;
        }

        public void run(T datos) {
            if (accionNoArgs != null) accionNoArgs.run();
            else if (accionUno != null) accionUno.accept(datos);
            else if (accionDos != null) accionDos.accept(datos, datos);  // Usa datos dos veces si es BiConsumer<T,T>
            else if (accionSupplier != null) { T res = accionSupplier.get(); /* opc: datos.add(res); */ }
            else if (accionFunction != null) { T res = accionFunction.apply(datos); /* opc: datos = res; */ }
        }
    }

    private final String titulo;
    private final T datos;
    private final Map<Integer, MenuItem<T>> items = new LinkedHashMap<>();

    public menu(String titulo, T datos) {
        this.titulo = titulo;
        this.datos = datos;
    }

    public menu<T> add(int opcion, String texto, Runnable accion) {
        items.put(opcion, new MenuItem<>(texto, accion));
        return this;
    }

    public menu<T> add(int opcion, String texto, Consumer<T> accion) {
        items.put(opcion, new MenuItem<>(texto, accion));
        return this;
    }

    public menu<T> add(int opcion, String texto, BiConsumer<T, T> accion) {
        items.put(opcion, new MenuItem<>(texto, accion));
        return this;
    }

    public menu<T> add(int opcion, String texto, Supplier<T> accion) {
        items.put(opcion, new MenuItem<>(texto, accion));
        return this;
    }

    public menu<T> add(int opcion, String texto, Function<T, T> accion) {
        items.put(opcion, new MenuItem<>(texto, accion));
        return this;
    }

    public void loop() {
        while (true) {
            cls();
            out.println(titulo);
            out.println("====== ===============================");
            for (var e : items.entrySet()) {
                out.printf("%d %s%n", e.getKey(), e.getValue().texto);
            }
            out.println("otra Salir");
            int opcion = leerInt("OPCION: ");
            MenuItem<T> item = items.get(opcion);
            if (item == null) break;
            item.run(datos);
        }
    }
}
