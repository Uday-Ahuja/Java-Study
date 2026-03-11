# Exception Handling in Java

## What is an Exception?

An **exception** is an event that disrupts the normal flow of program execution. When an error occurs, Java creates an exception object and "throws" it.

---

## Exception Hierarchy

```
Throwable (base class)
├── Error (irrecoverable)
│   ├── OutOfMemoryError
│   ├── VirtualMachineError
│   └── StackOverflowError
└── Exception (recoverable)
    ├── Checked Exceptions (compile-time)
    │   ├── IOException
    │   ├── SQLException
    │   └── ClassNotFoundException
    └── Unchecked Exceptions (runtime)
        └── RuntimeException
            ├── NullPointerException
            ├── ArithmeticException
            ├── ArrayIndexOutOfBoundsException
            └── NumberFormatException
```

---

## Types of Exceptions

### 1. Checked Exceptions (Compile-Time)
- Detected at **compile-time** — compiler forces you to handle them
- Cause: external factors (I/O, database, file reading)
- **Must** use `try-catch` or `throws`

```java
FileReader fr = new FileReader("file.txt");  // Won't compile without handling
```

### 2. Unchecked Exceptions (Runtime)
- Occur at **runtime** — compiler doesn't force handling
- Cause: programming bugs / logic errors
- Handling is optional

```java
int result = 10 / 0;  // Compiles fine, crashes at runtime
```

### 3. Errors
- **Irrecoverable** system-level problems
- Cause: JVM/system failures, resource exhaustion
- **Should NOT be handled**

---

## Keywords

### `try-catch`

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero: " + e.getMessage());
}
```

Multiple catch blocks — order from specific to general:

```java
try {
    int[] arr = {1, 2, 3};
    System.out.println(arr[5]);
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array index error");
} catch (Exception e) {
    System.out.println("General error");
}
```

---

### `throw`
Manually throw an exception inside a method body.

```java
public void checkAge(int age) {
    if (age < 18) {
        throw new ArithmeticException("Age must be 18+");
    }
}
```

---

### `throws`
Declare that a method might throw an exception — passes responsibility to the caller.

```java
public void readFile() throws IOException {
    FileReader fr = new FileReader("file.txt");
}
```

Caller must handle it:

```java
public void caller() {
    try {
        readFile();
    } catch (IOException e) {
        System.out.println("File error: " + e.getMessage());
    }
}
```

Or pass it further up:

```java
public static void main(String[] args) throws IOException {
    readFile();  // Let JVM handle it
}
```

---

### `finally`
Always executes — whether exception occurred or not. Used for cleanup/resource release.

```java
FileReader fr = null;
try {
    fr = new FileReader("file.txt");
} catch (IOException e) {
    System.out.println("Error reading file");
} finally {
    if (fr != null) fr.close();  // Always runs
}
```

---

## Checked vs Unchecked

| | Checked | Unchecked |
|---|---------|-----------|
| When | Compile-time | Runtime |
| Base class | `Exception` (not RuntimeException) | `RuntimeException` |
| Cause | External (I/O, DB, network) | Logic/programming bugs |
| Handling | Required | Optional |
| Examples | `IOException`, `SQLException` | `NullPointerException`, `ArithmeticException` |

---

## `throw` vs `throws`

| | `throw` | `throws` |
|---|---------|----------|
| Purpose | Manually throw an exception | Declare exception in method signature |
| Location | Inside method body | Method signature |
| Syntax | `throw new Exception()` | `void method() throws Exception` |
| Effect | Stops execution immediately | Forces caller to handle |

---

## Fully Checked vs Partially Checked

- **Fully checked** — all subclasses are also checked (`IOException`, `InterruptedException`)
- **Partially checked** — some subclasses are unchecked (`Exception` class itself)

---

## Complete Example

```java
import java.io.*;

public class ExceptionDemo {

    public void readFile(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        System.out.println("File opened");
        fr.close();
    }

    public void checkAge(int age) {
        if (age < 18) throw new IllegalArgumentException("Age must be 18+");
        System.out.println("Age valid");
    }

    public static void main(String[] args) {
        ExceptionDemo demo = new ExceptionDemo();

        // Checked exception
        try {
            demo.readFile("test.txt");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } finally {
            System.out.println("Cleanup done");
        }

        // Unchecked - manual throw
        try {
            demo.checkAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }

        // Unchecked - runtime
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }
    }
}
```

---

## Key Points

- **Checked** → must handle at compile-time
- **Unchecked** → optional, caught at runtime
- **Errors** → don't handle, irrecoverable
- **`throw`** → manually throw inside method
- **`throws`** → declare in signature, pass to caller
- **`finally`** → always runs, use for cleanup
- **`Throwable`** → parent of everything