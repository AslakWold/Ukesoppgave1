package com.company;

import hjelpeklasser.Liste;
import hjelpeklasser.TabellListe;

public class Uke6 {

    public static void main(String[] args) {
        String[] s = {"Per", "null", null,  "Kari", "Ole", null, "Azra", null};
        Liste<String> liste = new TabellListe<>(s);
        System.out.println(liste.antall());
        System.out.println(liste.hent(3));
        System.out.println(liste.tom());
        System.out.println(liste.indeksTil("Ole"));
        System.out.println(liste.inneholder("null"));
        System.out.println();

        System.out.println(liste.toString());

    }
}
