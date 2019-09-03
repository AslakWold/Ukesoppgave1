package com.company;

import hjelpetabeller.Tabell;

import java.sql.SQLOutput;
import java.util.Arrays;

public class    program {

    public static void main(String[] args) {

/*      int[] a = Tabell.randPerm(20);
        for(int k : a) {
            System.out.print(k + " ");
        }

        int m = Tabell.maksMedMaximum(a);

        System.out.println("\nStørste verdi ligger på plass " + m);

        Tabell.skriv(a,5,11);
        System.out.println();
        Tabell.skriv(a);

        int[] b = null;

        System.out.println(Tabell.maximum(b, 10 ,6)); */

        int[] a = Tabell.randPerm(20);
        int[] b = Tabell.nestMaks(a);

        int m = b[0], nm = b[1];
        Tabell.skrivln(a);
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm); //dope, stemmer

        System.out.println(Arrays.toString(Tabell.sortering(a)));


        System.out.println(Arrays.toString(Tabell.nestMaks(a)));
    }
}
