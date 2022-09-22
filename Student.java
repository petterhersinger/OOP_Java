package studentregister;

public class Student {

    String namn;
    String umuId;
    String kontakt;

    public Student(String namn, String umuId, String kontakt) {

        this.namn = namn;
        this.umuId = umuId;
        this.kontakt = kontakt;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public String getUmuId() {
        return umuId;
    }

    public void setUmuId(String umuId) {
        this.umuId = umuId;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    @Override
    public String toString() {

        return "Registerat{"
                + "namn= " + namn + ", umuId= " + umuId
                + ", tel= " + kontakt + '}';
    }
}