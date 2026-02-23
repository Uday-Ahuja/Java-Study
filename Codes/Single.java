// Single Inheritance- example
class Animal //parent class
{
    void eat(){
        System.out.println("This Animal Eats Food");
    }
}
class Dog extends Animal //child class
{
void bark(){
    System.out.println("Dog Barks");
}
}
public class Single 
{
    public static void main(String[] args) {
        Dog d= new Dog();
        d.bark();
        d.eat(); //inherited method
    }
}