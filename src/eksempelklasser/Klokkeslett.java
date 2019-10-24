package eksempelklasser;

public class Klokkeslett implements Comparable<Klokkeslett> {

    private int timer, minutter;

    public Klokkeslett(String klokkeslett) {
        if(klokkeslett.length() != 5 || klokkeslett.charAt(2) != ':') {
            throw new IllegalArgumentException("Klokkeslett må være på formen: tt:mm");
        }

        timer = Integer.parseInt(klokkeslett.substring(0,2));

        if(timer < 0 || timer > 23) {
            throw new IllegalArgumentException("Timetallet " + timer + " er ulovlig!");
        }

        minutter = Integer.parseInt(klokkeslett.substring(3));

        if(minutter < 0 || minutter > 59) {
            throw new IllegalArgumentException("Minutt-tallet " + minutter + " er ulovlig!");
        }

    }

    public int compareTo(Klokkeslett k){

        if(timer < k.timer) {return -1;}
        else if (timer > k.timer) {return 1;}
        else {
            return minutter - k.minutter;
        }
    }

    public boolean equals(Object o) {
        if(o == this) {return true;}
        if(!(o instanceof Klokkeslett)) {return false;}
        Klokkeslett k = (Klokkeslett) o;
        return timer == k.timer && minutter == k.minutter;
    }

    public boolean equals(Klokkeslett k) {
        return timer == k.timer && minutter == k.minutter;
    }

    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.timer;
        hash = 29 * hash + this.minutter;
        return hash;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(timer < 10) {
            sb.append('0');
        }
        sb.append(timer).append(':');
        if(minutter < 10) {
            sb.append('0');
        }
        sb.append(minutter);


        return sb.toString();
    }

}
