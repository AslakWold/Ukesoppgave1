package com.company;

import eksempelklasser.*;
import hjelpetabeller.Tabell;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

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

       /* for (Studium s : Studium.values())
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
        for (Student t : s) System.out.println(t);*/

        /*Person[] p = new Person[5];                   // en persontabell

        p[0] = new Person("Kari","Svendsen");         // Kari Svendsen
        p[1] = new Person("Boris","Zukanovic");       // Boris Zukanovic
        p[2] = new Person("Ali","Kahn");              // Ali Kahn
        p[3] = new Person("Azra","Zukanovic");        // Azra Zukanovic
        p[4] = new Person("Kari","Pettersen");        // Kari Pettersen

        *//*class FornavnKomparator implements Komparator<Person> {
            public int compare(Person p1, Person p2) {      //to personer
                return p1.fornavn().compareTo(p2.fornavn());  //Sammenligner fornavn
            }
        }

        //Komparator<Person> c = new FornavnKomparator();     //en Instans av klassen
        *//* //Gammeldags teknikk ^

        *//*Komparator<Person> c = (p1,p2) -> p1.fornavn().compareTo(p2.fornavn());
        Tabell.innsettingssortering(p, c);
        *//* //Moderne teknikk ^, men kan også sette lampa inn som argument i metoden =>

        Tabell.innsettingssortering(p, (p1, p2) -> p1.fornavn().compareTo(p2.fornavn()));


        System.out.println(Arrays.toString(p)); */

       /* Student[] s = new Student[6];                             // en studenttabell
        s[0] = new Student("Kari","Svendsen", Studium.Data);      // Kari Svendsen
        s[1] = new Student("Boris","Zukanovic", Studium.IT);      // Boris Zukanovic
        s[2] = new Student("Ali","Kahn", Studium.Anvendt);        // Ali Kahn
        s[3] = new Student("Azra","Zukanovic", Studium.IT);       // Azra Zukanovic
        s[4] = new Student("Kari","Pettersen", Studium.Data);     // Kari Pettersen
        s[5] = new Student("Kari", "Hansen", Studium.Data);       // Kari Hansen
        *//*Tabell.innsettingssortering(s, (s1,s2) -> s1.studium().compareTo(s2.studium()));
        System.out.println(Arrays.toString(s));*//*

        //Fra kompendiet
        Komparator<Student> c = (s1,s2) -> {
            int cmp = s1.studium().name().compareTo(s2.studium().name());
            return cmp != 0 ? cmp : s1.compareTo(s2);
        };

        Tabell.innsettingssortering(s, c);
        System.out.println(Arrays.toString(s));

        //Oppgave 3: Lambda uttrykk som sorter etter studium - fornavn - etternavn
        Tabell.innsettingssortering(s, (s1,s2) -> {
            int k = s1.studium().compareTo(s2.studium());
            if(k != 0) {
                return k;
            }
            k = s1.fornavn().compareTo(s2.fornavn());
            if(k != 0) {
                return k;
            }
            return s1.etternavn().compareTo(s2.etternavn());
        });

        String[] streng = {"21","18","8","13","20","6","16","25","3","10"};
        Tabell.innsettingssortering(streng, (s1,s2) -> {
            int k = s1.length() - s2.length();
            return k != 0 ? k : s1.compareTo(s2);
        });

        System.out.println(Arrays.toString(streng));*/

        /*Double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};

        Tabell.innsettingssortering(d, Comparator.naturalOrder());
        System.out.println(Arrays.toString(d));
        Tabell.innsettingssortering(d, Comparator.reverseOrder());
        System.out.println(Arrays.toString(d));

        Boolean[] b = {false, true, true, false, false, true, false, true};

        Tabell.innsettingssortering(b, Comparator.naturalOrder());
        System.out.println(Arrays.toString(b));

        Person[] p = new Person[5];                       // en persontabell
        p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
        p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

        Tabell.innsettingssortering(p, Comparator.comparing(Person::etternavn));
        System.out.println(Arrays.toString(p));

        String[] streng = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        //for denne (Oppg. 1.4.7 5) ) lagde jeg omvendtOrden i Komparator; kan også bruke lambda-uttrykk:

        //Tabell.innsettingssortering(streng, (x,y) -> y.length() - x.length());
        //Tabell.innsettingssortering(streng, Komparator.orden( x -> -x.length()));

        Tabell.innsettingssortering(streng, Comparator.comparing(x -> x));
        System.out.println(Arrays.toString(streng));

        Tabell.innsettingssortering(streng, Comparator.naturalOrder());
        System.out.println(Arrays.toString(streng));

        String[] s = {"21","18","8","13","20","6","16","25","3","10"};
        //ville at vi skulle bruke deretter(x -> x) men dette fungerer ikke pga av det var expected int
        Tabell.innsettingssortering(s, Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println(Arrays.toString(s));
*/

        int[] x = {3,5,6,2,6,1,4,7,7,4};         // x-koordinater
        int[] y = {3,6,3,5,5,2,1,4,2,4};         // y-koordinater

        Point[] punkt = new Point[x.length];     // en punkttabell
        for (int i = 0; i < punkt.length; i++) punkt[i] = new Point(x[i],y[i]);

        for (Point p : punkt) System.out.print("(" + p.x + "," + p.y + ") ");
        System.out.println();                    // linjeskift

        Comparator<Point> c = (p1, p2) ->
        {
            int d = p1.x - p2.x;    // forskjellen mellom x-koordinatene
            if (d != 0) return d;
            return p1.y - p2.y;     // forskjellen mellom y-koordinatene
        };

        Tabell.innsettingssortering(punkt, Comparator.comparing(Point::getX).thenComparing(Point::getY));

        Tabell.innsettingssortering(punkt, c);

        /*Tabell.innsettingssortering(punkt,  Comparator.comparing(p -> p.x).thenComparing(p -> p.y));
        Tabell.innsettingssortering(punkt, Comparator.comparingInt(p -> p.x).thenComparingInt(p -> p.y));*/
        //Uten å caste p som point vet ikke compiler helt hva p er

        Tabell.innsettingssortering(punkt,  Comparator.comparing((Point p) -> p.x).thenComparing(p -> p.y));
        Tabell.innsettingssortering(punkt, Comparator.comparingInt((Point p) -> p.x).thenComparingInt(p -> p.y));

        Tabell.innsettingssortering(punkt, Comparator.comparingDouble(Point::getX).thenComparingDouble(Point::getY));

        Tabell.innsettingssortering(punkt, (p1,p2) -> {
            int d = (p1.x * p1.x + p1.y * p1.y) - (p2.x * p2.x + p2.y * p2.y);
            if (d != 0) {
                return d;
            } else {
                return p1.y - p2.y;
            }
        });

        Tabell.innsettingssortering(punkt, (p1, p2) -> {
            int d = p2.x*p1.y - p1.x*p2.y;
            if(d != 0) return d;
            if(p1.x != 0) return p1.x - p2.x;
            if(p1.y != 0) return p1.y - p2.y;

            //nå må p1 == (0,0)
            if(p2.x == 0 && p2.y == 0) return 0; // p1 == p2 == (0,0)
            return -1; //p1 == (0,0) og p2 != (0,0) gir p1 mindre enn p2
        });


        for (Point p : punkt) System.out.print("(" + p.x + "," + p.y + ") ");
    }

}
