# Socket Programming

**Socket**: Endpoint for network communication. One end of two-way connection between client and server.

**Purpose**: Enables data exchange between applications over network using TCP/IP protocol.

---

## Client-Server Model

**Server**: Listens on port, waits for client connection.

**Client**: Initiates connection to server.

Server (listening on port 6666)
↑
| (client connects)
↓
Client (initiates connection)
---

## ServerSocket Class

Creates server-side socket. Listens and accepts client connections.

```java
ServerSocket ss = new ServerSocket(6666);  // Listen on port 6666
System.out.println("Server waiting...");

Socket s = ss.accept();                     // Accept client connection
System.out.println("Client connected");
```

**Key methods**:
- `accept()` - blocks until client connects, returns Socket
- `close()` - close server socket

---

## Socket Class

Represents connection between client and server.

```java
Socket s = new Socket("localhost", 6666);  // Connect to server
System.out.println("Connected to server");
s.close();
```

**Key methods**:
- `getInputStream()` - receive data
- `getOutputStream()` - send data
- `getPort()` - remote port
- `getLocalPort()` - local port
- `getInetAddress()` - remote IP
- `getLocalAddress()` - local IP
- `close()` - close connection

---

## DataInputStream and DataOutputStream

High-level streams for reading/writing data types.

```java
DataInputStream dis = new DataInputStream(s.getInputStream());
DataOutputStream dos = new DataOutputStream(s.getOutputStream());

// Send data
dos.writeInt(10);
dos.writeDouble(3.14);

// Receive data
int num = dis.readInt();
double value = dis.readDouble();
```

---

## Socket Programming Steps

1. **Server**: Create ServerSocket, listen
2. **Client**: Create Socket, connect to server
3. **Server**: Accept connection, get streams
4. **Communication**: Exchange data via streams
5. **Close**: Close all connections

---

## Example: Server and Client

**Server.java**

```java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server started");
            
            Socket s = ss.accept();
            System.out.println("Client connected");
            
            // Get streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            
            // Read two numbers
            int num1 = dis.readInt();
            int num2 = dis.readInt();
            
            // Add and send result
            int sum = num1 + num2;
            dos.writeInt(sum);
            
            System.out.println("Sent result: " + sum);
            
            ss.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
```

**Client.java**

```java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 6666);
            
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            
            // Send two numbers
            dos.writeInt(10);
            dos.writeInt(20);
            
            // Receive result
            int result = dis.readInt();
            System.out.println("Sum: " + result);
            
            s.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
```

**Run**:
```bash
# Terminal 1 - Server
javac Server.java
java Server

# Terminal 2 - Client
javac Client.java
java Client
```

---

## Socket Methods Reference

| Method | Returns | Purpose |
|--------|---------|---------|
| `getPort()` | int | Remote port socket is bound to |
| `getLocalPort()` | int | Local port socket is bound to |
| `getInetAddress()` | InetAddress | Remote IP address |
| `getLocalAddress()` | InetAddress | Local IP address |
| `getRemoteSocketAddress()` | SocketAddress | Remote socket address |
| `getLocalSocketAddress()` | SocketAddress | Local socket address |
| `getInputStream()` | InputStream | Input stream for receiving data |
| `getOutputStream()` | OutputStream | Output stream for sending data |
| `close()` | void | Close socket connection |

---

## Socket vs RMI

| Feature | Socket | RMI |
|---------|--------|-----|
| **Level** | Low-level | High-level |
| **Data type** | Bytes/Streams | Java objects |
| **Serialization** | Manual | Automatic |
| **Speed** | Faster | Slower |
| **Complexity** | More code | Less code |
| **Language** | Any language | Java only |
| **Use case** | Custom protocols, text/binary data | Distributed Java objects |