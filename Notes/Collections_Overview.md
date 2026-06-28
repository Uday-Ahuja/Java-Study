**Collections Framework**: Standard APIs for storing and manipulating groups of objects.

Built on three main interfaces: **List**, **Set**, **Map**.

---

## List Interface

Ordered, allows duplicates. Maintains insertion order.

**Implementations**:
- `ArrayList` - dynamic array, fast access
- `Vector` - synchronized, slow (legacy)
- `LinkedList` - linked list, fast insertion/deletion

**Key methods**: `add()`, `get()`, `remove()`, `set()`, `size()`

```java
List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Apple");  // Duplicates allowed
// [Apple, Banana, Apple]

String first = list.get(0);     // Apple
list.remove(1);                 // Removes "Banana"
```

---

## Set Interface

Unordered, no duplicates. Each element unique.

**Implementations**:
- `HashSet` - no order, fastest
- `TreeSet` - sorted order

**Key methods**: `add()`, `remove()`, `contains()`, `size()`

```java
Set<String> set = new HashSet<>();
set.add("Apple");
set.add("Banana");
set.add("Apple");   // Duplicate ignored
// {Apple, Banana} - order not guaranteed

boolean contains = set.contains("Apple");  // true
```

---

## Map Interface

Key-value pairs. Each key unique.

**Implementations**:
- `HashMap` - no order, fastest
- `TreeMap` - sorted by key

**Key methods**: `put()`, `get()`, `remove()`, `keySet()`, `values()`, `entrySet()`

```java
Map<String, Integer> map = new HashMap<>();
map.put("Alice", 85);
map.put("Bob", 90);
map.put("Alice", 88);   // Updates Alice's value to 88
// {Alice=88, Bob=90}

int score = map.get("Alice");  // 88
map.remove("Bob");
```

---

## Hierarchy

```
Collection
├── List
│   ├── ArrayList
│   ├── Vector
│   └── LinkedList
├── Set
│   ├── HashSet
│   └── TreeSet
└── Map (separate)
    ├── HashMap
    └── TreeMap
```

---

## Collections Comparison Quick Reference

| Interface | Ordered | Duplicates | Key Method |
|-----------|---------|-----------|-----------|
| **List** | ✅ Yes | ✅ Yes | `get(index)` |
| **Set** | ❌ No | ❌ No | `add()` |
| **Map** | ❌ No | Keys unique | `put(key, value)` |

---