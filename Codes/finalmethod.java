class parent
{
    final void display(){
        System.out.println("Final method in parent class");
    }
}
class child extends parent
{
    // void display(); wil raise COMPILATION error if attempted
}
public class finalmethod {
    public static void main(String[] args) {
        child c = new child();
        //c.display();
        parent p=new parent();
        p.display();
    }
}
