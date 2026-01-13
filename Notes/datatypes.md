# Java Data Types, Variables & Identifiers

## Primitive Data Types

- `byte` - 8-bit integer (-128 to 127)
- `short` - 16-bit integer (-32,768 to 32,767)
- `int` - 32-bit integer (-2³¹ to 2³¹-1)
- `long` - 64-bit integer (-2⁶³ to 2⁶³-1)
- `float` - 32-bit floating point
- `double` - 64-bit floating point
- `char` - 16-bit Unicode character
- `boolean` - true/false

## Non-Primitive Data Types

- **String** - sequence of characters
- **Arrays** - collection of similar type elements
- **Objects** - instances of classes
- **Classes** - blueprints for objects
- **Interfaces** - abstract type with method signatures

## Object

**Definition**: Instance of a class. Everything in Java (except primitives) is an object.

**Components**:
- **State**: Data/attributes (instance variables)
- **Behavior**: Methods/functions
- **Identity**: Unique reference/memory address

## Class

Blueprint or template for creating objects. Defines properties and methods.

## Interface

**Definition**: Contract that defines method signatures and constants. Contains only method declarations (no body) and variables (implicitly `public static final`).

**Purpose**: Achieve abstraction and multiple inheritance.
```java
interface Animal {
    void sound(); // method signature, no body
}
```

## Array

**Superclass**: `Object` class is the superclass of all arrays in Java. Arrays are objects.
```java
int[] numbers = {1, 2, 3, 4, 5};
```

## Final Variable

**Definition**: Constant whose value cannot be changed once assigned.

**Application**: Use `final` keyword to make variable immutable.
```java
final int myNum = 15;
myNum = 20; // ERROR: cannot assign a value to final variable
```

**Use Cases**:
- Constants (e.g., `final double PI = 3.14159;`)
- Configuration values that shouldn't change
- Thread-safe immutable values

## Variable Examples
```java
class Display_var {
    public static void main(String[] args) {
        // String concatenation
        String fName = "SIT";
        String lName = "College";
        String fullName = fName + lName; // Concatenate 2 variables
        
        // Arithmetic operations
        int x = 5;
        int y = 6;
        System.out.println(x + y); // Print value of x + y (11)
        
        // Declare multiple variables
        int a = 66, b = 45, c = 6;
        System.out.println(a + b + c); // 117
    }
}
```

## Java Identifier Rules

**Valid Characters**: Letters, digits, underscore (`_`), dollar sign (`$`)

**Rules**:
- **Case sensitive**: `myVar` ≠ `MyVar`
- **Cannot start with digit**: `1var` ❌, `var1` ✅
- **Can start with**: letter, `_`, or `$`
- **No whitespace**: `my var` ❌, `myVar` ✅
- **Cannot use reserved keywords**: `int`, `class`, `public`, etc.
- **Convention**: Start with lowercase letter, use camelCase

**Examples**:
```java
// Valid
int age;
int _count;
int $price;
int myVariableName;

// Invalid
int 2fast; // starts with digit
int my-var; // hyphen not allowed
int class; // reserved keyword
```