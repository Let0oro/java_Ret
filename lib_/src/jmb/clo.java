package lib;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

public final class clo {
    public static <T> T deepClone(T obj) {
        return clonar(obj,true);
    }

    public static <T> T superficialClone(T obj) {
        return clonar(obj,false);
    }

    /**
     * Realiza una clonación superficial invocando al metodo clone() del objeto.
     * Si el objeto no es Cloneable, devuelve la referencia original.
     */
    @SuppressWarnings("unchecked")
    public static <T> T clonar(T obj, boolean profundo) {
        if (obj == null) return null;

        Class<?> clazz = obj.getClass();

        // 1. Manejo de Arrays (incluye multidimensionales)
        if (clazz.isArray()) {
            int length = Array.getLength(obj);
            Object copy = Array.newInstance(clazz.getComponentType(), length);
            if(profundo) for (int i = 0; i < length; i++)
                Array.set(copy, i, deepClone(Array.get(obj, i)));
            else for (int i = 0; i < length; i++)
                Array.set(copy, i, Array.get(obj, i));

            return (T) copy;
        }

        // 2. Manejo de Colecciones (List, Set, etc.)
        if (obj instanceof Collection) {
            try {
                Collection<Object> original = (Collection<Object>) obj;
                // Intentamos crear una instancia nueva del mismo tipo (ArrayList, HashSet, etc.)
                Collection<Object> copy = original.getClass().getDeclaredConstructor().newInstance();
                if(profundo) for (Object item : original)
                    copy.add(deepClone(item));
                else copy.addAll(original);

                return (T) copy;
            } catch (Exception e) {
                throw new RuntimeException("Error clonando colección", e);
            }
        }

        // 3. Manejo de Mapas
        if (obj instanceof Map) {
            try {
                Map<Object, Object> original = (Map<Object, Object>) obj;
                Map<Object, Object> copy = original.getClass().getDeclaredConstructor().newInstance();
                if(profundo) for (Map.Entry<Object, Object> entry : original.entrySet()) {
                    copy.put(deepClone(entry.getKey()), deepClone(entry.getValue()));
                }
                else copy.putAll(original);

                return (T) copy;
            } catch (Exception e) {
                throw new RuntimeException("Error clonando mapa", e);
            }
        }

        // 4. Manejo de objetos que implementan Cloneable
        if (obj instanceof Cloneable) {
            try {
                // Buscamos el metodo clone() y lo hacemos accesible si es necesario
                Method cloneMethod = clazz.getMethod("clone");
                return (T) cloneMethod.invoke(obj);
            } catch (NoSuchMethodException e) {
                // A veces Cloneable se implementa pero clone() sigue siendo protected
                try {
                    Method protectedClone = Object.class.getDeclaredMethod("clone");
                    protectedClone.setAccessible(true);
                    return (T) protectedClone.invoke(obj);
                } catch (Exception ex) {
                    return obj; // Si falla, devolvemos la referencia (fallback)
                }
            } catch (Exception e) {
                throw new RuntimeException("Error al invocar clone() via reflexión", e);
            }
        }

        // 5. Tipos inmutables o base (String, Integer, etc.)
        // No necesitan clonarse, se devuelve la referencia original
        return obj;
    }
}
