# Static_Final_This.md

**`static` keyword**: Class-level, not instance-level. Shared across all objects of the class.

**Static variable**: One copy shared by all instances.

```java
class Student {
    static int totalStudents = 0;
    String name;
    
    Student(String name) {
        this.name = name;
        totalStudents++;
    }
}

Student s1 = new Student("Alice");
Student s2 = new Student("Bob");
System.out.println(Student.totalStudents);  // 2 (same for all objects)
```

**Static method**: Called on class, not object. Cannot access instance variables.

```java
class Math {
    static int add(int a, int b) {
        return a + b;
    }
}

int result = Math.add(5, 10);  // Called on class, not object
```

**Static block**: Executed once when class is loaded.

```java
class Database {
    static {
        System.out.println("Loading database...");
        // One-time initialization
    }
}
```

---

## `final` Keyword

**Final variable**: Value cannot change after assignment. Constant.

```java
final double PI = 3.14159;
PI = 3.14;  // ❌ ERROR - cannot reassign

final int MAX = 100;
MAX = 200;  // ❌ ERROR
```

**Final method**: Cannot be overridden by child class.

```java
class Parent {
    final void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    void display() {  // ❌ ERROR - cannot override final method
    }
}
```

**Final class**: Cannot be extended. End of inheritance chain.

```java
final class ImmutableClass {
}

class ChildClass extends ImmutableClass {  // ❌ ERROR - cannot extend final class
}
```

Final class CAN extend another class:
```java
final class Child extends Parent {  // ✅ VALID - Child is final, but can extend
}
```

---

## `this` Keyword

Reference to current object. Used to:
1. Refer to instance variables
2. Call another constructor (constructor chaining)
3. Pass current object to method

**Refer to instance variable**:

```java
class Student {
    String name;
    
    Student(String name) {
        this.name = name;  // 'this' refers to current object's name
    }
    
    void display() {
        System.out.println(this.name);  // Can access current object's name
    }
}
```

**Constructor chaining**:

```java
class Student {
    String name;
    int age;
    
    Student() {
        this("Unknown", 0);  // Calls parameterized constructor
    }
    
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

**Pass current object**:

```java
class Student {
    void compare(Student other) {
        if (this.age > other.age) {
            System.out.println("Current student is older");
        }
    }
}
```

---

## static vs final vs this - Quick Reference

| Keyword | Applies to | Behavior | Scope |
|---------|-----------|----------|-------|
| `static` | Variables, Methods, Blocks | Shared across all instances | Class-level |
| `final` | Variables, Methods, Classes | Cannot change/override/extend | Compile-time |
| `this` | Reference | Points to current object | Instance-level |

---