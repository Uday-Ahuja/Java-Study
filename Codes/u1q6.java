import java.util.Scanner;

/*
6. A College Admission System stores college name common to all students, while roll number and name differ. Write a Java program that:
●	Uses static variables for college name
●	Uses instance variables for student details
●	Uses static and instance methods to display information
*/
class Student
{
    static String collegename="SIT";
    int prn;
    String name;
    Student(Scanner scr){
        System.out.print("Enter Name: ");
        name=scr.nextLine();
        System.out.print("Enter PRN: ");
        prn=scr.nextInt();
    }
    Student(int prn,String name){
        this.name=name;
        this.prn=prn;        
    }
    static void displayCollege(){
        System.out.println("College: "+collegename);
    }
    void displayInfo(){
        System.out.println("----- Student Info-----");
        displayCollege();
        System.out.println("Name: "+name);
        System.out.println("PRN: "+prn);
    }
}
public class u1q6 {
    public static void main(String[] args) {
        Scanner scr=new Scanner(System.in);
        Student s=new Student(scr);
        s.displayInfo();
        scr.close();
    }
}
