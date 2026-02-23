class Shape{
    void showgrand(){
        System.out.println("I am a Shape");
    }
}
class Triangle extends Shape
{
    void showpar(){
        System.out.println("I am a Triangle");
    }
}
class Rtangle extends Triangle
{
    void showchild(){
        System.out.println("Type: Right Angled");
    }
}
public class Multilevel2 {
    public static void main(String[] args) {
        Rtangle c=new Rtangle();
        c.showgrand();
        c.showpar();
        c.showchild();
    }
}
