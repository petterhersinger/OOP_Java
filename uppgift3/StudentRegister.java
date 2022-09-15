package studentregister;

import java.util.Scanner;

public class StudentRegister {

    public static void main(String[] args) {

        RegisterHantering hr = new RegisterHantering();

        Register register = new Register();

        register.setUmuId("6862");
        register.setKontakt("462690276");
        register.setNamn("Lasse");

        hr.add(register);

        Scanner input = new Scanner(System.in);

        int option = 0;

        do {
            menu();
            option = input.nextInt();

            switch (option) {

                case 1:

                    System.out.print(
                            "Vad är studentens UmuId? ");

                    String umuId = input.nextLine();

                    System.out.print(
                            "Vad är studentens kontaktuppgifter? Börja med 46 istället för 070: ");

                    String kontakt = input.nextLine();

                    System.out.print(
                            "Vad är studentens namn? ");

                    String namn = input.nextLine();

                    register = new Register(namn, umuId, kontakt);
                    hr.add(register);
                    System.out.println(register.toString());

                    break;

                case 2:

                    System.out.print(
                            "Vad är studentens UmuId? ");
                    String rId = input.nextLine();

                    hr.delete(rId);

                    break;

                case 3:

                    System.out.print(
                            "Vad är studentens UmuId? ");

                    String rIdNo = input.nextLine();
                    hr.update(rIdNo, input);

                    break;

                case 4:

                    System.out.print(
                            "Vad är studentens UmuId? ");
                    String bookId = input.nextLine();

                    if (!hr.find(bookId)) {
                        System.out.println(
                                "UmuId finns inte i registret\n");
                    }

                    break;

                case 5:
                    hr.display();
                    break;

                case 9:

                    System.out.println(
                            "\nTack!\n");
                    System.exit(0);

                    break;

                default:

                    System.out.println("\nFelaktig input\n");
                    break;
            }
        }

        while (option != 9);
    }

    public static void menu() {
        System.out.println("MENU");
        System.out.println("1: Lägg till Student");
        System.out.println("2: Ta bort Student");
        System.out.println("3: Uppdatera Student");
        System.out.println("4: Sök Student");
        System.out.println("5: Visa Studenter");
        System.out.println("9: Avsluta programmet");
        System.out.print("Var vänlig välj : ");
    }
}