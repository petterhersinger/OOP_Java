package fordon;

public class Bil extends Fordon {

    private String kategori;

    Bil(String regNr, boolean uthyrd, int kostnad, String kategori) {
        super(regNr, uthyrd, kostnad);
    }
    public String getKategori() {
        return kategori;
    }
}
