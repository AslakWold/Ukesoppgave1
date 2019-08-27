package hjelpetabeller;

import java.util.Arrays;
import java.util.Random;

public class Tabell {

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
        if(begin < 0 || end > values.length || begin >= end) {
            throw new IllegalArgumentException("Illegalt argument");
        }

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
}
