import java.util.Scanner;

class doctor {
    int doctorId;
    String specialization, name;

    doctor(int doctorId, String specialization, String name) {
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.name = name;
    }

    void getInfo(Scanner scr) {
        System.out.println("Enter Doctor Data");
        System.out.println("Enter Name:");
        this.name = scr.nextLine();
        System.out.println("Enter Specialization:");
        this.specialization = scr.nextLine();
        System.out.println("Enter Id:");
        this.doctorId = scr.nextInt();
        scr.nextLine();
    }

    void displayDoctor() {
        System.out.println("-----Doctor Data-----");
        System.out.println("Doctor Name: " + this.name);
        System.out.println("Doctor Specialization: " + this.specialization);
        System.out.println("Doctor Id: " + this.doctorId);
    }
}

class patient {
    int patientId;
    String disease, name;

    patient(int patientId, String disease, String name) {
        this.patientId = patientId;
        this.disease = disease;
        this.name = name;
    }

    void getInfo(Scanner scr) {
        System.out.println("Enter Patient Data");
        System.out.println("Enter Name:");
        this.name = scr.nextLine();
        System.out.println("Enter Disease:");
        this.disease = scr.nextLine();
        System.out.println("Enter Id:");
        this.patientId = scr.nextInt();
        scr.nextLine();
    }

    void displayPatient() {
        System.out.println("-----Patient Data-----");
        System.out.println("Patient Name: " + this.name);
        System.out.println("Patient Disease: " + this.disease);
        System.out.println("Patient Id: " + this.patientId);
    }
}

public class u1q1 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        doctor d1 = new doctor(0, "", "");
        patient p1 = new patient(0, "", "");

        d1.getInfo(scr);
        p1.getInfo(scr);

        d1.displayDoctor();
        p1.displayPatient();

        scr.close();
    }
}