class Shape{
    void displayShape(){
        System.out.println("Shape Class");
    }
}
class Circle extends Shape
{
    void displayCircle(){
        System.out.println("Circle: Area= pi*r*r and Circumference=2*pi*r");
    }
}
class Square extends Shape
{
    void displaySquare(){
        System.out.println("Square: Area= side*side and Perimeter= 4*side");
    }
}
public class Hierarchical {
    public static void main(String[] args) {
        Circle c= new Circle();
        c.displayShape();
        c.displayCircle();

        Square s=new Square();
        s.displayShape();
        s.displaySquare();
    }
}
