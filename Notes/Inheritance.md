## Inheritance
---
**Inheritance**: Child class acquires properties and methods of parent class using `extends` keyword.

```java
class Parent {
    void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    void show() {
        System.out.println("Child");
    }
}

Child c = new Child();
c.display();  // Parent method
c.show();     // Child method
```

---

## Types of Inheritance

### 1. Single Inheritance
One parent, one child.

```java
class Animal {
    void eat() { System.out.println("Eating"); }
}

class Dog extends Animal {
    void bark() { System.out.println("Bark"); }
}
```

### 2. Multilevel Inheritance
Chain: GrandParent → Parent → Child.

```java
class GrandParent {
    void method1() { }
}

class Parent extends GrandParent {
    void method2() { }
}

class Child extends Parent {
    void method3() { }
}

Child c = new Child();
c.method1();  // GrandParent
c.method2();  // Parent
c.method3();  // Child
```

### 3. Hierarchical Inheritance
Multiple children inherit from same parent.

```java
class Animal { }
class Dog extends Animal { }
class Cat extends Animal { }
class Bird extends Animal { }
```

### 4. Multiple Inheritance (Classes - NOT ALLOWED)
One child from multiple parents - causes diamond problem.

```java
// ILLEGAL in Java
class Child extends Parent1, Parent2 { }
```

**Why not?** Ambiguity: if both parents have `show()`, which does child inherit?

```
    Parent1       Parent2
    show()        show()
        \           /
         \         /
          Child
      Which show()? ❌
```

### 5. Multiple Inheritance (Interfaces - ALLOWED)
Classes can implement multiple interfaces. No conflict because interfaces have no implementation.

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

## Object Reference Rules

| Reference | Object | Can Access | Valid? |
|-----------|--------|------------|--------|
| `Child c` | `new Child()` | Parent + Child methods | ✅ Yes |
| `Parent p` | `new Child()` | Parent methods only (upcasting) | ✅ Yes |
| `Parent p` | `new Parent()` | Parent methods only | ✅ Yes |
| `Child c` | `new Parent()` | — | ❌ No (incompatible types) |

```java
Parent p = new Child();  // Upcasting - ALLOWED
p.parentMethod();        // ✅ Works
p.childMethod();         // ❌ ERROR - Parent reference can't see Child methods

Child c = new Parent();  // Downcasting - COMPILE ERROR
```

---

## `super` Keyword

Refers to parent class. Used to call parent's constructor or method.

```java
class Parent {
    void display() { System.out.println("Parent"); }
}

class Child extends Parent {
    void display() {
        super.display();  // Call parent's display()
        System.out.println("Child");
    }
}

Child c = new Child();
c.display();
// Output:
// Parent
// Child
```

**Constructor chaining with super()**:

```java
class Parent {
    Parent(String name) {
        System.out.println("Parent constructor: " + name);
    }
}

class Child extends Parent {
    Child(String name) {
        super(name);  // Call parent constructor
    }
}

Child c = new Child("Alice");
// Output: Parent constructor: Alice
```

---

## Inheritance Types Comparison

| Type | Parents | Children | Use Case | Diamond Problem |
|------|---------|----------|----------|-----------------|
| Single | 1 | 1 | Simple hierarchy | No |
| Multilevel | 1 (chain) | Chain | Progressive specialization | No |
| Hierarchical | 1 | Many | Common behavior, different implementations | No |
| Multiple (Classes) | Many | 1 | Code reuse from multiple sources | ❌ Yes - Not allowed |
| Multiple (Interfaces) | Many | 1 | Contract from multiple sources | ✅ No - No implementation conflict |

---