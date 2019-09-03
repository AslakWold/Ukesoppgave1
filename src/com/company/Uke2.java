package com.company;

public class Uke2 {

    public static void main(String[] args) {
        int[] array = {14, 2, 4,9,21,15};

        System.out.println(minimum(array,3,5    ));
        System.out.println(minimum1(array));
    }

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
