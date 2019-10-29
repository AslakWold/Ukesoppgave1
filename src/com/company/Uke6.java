package com.company;

import hjelpeklasser.Liste;
import hjelpeklasser.TabellListe;

public class Uke6 {

    public static void main(String[] args) {
        String[] s = {"Per", "null", null,  "Kari", "Ole", null, "Azra", null};
        Liste<String> liste = new TabellListe<>(s);
        System.out.println("Hello");

    }
}
