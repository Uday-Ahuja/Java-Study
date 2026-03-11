# ArrayList vs Vector

**ArrayList**: Unsynchronized dynamic array. Fast, not thread-safe.
**Vector**: Synchronized dynamic array. Slow, thread-safe, legacy.

## Basic Usage
```java
ArrayList<Integer> list = new ArrayList<>();
list.add(10);
list.add(20);
// [10, 20]

Vector<Integer> vec = new Vector<>();
vec.add(10);
vec.add(20);
// [10, 20]
```

## Key Differences

| Feature | ArrayList | Vector |
|---------|-----------|--------|
| **Synchronization** | No | Yes (all methods synchronized) |
| **Performance** | Faster | Slower |
| **Growth** | 50% (10 → 15) | 100% (10 → 20) |
| **Thread-safe** | ❌ | ✅ |
| **Introduced** | Java 1.2 | Java 1.0 (legacy) |

## Growth Example
```java
ArrayList<Integer> list = new ArrayList<>(10);  // capacity: 10
// Add 11th element → new capacity: 15 (50% increase)

Vector<Integer> vec = new Vector<>(10);  // capacity: 10
// Add 11th element → new capacity: 20 (100% increase)
```