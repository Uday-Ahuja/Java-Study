## Classes objects and Constructors.

**Class**: Blueprint for creating objects. Defines attributes (variables) and methods (functions).

```java
class Student {
    String name;     // attribute
    int age;
    
    void study() {   // method
        System.out.println(name + " is studying");
    }
}
```

**Object**: Instance of a class. Created using `new` keyword.

```java
Student s1 = new Student();
Student s2 = new Student();
```

---

## Constructor

**Definition**: Special method called when object is created. Same name as class, no return type.

**Types**:

### Default Constructor
Compiler-generated. No parameters, no body.

```java
class Student {
    // Compiler creates: Student() { }
}

Student s = new Student();  // calls default constructor
```

### Parameterized Constructor
Accepts parameters, initializes attributes.

```java
class Student {
    String name;
    int age;
    
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

Student s = new Student("Alice", 20);
```

### Constructor Chaining
One constructor calls another using `this()`.

```java
class Student {
    String name;
    int age;
    
    Student() {
        this("Unknown", 0);  // calls parameterized constructor
    }
    
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

---

## Object Instantiation

```java
Student s = new Student("Bob", 21);

// Memory allocation:
// Heap: Student object {name="Bob", age=21}
// Stack: reference 's' points to heap object
```

**Key**: Each `new` creates separate object in heap. Different objects, different memory addresses.

```java
Student s1 = new Student("Alice", 20);
Student s2 = new Student("Bob", 21);
// Two separate objects in heap, though same attributes
```

---

## Object Attributes vs Methods

| Attribute | Method |
|-----------|--------|
| Variable storing data | Function performing action |
| Accessed: `object.attributeName` | Called: `object.methodName()` |
| State of object | Behavior of object |

---