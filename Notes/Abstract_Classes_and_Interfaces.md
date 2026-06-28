# Abstract Classes and Interfaces.

**Abstraction**: Showing essential features, hiding implementation details.

---

## Abstract Classes

**Definition**: Class declared with `abstract` keyword. Cannot instantiate, can have abstract + concrete methods.

```java
abstract class Animal {
    abstract void sound();  // Abstract method (no body)
    
    void sleep() {          // Concrete method
        System.out.println("Sleeping");
    }
}

// Animal a = new Animal();  // ❌ ERROR - cannot instantiate
```

### Rules

1. Cannot create object with `new`
2. Can have abstract methods (no implementation)
3. Can have concrete methods (with implementation)
4. Can have constructors (called via `super()`)
5. Can have instance variables, static variables
6. Child class must override ALL abstract methods (or be abstract itself)

```java
abstract class Shape {
    abstract void draw();
    
    void display() {
        System.out.println("Shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing circle");
    }
}

Circle c = new Circle();
c.draw();      // Drawing circle
c.display();   // Shape
```

---

## Interfaces

**Definition**: Pure abstraction. Only method signatures (abstract by default), no implementation.

```java
interface Animal {
    void sound();        // Abstract method
    void eat();
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Bark");
    }
    
    public void eat() {
        System.out.println("Eating");
    }
}
```

### Rules

1. Cannot instantiate
2. Methods are abstract by default (no body)
3. Variables are `public static final` by default
4. Can implement multiple interfaces
5. Class must implement ALL methods (or be abstract)

```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() { System.out.println("Flying"); }
    public void swim() { System.out.println("Swimming"); }
}
```

---

## Abstract Class vs Interface

| Aspect | Abstract Class | Interface |
|--------|----------------|-----------|
| **Instantiation** | Cannot instantiate | Cannot instantiate |
| **Methods** | Abstract + Concrete | Abstract only (default) |
| **Variables** | Any type | `public static final` |
| **Constructor** | Can have | Cannot have |
| **Inheritance** | Single | Multiple (via implements) |
| **Access modifiers** | Any | Only public |
| **Use case** | Partial implementation, code reuse | Pure contract, multiple inheritance |

```java
// Abstract class - HAS implementation
abstract class Vehicle {
    void start() { System.out.println("Starting"); }
    abstract void accelerate();
}

// Interface - ONLY contract
interface Drawable {
    void draw();
}
```

---

## Multiple Inheritance via Interfaces

Solves diamond problem because interfaces have no implementation conflict.

```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() { }
    public void swim() { }
}
```

---

## Hybrid Inheritance

Class extends another class + implements interfaces.

```java
class Animal {
    void eat() { }
}

interface Flyable {
    void fly();
}

class Bird extends Animal implements Flyable {
    public void fly() { }
}
```

---

## When to Use What

**Use Abstract Class**:
- Partial implementation needed
- Related classes sharing code
- Non-public members needed
- Constructor needed for initialization

**Use Interface**:
- Pure contract definition
- Multiple inheritance needed
- Unrelated classes implementing same behavior
- Constantly evolving specifications

---