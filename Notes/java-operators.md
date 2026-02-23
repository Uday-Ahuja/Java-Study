# Java Operators

## 1. Arithmetic Operators

**Basic Operations**: `+`, `-`, `*`, `/`, `%` (modulus)

**Increment/Decrement**: `++`, `--`
```java
int a = 10, b = 3;
System.out.println(a + b);  // 13
System.out.println(a - b);  // 7
System.out.println(a * b);  // 30
System.out.println(a / b);  // 3 (integer division)
System.out.println(a % b);  // 1 (remainder)

a++;  // a = 11
b--;  // b = 2
```

## 2. Assignment Operators

**Simple**: `=`

**Compound**: `+=`, `-=`, `*=`, `/=`, `%=`, `&=`, `|=`, `^=`, `>>=`, `<<=`, `>>>=`
```java
int x = 5;
x += 3;   // x = x + 3 → 8
x -= 2;   // x = x - 2 → 6
x *= 4;   // x = x * 4 → 24
x /= 3;   // x = x / 3 → 8
x %= 5;   // x = x % 5 → 3
```

## 3. Comparison (Relational) Operators

**Operators**: `==`, `!=`, `>`, `<`, `>=`, `<=`

**Returns**: `boolean` (true/false)
```java
int x = 5;
int y = 3;
System.out.println(x > y);   // true
System.out.println(y > x);   // false
System.out.println(x == y);  // false
System.out.println(x != y);  // true
System.out.println(x >= 5);  // true
```

## 4. Logical Operators

**AND**: `&&` (both must be true)

**OR**: `||` (at least one must be true)

**NOT**: `!` (inverts boolean)
```java
boolean a = true, b = false;
System.out.println(a && b);  // false
System.out.println(a || b);  // true
System.out.println(!a);      // false
System.out.println(!b);      // true
```

## 5. Bitwise Operators

**Operators**: `&` (AND), `|` (OR), `^` (XOR), `~` (NOT), `<<` (left shift), `>>` (signed right shift), `>>>` (unsigned right shift)
```java
public class BitwiseOperators {
    public static void main(String[] args) {
        int a = 5;  // Binary: 0101
        int b = 3;  // Binary: 0011
        
        // & (AND): Both bits must be 1
        // 0101 & 0011 = 0001 (1)
        System.out.println("a & b = " + (a & b));  // 1
        
        // | (OR): At least one bit must be 1
        // 0101 | 0011 = 0111 (7)
        System.out.println("a | b = " + (a | b));  // 7
        
        // ^ (XOR): Bits must be different
        // 0101 ^ 0011 = 0110 (6)
        System.out.println("a ^ b = " + (a ^ b));  // 6
        
        // ~ (NOT): Inverts all bits (also inverts sign)
        // ~0101 = 1010 (in 2's complement = -6)
        System.out.println("~a = " + (~a));  // -6
        
        // << (Left Shift): Shift bits left, fill with 0s
        // 0101 << 1 = 1010 (10) - equivalent to a * 2
        System.out.println("a << 1 = " + (a << 1));  // 10
        
        // >> (Right Shift): Shift bits right, preserve sign bit
        // 0101 >> 1 = 0010 (2) - equivalent to a / 2
        System.out.println("a >> 1 = " + (a >> 1));  // 2
        
        // >>> (Unsigned Right Shift): Shift right, fill with 0s
        // For positive numbers, same as >>
        System.out.println("a >>> 1 = " + (a >>> 1));  // 2
        
        // Difference between >> and >>> with negative numbers
        int negative = -8;  // Binary: 11111111111111111111111111111000
        
        // >> preserves sign (fills with 1s for negative)
        System.out.println("negative >> 1 = " + (negative >> 1));  // -4
        
        // >>> doesn't preserve sign (fills with 0s)
        System.out.println("negative >>> 1 = " + (negative >>> 1));  // 2147483644
    }
}
```

**Key Differences**:
- `>>`: Signed shift (preserves sign bit, fills with sign bit)
- `>>>`: Unsigned shift (always fills with 0s, treats as positive)

## 6. Miscellaneous Operators

### Ternary Operator (`? :`)

**Syntax**: `condition ? valueIfTrue : valueIfFalse`

**Purpose**: Shorthand for if-else
```java
public class TernaryOperator {
    public static void main(String[] args) {
        int a = 10;
        int b;
        
        // Condition 1: a == 1
        b = (a == 1) ? 20 : 30;
        System.out.println("When a == 1: b = " + b);  // b = 30
        
        // Condition 2: a == 10
        b = (a == 10) ? 30 : 20;
        System.out.println("When a == 10: b = " + b);  // b = 30
    }
}
```

### `instanceof` Operator

**Purpose**: Checks if object is instance of a class/interface

**Returns**: `boolean`
```java
String str = "Hello";
System.out.println(str instanceof String);  // true
System.out.println(str instanceof Object);  // true
```

## User Input with Scanner

**Package**: `java.util.Scanner`

**Purpose**: Read input from keyboard (or other sources)
```java
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner sc = new Scanner(System.in);
        
        // Input integers
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        
        // Calculate and display sum
        int sum = num1 + num2;
        System.out.println("Sum = " + sum);
        
        // Close scanner
        sc.close();
    }
}
```

### Scanner Methods

| Method | Purpose | Return Type |
|--------|---------|-------------|
| `nextInt()` | Read integer | `int` |
| `nextLong()` | Read long integer | `long` |
| `nextFloat()` | Read float | `float` |
| `nextDouble()` | Read double | `double` |
| `nextBoolean()` | Read boolean | `boolean` |
| `next()` | Read single word (until space) | `String` |
| `nextLine()` | Read entire line (until Enter) | `String` |
| `nextByte()` | Read byte | `byte` |
| `nextShort()` | Read short | `short` |
| `hasNext()` | Check if input available | `boolean` |
| `close()` | Close scanner | `void` |

**Important**: Always close Scanner with `sc.close()` to prevent resource leaks.

**Note**: `next()` reads only one word, `nextLine()` reads the entire line including spaces.