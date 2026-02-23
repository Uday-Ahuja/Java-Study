
# Garbage Collection in Java

## What is Garbage Collection?

Automatic process where JVM reclaims memory occupied by **unreachable objects** (objects no longer referenced by any variable). You don't manually free memory like C++ (`delete`).
```java
String str = "Hello";
str = "World";  // "Hello" object is now unreachable → eligible for GC
```

---

## How GC Knows What to Collect?

Object becomes eligible for GC when:
- No variable references it
- Reference set to `null`
- Object goes out of scope
```java
void method() {
    Student s = new Student();  // Object created
}
// Method ends → s out of scope → Student object eligible for GC
```

---

## Heap Structure (How Memory is Divided)
```
HEAP
├── Young Generation
│   ├── Eden Space      (new objects born here)
│   ├── Survivor S0     (survived 1+ GC cycles)
│   └── Survivor S1
└── Old Generation      (long-lived objects)
```

### Young Generation
- All new objects created here (Eden Space)
- **Minor GC**: Collects young generation frequently
- Short-lived objects (local vars, temp objects) die here
- Survivors move to Survivor spaces (S0/S1)
- After surviving multiple cycles → promoted to Old Generation

### Old Generation
- Long-lived objects that survived multiple Minor GCs
- **Major GC / Full GC**: Collects old generation (less frequent, slower)

---

## Types of Garbage Collectors

### 1. Serial GC
**Best for**: Small heaps, single-threaded, low-resource environments

**How it works**:
- Uses **single thread** for all GC activity
- **Stop-the-World**: Application completely pauses during GC
- Collects Young Generation first, then Old Generation if needed
- Simple, no multi-threading overhead

**Problem**: Pause times can be significant for large heaps
```
Application → STOP → GC runs (single thread) → RESUME
```

**Use when**: Small applications, limited memory, low concurrency needs

---

### 2. Partial GC
**Not a specific collector** - a concept/term describing collecting **only part of the heap** instead of full heap.

**Types**:
- **Minor GC**: Collects only Young Generation (fast, frequent)
- **Major GC**: Collects only Old Generation (slower, less frequent)
- **Full GC**: Collects entire heap (slowest, avoid if possible)

**Why Partial?**: Young generation has mostly short-lived objects → faster to collect only that part

---

### 3. G1 GC (Garbage First)
**Introduced**: JDK 7

**Best for**: Multi-threaded applications with large heaps

**How it works**:
- Heap divided into **flexible regions** (not fixed Young/Old split)
- Runs **concurrently** (background, while app runs)
- Collects regions with most garbage first (hence "Garbage First")
- User can specify **maximum pause time target**

**Phases**:
- **Young GC**: Collects Eden + Survivor spaces
- **Mixed GC**: Collects Young Generation + some Old Generation regions
- **Full GC**: Entire heap (triggered rarely)

**Advantage over Serial GC**: Lower pause times, handles large heaps better
```
Application runs → GC runs in background concurrently → Short pauses only
```

**Use when**: Large heaps, multi-threaded server applications

---

### 4. ZGC (Z Garbage Collector)
**Introduced**: JDK 11 (JEP 333)

**Best for**: Extremely low-latency applications with very large heaps

**How it works**:
- **Sub-millisecond** pause times (almost no stop-the-world)
- Region-based like G1 but far more concurrent
- Can handle **multi-terabyte heaps**
- Almost all GC work done concurrently with application

**Use when**:
- Real-time systems
- High-frequency trading
- Databases
- Heaps over 10 GB
- Latency is critical
```
Application runs → Almost everything done concurrently → Barely noticeable pauses
```

---

## Comparison Table

| Feature | Serial GC | G1 GC | ZGC |
|---------|-----------|-------|-----|
| **Threads** | Single | Multiple | Multiple |
| **Pause Time** | High | Medium (predictable) | Sub-millisecond |
| **Heap Size** | Small | Medium-Large | Very Large (TB) |
| **Concurrency** | None | Partial | Almost fully concurrent |
| **Introduced** | Original | JDK 7 | JDK 11 |
| **Best For** | Simple apps | Server apps | Low-latency apps |
| **Complexity** | Simple | Moderate | Complex |

---

## Stop-the-World Event

All GC types have Stop-the-World (STW) pauses to some degree:
- **Serial GC**: Long STW pauses (everything stops)
- **G1 GC**: Short, predictable STW pauses
- **ZGC**: Sub-millisecond STW pauses (barely noticeable)
```
Stop-the-World = Application completely freezes while GC runs
```

**Why needed?**: GC needs consistent snapshot of memory to safely collect objects

---

## GC Progression (Simpler → Advanced)
```
Serial GC → G1 GC → ZGC
(Simple)    (Balanced)  (Low-latency)
```

**Default GC in modern Java (Java 9+)**: G1 GC