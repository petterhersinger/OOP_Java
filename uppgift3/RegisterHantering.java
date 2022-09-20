package studentregister;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class RegisterHantering {

    static LinkedList<Register> list;

    Scanner input = new Scanner(System.in);

    public RegisterHantering() {
        list = new LinkedList<>();
    }

    private void lasFil() throws IOException {
        File Filnamn = new File("register.csv");

        FileReader Las = new FileReader(Filnamn);
        BufferedReader br = new BufferedReader(Las);

        String rad;

        while ((rad = br.readLine()) != null) {
            String[] post = rad.split("; ");

            Register register = new Register();
            register.setNamn(post[0]);
            register.setUmuId(post[1]);
            register.setKontakt(post[2]);
            list.add(register);
        }
        br.close();
    }


    private void skrivFil() {
        try {
            File Filnamn = new File("register.csv");

            FileWriter Skriv = new FileWriter(Filnamn);
            BufferedWriter bw = new BufferedWriter(Skriv);

            for (int i = 0; i < list.size(); i++) {
                Register register = list.get(i);
                String registrering = register.getNamn() + "; "
                        + register.getUmuId() + "; "
                        + register.getKontakt();
                bw.write(registrering);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void add() {
        System.out.println(
                "Vad är studentens UmuId? ");

        String umuId = input.nextLine();

        System.out.println(
                "Vad är studentens telefonnummer? ");

        String kontakt = input.nextLine();

        System.out.println(
                "Vad är studentens namn? ");

        String namn = input.nextLine();

        Register register = new Register(namn, umuId, kontakt);
        System.out.println(register.toString());

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

    public void delete() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Vad är studentens UmuId? ");
        String rId = scan.nextLine();
        for(Register l : list) {
            if(rId.equalsIgnoreCase(l.getUmuId())) {
                list.remove(l);
                skrivFil();
                break;
            }
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

            System.out.println(
                    "Vad är studentens umuId? ");
            String umuId = input.nextLine();

            System.out.println(
                    "Vad är studentens telefonnummer? ");
            String kontakt = input.nextLine();

            System.out.println(
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
