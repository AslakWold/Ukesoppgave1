package hjelpeklasser;

import java.util.*;

public class TabellListe<T> implements Liste<T> {
    private T[] a;
    private int antall;



     @SuppressWarnings("unchecked")     //pga. konvertering: Object[] -> T[]
    public TabellListe(int størrelse) { //konstruktør
         a = (T[]) new Object[størrelse];       //Oppretter tabellen
         antall = 0;                            //foreløpig ingen verdier
    }

    public TabellListe() {              //Standardkonstruktør
        this(10);              //Startstørrelse på 10
    }

    public TabellListe(T[] b) {        //en T-tabell som parameter
        this(b.length);                //Kaller den andre konstruktøren
        for (T verdi : b) {
            if (verdi != null) {
                a[antall++] = verdi;       //hopper over null-verdier
            }
        }
    }

    public int antall() {
        return antall;         //returnerer antallet
    }

    public boolean tom() {
        return antall == 0;        //listen er tom hvis antall er 0
    }

    @Override
    public void nullstill() {
        if(a.length > 10) {
            a = (T[]) new Object[10];
        } else {
            for(int i = 0; i < antall; i++) {
                a[i] = null;
            }
        }
        antall = 0;
    }


    public T hent(int indeks) {
        indeksKontroll(indeks, false);     //false: indeks = antall er ulovlig
        return a[indeks];                          //returnerer tabellelement
    }

    public int indeksTil(T verdi) {
        for(int i = 0; i < antall; i++) {
            if(a[i].equals(verdi)) { return i; }  //funnet!
        }
        return -1;     //ikke funnet!
    }

    @Override
    public T oppdater(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "null er ulovlig!");
        indeksKontroll(indeks, false); //false: indeks = antall er ulovlig

        T gammelverdi = a[indeks];  //tar vare på den gamle verdien
        a[indeks] = verdi;      //oppdaterer
        return gammelverdi;     //returnerer gammelverdi
    }

    @Override
    public boolean fjern(T verdi) {
         Objects.requireNonNull(verdi, "null er ulovlig");

         int indeks = 0;

         for(int i = 0; i < antall; i++) {
            if(a[i].equals(verdi)) {
                antall--;
                System.arraycopy(a,i + 1,a, i, antall - i);

                a[antall] = null;

                return true;
            }

         }

         return false;
    }

    @Override
    public T fjern(int indeks) {
        indeksKontroll(indeks, false); //false: indeks = antall er ulovlig
        T verdi = a[indeks];

        antall--;   //sletter ved å flytte verdier mot venstre
        System.arraycopy(a, indeks + 1,a, indeks, antall - indeks);
        a[antall] = null;   //tilrettelegger for søppeltømming

        return verdi;
    }

    @Override
    public boolean leggInn(T verdi) {   //legger inn bakerst
        Objects.requireNonNull(verdi, "null er ulovlig!");

        if(antall == a.length) {    //en full tabell utvides med 50%
            a = Arrays.copyOf(a, (3*antall)/2 + 1);
        }

        a[antall++] = verdi;        //setter inn ny verdi
        return true;                //vellykket innlegging
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi,"null er ulovlig!");
        indeksKontroll(indeks, true);   //true: indeks = antall er lovlig

        //en full tabell utvides med 50%
        if(antall == a.length) {
            a = Arrays.copyOf(a, (3*antall)/2 + 1);
        }

        //rydder plass til den nye verdien
        System.arraycopy(a,indeks,a,indeks+1, antall -indeks);

        a[indeks++] = verdi;
        antall++;
    }

    public boolean inneholder(T verdi) {
         return indeksTil(verdi) != -1;
     }

    public String toString() {
       if(antall == 0) {return "[]";}
       StringJoiner sj = new StringJoiner(", ","[", "]");

       for(int i = 0; i < antall; i++) {
           sj.add(a[i].toString());
       }
       return sj.toString();
    }

    private class TabellListeIterator implements Iterator<T> {
         private int denne = 0; //instansevariabel
         private boolean fjernOK = false;
         public boolean hasNext() { //sjekker om det er flere igjen  i listen
             return denne < antall; //sjekker verdien til denne
         }

         public T next() {
             if(!hasNext()) {
                 throw new NoSuchElementException("Tom eller ingen verdi!");
             }
             T denneVerdi = a[denne];   //henter aktuell verdi
             denne++;
             fjernOK = true;

             return denneVerdi;

         }

         public void remove() {
             if(!fjernOK) {
                 throw new IllegalStateException("Ulovlig tilstand!");
             }
             fjernOK = false;   //remove() kan ikke kalles på nytt

             //verdien i denne-1 skal fjernes da ble returnert i siste kall
             //på next(), verdiene fra og med denne flyttes derfor en plass mot venstre
             antall--;      //en verdi blir fjernet
             denne--;       //denne må flyttes til venstre

             System.arraycopy(a, denne + 1, a, denne, antall-denne);
             a[antall] = null;  //verdien som lå lengst til høyre nulles;
         }


    }

    @Override
    public Iterator<T> iterator() {
         return new TabellListeIterator();
    }
}
