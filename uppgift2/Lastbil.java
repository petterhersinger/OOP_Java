package fordon;

public class Lastbil extends Fordon{

    private int lastutrymme;

    Lastbil(String regNr, boolean uthyrd, int kostnad, int lastutrymme) {
        super(regNr, uthyrd, kostnad);
    }

    public int getLastutrymme() {
        return lastutrymme;
    }
}
