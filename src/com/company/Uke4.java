package com.company;

import eksempelklasser.*;
import hjelpetabeller.Tabell;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**Kapitell 1.4;
 a.
 Seksjon 1.4.1: oppgave 1, 2, 3, 4, 5, 6
 b.
 Seksjon 1.4.2: oppgave 1, 2
 c.
 Seksjon 1.4.3: oppgave 2, 5, 6, 7, 8
 d.
 Seksjon 1.4.4: oppgave 1, 2
 e.
 Seksjon 1.4.5: oppgave 1, 2, 3, 4, 5
 f.
 Seksjon 1.4.6: oppgave 1, 2, 3, 4, 5, 7
 g.
 Seksjon 1.4.7: oppgave 1, 2, 3, 4, 5
 h.
 Seksjon 1.4.8: oppgave 1, 2, 4
 i.
 Seksjon 1.4.9: oppgave 1, 2, 3, 4, 5, 6
 **/

public class Uke4 {

    public static void main(String[] args) {

        /*double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        String[] s = {"Aslak", "Benjamin", "Jacob", "Edvard", "Eirik", "Simen", "Oskar", "Torbjørn"};
        char[] c = "ASLAK".toCharArray();
        */
        /*Integer[] a = {5,2,7,3,9,1,8,4,6};
        Integer[] b = {2,9,3,4,7,8,6,5,1};*/

       /* String[] s = {"Karianne"};
        String[] t = {"Kari"};

        System.out.println(s[0].compareTo(t[0]));
        System.out.println(Boolean.compare(false, true));*/

       /* String[] s = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        int k = Tabell.maks(s);        // hvilken maks-metode?
        System.out.println(s[k]);      // Utskrift:  Thanh*/

       /* String[] s = {"Per","Kari","Ole","Anne","Ali","Eva"};
        Tabell.innsettingssortering(s);
        System.out.println(Arrays.toString(s));  // [Ali, Anne, Eva, Kari, Ole, Per]*/

       /* int k = Tabell.maks(d);
        int l = Tabell.maks(s);
        int m = Tabell.maks(c);
       */
       /*int n = Tabell.maks(a);
       int o = Tabell.maks(b);
        System.out.println(a[0].compareTo(b[1]));
        System.out.println(a[n] + " " + b[o]);*/
        //System.out.println(d[k] + " " + s[l] + " " + c[m] + " " + a[n]);

        /*Integer[] a = Tabell.randPermInteger(20);
        System.out.println(Arrays.toString(a));


        Tabell.innsettingssortering(a);
        System.out.println(Arrays.toString(a));

        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        Double[] e = new Double[d.length];
        // Utskrift: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        for(int i = 0; i < e.length; i++) {
            e[i] = d[i];
        }
        Tabell.innsettingssortering(e);
        System.out.println(Arrays.toString(e));*/

      /*  int[] a = {5,2,7,3,9,1,8,10,4,6};          // en int-tabell
        Heltall[] h = new Heltall[a.length];       // en Heltall-tabell

        for (int i = 0; i < h.length; i++) h[i] = new Heltall(a[i]);
        Tabell.innsettingssortering(h);           // generisk sortering
        System.out.println(Arrays.toString(h));   // utskrift

        Heltall x = new Heltall(3), y = new Heltall(3);  // x og y er like
        System.out.println(x.compareTo(y) + "  " + x.equals(y));


        System.out.println(x.hashCode() + "  " + y.hashCode());*/

       /* Person[] p = new Person[7];                   // en persontabell

        p[0] = new Person("Kari","Svendsen");         // Kari Svendsen
        p[1] = new Person("Boris","Zukanovic");       // Boris Zukanovic
        p[2] = new Person("Ali","Kahn");              // Ali Kahn
        p[3] = new Person("Azra","Zukanovic");        // Azra Zukanovic
        p[4] = new Person("Kari","Pettersen");        // Kari Pettersen
        p[5] = new Person("Aslak", "Wold");           // Aslak Wold
        p[6] = new Person("Eirik", "Wold");           // Eirik Wold

        int m = Tabell.maks(p);                       // posisjonen til den største
        System.out.println(p[m] + " er størst");      // skriver ut den største

        //Tabell.innsettingssortering(p);               // generisk sortering
        Arrays.sort(p);                                 // Arrays sort
        System.out.println(Arrays.toString(p));       // skriver ut sortert

        Stream s = Arrays.stream(p);
        Optional<Person> resultat = s.max(Comparator.naturalOrder());
        resultat.ifPresent(System.out::println);
        Arrays.stream(p).max(Comparator.naturalOrder()).ifPresent(System.out::println)*/

        for (Studium s : Studium.values())
        {
            System.out.println(s.toString() + " (" + s.name() + ")");
        }

        for(Måned m : Måned.values()) {
            System.out.println(m.toString() + " (" + m.name() + ")");
        }

        Student[] s = new Student[7];  // en Studenttabell

        s[0] = new Student("Kari", "Svendsen", Studium.Data);    // Kari Svendsen
        s[1] = new Student("Boris", "Zukanovic", Studium.IT);    // Boris Zukanovic
        s[2] = new Student("Ali", "Kahn", Studium.Anvendt);      // Ali Kahn
        s[3] = new Student("Azra", "Zukanovic", Studium.IT);     // Azra Zukanovic
        s[4] = new Student("Kari", "Pettersen", Studium.Data);   // Kari Pettersen
        s[5] = new Student("Torbjørn", "Bratvold", Studium.Elektro); // Torbjørn Bratvold
        s[6] = new Student("Jonas", "Lium", Studium.Elektro);    // Jonas Lium

        Tabell.innsettingssortering(s);                     // Programkode 1.4.2 e)
        for (Student t : s) System.out.println(t);



    }

}
