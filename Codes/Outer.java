public class Outer {
    class inner{
        void display(){
            System.out.println("Inner Class");
        }
    }
    public static void main(String[] args) {
        Outer.inner inobj = new Outer().new inner();
        inobj.display();
    }
}
