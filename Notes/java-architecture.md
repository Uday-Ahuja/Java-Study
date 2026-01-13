# Java Execution & Architecture Notes

## Lifecycle of JVM Execution

1. **Class Loading**: ClassLoader loads `.class` files into memory
2. **Bytecode Verification**: JVM verifies bytecode for type safety, illegal memory access, stack overflow prevention (security layer)
3. **Execution**: JVM interprets or JIT-compiles bytecode to machine code and executes

**JIT (Just-In-Time Compiler)**: Compiles frequently-used bytecode to native machine code at runtime. Executes hot code immediately without interpretation. Decreases performance gap between Java and C++/native languages that have direct OS connectivity.

## JVM Components

- **Class Loader**: Loads `.class` files into JVM memory
- **Bytecode Verifier**: Validates bytecode before execution (security)
- **Bytecode Interpreter**: Executes bytecode line-by-line (slower)
- **JIT Compiler**: Compiles hot code to native machine code (faster)
- **Heap**: Stores objects and instance variables. Shared across threads. GC operates here.
- **Method Area**: Stores class metadata, static variables, method bytecode
- **Stack**: Stores method call frames, local variables, partial results. One stack per thread.
- **Garbage Collector**: Automatically reclaims memory from unreachable objects

## JRE (Java Runtime Environment)

**Definition**: Runtime environment required to run Java applications. Includes JVM and standard libraries but does NOT contain compiler.

**Key Features**:
- **Includes JVM**: Enables execution of `.class` files
- **Java Libraries**: Core Java APIs (`java.util`, `java.io`, `java.net`, etc.) for building applications
- **Platform Specific**: Tailored to specific OS (Windows JRE, Linux JRE, Mac JRE)

## Relationship Between javac, JVM, and JRE

1. **Write Code**: Create `.java` source files
2. **Compile**: Use `javac` (compiler, part of JDK) → produces `.class` bytecode files
3. **Run**: Use JVM (part of JRE) to execute bytecode

**Flow**: Source Code → `javac` → Bytecode → JVM (in JRE) → Execution

## Features of Java

### Platform Independent
- Write once, run anywhere (WORA)
- Bytecode runs on any platform with JVM

### Secure and Robust
- **Bytecode verification**: Checks code safety before execution
- **Class loader**: Isolates system classes from user classes
- **Security manager**: Controls access to system resources
- No pointers → prevents memory corruption

### Simple
- No explicit pointers
- No pointer arithmetic
- No segmentation faults
- Automatic memory management (GC)

### Multithreading
- Built-in support for concurrent execution
- `Thread` class, `synchronized` keyword
- High-level concurrency utilities (`java.util.concurrent`)

### Portable
- Bytecode is platform-independent
- No platform-specific features in core language

### Object-Oriented
- Pure OOP (everything in classes except primitives)
- Supports inheritance, polymorphism, encapsulation, abstraction

### High Performance
- **JIT compiler** optimizes runtime performance
- Compiles hot code paths to native machine code
- Efficient for many use cases, competitive with native languages

### Distributed
- APIs like **RMI (Remote Method Invocation)** and **CORBA**
- Built-in networking support (`java.net`)
- Supports internet-based and distributed applications seamlessly

### Scalable
- Enterprise-ready (Jakarta EE, Spring)
- Handles large-scale applications effectively

### Development Framework Support
- Rich ecosystem: Spring, Hibernate, Jakarta EE, Apache frameworks
- Strong tooling and IDE support

### Statically and Strongly Typed
- **Statically typed**: Type checking at compile-time
- **Strongly typed**: Type safety enforced, no implicit dangerous conversions
- Catches type errors early