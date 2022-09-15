package studentregister;

import java.util.LinkedList;
import java.util.Scanner;

public class RegisterHantering {

    LinkedList<Register> list;

    public RegisterHantering() {
        list = new LinkedList<>();
    }

    public void add(Register register) {

        if (!find(register.getUmuId())) {
            list.add(register);
        } else {

            System.out.println(
                    "Registreringen finns redan med i listan");
        }
    }

    public boolean find(String umuId) {

        for (Register l : list) {

            if (l.getUmuId().equals(umuId)) {

                System.out.println(l);
                return true;
            }
        }
        return false;
    }

    public void delete(String recUmuId) {
        Register registerDel = null;

        for (Register ll : list) {

            if (ll.getUmuId().equals(recUmuId)) {
                registerDel = ll;
            }
        }

        if (registerDel == null) {

            System.out.println("Felaktigt umu Id");
        } else {

            list.remove(registerDel);

            System.out.println(
                    "Registreringen borttagen från listan");
        }
    }

    public Register findRegister(String umuId) {

        for (Register l : list) {

            if (l.getUmuId().equals(umuId)) {
                return l;
            }
        }

        return null;
    }

    public void update(String id, Scanner input) {

        if (find(id)) {
            Register rec = findRegister(id);

            System.out.print(
                    "Vad är studentens umuId? ");
            String umuId = input.nextLine();

            System.out.print(
                    "Vad är studentens telefonnummer? ");
            String kontakt = input.nextLine();

            System.out.print(
                    "Vad är studentens namn? ");
            String namn = input.nextLine();

            rec.setUmuId(umuId);
            rec.setNamn(namn);
            rec.setKontakt(kontakt);
            System.out.println("Registreringen uppdaterad");
        } else {

            System.out.println(
                    "Registreringen hittades inte i listan");
        }
    }

    public void display() {
        if (list.isEmpty()) {

            System.out.println("Denna lista har inga registreringar\n");
        }
        for (Register register : list) {

            System.out.println(register.toString());
        }
    }
}
