# ArrayList_and_Vectors.md

**ArrayList**: Dynamic array, unsynchronized, fast, 50% growth when full.

**Vector**: Dynamic array, synchronized (thread-safe), slow, 100% growth (doubles) when full.

Both implement `List` interface.

---

## ArrayList Methods

### Adding Elements

```java
ArrayList<Integer> list = new ArrayList<>();

list.add(10);              // Add at end
list.add(20);
list.add(30);
// [10, 20, 30]

list.add(1, 15);           // Add at specific index (index 1)
// [10, 15, 20, 30]
```

### Retrieving Elements

```java
int element = list.get(0);     // Get element at index 0
System.out.println(element);   // 10

for (int num : list) {         // Enhanced for loop
    System.out.println(num);
}

for (int i = 0; i < list.size(); i++) {  // Traditional for loop
    System.out.println(list.get(i));
}
```

### Modifying Elements

```java
list.set(0, 99);           // Replace element at index 0
// [99, 15, 20, 30]
```

### Removing Elements

```java
list.remove(0);            // Remove element at index 0
// [15, 20, 30]

list.remove(Integer.valueOf(20));  // Remove value 20
// [15, 30]
```

### Checking Size

```java
int size = list.size();    // Get number of elements
System.out.println(size);  // 2

boolean isEmpty = list.isEmpty();  // Check if empty
```

### Clear

```java
list.clear();              // Remove all elements
// []
```

---

## Vector Methods

Same as ArrayList (implements same List interface).

```java
Vector<Integer> vec = new Vector<>();

vec.add(10);
vec.get(0);
vec.set(0, 99);
vec.remove(0);
vec.size();
vec.isEmpty();
vec.clear();
```

**Vector-specific**:

```java
vec.capacity();            // Current capacity (may be > size)
vec.elements();            // Enumeration (legacy)
```

---

## ArrayList vs Vector - Detailed Comparison

| Feature | ArrayList | Vector |
|---------|-----------|--------|
| **Synchronization** | No (not thread-safe) | Yes (thread-safe) |
| **Performance** | Faster | Slower (due to synchronization) |
| **Growth** | 50% (10 → 15) | 100% (10 → 20) |
| **Thread-safe** | ❌ No | ✅ Yes |
| **Introduced** | Java 1.2 | Java 1.0 (legacy) |
| **Recommendation** | ✅ Use this | ❌ Avoid (outdated) |
| **Methods** | Same List interface | Same List interface |
| **Concurrent access** | Manual sync needed | Built-in sync |

---

## When to Use What

**Use ArrayList**: 
- Single-threaded applications (most cases)
- Performance critical
- No concurrent access

**Use Vector**:
- Multiple threads accessing simultaneously (but better alternatives exist)
- Legacy code compatibility

**Modern alternative** for thread-safe list:
```java
List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());
```

---