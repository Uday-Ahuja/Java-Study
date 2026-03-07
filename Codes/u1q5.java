/*
5. A Shape Drawing Application calculates area for different shapes. Write a Java program where:
●	A base class Shape contains a method calculateArea()
●	Derived classes Circle and Rectangle override this method
●	Polymorphism is demonstrated using a base-class reference
*/
import java.util.Scanner;

class Shape{
    void calculateArea(){}
}

class Circle extends Shape{
    float radius;
    Circle(float radius){
        this.radius=radius;
    }
    void calculateArea(){
        float area=(float)Math.PI*radius*radius;
        System.out.println("Circle Area: "+area);
    }
}

class Rectangle extends Shape{
    float length,breadth;
    Rectangle(float length,float breadth){
        this.length=length;
        this.breadth=breadth;
    }
    void calculateArea(){
        float area=length*breadth;
        System.out.println("Rectangle Area: "+area);
    }
}

public class u1q5{
    public static void main(String[] args){
        Scanner scr=new Scanner(System.in);

        System.out.print("Enter radius: ");
        float r=scr.nextFloat();

        System.out.print("Enter length: ");
        float l=scr.nextFloat();

        System.out.print("Enter breadth: ");
        float b=scr.nextFloat();

        Shape s;

        s=new Circle(r);
        s.calculateArea();

        s=new Rectangle(l,b);
        s.calculateArea();
        scr.close();
    }
}