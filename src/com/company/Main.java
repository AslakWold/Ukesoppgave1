package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Hallo algdat!");
        int[] tabell = {14,3,2,1,17,0};
        System.out.println("Indeksen til det minste tallet er: " + Arrays.toString(minmax(tabell)));
        Scanner ip = new Scanner(System.in);
        System.out.println("Skriv in et heltall: ");
        int heltall = ip.nextInt();
        int fakultetDuØnsker = 5;
        System.out.println("Summen av fakulteten til tallet er: " + fak(heltall));


    }

    //1.1.2 deloppgave 2
    //metode som finner indeksen til det minste tallet i et array
    public static int min(int[] min) {
        if(min.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen er tom");
        }

        int m = 0; //Indeksen til det foreløpig minste tallet

        for(int i = 1; i < min.length; i++) {
            if(min[i] < min[m]) { //finner ut om tallet neste tallet i rekka er mindre
                m = i;              //setter indeksen til det nye minste tallets indeks
            }
        }
        return m;
    }

    //1.1.3 oppgave 5
    public static int[] minmax(int[] tall) {
        if(tall.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen er tom");
        }

        int min = 0; //Indeksen til det foreløpig minste tallet
        int max = 0;
        int[] b = new int[2];


        for(int i = 1; i < tall.length; i++) {
            if(tall[i] < tall[min]) { //finner ut om tallet neste tallet i rekka er mindre
                min = i;            //setter indeksen til det nye minste tallets indeks
                b[0] = min;
            }
            if(tall[i] > tall[max]) { //finner ut om det neste tallet i rekka er større
                max = i; //Setter indeksen til det største tallets indeks
                b[1] = max;
            }

        }
        return b;
    }

    public static long fak(int n) {

        int sum = 1;

        while (n > 0) {

            sum *= n;
            n--;
        }
        return sum;
    }

}
