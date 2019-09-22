package eksempelklasser;

public enum Studium {
    Data ("Ingeniørfag - data"),        //enumkonstanten Data
    IT ("Informasjonsteknologi"),       //enumkonstanten IT
    Anvendt ("Anvendt datateknologi"),  // enumkonstanten Anvendt
    Elektro ("Ingeniørfag - Elektronikk og informasjonsteknologi"),
    Enkeltemne ("Enkeltemnestudent");   //enumkonstanten Enkeltemne

    private final String fulltnavn;         //instansvariabel
        Studium(String fulltnavn) {
        this.fulltnavn = fulltnavn;
    }

    @Override
    public String toString() {
        return fulltnavn;
    }
}
