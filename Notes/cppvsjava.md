```markdown
# C++ vs Java: Major Differences

| **Aspect** | **C++** | **Java** |
|------------|---------|----------|
| **Memory Management** | Manual (`new`/`delete`). You control allocation/deallocation. Memory leaks are your responsibility. | Automatic garbage collection. JVM handles cleanup when objects unreachable. |
| **Platform Dependency** | Compiled to native machine code. Platform-specific binaries. Compile separately for each OS. | Compiled to bytecode, runs on JVM. Write once, run anywhere (WORA). JVM is platform-specific, code isn't. |
| **Execution** | Direct execution by OS. Native binary runs on hardware. | Bytecode executed by **JVM (Java Virtual Machine)**. JVM interprets/JIT-compiles bytecode to machine code. |
| **Runtime Environment** | None required. Executable runs directly. | **JRE (Java Runtime Environment)** required: JVM + core libraries + runtime components. **JDK (Java Development Kit)** = JRE + compiler + dev tools. |
| **Pointers** | Full pointer support with pointer arithmetic. Direct memory address manipulation. | No explicit pointers. References only. No pointer arithmetic. Safer, less control. |
| **Inheritance** | Multiple inheritance allowed. Can inherit from multiple classes. Diamond problem possible. | Single inheritance for classes. Multiple inheritance only via interfaces. Cleaner design. |
| **Operator Overloading** | Full operator overloading. Define `+`, `*`, `[]`, `->`, etc. for custom types. | No operator overloading (except built-in `+` for String). Simpler syntax. |
| **Templates/Generics** | **Templates**: Compile-time code generation. No type erasure. Separate code per type instantiation. | **Generics**: Type erasure at runtime. Generic info removed after compilation. Runtime type is raw/Object. |
| **Performance** | Generally faster. No VM overhead. Direct hardware access. Highly optimized native code. | JIT compilation helps, but JVM overhead exists. Startup slower. Runtime performance gap has narrowed. |
| **Exception Handling** | Exceptions optional. No checked exceptions. Less compiler enforcement. | Exceptions central. **Checked exceptions** must be declared (`throws`) or caught. Compiler enforces. |
| **Standard Library** | STL (Standard Template Library): containers, algorithms, iterators. Minimalist. | Massive standard library: Collections, I/O, networking, concurrency, **JDBC**, Swing/JavaFX, etc. |
| **Database Connectivity** | No standard API. Use vendor-specific libraries (MySQL Connector, ODBC, SQLite C++, etc.). | **JDBC (Java Database Connectivity)**: Standardized API for SQL databases. Driver-based architecture. |
| **Compilation** | Source → Native machine code (platform-specific executable). | Source → Bytecode (`.class` files, platform-independent). JVM executes bytecode. |
| **Destructor** | Explicit destructors. Called when object destroyed. Deterministic cleanup. | **Finalizers** (deprecated) or `try-with-resources`/`AutoCloseable`. Garbage collector controls timing. Non-deterministic. |
| **Preprocessor** | Has preprocessor (`#include`, `#define`, `#ifdef`). Macro support. | No preprocessor. No macros. Cleaner compilation model. |
| **Global Variables/Functions** | Supports global variables and standalone functions. | Everything must be inside a class. No true globals or standalone functions. |
| **Thread Support** | Standard threading since C++11 (`std::thread`). Platform libraries before that. | Built-in threading from start. `Thread` class, `synchronized`, concurrency utilities in `java.util.concurrent`. |
| **Goto Statement** | `goto` exists and usable. | `goto` is reserved keyword but not implemented. Cannot use. |
```