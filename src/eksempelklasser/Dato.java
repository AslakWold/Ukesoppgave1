package eksempelklasser;

import java.util.Objects;

public class Dato implements Comparable<Dato> {

    private final int dag, mnd, år;

    public Dato(int dag, int mnd, int år) {
        this.dag = dag;
        this.mnd = mnd;
        this.år = år;
    }

    public Dato(int dag, Måned måned, int år) {
        this.dag = dag;
        mnd = måned.getMndnr();
        this.år = år;
    }

    public int compareTo(Dato d) {
        if(år < d.år) {return -1;}
        else if(år > d.år) {return 1;}
        else if (mnd < d.mnd) {return -1;}
        else if (mnd > d.mnd) {return 1;}
        else {return dag-d.dag;}
    }

    public boolean equals(Object o) {

        /**d) Metoden equals() i datoklassen er kodet ved hjelp av compareTo(). Lag egen kode for equals(). Pass
         *på at koden blir slik at x.equals(y) = y.equals(x) for alle datoer x og y. Pass også på at x.equals(y) = true
         * hvis og bare hvis x.compareTo(y) = 0.**/


        if(o == this) {return true;}
        if(!(o instanceof Dato)) {return false;}
        Dato d = (Dato) o;
        return år == d.år && mnd == d.mnd && dag == d.dag;
    }



    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dag).append('.').append(" ").append(Måned.toString(mnd)).append(" ").append(år);
        return sb.toString();
    }

    public int hashCode() {
        return Objects.hash(dag,mnd,år);
    }

}
