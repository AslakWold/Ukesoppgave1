package hjelpeklasser;

import java.util.*;
import java.util.function.Predicate;

public interface Beholder<T> extends Iterable<T> {
    boolean leggInn(T verdi);    //legger inn verdi i beholderen
    boolean inneholder(T verdi); //sjekker om den inneholder verdien
    boolean fjern(T verdi);      //fjerner verdi fra beholderen
    int antall();                //returnerer antallet i beholderen
    boolean tom();               //sjekker om beholderen er tom
    void nullstill();            //tømmer beholderen
    Iterator<T> iterator();      //returnerer en iterator

    default boolean fjernHvis(Predicate<? super T> p) {
        Objects.requireNonNull(p);

        boolean fjernet = false;
        for(Iterator<T> i = iterator(); i.hasNext();) {
            if(p.test(i.next())) {
                i.remove();
                fjernet = true;
            }
        }
        return fjernet;
    }
}   //Beholder
