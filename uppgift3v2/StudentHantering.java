package studentregister;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentHantering {
    private ArrayList<Student> studenter;

    public StudentHantering() {
        studenter = new ArrayList<Student>();
    }
    public void laggTillStudent(Student student) {
        studenter.add(student);
    }
    public Student hämtaStudent(int index) {
        return studenter.get(index);
    }
    public void visaStudenter(){
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
        for (int i = 0; i < studenter.size(); i++){
            Student s = studenter.get(i);
            System.out.println();
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
            //bilar.add(b);
            laggTillStudent(s);
        }
        br.close();
    }
    public void uppdateraStudent() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vad är studentens UmuId");
        String uId = scan.nextLine();
        for (Student s : studenter) {
            if (uId.equalsIgnoreCase(s.getUmuId())) {
                System.out.println("Vad är studentens namn?");
                String uNamn = scan.nextLine();
                s.setNamn(uNamn);
                System.out.println("Vad är studentens namn?");
                String uKontakt = scan.nextLine();
                s.setKontakt(uKontakt);
            } else {
                System.out.println("Studenten är inte registrerad");
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
