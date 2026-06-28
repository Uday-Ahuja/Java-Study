# Thread Synchronization

**Synchronization**: Mechanism to control access to shared resources when multiple threads access simultaneously.

**Problem**: Race condition - multiple threads modifying shared data causes inconsistency.

```java
int count = 0;

// Thread 1: count++
// Thread 2: count++

// Expected: count = 2
// Actual: count = 1 (race condition)
```

---

## synchronized Keyword

### Synchronized Method

Entire method is locked. Only one thread can execute at a time.

```java
class Counter {
    int count = 0;
    
    synchronized void increment() {  // Lock on this object
        count++;
    }
}

Counter c = new Counter();
c.increment();  // Thread 1
c.increment();  // Thread 2 (waits if Thread 1 executing)
```

### Synchronized Block

Only specified block is locked. Finer control.

```java
class Counter {
    int count = 0;
    
    void increment() {
        synchronized(this) {  // Lock on this object
            count++;
        }
        // Other code (not synchronized)
    }
}
```

---

## How Synchronization Works

Every object has an intrinsic lock (monitor). Only one thread can hold lock at a time.

```java
synchronized void method() {
    // Acquire lock on this object
    // ... execute code ...
    // Release lock
}
```

**Thread flow**:
1. Thread tries to enter synchronized block
2. If lock available: acquire, execute, release
3. If lock held: wait in queue
4. When lock released: next thread in queue acquires

---

## wait(), notify(), notifyAll()

Inter-thread communication. Threads signal each other.

```java
synchronized void method() {
    wait();          // Release lock, wait for notification
    notify();        // Wake one waiting thread
    notifyAll();     // Wake all waiting threads
}
```

**Must be in synchronized context**:

```java
synchronized(obj) {
    obj.wait();
    obj.notify();
}
```

---

## Producer-Consumer Problem

**Classic synchronization problem**:
- Producer: Produces data, puts in buffer
- Consumer: Takes data from buffer
- Buffer: Shared, limited size

```java
class Buffer {
    int data = -1;
    boolean empty = true;
    
    synchronized void produce(int value) {
        while (!empty) {
            try { wait(); } catch (Exception e) { }
        }
        data = value;
        empty = false;
        notify();  // Wake consumer
    }
    
    synchronized int consume() {
        while (empty) {
            try { wait(); } catch (Exception e) { }
        }
        int value = data;
        empty = true;
        notify();  // Wake producer
        return value;
    }
}
```

---

## Deadlock

**Deadlock**: Two threads waiting for each other indefinitely.

```java
Object lock1 = new Object();
Object lock2 = new Object();

// Thread 1
synchronized(lock1) {
    Thread.sleep(100);
    synchronized(lock2) {  // Waiting for lock2
    }
}

// Thread 2
synchronized(lock2) {
    Thread.sleep(100);
    synchronized(lock1) {  // Waiting for lock1
    }
}

// Deadlock: T1 has lock1, wants lock2. T2 has lock2, wants lock1.
```

**Prevention**:
- Always acquire locks in same order
- Use timeout
- Avoid nested locks

---

## Thread Safety

**Thread-safe**: Safe concurrent access without external synchronization.

**Example**:
```java
// Not thread-safe
ArrayList<String> list = new ArrayList<>();

// Thread-safe
List<String> list = Collections.synchronizedList(new ArrayList<>());
```

---

## volatile Keyword

Indicates variable may be modified by multiple threads. Forces reading from memory (not cache).

```java
class Flag {
    volatile boolean stop = false;  // Visible across threads
}
```

---

## synchronized vs volatile

| Feature | synchronized | volatile |
|---------|--------------|----------|
| **Use case** | Block/method access | Single variable |
| **Lock** | Yes | No |
| **Performance** | Slower (locks) | Faster |
| **Atomicity** | Yes | No (read/write only) |
| **Scope** | Block/method | Single variable |

```java
// synchronized: Locks
synchronized void increment() {
    count++;  // Atomic
}

// volatile: Visibility only
volatile int count = 0;
count++;  // NOT atomic (read, increment, write - 3 operations)
```

---

## Thread Synchronization Reference

| Mechanism | Purpose | When to use |
|-----------|---------|------------|
| `synchronized` | Mutual exclusion | Protecting shared resources |
| `wait()` | Thread waiting | Waiting for condition |
| `notify()` | Wake one thread | Signal thread to continue |
| `notifyAll()` | Wake all threads | Signal all threads |
| `volatile` | Visibility | Simple flag variables |
| `join()` | Wait for thread | Wait for completion |