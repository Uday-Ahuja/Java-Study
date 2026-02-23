```markdown
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
        ├── RuntimeException
        │   ├── NullPointerException
        │   ├── ArithmeticException
        │   ├── ArrayIndexOutOfBoundsException
        │   └── NumberFormatException
```

---

## Types of Exceptions

### 1. Checked Exceptions (Compile-Time)
**When**: Detected at **compile-time**. Compiler forces you to handle them.

**Examples**: `IOException`, `SQLException`, `ClassNotFoundException`, `FileNotFoundException`

**Cause**: External factors (I/O operations, database connections, file reading)

**Handling**: **REQUIRED** - Must use `try-catch` or `throws`

```java
import java.io.*;

public class Example {
    public static void main(String[] args) {
        // ❌ This won't compile without handling
        FileReader fr = new FileReader("file.txt");  // Compile error
    }
}
```

### 2. Unchecked Exceptions (Runtime)
**When**: Occur at **runtime**. Compiler doesn't force handling.

**Examples**: `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundsException`

**Cause**: Programming bugs/logic errors

**Handling**: **NOT REQUIRED** - Optional to use `try-catch`

```java
public class Example {
    public static void main(String[] args) {
        int result = 10 / 0;  // ArithmeticException at runtime
        // Compiles fine, crashes at runtime
    }
}
```

### 3. Errors (Runtime)
**When**: Occur at **runtime**. **Irrecoverable** system-level problems.

**Examples**: `OutOfMemoryError`, `VirtualMachineError`, `StackOverflowError`

**Cause**: JVM/system failures, resource exhaustion

**Handling**: **Should NOT be handled** - let program crash

---

## Exception Handling Keywords

### 1. `try-catch` Block

**Purpose**: Handle exceptions gracefully

```java
try {
    // Code that might throw exception
    int result = 10 / 0;
} catch (ArithmeticException e) {
    // Handle the exception
    System.out.println("Cannot divide by zero: " + e.getMessage());
}
```

**Multiple catch blocks**:
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

### 2. `throw` Keyword

**Purpose**: Manually throw an exception

**Location**: Inside method body or block of code

**Usage**: Can throw both checked and unchecked exceptions

**Effect**: Stops current execution flow immediately

```java
public void checkAge(int age) {
    if (age < 18) {
        throw new ArithmeticException("Age must be 18+");  // Throws exception
    }
    System.out.println("Access granted");
}
```

---

### 3. `throws` Keyword

**Purpose**: Declare that a method might throw an exception (pass responsibility to caller)

**Location**: In method signature

**Usage**: Used for **checked exceptions only** (not required for unchecked)

**Effect**: Forces caller to handle declared exceptions

```java
import java.io.*;

public void readFile() throws IOException {  // Declares exception
    FileReader fr = new FileReader("file.txt");
    // Doesn't handle exception, passes to caller
}
```

**Caller must handle**:
```java
public void caller() {
    try {
        readFile();  // Must handle IOException
    } catch (IOException e) {
        System.out.println("File error: " + e.getMessage());
    }
}
```

**OR caller can also use throws**:
```java
public void caller() throws IOException {
    readFile();  // Passes responsibility further up
}
```

**Don't know how to handle? Use throws in main**:
```java
public static void main(String[] args) throws IOException {
    readFile();  // Let JVM handle it (program crashes on error)
}
```

---

### 4. `finally` Block

**Purpose**: Code that **always executes** - whether exception occurs or not

**Use Cases**: Releasing resources, closing connections, cleanup operations

```java
FileReader fr = null;
try {
    fr = new FileReader("file.txt");
    // Read file
} catch (IOException e) {
    System.out.println("Error reading file");
} finally {
    // ALWAYS runs - close file whether task succeeded or failed
    if (fr != null) {
        try {
            fr.close();  // Release resource
        } catch (IOException e) {
            System.out.println("Error closing file");
        }
    }
}
```

**Execution Flow**:
- Task completed successfully? → Run `finally` → Close resources
- Exception occurred? → Run `catch` → Run `finally` → Close resources
- `finally` runs **no matter what**

---

## Checked vs Unchecked Exceptions

| Parameter | Checked Exception | Unchecked Exception |
|-----------|-------------------|---------------------|
| **Behavior** | Compile-time | Runtime |
| **Base Class** | `Exception` (except `RuntimeException`) | `RuntimeException` |
| **Cause** | External factors (I/O, database, network) | Programming bugs (logic errors) |
| **Handling Requirement** | **Required** - Must use `try-catch` or `throws` | **Not Required** - Optional |
| **Examples** | `IOException`, `SQLException`, `FileNotFoundException` | `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundsException` |
| **Compiler Check** | ✅ Yes - won't compile without handling | ❌ No - compiles fine |

---

## Categories of Checked Exceptions

### 1. Fully Checked
All subclasses are also checked exceptions.

**Examples**: `IOException`, `InterruptedException`

```
IOException (checked)
├── FileNotFoundException (checked)
├── EOFException (checked)
└── SocketException (checked)
```

### 2. Partially Checked
Some subclasses are unchecked exceptions.

**Example**: `Exception` class

```
Exception (checked)
├── IOException (checked)
├── SQLException (checked)
└── RuntimeException (unchecked)
    ├── NullPointerException (unchecked)
    └── ArithmeticException (unchecked)
```

---

## `throw` vs `throws`

| Parameter | `throw` | `throws` |
|-----------|---------|----------|
| **Definition** | Used to **manually throw** an exception | Used to **declare** exceptions a method might throw |
| **Location** | Inside method body or block of code | In method signature (after parameters) |
| **Usage** | Can throw both checked and unchecked | Used for checked exceptions only (not required for unchecked) |
| **Responsibility** | Throws exception immediately | Passes responsibility to caller |
| **Flow of Execution** | Stops current flow immediately | Forces caller to handle declared exceptions |
| **Syntax** | `throw new Exception();` | `void method() throws Exception { }` |

### Examples

**`throw`**:
```java
public void validateAge(int age) {
    if (age < 18) {
        throw new IllegalArgumentException("Must be 18+");  // Manually throw
    }
}
```

**`throws`**:
```java
public void readFile() throws IOException {  // Declare exception
    FileReader fr = new FileReader("file.txt");
}
```

---

## Complete Example

```java
import java.io.*;

public class ExceptionDemo {
    
    // Method declares it might throw IOException
    public void readFile(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        System.out.println("File opened successfully");
        fr.close();
    }
    
    // Method validates age, throws exception manually
    public void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18+");
        }
        System.out.println("Age valid");
    }
    
    public static void main(String[] args) {
        ExceptionDemo demo = new ExceptionDemo();
        
        // Example 1: Handling checked exception
        try {
            demo.readFile("test.txt");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } finally {
            System.out.println("Cleanup done");
        }
        
        // Example 2: Handling unchecked exception
        try {
            demo.checkAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
        
        // Example 3: Unchecked - ArithmeticException
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

- **Checked exceptions**: Must be handled (compile-time)
- **Unchecked exceptions**: Optional to handle (runtime)
- **Errors**: Don't handle (irrecoverable)
- **`throw`**: Manually throw exception inside method
- **`throws`**: Declare exception in method signature
- **`finally`**: Always runs (cleanup, resource release)
- **Base class**: `Throwable` (parent of all exceptions and errors)
```