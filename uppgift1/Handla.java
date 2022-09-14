package matkasse;

public class Handla {
    public static void main(String[] args) {

        Matkasse kasse1 = new Matkasse("Vegetarisk", "student", 2);
        Matkasse kasse2 = new Matkasse("Exklusiv", "pensionär", 1);
        Matkasse kasse3 = new Matkasse("Standard", "familj", 3);

        skrivut(kasse1);
        skrivut(kasse2);
        skrivut(kasse3);

    }
    private static void skrivut(Matkasse kassen) {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Tack för din beställning av vår 5 dagars "
                + kassen.getKasse() + " matkasse. "
                + "\nDu har valt "
                + kassen.getAntalPortioner()
                + " portioner/dag. "
                + "Priset per portion är "
                + kassen.prisPerPortion()
                + " kr."
                + " \nDen totala summan per vecka för dig som "
                + kassen.getKundkategori() + " är "
                + kassen.beraknaPris() + " kr."
        );

    }
}
