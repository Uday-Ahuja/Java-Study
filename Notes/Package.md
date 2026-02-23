# Java Packages

## What is a Package?

A **package** is a namespace that organizes classes and interfaces into groups. Think of it like folders/directories for your code.

**Purpose**:
- Organize related classes together
- Avoid name conflicts (two classes can have same name in different packages)
- Control access (package-private visibility)
- Easier code maintenance

---

## Package Naming Convention

- All lowercase: `mypackage`, `com.company.project`
- Reverse domain name for uniqueness: `com.google.maps`, `org.apache.commons`
- Use dots (`.`) for hierarchy: `com.mycompany.project.utils`

---

## Creating a Package

### Step 1: Declare Package at Top of File
```java
package com.mycompany.utils;  // MUST be first line (except comments)

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
```

### Step 2: Directory Structure Matches Package

**File location**: `com/mycompany/utils/Calculator.java`
```
project/
├── com/
│   └── mycompany/
│       └── utils/
│           └── Calculator.java
```

**Rule**: Package name = directory path (dots become folders)

---

## Compiling with Packages

### Without Package Structure
```bash
javac Calculator.java
```

### With Packages (from project root)
```bash
javac com/mycompany/utils/Calculator.java
```

### Compile and Place in Specific Directory
```bash
javac -d . Calculator.java
```

**`-d` flag**: 
- `-d .` → Creates package directory structure in current folder
- `-d bin` → Creates structure in `bin` folder
- Automatically creates folders matching package declaration

**Example**:
```bash
# File has: package com.mycompany.utils;
javac -d . Calculator.java

# Creates: com/mycompany/utils/Calculator.class
```

---

## Using Classes from Packages

### Option 1: Import Specific Class
```java
import com.mycompany.utils.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 3));
    }
}
```

### Option 2: Import All Classes from Package
```java
import com.mycompany.utils.*;  // * means all classes

public class Main {
    // Can use any class from utils package
}
```

### Option 3: Fully Qualified Name (No Import)
```java
public class Main {
    public static void main(String[] args) {
        com.mycompany.utils.Calculator calc = new com.mycompany.utils.Calculator();
        System.out.println(calc.add(5, 3));
    }
}
```

---

## Running Classes with Packages

### From Project Root
```bash
java com.mycompany.Main
```

**Note**: 
- Use `.` (dot) notation, not `/` (slash)
- Don't include `.class` extension
- Must run from directory containing package root

---

## Complete Example

### Project Structure
```
myproject/
├── com/
│   └── company/
│       ├── models/
│       │   └── Student.java
│       └── utils/
│           └── Helper.java
└── Main.java
```

### `com/company/models/Student.java`
```java
package com.company.models;

public class Student {
    private String name;
    private int age;
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void display() {
        System.out.println(name + " - " + age);
    }
}
```

### `com/company/utils/Helper.java`
```java
package com.company.utils;

public class Helper {
    public static void printMessage(String msg) {
        System.out.println("Message: " + msg);
    }
}
```

### `Main.java`
```java
import com.company.models.Student;
import com.company.utils.Helper;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Alice", 20);
        s.display();
        
        Helper.printMessage("Hello from package!");
    }
}
```

### Compile and Run
```bash
# Compile all files (from myproject/ directory)
javac -d . com/company/models/Student.java
javac -d . com/company/utils/Helper.java
javac Main.java

# Run
java Main
```

**Output**:
```
Alice - 20
Message: Hello from package!
```

---

## Built-in Java Packages

### Automatically Imported
- **`java.lang`** - Automatically imported (String, Math, System, etc.)

### Common Packages (Need Import)
- **`java.util`** - Utilities (Scanner, ArrayList, HashMap, Date, etc.)
- **`java.io`** - Input/Output (File, BufferedReader, etc.)
- **`java.net`** - Networking (URL, Socket, etc.)
- **`java.sql`** - Database (Connection, Statement, ResultSet - JDBC)
- **`java.awt`** / **`javax.swing`** - GUI components
- **`java.time`** - Date and Time API (LocalDate, LocalTime, etc.)

### Examples
```java
import java.util.Scanner;        // Single class
import java.util.ArrayList;
import java.io.*;                 // All classes from java.io
import java.sql.Connection;
```

---

## Access Modifiers with Packages

| Modifier | Same Class | Same Package | Subclass (Different Package) | Other Package |
|----------|------------|--------------|------------------------------|---------------|
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| **default** (no modifier) | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

**Default (Package-Private)**: Accessible only within same package
```java
package com.company;

class Helper {  // No public - package-private
    void help() {  // Package-private method
        System.out.println("Help!");
    }
}
```

---

## Static Import

Import static members directly (methods/variables) without class name.
```java
import static java.lang.Math.*;  // Import all static members

public class Main {
    public static void main(String[] args) {
        System.out.println(sqrt(16));  // Instead of Math.sqrt(16)
        System.out.println(PI);        // Instead of Math.PI
    }
}
```

---

## Key Commands Summary
```bash
# Compile with package structure creation
javac -d <destination> <source.java>
javac -d . MyClass.java

# Compile multiple files
javac -d . com/company/utils/*.java

# Run class with package
java com.company.MainClass

# Compile with classpath (if packages in different location)
javac -cp .:lib/* Main.java
java -cp .:lib/* Main
```

---

## Common Mistakes

❌ **Wrong**: Package doesn't match directory
```
File: src/Calculator.java
Package: com.mycompany.utils  // Mismatch!
```

❌ **Wrong**: Import after class declaration
```java
public class Main { }
import java.util.Scanner;  // ERROR: must be at top
```

❌ **Wrong**: Running with wrong path
```bash
java com/company/Main.class  // Don't use slashes or .class
```

✅ **Correct**: 
```bash
java com.company.Main  // Use dots
```

---

## Summary

1. **Package declaration** → First line: `package com.company.utils;`
2. **Directory structure** → Must match package: `com/company/utils/`
3. **Compile** → `javac -d . FileName.java` (creates folders)
4. **Import** → `import com.company.utils.ClassName;`
5. **Run** → `java com.company.MainClass` (dot notation)