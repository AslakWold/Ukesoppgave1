package com.company;

import hjelpetabeller.Tabell;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class Uke3 {

    public static void main(String[] args) {

        /**
         * a.Seksjon 1.3.1: oppgave 1, 2, 3
         * b.Seksjon 1.3.2: oppgave 1
         * c.Seksjon 1.3.4: oppgave 1, 3, 5, 9, 10, 11
         * d.Seksjon 1.3.5: oppgave 2, 3, 5
         * e.Seksjon 1.3.6: oppgave 3, 4
         * f.Seksjon 1.3.8: oppgave 3, 4, 5, 6, 7, 8
         */
        //1.3.1 2)
        //sjekker bare at alle tall stemmer (permuterte for hånd først
        //int[] a = {3,8,10,12,14,16,21,24,27,30,32,33,34,37,40};

        //long tid = System.currentTimeMillis();
        //System.out.println(Tabell.lineærsøk(a, 11));
        //System.out.println(Tabell.bakvendtLineærsøk(a, 40));
       // System.out.println(Tabell.hopplengdeLineærsøk(a, 3, 21));


        //tid = System.currentTimeMillis() - tid;
        //System.out.println(tid);

    /*    int[] b = {1, 3, 4, 4, 5, 7, 7, 7, 7, 8, 9, 10, 10, 12, 15, 15, 15};
        System.out.println(Tabell.binærsøk(b,15));
        //Jeg er en idiot og har kjørt versjon 3 hele tiden

        long tid = System.currentTimeMillis();
        Tabell.innsettingssortering(b,);
        tid = System.currentTimeMillis() - tid;
        System.out.println(tid);*/
        //long tid = System.currentTimeMillis();
        //utvalgsortering(b);
        //tid ~ 3500ms
        //Tabell.utvalgssortering(b);
        //tid ~ 1500 ms
        //tid = System.currentTimeMillis() - tid;
        //System.out.println(tid);

        //utvalgssortering1(a, 2, 6);
        //utvalgssortering2(a, 2, 6);
        //System.out.println(Arrays.toString(a));

        /*Tabell.nestePermutasjon(a);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        Tabell.boblesortering(b);
        System.out.println(Arrays.toString(b));
        */
        //utvalgssortering(a);

        //System.out.println(Arrays.toString(b));
        //utvalgssortering(b);

        //Tabell.utvalgssortering(b);
        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(b));

        double s  = 1/3;
        double t = 1/4;
        System.out.println(GCD(s,t));
        lcm((int) s, (int) t);

        float bitch = (1/3)*(1/4);
        System.out.println(bitch);

    }

    public static void utvalgssortering(int[] a) {

        for(int i = 0; i < a.length - 1; i++) {
            int minsteverdi = a[i];
            int minsteindeks = i;

            for(int j = i + 1; j < a.length; j++) {
                if(a[j] < minsteverdi) {
                    minsteverdi = a[j];
                    minsteindeks = j;
                }
            }
            int temp = a[i];
            a[i] = a[minsteindeks];
            a[minsteindeks] = temp;

        }
    }

    public static void utvalgssortering1(int[] a, int fra, int til) {
        if(til > a.length || fra < 0) {
            throw new InvalidParameterException("Indeksene dine er ikke lovlige");
        }
        if(fra > til) {
            throw new IllegalArgumentException("Du har mikset opp fra og til");
        }

        for(int i = fra; i < til - 1; i++) {
            int minsteverdi = a[i];
            int minsteindeks = i;

            for(int j = i+1; j < til; j++) {
                if(a[j] < minsteverdi) {
                    minsteverdi = a[j];
                    minsteindeks = j;
                }
            }

            int temp = a[i];
            a[i] = a[minsteindeks];
            a[minsteindeks] = temp;
        }
    }

    public static void utvalgssortering2(int[] a, int fra, int til) {
        Tabell.fraTilKontroll(a.length, fra, til);

        for(int i = fra; i < til - 1; i++) {
            Tabell.bytt(a, i, Tabell.minimum(a,i,til));
        }
    }

    public static double GCD(double a, double b)
    {
        while (a != 0 && b != 0)
        {
            if (a > b)
                a %= b;
            else
                b %= a;
        }

        return a == 0 ? b : a;
    }

    public static int lcm(double a, double b) {
        double lcm = (a*b)/ GCD(a,b);
        return (int) lcm;
    }

}
