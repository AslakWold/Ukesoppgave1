package com.company;

import java.util.Arrays;

public class Ukesoppgaveruke2 {
    public static void main(String[] args) {
        int[] array = {1, 7 , 6 ,8, 13};

        System.out.println(minimum1(array,1,3));

        char[] tegn = {'A', 'B', 'C', 'D', 'E'};

        char[] tegn2 = Arrays.copyOfRange(tegn,1,3);

        for(char i : tegn2) {
            System.out.println(i);
        }

    }
    public static int maximum(int[] value, int begin, int end) {
        if(begin < 0 || end > value.length) {
            throw new IllegalArgumentException("Illegalt argument");
        }
        else if(begin == end) {
            throw new IllegalArgumentException("Dette blir ikke et intervall.");
        }

        int indeks = begin; //indeks i største verdi for intervall value[begin, end>
        int maksverdi = value[begin];   //største verdi i value[begin, end>

        for(int i = begin+1; i < end; i++) {
            if(maksverdi < value[i]) {
                indeks = i;
                maksverdi = value[indeks];
            }
        }
        return indeks;

    }

    public static int minimum1(int[] value, int begin, int end) {
        if(begin < 0 || begin > end || begin >= end || end > value.length) {
            throw new IllegalArgumentException("Illegalt argument");
        }

        int indeks = begin;
        int minimumsverdi = value[begin];

        for(int i = begin+1; i < value.length; i++) {
            if(minimumsverdi > value[i]) {
                indeks = i;
                minimumsverdi = value[indeks];
            }
        }
        return indeks;
    }

}
