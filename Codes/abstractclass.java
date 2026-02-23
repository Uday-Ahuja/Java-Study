abstract class Animal {
    abstract void sound();

    void eat() {
        System.out.println("This Animal Eats Food");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog Barks");
    }

    void bhow() {
        System.out.println("Woof Woof");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Cat Meows");
    }

    void mi() {
        System.out.println("Meow Meow");
    }
}

public class abstractclass {
    public static void main(String[] args) {

        Animal d = new Dog();
        Animal c = new Cat();

        d.sound();   //  Allowed (declared in Animal)
        c.sound();   //  Allowed (declared in Animal)

        // d.bhow();  //  ERROR: bhow() not defined in Animal
        // c.mi();    //  ERROR: mi() not defined in Animal

        Dog dogObj = new Dog();
        dogObj.bhow();  //  Allowed (reference type is Dog)
    }
}
