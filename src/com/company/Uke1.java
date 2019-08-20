package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Uke1 {

    public static void main(String[] args) {
	    /*System.out.println("Hallo algdat!");
        int[] tabell = {14,3,2,1,17,0};
        System.out.println("Indeksen til det minste tallet er: " + Arrays.toString(minmax(tabell)));
        Scanner ip = new Scanner(System.in);
        System.out.println("Skriv in et heltall: ");
        int heltall = ip.nextInt();
       // int fakultetDuØnsker = 5;
        System.out.println("Summen av fakulteten til tallet er: " + fak(heltall));
*/
	    int[] values = {1};
	    int[] verdier = {};
        System.out.println("Resultat med ett tall" + (maks(values)));
        System.out.println("Resultat med ett tall" + (maks(verdier)));
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

    public static int maks(int[] a) {       //siste versjon av maksmetoden
        int sist = a.length -1;             //siste posisjon i tabellen
        int m = 0;                          //indeks til største verdi i tabellen
        int maksverdi = a[0];               //største verdi
        int temp = a[sist];                 //tar vare på siste verdi
        a[sist] = 0x7fffffff;               //legger tallet 2147483647 sist

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
