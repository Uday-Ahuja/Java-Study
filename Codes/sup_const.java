class parent
{
    parent(){
        System.out.println("Parent Constructor Called");
    }
}
class child extends parent
{
    child(){
        super(); 
        System.out.println("Child Constructor Called");
    }
}
public class sup_const 
{
    public static void main(String[] args) {
        child c=new child();
    }
}
