package matkasse;

public class Matkasse {
    private String kasse;
    private String kundkategori;
    private int antalPortioner;


    Matkasse(String kasse, String kundKategori, int antalPortioner) {
        this.kasse = kasse;
        this.kundkategori = kundKategori;
        this.antalPortioner = antalPortioner;
    }

    public String getKasse() {
        return kasse;
    }

    public String getKundkategori() {
        return kundkategori;
    }

    public int getAntalPortioner() {
        return antalPortioner;
    }

    public int prisPerPortion() {
        if (kasse.equals("Vegetarisk")) {
            if (kundkategori.equals("student")) {
                return 10;
            } else if (kundkategori.equals("pensionär")) {
                return 15;
            } else if (kundkategori.equals("familj")) {
                return 20;
            }
        } else if (kasse.equals("Exklusiv")) {
            if (kundkategori.equals("student")) {
                return 20;
            } else if (kundkategori.equals("pensionär")) {
                return 30;
            } else if (kundkategori.equals("familj")) {
                return 40;
            }
        } else if (kasse.equals("Standard")) {
            if (kundkategori.equals("student")) {
                return 15;
            } else if (kundkategori.equals("pensionär")) {
                return 20;
            } else if (kundkategori.equals("familj")) {
                return 30;
            }
        }
        return 0;
    }

    public int beraknaPris() {
        return 5 * prisPerPortion() * antalPortioner;
    }
}
