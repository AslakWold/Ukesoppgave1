package eksempelklasser;

public enum Måned {
    JAN ("Januar", 1),
    FEB ("Februar", 2),
    MAR ("Mars", 3),
    APR ("Aprli", 4),
    MAI ("Mai", 5),
    JUN ("Juni", 6),
    JUL ("Juli", 7),
    AUG ("August", 8),
    SEP ("September", 9),
    OKT ("Oktober", 10),
    NOV ("November", 11),
    DES ("Desember", 12);

    private String fulltnavn;
    private int mndnr;

        Måned(String fulltnavn, int mndnr) {
        this.fulltnavn = fulltnavn;
        this.mndnr = mndnr;
    }

    public int getMndnr() {
        return mndnr;
    }

    public String toString() {
        return fulltnavn;
    }

    public static String toString(int mnd) {
        if(mnd < 1 || mnd > 12) {
            throw new IllegalArgumentException("Ulovlig månedsnummer!");
        }
        return values()[mnd - 1].toString();
    }

    public static Måned[] vår() {
        Måned[] vår = new Måned[2];
        vår[0] = APR;
        vår[1] = MAI;
        return vår;
    }

    public static Måned[] sommer() {
        Måned[] sommer = new Måned[3];
        sommer[0] = JUN;
        sommer[1] = JUL;
        sommer[2] = AUG;
        return sommer;
    }

    public static Måned[] høst() {
        Måned[] høst = new Måned[2];
        høst[0] = SEP;
        høst[1] = OKT;
        return høst;
    }

    public static Måned[] vinter() {
        Måned[] vinter = new Måned[5];
        vinter[0] = NOV;
        vinter[1] = DES;
        vinter[2] = JAN;
        vinter[3] = FEB;
        vinter[4] = MAR;
        return vinter;
    }



}
