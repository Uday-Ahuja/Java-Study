# RMI (Remote Method Invocation)

**RMI**: Allows Java objects to invoke methods on remote objects as if they were local.

**Purpose**: Enables client-server communication with high-level object interface.

---

## RMI Architecture
Client Side          Network          Server Side

[Stub] ←→ [RMI Registry] ←→ [Skeleton] [Remote Object]

### Components

**Stub**: Proxy object on client side. Represents remote object. Client calls methods on stub.

**Skeleton**: Receiver on server side. Receives requests from stub, forwards to actual remote object.

**Remote Reference Layer (RRL)**: Manages references made by client to remote object.

**Transport Layer**: Manages connections between client and server.

**RMI Registry**: Database storing bindings (name → remote object reference).

---

## Why Remote Interface?

**Remote interface**: Extends `java.rmi.Remote`. Declares methods that can be invoked remotely.

```java
import java.rmi.*;

public interface AddInterface extends Remote {
    public int add(int a, int b) throws RemoteException;
}
```

**Why needed?**
1. **Contract**: Specifies which methods are accessible remotely
2. **Marking**: JVM knows this interface defines remote methods
3. **Exception handling**: Forces declaration of RemoteException
4. **Type safety**: Compiler checks method signatures

---

## UnicastRemoteObject

**Purpose**: Base class for implementing remote objects. Handles serialization, stub/skeleton generation.

```java
public class AddServer extends UnicastRemoteObject implements AddInterface {
    AddServer() throws RemoteException {
        super();  // Calls UnicastRemoteObject constructor
    }
}
```

**Why extend it?**
1. Enables serialization (pass object over network)
2. Generates stub and skeleton automatically
3. Handles remote communication details

---

## RMI Registry

**Purpose**: Maps name → remote object reference. Clients lookup objects by name.

```bash
rmiregistry  # Starts on port 1099
```

**Naming class**: Used to bind/lookup objects.

```java
// Server: Register object
Naming.rebind("AddService", server);

// Client: Lookup object
AddInterface stub = (AddInterface) Naming.lookup("rmi://localhost/AddService");
```

---

## RMI Execution Steps

1. **Define Remote Interface**
```java
public interface AddInterface extends Remote {
    public int add(int a, int b) throws RemoteException;
}
```

2. **Implement with UnicastRemoteObject**
```java
public class AddServer extends UnicastRemoteObject implements AddInterface {
    public int add(int a, int b) {
        return a + b;
    }
}
```

3. **Create Server Program**
```java
public static void main(String[] args) {
    try {
        AddServer server = new AddServer();
        Naming.rebind("AddService", server);
        System.out.println("Server ready");
    } catch (Exception e) { }
}
```

4. **Create Client Program**
```java
public static void main(String[] args) {
    try {
        AddInterface stub = (AddInterface) Naming.lookup("rmi://localhost/AddService");
        int result = stub.add(10, 20);
        System.out.println("Sum: " + result);
    } catch (Exception e) { }
}
```

5. **Compile All**
```bash
javac AddInterface.java
javac AddServer.java
javac AddClient.java
```

6. **Run**
```bash
# Terminal 1
rmiregistry

# Terminal 2
java AddServer

# Terminal 3
java AddClient
```

---

## RMI vs Socket

| Feature | RMI | Socket |
|---------|-----|--------|
| **Level** | High-level (objects) | Low-level (bytes) |
| **Data** | Java objects | Streams, bytes |
| **Serialization** | Automatic | Manual |
| **Speed** | Slower (serialization overhead) | Faster |
| **Complexity** | Less code | More code |
| **Language** | Java only | Any language |
| **Setup** | Complex (registry, stubs) | Simple |
| **Firewall** | Issues (dynamic ports) | Better |
| **Use case** | Distributed Java apps | Custom protocols |

---

## RMI Limitations

- **Java-only**: Not language independent (unlike sockets)
- **Serialization overhead**: Slower than sockets
- **Complex setup**: Requires registry, interface, skeleton/stub
- **Firewall issues**: Dynamic port allocation causes firewall problems