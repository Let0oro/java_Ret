package jmb;

import java.util.Comparator;
import java.util.function.BiPredicate;

public class sorter<T> {

    private final Comparator<T>[] comparators;

    @SafeVarargs
    public sorter(Comparator<T>... comparators) {
        this.comparators = comparators;
    }

    public void sort(T[] array) {
        java.util.Arrays.sort(array, this::compare);
    }

    private int compare(T a, T b) {
        for (Comparator<T> comp : comparators) {
            int res = comp.compare(a, b);
            if (res != 0) return res;
        }
        return 0;
    }

    public static <T> Comparator<T> priorityPredicate(BiPredicate<T,T> pred) {
        return (a, b) -> pred.test(a, b) ? -1 : (pred.test(b, a) ? 1 : 0);
    }

}
