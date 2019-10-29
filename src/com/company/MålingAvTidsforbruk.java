package com.company;

import java.util.Arrays;
import java.util.Random;

public class MålingAvTidsforbruk {

    public static void main(String[] args) {

        int n = 100_000, antall = 2_000; // tabellstørrelse og gjentagelser
        long tid = 0;
        int[] a = randPerm(n);

        tid = System.currentTimeMillis();   //leser av klokken
        for(int i = 0; i < antall; i++) {
            kostnader(a);
        }
        tid = System.currentTimeMillis() - tid; //medgått tid
        System.out.println("Faste kostnader: " + tid + " millisek");

        tid = System.currentTimeMillis();   //leser av klokken
        for(int i = 0; i < antall; i++) {
            maks1(a);   //programkode 1.1.2
        }
        tid = System.currentTimeMillis() - tid; //medgått tid
        System.out.println("Maks1-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();   //leser av klokken
        for(int i = 0; i < antall; i++) {
            maks2(a);
        }
        tid = System.currentTimeMillis() - tid; //medgått tid
        System.out.println("Maks2-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();   //leser av klokken
        for(int i = 0; i < antall; i++) {
            maks3(a);
        }
        tid = System.currentTimeMillis() - tid; //medgått tid
        System.out.println("Maks3-metoden: " + tid + " millisek");
    }


    public static int kostnader(int[] a) {
        int m = 0;
        for(int i = 1; i < a.length; i++) {} //en tom blokk
        return m;
    }
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static int[] randPerm(int n) {   //En effektiv versjon
        Random r = new Random(); //en random-generator
        int[] a = new int[n];   //en tabell med plass til n tall

        Arrays.setAll(a, i -> i+1); //legger inn tallene 1,2,3....,n

        for(int k = n - 1;k > 0; k--) { //løkke som går n-1 ganger
            int i = r.nextInt(k+1); //en tilfeldig tall fra 0 til k
            bytt(a,k,i);                //bytter om
        }
        return a;                       //permutasjon returneres
    }

    public static int antallMaks(int[] a) {     //teller opp i a
        int antall = 0;         //antall tall
        int maksverdi = a[0];

        for(int i = 1; i < a.length; i++) {     //går gjennom tabellen a
            if(a[i] > maksverdi) {
                antall++;               //har funnet et nytt tall
                maksverdi = a[i];       //oppdaterer maksverdi
            }
        }
        return antall;                  //de som er stlrre en det største foran
    }

    public static int maks1(int[] a) {
        if(a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen er tom");
        }

        int m = 0; //Indeksen til det foreløpig minste tallet

        for(int i = 1; i < a.length; i++) {     //obs: starter med i = 1
            if(a[i] > a[m]) { //finner ut om tallet neste tallet i rekka er mindre
                m = i;              //setter indeksen til det nye minste tallets indeks
            }
        }
        return m;
    }

    public static int maks2(int[] a) {  //versjon 2 av maksmetoden
        int m = 0;                      //indeks til største verdi
        int maksverdi = a[0];           //største verdi

        for(int i = 1; i < a.length; i++) {
            if(a[i] > maksverdi) {
                maksverdi = a[i];       //største verdi oppdateres
                m = i;                  //indeks til største verdi oppdateres
            }
        }
        return m;                       //returnerer indeks/posisjonen til største verdi
    }

    public static int maks3(int[] a) { //versjon 3 av maksmetoden
        int sist = a.length - 1;       //siste posisjon i tabellen
        int m = 0;                     //indeksen til største verdi
        int maksverdi = a[0];           //største verdi
        int temp = a[sist];             //tar vare på siste verdi
        a[sist] = 0x7fffffff;           //legger tallet 2147483647 sist

        for(int i = 0; ; i++) {             //i starter med 0
            if(a[i] >=maksverdi) {          //denne blir sann til slutt
                if(i == sist) {             // sjekker om vi er ferdige
                    a[sist] = temp;         // legger siste verdi tilbake
                    return temp >=maksverdi ? sist : m; //er siste størst?
                }
                else {
                    maksverdi = a[i];       //maksverdi oppdateres
                    m = i;                  //m oppdateres
                }
            }
        }
    } //maks


}

