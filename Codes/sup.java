class parent{
    void display1(){
        System.out.println("Parent class method1");
    }
    void display2(){
        System.out.println("Parent class method2");
    }
    void display3(){
        System.out.println("Parent class method3");
    }
}
class child extends parent{
    void display(){
        System.out.println("Calling Parent Method using Super keyword");
        super.display1();// Calls Display function of parent class
        super.display2();// Calls Display function of parent class
        super.display3();// Calls Display function of parent class
        System.out.println("Child Class Method");
    }
}
public class sup {
    public static void main(String[] args) {
        child c=new child();
        c.display();
    }
}
