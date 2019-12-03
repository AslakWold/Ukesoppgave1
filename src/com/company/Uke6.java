package com.company;

import hjelpeklasser.Liste;
import hjelpeklasser.TabellListe;

public class Uke6 {

    public static void main(String[] args) {
        /*String[] s = {"Per", "null", null,  "Kari", "Ole", null, "Azra", null};
        Liste<String> liste = new TabellListe<>(s);
        System.out.println(liste.antall());
        System.out.println(liste.hent(3));
        System.out.println(liste.tom());
        System.out.println(liste.indeksTil("Ole"));
        System.out.println(liste.inneholder("null"));
        System.out.println();

        System.out.println(liste.toString());*/

        String[] snull = {"Per", "null", null,  "Kari", "Ole", null, "Azra", null};
        String[] s = {"Per", "null", "Kari", "Ole", "Azra"};
        TabellListe<String> t = new TabellListe<>(20);

        for(int i = 0; i < s.length; i++) {
            t.leggInn(s[i]);
        }
        System.out.println(t.toString());

        t.leggInn(2,"Jonas");
        System.out.println(t.toString());

        t.fjern(2);
        System.out.println(t.toString());

        t.oppdater(2, "Knut");
        System.out.println(t.toString());

        t.nullstill();
        System.out.println(t.toString());







    }
}
