package fordon;

/**
 * @author Petter Hersinger
 * Klassen Fordon är superklass till klasserna Bil & Lastbil.
 */
public class Fordon {
    private String regNr;
    private boolean uthyrd;
    private int kostnad;

    /**
     * Konstruktor för variablerna regNr, uthyrd och kostnad.
     * @param regNr
     * @param uthyrd
     * @param kostnad
     */
    Fordon (String regNr, boolean uthyrd, int kostnad) {
        this.regNr = regNr;
        this.uthyrd = uthyrd;
        this.kostnad = kostnad;
    }

    /**
     *
     * @return Returnerar registreringsnumret för ett specifikt fordon.
     */
    public String getRegNr() {
        return regNr;
    }

    /**
     *
     * @return Returnerar true/false genom en boolean variabel för ett specifikt fordon; om det är uthyrt eller inte.
     */
    public boolean getUthyrd() {
        return uthyrd;
    }

    /**
     *
     * @return Returnerar kostnaden för ett specfikt fordon.
     */
    public int getKostnad() {
        return kostnad;
    }

    /**
     * Sätter värdet på variabeln uthyrd till true om bilen är uthyrd.
     */
    public void hyraUt() {
        this.uthyrd = true;
    }

    /**
     * Sätter värdet på variabeln uthyrd till false om bilen är tillgänglig.
     */
    public void lamnaTillbaka() {
        this.uthyrd = false;
    }

    /**
     *
     * @return Returnerar registreringsnummer & kostnad för ett specifikt fordon.
     * Returnerar även om bilen är uthyrd eller inte genom en if sats för en boolean variabel.
     */
    @Override
    public String toString() {
        if (uthyrd == false) {
            return "Ett fordon med registreringsnummer " + regNr
                    + " som kostar " + kostnad + " kr per dag att hyra."
                    + " Fordonet är redo att hyras ut";
        } else {
            return "Ett fordon med registreringsnummer " + regNr
                    + " som kostar " + kostnad + " kr per dag att hyra."
                    + " Fordonet är redan uthyrt";
        }

    }
}