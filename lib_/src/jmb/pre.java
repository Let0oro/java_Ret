package lib;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

final public class pre {
    static public <T> Predicate<T> distintoDe(T valor){return v->!v.equals(valor);}
    static public <T extends Comparable<? super T>> Predicate<T> min(T valor){return v->v.compareTo(valor)>=0;}
    static public <T extends Comparable<? super T>> Predicate<T> minExc(T valor){return v->v.compareTo(valor)>0;}
    static public <T extends Comparable<? super T>> Predicate<T> max(T valor){return v->v.compareTo(valor)<=0;}
    static public <T extends Comparable<? super T>> Predicate<T> maxExc(T valor){return v->v.compareTo(valor)<0;}
    static public <T extends Comparable<? super T>> Predicate<T> entre(T minimo,T maximo){return min(minimo).and(max(maximo));}
    static public <T extends Comparable<? super T>> Predicate<T> entreExc(T minimo,T maximo){return minExc(minimo).and(maxExc(maximo));}
    static public <T extends Comparable<? super T>> Predicate<T> entreDesExc(T minimo,T maximo){return minExc(minimo).and(max(maximo));}
    static public <T extends Comparable<? super T>> Predicate<T> entreHasExc(T minimo,T maximo){return min(minimo).and(maxExc(maximo));}

    @SafeVarargs
    static public <T> Predicate<T> in(T...valores){return v->{for (T val:valores) if(val.equals(v)) return true; return false;};}
    @SafeVarargs
    static public <T> Predicate<T> ninguno(T...valores){return in(valores).negate();}


    //RESTRICCIONES reales
    static public Predicate<Double> decimales(int numero){return v->new BigDecimal(v+"").scale()<=numero;}
    static public Predicate<Double> parteEntera(int numero){return v->String.valueOf(v.longValue()).length()<=numero;}
    static public Predicate<Double> digitos(int parteEntera, int decimales){return decimales(decimales).and(parteEntera(parteEntera));}

    //RESTRICCIONES de cadena
    static public Predicate<String> noVacia(){return v->!v.isEmpty();}
    static public Predicate<String> patron(String regular){return v->v.matches(regular);}
    static public Predicate<String> mayusculas(){return patron("[A-ZÑÁÉÍÓÚÜ]*");}
    static public Predicate<String> mayusculasTope(int min, int max){return patron("[A-ZÑÁÉÍÓÚÜ]{"+min+","+max+"}");}
    static public Predicate<String> mayusculasSinTilde(){return patron("[A-ZÑ]*");}
    static public Predicate<String> mayusculasSinTildeTope(int min, int max){return patron("[A-ZÑ]{"+min+","+max+"}");}
    static public Predicate<String> minusculas(){return patron("[a-zñáéíóúü]*");}
    static public Predicate<String> minusculasTope(int min, int max){return patron("[a-zñáéíóúü]{"+min+","+max+"}");}
    static public Predicate<String> minusculasSinTilde(){return patron("[a-zñ]*");}
    static public Predicate<String> minusculasSinTildeTope(int min, int max){return patron("[a-zñ]{"+min+","+max+"}");}
    static public Predicate<String> email(){return patron("[^.@A-ZÑÁÉÍÓÜñáéíóúü]+(\\.[^.@A-ZÑÁÉÍÓÜñáéíóúü]+)*@[^.@A-ZÑÁÉÍÓÜñáéíóúü]+\\.[a-z]{3}");}

    //RESTRICCIONES no nulo
    static public <T> Predicate<T> noNulo(){return Objects::nonNull;}

    //RESTRICCIONES DE TAMAÑO para cadenas, arrays, listas y mapas
    static public <T> Predicate<T> tamEntre(int min, int max) {
        return obj -> {
            if (obj == null) return false;

            // Para Cadenas de texto
            if (obj instanceof CharSequence s) return s.length()>=min && s.length()<=max;

            // Para Listas, Sets, etc.
            if (obj instanceof Collection<?> c) return c.size()>=min && c.size()<=max;

            // Para Mapas (opcional, según tu definición de "componente")
            if (obj instanceof Map<?, ?> m) return m.size()>=min && m.size()<=max;

            // Para Arrays (usa reflexión para soportar arrays de primitivos como int[] o double[])
            if (obj.getClass().isArray()) return Array.getLength(obj)>=min && Array.getLength(obj)<=max;

            return false;
        };
    }

    static public <T> Predicate<T> tam(int n){return tamEntre(n,n);}
    static public <T> Predicate<T> tamMin(int n){return tamEntre(n,Integer.MAX_VALUE);}
    static public <T> Predicate<T> tamMax(int n){return tamEntre(0,n);}
}
