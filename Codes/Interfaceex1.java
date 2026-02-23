interface Animal
{
    void sound();
}
interface Mammal
{
    void birth();
}
class Dog implements Animal, Mammal
{
    public void sound(){
        System.out.println("Sound: Woof Woof");
    }
    public void birth(){
        System.out.println("Dog Gives Birth");
    }
}
class Sparrow implements Animal
{
    public void lays(){
        System.out.println("Sparrow Lays Eggs");
    }
    public void sound(){
        System.out.println("Sound: Chu Chu");
    }
}
public class Interfaceex1 
{
    public static void main(String[] args) {
        Dog d= new Dog();
        Sparrow s=new Sparrow();
        d.birth();
        d.sound();
        s.lays();
        s.sound();
    }
}
