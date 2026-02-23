class Animal{
    void showgrand(){
        System.out.println("I am an Animal");
    }
}
class Cat extends Animal
{
    void showpar(){
        System.out.println("I am a Cat");
    }
}
class Sphynx extends Cat
{
    void showchild(){
        System.out.println("Breed: Sphynx Cat");
    }
}
public class MultiLevel {
    public static void main(String[] args) {
        Sphynx c=new Sphynx();
        c.showgrand();
        c.showpar();
        c.showchild();
    }
}
