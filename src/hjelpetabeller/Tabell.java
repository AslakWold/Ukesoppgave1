package hjelpetabeller;

import eksempelklasser.Comparator;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.NoSuchElementException;
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

    public static int[] nestMaks(int[] a) // ny versjon
    {
        int n = a.length;     // tabellens lengde
        if (n < 2) throw      // må ha minst to verdier
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = 0;      // m er posisjonen til største verdi
        int nm = 1;     // nm er posisjonen til nest største verdi

        // bytter om m og nm hvis a[1] er større enn a[0]
        if (a[1] > a[0]) { m = 1; nm = 0; }

        int maksverdi = a[m];                // største verdi
        int nestmaksverdi = a[nm];           // nest største verdi

        for (int i = 2; i < n; i++)
        {
            if (a[i] > nestmaksverdi)
            {
                if (a[i] > maksverdi)
                {
                    nm = m;
                    nestmaksverdi = maksverdi;     // ny nest størst

                    m = i;
                    maksverdi = a[m];              // ny størst
                }
                else
                {
                    nm = i;
                    nestmaksverdi = a[nm];         // ny nest størst
                }
            }
        } // for

        return new int[] {m,nm};    // n i posisjon 0, nm i posisjon 1

    } // nestMaks

    public static int[] nestMaksTurnering(int[] a) {
        int n = a.length;       //for å forenkle notasjonen

        if(n < 2) {
            throw new IllegalArgumentException("a.length(" + n + ") < 2!");
        }

        int[] b = new int[2*n];         //turneringstreet
        System.arraycopy(a,0,b,n,n);

        for(int k = 2*n-2; k > 1; k -= 2) {      //lager turneringstreet
            b[k/2] = Math.max(b[k], b[k+1]);
        }

        System.out.println((Arrays.toString(b)));

        int maksverdi = b[1], nestmaksverdi = Integer.MIN_VALUE;

        for(int m = 2*n - 1, k = 2; k < m; k *= 2) {
            int tempverdi = b[k+1];         //ok hvis maksverdi er b[k]
            if(maksverdi != b[k]) {
                tempverdi = b[k];
                k++;
            }
            if(tempverdi > nestmaksverdi) {
                nestmaksverdi = tempverdi;
            }
        }
        return new int[] {maksverdi, nestmaksverdi};        //størst og neststørst
    } //nestMaksTurnering


    /*public static int[] nestMaks(int[] a) { // ny versjon av nestmaks
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
    } //nestMaks */

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

    public static void kopier(int[] a, int i, int[] b, int j, int ant) {
        for(int n = i + ant; i < n; ) {
            b[j++] = a[i++];
        }
    }

    public static void snu(int[] a, int v, int h) { //snur intervallet a[v:h]
        while (v < h) {
            bytt(a, v++, h--);
        }
    }

    public static void snu(int[] a, int v) { //snu fra og med v og ut tabellen
        snu(a, v ,a.length - 1);
    }

    public static void snu(int[] a) { //snur hele tabellen
        snu(a, 0, a.length - 1);
    }

    public static boolean nestePermutasjon(int[] a) {
        int i = a.length - 2; // i starter nest bakerst
        while(i >= 0 && a[i] > a[i + 1]) { // går mot venstre
            i--;
        }
        if(i < 0) { //a = {n, n-1, ...., 2, 1}
            return false;
        }

        int j = a.length - 1; // j starter bakerst
        while(a[j] < a[i]) { //stopper nå¨r a[j] > a[i]
            j--;
        }
        bytt(a, i, j); //bytter
        snu(a, i + 1);//snur

        return true; // en ny permutasjon
    }

    public static void boblesortering(int[] a) {
        for(int n = a.length; n > 1;) {
            int byttindeks = 0;
            for (int i = 1; i < n; i++) {
                if (a[i - 1] > a[i]) {
                    bytt(a,i-1, i);
                    byttindeks = i;
                }
            }
            n = byttindeks;
        }
    }

    public static void utvalgssortering(int[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            bytt(a, i, minimum(a, i, a.length));
        }
    }

    public static int lineærsøk(int[] a, int verdi) {
        if(a.length == 0 ||  verdi > a[a.length - 1]) {
            return -(a.length + 1);     //verdi er større enn den største
        }

        int i = 0; for( ; a[i] < verdi; i++); //siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1); //sjekker innholdet i a[i];

    }

    public static int bakvendtLineærsøk(int[] a, int verdi) {
        if(a.length == 0 ||  verdi > a[a.length - 1]) {
            return -(a.length + 1);     //verdi er større enn den største
        }

        int i = a.length - 1; for( ; a[i] > verdi; i--); //siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1); //sjekker innholdet i a[i];

    }

    public static int hopplengdeLineærsøk(int[] a, int hopplengde, int verdi) {
        if(a.length == 0 || verdi > a[a.length - 1]) {
            return -(a.length + 1);
        }
        if(hopplengde < 1) {
            throw new IllegalArgumentException("Må ha k > 0!");
        }
        int j = hopplengde - 1;
        for(; j < a.length && verdi > a[j]; j += hopplengde);

        int i = j - hopplengde + 1; //søker i a[j-k+1:j]
        for(; i < a.length && verdi > a[i]; i++);

        if(i < a.length && a[i] == verdi) {
            return i;
        } else {
            return -(i + 1);
        }
    }

    public static int kvadratrotsøk(int[] a, int verdi) {
        return hopplengdeLineærsøk(a,(int) Math.sqrt(a.length), verdi);
    }

    /*public static int binærsøk(int[] a, int fra, int til, int verdi) {
        fraTilKontroll(a.length, fra, til);
        int v = fra; int h = til-1; // v og h er intervallets endepunkter

        while(v <= h) { //fortsetter så lenge som a[v:h] ikke er tom
            int m = (v + h) / 2;
            int midtverdi = a[m];

            if (verdi == midtverdi) {
                return m; //funnet
            } else if(verdi > midtverdi) {
                v = m + 1; // verdi i a[m+1:h]
            } else {
                h = m - 1; // verdi i a[v:m-1]
            }
        }
        return -(v + 1); // ikke funnet, v er relativt insettingspunkt
    } */

    public static int binærsøk(int[] a, int verdi) { // søker i hele a
        return binærsøk(a,0,a.length,verdi);
    }

    public static int binærsøk(int[] a, int fra, int til, int verdi) {
        fraTilKontroll(a.length, fra, til);
        int v = fra, h = til - 1; // v og h er intervallets endepunkter

        while(v < h) { // obs. må ha v < h her og ikke v <= h

            int m = (v + h) / 2; // heltallsdivisjon - finner midten

            if (verdi > a[m]) {
                v = m + 1; // verdi må ligge i a[m+1:h]
            } else {
                h = m;      //verdi må ligge i a[v:m]
            }
        }
        if( h < v || verdi < a[v]) {
            return -(v + 1);        //ikke funnet
        } else if(verdi == a[v]) {
            return v; //funnet
        } else {
            return -(v + 2); // ikke funnet
        }

    }

    public static void innsettingssortering(int[] a, int fra, int til) {
        for(int i = fra; i < til; i++) {
            int temp = a[i]; //hjelpevariabel
            int j = i - 1; for(;  j >= 0 && temp < a[j]; j--) {
                a[j+1]= a[j];
            }
            a[j+1]= temp;
        }
    }

    public static int maks(double[] a) {
        int m = 0;  //indeks til startverdi
        double maksverdi = a[0]; // foreløpig største verdi

        for(int i = 1; i < a.length; i++) {
            if(a[i] > maksverdi) { // hvis tallet på i'te posisjon er større enn nåværende maksverdi
                m = i; //ny indeks for maks
                maksverdi = a[i]; // ny maksverdi
            }
        }
        return m; //returner posisjonen til største verdi
    }

    /*public static int maks(String[] a) {
        int m = 0; // indeks til største verdi
        String maksverdi = a[0]; //største verdi

        for(int i = 1; i < a.length; i++) {
            if(a[i].compareToIgnoreCase(maksverdi) > 0) { //Hvis strengen i posisjon a[i] er "større" dvs. lenger bak i alfabetet
                maksverdi = a[i]; // ny største verdi
                m = i; //ny indeks til største verdi
             }
        }
        return m; // returnerer posisjonen til største verdi
    }*/

    public static int maks(char[] a) {
        int m = 0;
        char maksverdi = a[0];

        for(int i = 0; i < a.length; i++) {
            if(a[i] > maksverdi) { //Her tar den verdier fra ASCII (tallverdier for bokstaver)
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static int maks(Integer[] a) {
        int m = 0;
        Integer maksverdi = a[0];

        for(int i = 1; i < a.length; i++) {
            if(a[i].compareTo(maksverdi) > 0) {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static <T extends Comparable<? super T>> int maks(T[] a) {
        int m = 0;
        T maksverdi = a[0];

        for(int i = 0; i < a.length; i++) {
            if(a[i].compareTo(maksverdi) > 0) {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a) {
        for(int i = 1; i < a.length; i++) {
            T verdi = a[i];         //verdi er et tabellelement
            int j = i - 1;          //j er en indeks

            // sammenligner og forskyver:
            for(; j >= 0 && verdi.compareTo(a[j]) < 0; j--) {
                a[j+1] = a[j];
            }
            a[j + 1] = verdi;
        }
    }

    public static void skriv(Object[] a, int fra, int til) {
        String space = "";
        for(int i = fra; i < til; i++) {
            System.out.print(space + a[i]);
            space = " ";
        }
    }

    public static void skriv(Object[] a) {
        String space = "";
        for(int i = 0; i < a.length; i++) {
            System.out.print(space + a[i]);
            space = " ";
        }
    }

    public static void skrivln(Object[] a, int fra, int til) {
        String space = "";

        for(int i = fra; i < til; i++) {
            System.out.print(space + a[i]);
            space = " ";
        }
        System.out.println();
    }

    public static void skrivln(Object[] a) {
        String space = "";
        for(int i = 0; i < a.length; i++) {
            System.out.print(space + a[i]);
            space = " ";
        }
        System.out.println();
    }
    public static void bytt(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static Integer[] randPermInteger(int n) {
        Integer[]a = new Integer[n];        //en Integer-tabell
        Arrays.setAll(a, i -> i + 1);       //tallene fra 1 til n

        Random r  = new Random();       //hentes fra java.util

        for(int k = n - 1; k > 0; k--) {
            int i = r.nextInt(k+1);     //tilfeldig tall far [0,k]
            bytt(a,k,i);
        }
        return a;       //tabellen med permutasjonen returneres
    }

    public static <T> void innsettingssortering(T[] a, Comparator<? super T> c) {
        for(int i = 1; i < a.length; i++) { //starter med i = 1
            T verdi = a[i];     //verdi er et tabellelement
            int j = i - 1;      //j er en indeks

            //sammenligner og forskyver:
            for( ; j >= 0 && c.compare(verdi, a[j]) < 0; j--) {
                a[j+1] = a[j];
            }
            a[j+1] = verdi;     //j + 1 er rett sortert plass
        }
    }

    public static <T> int maks(T[] a, Comparator<? super T> c) {
        return maks(a, 0, a.length, c); //kaller metoden under
    }

    public static <T> int maks(T[] a, int fra, int til, Comparator<? super T> c) {
        fraTilKontroll(a.length, fra, til);

        if(fra == til) {
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall");
        }

        T maksverdi = a[fra];   //Største verdi
        int m = fra;            //indeks til største verdi

        for(int i = fra + 1; i < til; i++) {
            if(c.compare(a[i],maksverdi) > 0)  {
                maksverdi = a[i];   //største verdi oppdateres
                m = i;              //indeks til største verdi oppdateres
            }
        }
        return m;
    }

}

