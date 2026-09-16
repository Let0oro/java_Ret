package lib;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.function.Predicate;

public final class val {
    static public <T> boolean valido(T valor, Predicate<T> condicion){
        return condicion == null || condicion.test(valor);
    }

    static public <T> String valido(T valor, Predicate<T> condicion, String mensaje){
        return condicion==null?"":(condicion.test(valor)?"":mensaje);
    }

    @SuppressWarnings("unchecked")
    static public <T,R> boolean valido(T valor, Predicate<T> condicion, Predicate<R> componente){
        boolean valido = valido(valor,condicion);
        if(componente!=null) {
            if(valor instanceof Collection<?> c)
                for(Object elemento:c)
                    if(!valido((R) elemento,componente)){
                        valido = false;
                        break;
                    }
                    else if (valor.getClass().isArray())
                        for (int i = 0; i < Array.getLength(valor); i++)
                            if (!valido((R) Array.get(valor, i), componente)) {
                                valido = false;
                                break;
                            }
        }
        return valido;
    }

    @SuppressWarnings("unchecked")
    static public <T,R> String valido(T valor, Predicate<T> condicion, String mensaje, Predicate<R> componente, String mensajeComponente){
        String valido = valido(valor,condicion,mensaje);
        if(componente!=null) {
            if(valor instanceof Collection<?> c)
                for(Object elemento:c)
                    if(!valido((R) elemento,componente)){
                        valido = valido.isEmpty()?mensajeComponente:valido+"|"+mensajeComponente;
                        break;
                    }
                    else if (valor.getClass().isArray())
                        for (int i = 0; i < Array.getLength(valor); i++)
                            if (!valido((R) Array.get(valor, i), componente)) {
                                valido = valido.isEmpty()?mensajeComponente:valido+"|"+mensajeComponente;
                                break;
                            }
        }
        return valido;
    }

    @SuppressWarnings("unchecked")
    static public <T,R,S> boolean valido(T valor, Predicate<T> condicion, Predicate<R> componente, Predicate<S> clave){
        boolean valido = valido(valor,condicion);
        if(componente!=null) {
            if(valor instanceof Map<?,?> c) {
                for (Object elemento : c.values())
                    if (!valido((R) elemento, componente)) {
                        valido = false;
                        break;
                    }
                for (Object elemento : c.keySet())
                    if (!valido((S) elemento, clave)) {
                        valido = false;
                        break;
                    }
            }
        }
        return valido;
    }

    @SuppressWarnings("unchecked")
    static public <T,R,S> String valido(T valor, Predicate<T> condicion, String mensaje, Predicate<R> componente, String mensajeComponente, Predicate<S> clave, String mensajeClave){
        String valido = valido(valor,condicion,mensaje);
        if(componente!=null) {
            if(valor instanceof Map<?,?> c) {
                for (Object elemento : c.values())
                    if (!valido((R) elemento, componente)) {
                        valido = valido.isEmpty()?mensajeComponente:valido+"|"+mensajeComponente;
                        break;
                    }
                for (Object elemento : c.keySet())
                    if (!valido((S) elemento, clave)) {
                        valido = valido.isEmpty()?mensajeClave:valido+"|"+mensajeClave;
                        break;
                    }
            }
        }
        return valido;
    }

    static public <T,E extends RuntimeException> void validar(Function<String,E> error, T valor, Predicate<T> condicion, String mensaje){
        if(!valido(valor,condicion)){
            if(error==null) throw new IllegalArgumentException(mensaje);
            throw error.apply(mensaje);
        }
    }

    static public <T,R,E extends RuntimeException> void validar(Function<String,E> error,T valor, Predicate<T> condicion, String mensaje, Predicate<R> componente,String mensajeComponente){
        String s;
        if(!(s=valido(valor,condicion,mensaje,componente,mensajeComponente)).isEmpty()){
            if(error==null) throw new IllegalArgumentException(s);
            throw error.apply(s);
        }
    }

    static public <T,R,S,E extends RuntimeException> void validar(Function<String,E> error,T valor, Predicate<T> condicion, String mensaje, Predicate<R> componente, String mensajeComponente, Predicate<S> clave, String mensajeClave){
        String s;
        if(!(s=valido(valor,condicion,mensaje,componente,mensajeComponente,clave,mensajeClave)).isEmpty()){
            if(error==null) throw new IllegalArgumentException(mensaje);
            throw error.apply(mensaje);
        }
    }

    public record Regla<T>(T valor, Predicate<T> predicado, String mensaje){}

    public static String valido(Regla<?>... reglas) {
        StringJoiner sj = new StringJoiner("|");
        for (Regla<?> regla : reglas) {
            // Usamos un helper para poder testear el predicado con el valor genérico
            if (!evaluar(regla)) {
                sj.add(regla.mensaje);
            }
        }
        return sj.toString();
    }

    private static <T> boolean evaluar(Regla<T> regla) {
        return regla.predicado.test(regla.valor);
    }

    static public <E extends RuntimeException> void validar(Function<String,E> error, Regla<?>... reglas){
        String s;
        if(!(s=valido(reglas)).isEmpty()) {
            if(error==null) throw new IllegalArgumentException(s);
            throw error.apply(s);
        }
    }

    static public String valido(String ... mensajes){
        StringJoiner sj = new StringJoiner("|");
        for(String mensaje:mensajes)
            if(!mensaje.isEmpty())
                sj.add(mensaje);
        return sj.toString();
    }

    static public <E extends RuntimeException> void validar(Function<String,E> error, String ... mensajes){
        String s;
        if(!(s=valido(mensajes)).isEmpty()) {
            if(error==null) throw new IllegalArgumentException(s);
            throw error.apply(s);
        }
    }
}
