package hjelpetabeller;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Random;

public class Tabell { //samleklasse for metodene fra program/målingAvTidsforbruk

    private Tabell() {}; //privat standardkonstruktør - hindrer instansiering

    //Metoden bytt(int[] values, int i, int j)
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
    //Metoden randPerm(int n)
    public static int[] randPerm(int n) {   //En effektiv versjon
        Random r = new Random(); //en random-generator
        int[] a = new int[n];   //en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1); //legger inn tallene 1,2,3....,n

        for (int k = n - 1; k > 0; k--) { //løkke som går n-1 ganger
            int i = r.nextInt(k + 1); //en tilfeldig tall fra 0 til k
            bytt(a, k, i);                //bytter om
        }
        return a;

    }
    //Metoden randPerm(int[] a)
    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }



    //Metoden maks(int[] values, int begin, int end)
    public static int maximum(int[] values, int begin, int end) {
        arrayTest(values);
        fraTilKontroll(values.length, begin, end);
        int indeks = begin;
        int maksverdi = values[begin];

        for(int i = begin + 1; i < end; i++) {
            if(maksverdi < values[i]) {
                indeks = i;
                maksverdi = values[indeks];
            }
        }
        return indeks;
    }

    //Metoden maks(int[] values)
    public static int maksMedMaximum(int[] values) {
        return maximum(values, 0, values.length);
    }

    //min-metodene - se oppgave 1 avsnitt 1.2.1

    public static int minimum(int[] values, int begin, int end) {
        if(begin < 0 || end > values.length || begin >= end) {
            throw new IllegalArgumentException("Illegalt argument");
        }

        int indeks = begin; //indeks til største/minste verdi fra [begin, end>
        int minimumsverdi = values[begin];  //største/minste verdi i [begin, end>

        for(int i = begin+1; i < end; i++) {
            if(minimumsverdi > values[i]) {
                indeks = i;     //indeks til minste verdi oppdateres
                minimumsverdi = values[indeks]; // minste verdi oppdateres
            }
        }
        return indeks;
    }

    public static int minimum1(int[] values) {
        return minimum(values, 2,5);
    }

    public static void bytt(char[] c, int i, int j) {
        char temp = c[i]; c[i] = c[j]; c[j] = temp;
    }

    public static void skriv(int[] a, int fra, int til) {
        String space = "";
        for(int i = fra; i < til; i++) {
            System.out.print(space + a[i]);
            space = " ";
        }
    }

    public static void skriv(int[] a) {
        String space = "";
        for(int i = 0; i < a.length; i++) {
            System.out.print(space + a[i]);
            space = " ";
        }
    }

    public static void skrivln(int[] a, int fra, int til) {
        String space = "";
        for(int i = fra; i < til; i++) {
            System.out.print(space + a[i]);
            space = " ";
        }
        System.out.println();
    }

    public static void skrivln(int[] a) {
        String space = "";
        for(int i = 0; i < a.length; i++) {
            System.out.print(space + a[i]);
            space = " ";

        }
        System.out.println();

    }

    public static void fraTilKontroll(int tablengde, int fra, int til) {
        if (fra < 0) {
            throw new ArrayIndexOutOfBoundsException("Fra(" + til + ") er negativ!");
        }

        if(til > tablengde) {
            throw new ArrayIndexOutOfBoundsException("Til(" + til + ") > tablengde(" +tablengde+ ")");
        }

        if(fra > til) {
            throw new IllegalArgumentException("Fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }
    }

    public static void vhKontroll(int tablengde, int v, int h) {
        if(v < 0) {
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");
        }

        if(h >= tablengde) {
            throw new ArrayIndexOutOfBoundsException("h(" + h + ") >= tablengde(" + tablengde +")");
        }

        if( v > h + 1) {
            throw new IllegalArgumentException("v = " + v + ", h = " + h);
        }
    }

    public static void arrayTest(int[] a) {
        if(a == null) {
            throw new NullPointerException("Arrayet er ikke definert");
        }

        if(a.length == 0) {
            throw new InvalidParameterException("Arrayet har ikke lengde > 0");
        }
    }

    public static int[] nestMaks(int[] a) { // ny versjon av nestmaks
        int n = a.length; // tabellens lengde
        if(n < 2) {
            throw new java.util.NoSuchElementException("a.length (" + n + ") < 2!");
        }

        int sist = a.length - 1;
        int m = 0; //Indeks til største verdi
        int nm = sist; // indeks til nest største verdi

        if(a[sist] > a[0]) {
            m = sist;
            nm = 0;
        }

        int maksverdi = a[m]; // største verdi
        int nestmaksverdi = a[nm]; // neststørste verdi


        int temp = a[sist];
        a[sist] = 0x7fffffff;

        for(int i = 1; ; i++) {
            if(a[i] > nestmaksverdi) {

                if(i == sist) {
                    a[sist] = temp; //legger siste verdi tilbake
                    int[] b = {m, nm};
                    return b;
                }
                if(a[i] > maksverdi) {
                    nm = m;
                    nestmaksverdi = maksverdi; // ny nest største verdi

                    m = i;
                    maksverdi = a[m]; // ny største verdi
                }
                else {
                    nm = i;
                    nestmaksverdi = a[nm]; // ny nest størst verdi
                }
            } // if
        } // for
    }

    /*
    public static int[] nestMaks(int[] a) {
        int n = a.length;

        if( n < 2) throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maksMedMaximum(a); //m er posisjonen til tabellens største verdi

        int nm; // nm skal inneholde posisjonen til nest største verdi

        if(m == 0) {
            nm = maximum(a,1, n); // den største ligger bakerst
        }
        else if(m == n - 1) {
            nm = maximum(a, 0 , n - 1); // leter i a[0:n-1>
        }
        else {
            int mv = maximum(a, 0, m); //leter i a[0:m>
            int mh = maximum(a, m +1, n); // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv; // hvem er størst?
        }

        return new int[] {m, nm};
    } */

    //versjon av nestMaks der den største havner forrest:

    public static int[] nestMaksForrest(int[] a) {
        if(a.length < 2) {
            throw new IllegalArgumentException("a.length(" + a.length + ") < 2!");
        }

        int m = Tabell.maksMedMaximum(a); // m er posisjonen til tabellens største verdi

        Tabell.bytt(a, 0, m); //bytter om så den største kommer først

        int k = Tabell.maximum(a, 1, a.length);

        if(k == m) {
            k = 0; // den nest største lå opprinnelig forrest
        }

        Tabell.bytt(a, 0, m);

        return new int[] {m, k};
    } // nestMaksForrest

    public static int[] nestMaksBakerst(int[] a) {
        if(a.length < 2) {
            throw new IllegalArgumentException("a.length(" + a.length + ") < 2!");
        }

        int m = Tabell.maksMedMaximum(a); // m er posisjonen til tabellens største verdi

        Tabell.bytt(a, a.length-1, m); // bytter om slik at den største verdien havner bakerst

        int k = Tabell.maximum(a, 0, a.length -1);

        if(k == m) {
            k = a.length - 1; // den nest største lå opprinnelig bakerst
        }

        Tabell.bytt(a, a.length - 1, m);

        return new int[] {m, k};
    }

    public static int[] sortering(int[] a) {
        for(int i = a.length; i > 1; i--) {
            int m = Tabell.maximum(a, 0, i);
            Tabell.bytt(a,i-1,m);
        }
        return a;
    }
}

