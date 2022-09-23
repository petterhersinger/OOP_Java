package studentregister;

import java.io.IOException;
import java.util.Scanner;

public class StudentRegister {
    public static void main(String[] args) throws IOException {
        StudentHantering sh = new StudentHantering();
        Student s = new Student();

        Scanner input = new Scanner(System.in);

        int option = 0;

        do {
            menu();
            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:

                    sh.laggTillStudent();
                    break;

                case 2:

                    sh.visaStudenter();
                    break;

                case 3:

                    sh.uppdateraStudent();
                    break;

                case 4:

                    sh.taBortStudent();
                    break;

                case 5:
                    sh.skrivTillFil();
                    System.out.println("Sparat och klart!");
                    break;

                default:
                    System.out.println("Något kraschade..");
                    break;
            }
        }
        while (option !=5);
    }
    public static void menu() {
        System.out.println("MENU");
        System.out.println("1: Lägg till Student");
        System.out.println("2: Läs av Studenter");
        System.out.println("3: Uppdatera Student");
        System.out.println("4: Ta bort Student");
        System.out.println("5: Avsluta programmet");
        System.out.print("Var vänlig välj : ");
    }
}
