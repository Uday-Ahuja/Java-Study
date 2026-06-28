## Polymorphism

**Polymorphism**: "Many forms". Same interface, different implementations.

---

## Method Overloading

**Definition**: Multiple methods with same name, different parameters (in same class).

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    
    double add(double a, double b) {
        return a + b;
    }
    
    int add(int a, int b, int c) {
        return a + b + c;
    }
}

Calculator calc = new Calculator();
System.out.println(calc.add(5, 10));              // Calls 1st
System.out.println(calc.add(5.5, 10.5));          // Calls 2nd
System.out.println(calc.add(5, 10, 15));          // Calls 3rd
```

**Overloading criteria**: Number of parameters, type of parameters, order of parameters (NOT return type).

```java
// ❌ INVALID - same signature
double add(int a, int b) { return a + b; }  // ERROR - already exists
```

---

## Method Overriding

**Definition**: Child class provides new implementation for parent's method. Same signature.

```java
class Parent {
    void show() {
        System.out.println("Parent show");
    }
}

class Child extends Parent {
    @Override  // Recommended annotation
    void show() {
        System.out.println("Child show");  // New implementation
    }
}

Parent p = new Parent();
p.show();                    // Parent show

Child c = new Child();
c.show();                    // Child show

Parent ref = new Child();
ref.show();                  // Child show (Runtime binding)
```

**Key**: Decision happens at **runtime** based on actual object type, not reference type.

---

## Method Overloading vs Overriding

| Aspect | Overloading | Overriding |
|--------|------------|-----------|
| **Same class or different?** | Same class | Parent & Child class |
| **Signature** | Different (parameters) | Same (name, parameters, return type) |
| **When resolved?** | Compile-time | Runtime |
| **Access modifier** | Can change | Usually same or broader |
| **Throws clause** | Can change | Can only narrow (subclass exceptions) |

```java
// Overloading - compile-time
class Math {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}

// Overriding - runtime
class Parent {
    void display() { }
}
class Child extends Parent {
    void display() { }  // Runtime decides which
}
```

---

## Runtime (Dynamic) Binding

Method called is decided at runtime based on actual object type.

```java
class Animal {
    void sound() { System.out.println("Animal sound"); }
}

class Dog extends Animal {
    void sound() { System.out.println("Dog barks"); }
}

class Cat extends Animal {
    void sound() { System.out.println("Cat meows"); }
}

Animal a1 = new Dog();
Animal a2 = new Cat();
Animal a3 = new Animal();

a1.sound();  // Dog barks (actual object is Dog)
a2.sound();  // Cat meows (actual object is Cat)
a3.sound();  // Animal sound (actual object is Animal)
```

---

## Polymorphism Benefits

1. **Code reusability**: Same reference, different behaviors
2. **Flexibility**: Add new child classes without changing existing code
3. **Maintainability**: Loosely coupled design

---