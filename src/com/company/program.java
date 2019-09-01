package com.company;

import hjelpetabeller.Tabell;

public class program {

    public static void main(String[] args) {

        int[] a = Tabell.randPerm(20);
        for(int k : a) {
            System.out.print(k + " ");
        }

        int m = Tabell.maksMedMaximum(a);

        System.out.println("\nStørste verdi ligger på plass " + m);

        Tabell.skriv(a,5,11);
        System.out.println();
        Tabell.skriv(a);

        int[] b = null;

        System.out.println(Tabell.maximum(b, 10 ,6));
    }
}
