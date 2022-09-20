package studentregister;

import java.io.IOException;
import java.util.Scanner;

public class StudentRegister {

    public static void main(String[] args) {

        RegisterHantering hr = new RegisterHantering();

        Register register = new Register();

        register.setUmuId("lare6862");
        register.setKontakt("0702690276");
        register.setNamn("Lasse");

        //hr.add(register);

        Scanner input = new Scanner(System.in);

        int option = 0;

        do {
            menu();
            option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1:

                    hr.add();

                    break;

                case 2:

                    hr.delete();

                    break;

                case 3:

                    hr.update();
                    break;

                case 4:

                    hr.find();
                    break;

                case 5:
                    hr.display();
                    break;

                case 9:

                    System.out.println(
                            "\nTack! Nu är filen sparad.\n");
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