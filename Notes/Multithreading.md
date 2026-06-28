Multithreading.md
markdown

# Multithreading

**Process**: Independent program execution. Separate memory, resources. Heavy-weight.

**Thread**: Lightweight process within single program. Shares memory, resources with other threads. Heavy-weight.

---

## Process vs Thread

| Feature | Process | Thread |
|---------|---------|--------|
| **Memory** | Separate | Shared |
| **Resources** | Separate | Shared |
| **Communication** | Complex (IPC) | Simple (shared memory) |
| **Creation** | Slow, heavy-weight | Fast, light-weight |
| **Context switch** | Expensive | Cheap |
| **Failure** | Isolated | Affects other threads |
| **Example** | Chrome, Firefox, Word | Multiple tabs in browser |

---

## Creating Threads

### Method 1: Extend Thread class

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

MyThread t = new MyThread();
t.start();  // Calls run() in new thread
```

### Method 2: Implement Runnable interface

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running");
    }
}

Thread t = new Thread(new MyRunnable());
t.start();
```

**Why Method 2 is better?**
- Single inheritance limitation: Can only extend one class
- Runnable allows extending another class + implementing Runnable
- More flexible

---

## start() vs run()

```java
Thread t = new Thread(() -> System.out.println("Running"));

t.start();  // ✅ Creates new thread, calls run() in new thread
t.run();    // ❌ Calls run() in current thread, no parallelism
```

---

## Thread Lifecycle
new Thread()
       ↓
    [NEW]
       ↓ start()
  [RUNNABLE] ← ready to execute
       ↓
  [RUNNING]  ← executing
       ↓
(sleep/wait/join)
       ↓
   [BLOCKED]
       ↓ (time expires / notified)
  [RUNNABLE]
       ↓
  [RUNNING]
       ↓
    [DEAD]   ← thread terminates

**States**:
- **NEW**: Thread created but not started
- **RUNNABLE**: Ready to execute (waiting for CPU)
- **RUNNING**: Currently executing
- **BLOCKED**: Waiting (sleep, wait, join, I/O)
- **DEAD**: Execution finished

---

## Thread Methods

### start()
Starts thread. Creates new stack, calls run().

```java
Thread t = new Thread(() -> System.out.println("Hello"));
t.start();
```

### run()
Contains thread's executable code. Called by start().

```java
@Override
public void run() {
    System.out.println("Executing in thread");
}
```

### sleep()
Pauses current thread for milliseconds.

```java
try {
    Thread.sleep(1000);  // Sleep for 1 second
} catch (InterruptedException e) { }
```

### join()
Main thread waits for this thread to complete.

```java
Thread t = new Thread(() -> System.out.println("Running"));
t.start();
t.join();  // Main waits for t to finish
System.out.println("t finished");
```

### yield()
Current thread gives up CPU time to other threads (suggestion, not guarantee).

```java
Thread.yield();
```

### interrupt()
Interrupts sleeping/waiting thread.

```java
Thread t = new Thread(() -> {
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        System.out.println("Interrupted");
    }
});

t.start();
t.interrupt();  // Interrupts sleep
```

---

## Example: Multiple Threads

```java
class ThreadA extends Thread {
    public void run() {
        System.out.println("Thread A running");
    }
}

class ThreadB extends Thread {
    public void run() {
        System.out.println("Thread B running");
    }
}

public class Main {
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA();
        ThreadB t2 = new ThreadB();
        
        t1.start();
        t2.start();
    }
}
```

**Output** (may vary due to scheduling):
Thread A running
Thread B running
Or:
Thread B running
Thread A running
---

## Thread Methods Reference

| Method | Purpose |
|--------|---------|
| `start()` | Start thread execution |
| `run()` | Thread's executable code |
| `sleep(ms)` | Pause thread |
| `join()` | Wait for thread to finish |
| `yield()` | Give up CPU time |
| `interrupt()` | Interrupt blocked thread |
| `getName()` | Get thread name |
| `setName(name)` | Set thread name |
| `getPriority()` | Get priority (1-10) |
| `setPriority(p)` | Set priority |
| `isAlive()` | Check if thread running |