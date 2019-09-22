package eksempelklasser;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private final String fornavn;
    private final String etternavn;

    public Person(String fornavn, String etternavn) {
        Objects.requireNonNull(fornavn, "fornavn er null");
        Objects.requireNonNull(etternavn, "etternavn er null");

        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public String fornavn() {       //aksessor
        return fornavn;
    }

    public String etternavn() {     //aksessor
        return etternavn;
    }

    public int compareTo(Person p) {
        int cmp = etternavn.compareTo(p.etternavn); //sammenligner etternavn
        if(cmp != 0) {      //hvis etternavn ikke er like
            return cmp;     //returnerer cmp
        }
        return fornavn.compareToIgnoreCase(p.fornavn);      //sammenligner fornavn
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;        //er det samme objekt?
        }
        if(o == null) {
            return false;       //null-argument
        }
        if(getClass() != o.getClass()) {
            return false;       //er det rett klasse
        }
        final Person p = (Person) o;    //typekonvertering (casting)
        return etternavn.equals(p.etternavn) && fornavn.equals(p.fornavn);
    }

    public boolean equals(Person p) {
        if(p == this) {
            return true;
        }
        if(p == null) {
            return false;
        }
        return etternavn.equals(p.etternavn) && fornavn.equals(p.fornavn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(etternavn, fornavn);
    }

    @Override
    public String toString() {
        return String.join(" ", fornavn, etternavn);
    }
}
