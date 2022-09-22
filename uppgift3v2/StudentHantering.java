package studentregister;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentHantering {
    private ArrayList<Student> studenter;

    public StudentHantering() throws IOException {
        studenter = new ArrayList<Student>();
        lasFranFil();
    }

    public void laggTillStudent() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println(
                "Vad är studentens UmuId? ");

        String umuId = input.nextLine();

        System.out.println(
                "Vad är studentens telefonnummer? ");

        String kontakt = input.nextLine();

        System.out.println(
                "Vad är studentens namn? ");

        String namn = input.nextLine();

        Student s = new Student(namn, umuId, kontakt);
        s.setNamn(namn);
        s.setUmuId(umuId);
        s.setKontakt(kontakt);
        System.out.println(s.toString());

        if (!find(s.getUmuId())) {
            studenter.add(s);
            skrivTillFil();
        } else {
            System.out.println(
                    "Registreringen finns redan med i listan");
        }
    }

    public boolean find(String umuId) {

        for (Student s : studenter) {

            if (s.getUmuId().equals(umuId)) {

                System.out.println(s);
                return true;
            }
        }
        return false;
    }

    public void visaStudenter() {
        System.out.println("Studenter i registret: ");
        for (int i = 0; i < studenter.size(); i++) {
            Student s = studenter.get(i);
            System.out.println(s.getUmuId() + "; "
                    + s.getNamn() + "; " + s.getKontakt());
        }
    }

    public void skrivTillFil() throws IOException {
        File filNamn = new File("register.csv");
        FileWriter fw = new FileWriter(filNamn);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < studenter.size(); i++) {
            Student s = studenter.get(i);
            bw.write(s.getUmuId() + "; " +
                    s.getNamn() + "; " +
                    s.getKontakt());
            bw.newLine();
        }
        bw.close();
    }

    public void lasFranFil() throws IOException {
        File filNamn = new File("register.csv");
        FileReader fr = new FileReader(filNamn);
        BufferedReader br = new BufferedReader(fr);
        String rad;
        while ((rad = br.readLine()) != null) {
            String[] post = rad.split("; ");
            Student s = new Student();
            s.setUmuId(post[0]);
            s.setNamn(post[1]);
            s.setKontakt(post[2]);
            laggTillLista(s);
        }
        br.close();
    }

    private void laggTillLista(Student s) {
        studenter.add(s);
    }

    public void uppdateraStudent() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vad är studentens UmuId");
        String uId = scan.nextLine();
        for (Student s : studenter) {
            if (uId.equalsIgnoreCase(s.getUmuId())) {
                System.out.println("Vad är studentens namn?");
                String uNamn = scan.nextLine();
                s.setNamn(uNamn);
                System.out.println("Vad är studentens tel?");
                String uKontakt = scan.nextLine();
                s.setKontakt(uKontakt);
                skrivTillFil();
            }
        }
    }

    public void taBortStudent() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Vad är studentens UmuId? ");
        String rId = scan.nextLine();
        for (Student s : studenter) {
            if (rId.equalsIgnoreCase(s.getUmuId())) {
                studenter.remove(s);
                skrivTillFil();
                break;
            }
        }
    }
}