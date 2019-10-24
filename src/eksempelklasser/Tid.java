package eksempelklasser;

import java.util.Objects;

public class Tid implements Comparable<Tid> {

    private Dato dato;
    private Klokkeslett klokkeslett;

    public Tid(int dag, int mnd, int år, String klokkeslett) {
        dato = new Dato(dag,mnd,år);
        this.klokkeslett = new Klokkeslett(klokkeslett);
    }

    public Tid(Dato dato, Klokkeslett klokkeslett) {
        this.dato = dato;
        this.klokkeslett = klokkeslett;
    }

    public int compareTo(Tid t) {
        int cmp = dato.compareTo(t.dato);
        if(cmp != 0) {
            return cmp;
        }
        return klokkeslett.compareTo(t.klokkeslett);
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } if (!(o instanceof Tid)) {
            return false;
        }
        return equals((Tid) o);
    }

    public boolean equals(Tid t) {
        return klokkeslett.equals(t.klokkeslett) && dato.equals(t.dato);
    }

    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + dato.hashCode();
        hash = 97 * hash + klokkeslett.hashCode();
        return hash;
    }

    public String toString() {
        return dato + "kl. " + klokkeslett;
    }
}
