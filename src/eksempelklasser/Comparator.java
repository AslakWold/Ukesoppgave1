package eksempelklasser;

@FunctionalInterface
public interface Comparator<T> { //et funksjonsgrensesnitt
    int compare(T x, T y); //en abstrakt metode

    public static <T extends Comparable<? super T>> Comparator<T> naturligOrden() {
        return (x,y) -> x.compareTo(y);
    }

    public static <T extends Comparable<? super T>> Comparator<T> omvendtOrden() {
        return (x,y) -> y.compareTo(x);
    }

    public static <T, R extends Comparable<? super R>>
    Comparator<T> orden(Funksjon<? super T, ? extends R> velger) {
        return (x,y) -> velger.anvend(x).compareTo(velger.anvend(y));
    }

    public static <T, R extends Comparable<? super R>>
    Comparator<T> omvendtOrden(Funksjon<? super T, ? extends R> velger) {
        return (x,y) -> velger.anvend(y).compareTo(velger.anvend(x));
    }

    public static <T, R> Comparator<T> orden
            (Funksjon<? super T, ? extends R> velger, Comparator<? super R> c) {
        return (x,y) -> c.compare(velger.anvend(x), velger.anvend(y));
    }

    default Comparator<T> deretter(Comparator<? super T> c) {
        return (x,y) ->
        {
            int k = compare(x,y);
            return k != 0 ? k : c.compare(x,y);
        };
    }

    default <R> Comparator<T>
    deretter(Funksjon<? super T, ? extends R> velger, Comparator<? super R> c) {
        return (x,y) ->
        {
            int k = compare(x,y);
            return k != 0 ? k : c.compare(velger.anvend(x), velger.anvend(y));
        };
    }

    default Comparator<T> omvendt() {
        return (x,y) -> compare(y,x); //bytter x og y
    }


} //Komparator
