**Encapsulation**: Bundling data (attributes) and methods together. Hiding internal details, allowing controlled access via public methods.

```java
class BankAccount {
    private double balance;  // Hidden from outside
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}

BankAccount acc = new BankAccount();
// acc.balance = 1000;  // ❌ ERROR - private
acc.deposit(1000);      // ✅ Controlled access
```

---

## Access Modifiers

Control visibility of class members.

| Modifier | Same Class | Same Package | Subclass (Different Package) | Other Package |
|----------|-----------|--------------|------------------------------|---------------|
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| **default** (no modifier) | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

### public
Accessible everywhere.

```java
public class PublicClass { }
public int publicVar = 10;
public void publicMethod() { }
```

### private
Accessible only within same class.

```java
private int salary = 50000;  // Only this class can access

private void internalMethod() { }  // Only this class can call
```

### protected
Accessible in same package + subclasses in different packages.

```java
protected void method() { }  // Subclass can access even if different package
```

### default (package-private)
Accessible only within same package. No keyword used.

```java
class Helper { }            // default - package-private
int count = 5;              // default
void display() { }          // default
```

---

## Getters and Setters

Public methods to access private attributes safely.

```java
class Student {
    private String name;
    private int age;
    
    // Getter
    public String getName() {
        return name;
    }
    
    // Setter with validation
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        if (age > 0 && age < 100) {
            this.age = age;
        }
    }
}

Student s = new Student();
s.setName("Alice");      // ✅ Validation happens
s.setAge(20);
System.out.println(s.getName());  // Alice
```

---

## Benefits of Encapsulation

1. **Data hiding**: Internal implementation not exposed
2. **Validation**: Setters can enforce rules
3. **Flexibility**: Can change internal implementation without affecting outside code
4. **Maintainability**: Changes isolated to class

---