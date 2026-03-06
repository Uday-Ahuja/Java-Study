import java.util.Scanner;
class Employee
{
    int employeeId;
    String empname, department;
    double salary;
    Employee(Scanner scr){
        System.out.println("Enter Employee Id:");
        employeeId = scr.nextInt();
        scr.nextLine(); 
        System.out.println("Enter Employee Name:");
        empname = scr.nextLine();
        System.out.println("Enter Employee Department:");
        department = scr.nextLine();
        System.out.println("Enter Employee Salary:");
        salary = scr.nextDouble();
    }
    Employee(int employeeId,String empname,String department,double salary){
        this.employeeId = employeeId;
        this.empname = empname;
        this.department = department;
        this.salary = salary;
    }
    void printEmployeeInfo(){
        System.out.println("Employee Id: "+ employeeId);
        System.out.println("Employee Name: "+ empname);
        System.out.println("Employee Department: " + department);
        System.out.println("Employee Salary: "+ salary);
    }
}
public class u1q3 {
    public static void main(String[] args) {
        Scanner scr= new Scanner(System.in);
        Employee e1=new Employee(scr);
        Employee e2=new Employee(222,"Uday","CS",20000);
        e1.printEmployeeInfo();
        e2.printEmployeeInfo();
        scr.close();
    }
}
