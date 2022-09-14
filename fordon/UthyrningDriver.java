package fordon;

public class UthyrningDriver {

    public static void main(String[] args) {

        //Skapar fem objekt för att representera fordon som kan hyras
        Bil f1 = new Bil("ABC123", false, 695, "Liten kombi");
        Lastbil f2 = new Lastbil("CBA321", true, 725, 6);
        Bil f3 = new Bil("AAA111", false, 995, "Mellan SUV");
        Lastbil f4 = new Lastbil("BBB222", true, 995, 14);
        Bil f5 = new Bil("CCC333", false, 1495, "Minibuss");

        //Skapar ett garage för hyrfordon på Mineralvägen och placerar två fordon där
        Garage g1 = new Garage("Mineralvägen");
        g1.laggTillFordon(f1);
        g1.laggTillFordon(f2);
        //Skapar ett garage för hyrfordon på Formvägen och placerar tre fordon där
        Garage g2 = new Garage("Formvägen");
        g2.laggTillFordon(f3);
        g2.laggTillFordon(f4);
        g2.laggTillFordon(f5);

        //Hyr ut ett av fordonen
        f3.hyraUt();
        //Lämnar tillbaka ett annat fordon, som tidigare var uthyrt
        f4.lamnaTillbaka();

        //Skriver ut information om vilka bilar som finns att hyra vid vilket garage
        System.out.println(g1.toString());
        System.out.println(g2.toString());
    }
}