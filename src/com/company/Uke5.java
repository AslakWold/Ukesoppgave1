package com.company;

import hjelpetabeller.Tabell;

import java.util.Arrays;

public class Uke5 {


    public static int a(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("Kan ikke være mindre enn 0");
        }

        int x = 0;
        int y = 1;
        int z = 1;

        for(int i = 0; i < n; i++) {
            z = 2*y + 3*x;
            x = y;
            y = z;
        }
        return y;
    }

    //Iterativ tverrsum
    /*public static int tverrsum(int n) {
        System.out.println("Tverrsum " + n + " starter");
        int sum = 0;

        while(n > 0) {
            sum += n % 10;
            n /= 10;
            System.out.println("tverrsum(" + n + ") er ferdig");
        }
        return sum;
    }*/

    //rekursiv tverrsum
    public static int tverrsum(int n) {
        System.out.println("Tverrsum " + n + " starter");
        int sum = (n < 10) ? n : tverrsum(n/10) + (n % 10);
        System.out.println("tverrsum (" + n + ") er ferdig!");
        return sum;

    }

    public static int sifferRot(int n) {
        while(n >= 10) {
            n = tverrsum(n);
        }
        return n;
    }

    public static int kvadratsum(int n) {
        if(n == 1) {
            return 1;
        } else {
            return kvadratsum(n-1) + n*n;
        }
    }// formel er tydeligvis n*(n+1)*(2*n+1)/6

    public static int sum(int k, int n) {
        if(k == n) {        //summen av en verdi (verdien selv)
            return n;
        }
        int m = (k + n)/2; //midtpunkt (splitt og hersk)
        int sum = sum(k, m) + sum(m+1,n); // fra k til midten og m til midten
        return sum;
    }


    public static int maks(int[] a, int v, int h) {
        if(v == h) {
            return v;
        }
        int m = (v+h)/2;

        int mv = maks(a,v,m);
        int mh = maks(a,m+1,h);

        return a[mv] >= a[mh] ? mv : mh;

    }

    public static int fakultet(int n) {

        return n < 2 ? 1 : fakultet(n-1) * n;
    }

    public static int fib(int n)         // det n-te Fibonacci-tallet
    {
        if (n <= 1) return n;              // fib(0) = 0, fib(1) = 1
        else return fib(n-1) + fib(n-2);   // summen av de to foregående
    }

    public static int euklid(int a, int b) {
        System.out.println("Euklid for " + a + " og " + b + " starter.");
        if(b == 0) {
            return a;
        }
        int r = a % b;
        int tall = euklid(b, r);
        System.out.println("Euklid for " + b + " og " + r + " er ferdig");
        return tall;
    }

    public static int iterativEuklid(int a, int b) {

        while(b > 0 ) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    public static int parter0(int[] a, int v, int h, int skilleverdi) {
        while(true) {
            while(v <= h && a[v] < skilleverdi) {
                v++;
            }
            while(v <= h && a[h] > skilleverdi) {
                h--;
            }
            if(v < h) Tabell.bytt(a, v++, h--);
            else return v;
        }
    }

    public static int sParter0(int[] a, int v, int h, int indeks) {
        Tabell.bytt(a, indeks, h);
        int pos = parter0(a, v, h - 1, a[h]);
        Tabell.bytt(a, pos, h);
        return pos;
    }

    public static void kvikksortering0(int[] a, int v, int h) {
        System.out.println("Kallet med [" + v + ":" + h +"] starter!");
        if(v >= h) return; //tomt eller maks ett element


        int k = sParter0(a, v, h, (v+h)/2);
        if(v < k - 1) kvikksortering0(a, v, k-1);
        if(k+1 < h) kvikksortering0(a, k+1, h);
        System.out.println("Kallet med [" + v + ":" + h +"] er ferdig!");
    }
    public static void main(String[] args) {

        /*System.out.println(sum(1, 5));
        System.out.println(sifferRot(222323));
        */
        //System.out.println(fib(50));
        //Går inn i en nærmest evig løkke

        /*System.out.println("main() starter!");
        int sum = tverrsum(729586);
        System.out.println("main() er ferdig!");
        System.out.println(sum);

        System.out.println("main() starter!");
        int tall = euklid(1529, 14036);
        System.out.println("main() er ferdig!");
        System.out.println(tall);
        */

        System.out.println(sum(1,1000000));

        int[] a = Tabell.randPerm(10);
        System.out.println(Arrays.toString(a));
        kvikksortering0(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
