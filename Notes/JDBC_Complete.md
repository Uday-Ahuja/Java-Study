# JDBC

**JDBC (Java Database Connectivity)**: Standard API to connect Java applications to databases.

---

## Why JDBC?

- Standard way to communicate with databases
- Database-independent (same code, different drivers)
- Execute SQL queries from Java code

---

## JDBC Driver Types

### Type 1: JDBC-ODBC Bridge
- Translates JDBC calls to ODBC calls
- Slow, requires ODBC on system
- Rarely used

### Type 2: Native Driver
- Translates JDBC calls to native database API
- Faster than Type 1
- Platform-dependent

### Type 3: Network Protocol Driver
- Translates JDBC calls to database-independent network protocol
- Works through middleware
- Moderate performance

### Type 4: Thin Driver (Most Used)
- Pure Java, directly communicates with database
- Fastest, no platform dependencies
- Example: `mysql-connector-j-9.6.0.jar`

```java
// Type 4 driver for MySQL
Class.forName("com.mysql.cj.jdbc.Driver");  // Old way
// New way: Not needed with modern JDBC
```

---

## JDBC Components

### DriverManager
Manages JDBC drivers. Loads drivers, creates connections.

```java
Class.forName("com.mysql.cj.jdbc.Driver");  // Load driver
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/database_name",
    "root",
    "password"
);
```

### Connection
Represents connection to database.

```java
Connection con = DriverManager.getConnection(url, user, password);
// Use connection to create statements
con.close();  // Close when done
```

### Statement
Executes SQL queries.

```java
Statement stmt = con.createStatement();
```

**Types**:

**1. Statement**: Basic, not recommended for parameters (SQL injection risk).

```java
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
stmt.execute("INSERT INTO Student VALUES (1, 'Alice')");
```

**2. PreparedStatement**: Pre-compiled, parameters via `?`. Safe, reusable.

```java
PreparedStatement ps = con.prepareStatement("INSERT INTO Student VALUES (?, ?)");
ps.setInt(1, 1);
ps.setString(2, "Alice");
ps.executeUpdate();
```

**3. CallableStatement**: Calls stored procedures.

```java
CallableStatement cs = con.prepareCall("{call procedure_name(?)}");
cs.setInt(1, value);
cs.execute();
```

---

## Execute Methods

### executeQuery()
Returns `ResultSet`. Used for SELECT queries.

```java
PreparedStatement ps = con.prepareStatement("SELECT * FROM Student WHERE id = ?");
ps.setInt(1, 1);
ResultSet rs = ps.executeQuery();  // Returns ResultSet

while (rs.next()) {
    int id = rs.getInt("id");
    String name = rs.getString("name");
}
```

### executeUpdate()
Returns count of affected rows (int). Used for INSERT, UPDATE, DELETE.

```java
PreparedStatement ps = con.prepareStatement("UPDATE Student SET name = ? WHERE id = ?");
ps.setString(1, "Bob");
ps.setInt(2, 1);
int rows = ps.executeUpdate();  // Returns 1 (1 row updated)
```

### execute()
Can execute any SQL. Returns boolean (true if ResultSet, false if update count).

```java
Statement stmt = con.createStatement();
boolean hasResult = stmt.execute("SELECT * FROM Student");

if (hasResult) {
    ResultSet rs = stmt.getResultSet();
} else {
    int count = stmt.getUpdateCount();
}
```

---

## ResultSet

Holds query results. Navigate with cursor.

```java
ResultSet rs = stmt.executeQuery("SELECT * FROM Student");

while (rs.next()) {
    int id = rs.getInt("id");           // Get by column name
    int id2 = rs.getInt(1);             // Get by column index (1-based)
    String name = rs.getString("name");
    
    System.out.println(id + " " + name);
}
```

**Cursor movement**:
- `next()` - moves to next row
- `previous()` - moves to previous row
- `first()`, `last()` - move to first/last row

---

## JDBC Steps (Sequence)

1. **Load Driver** (Modern JDBC doesn't require this, but legacy code needs it)
```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

2. **Establish Connection**
```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/company_db",
    "root",
    "password"
);
```

3. **Create Statement** (Use PreparedStatement for safety)
```java
PreparedStatement ps = con.prepareStatement(
    "INSERT INTO Employee (id, name, salary) VALUES (?, ?, ?)"
);
```

4. **Set Parameters**
```java
ps.setInt(1, 101);
ps.setString(2, "Alice");
ps.setDouble(3, 50000);
```

5. **Execute Query**
```java
int rows = ps.executeUpdate();  // or executeQuery() for SELECT
```

6. **Process Results** (if SELECT)
```java
ResultSet rs = ps.executeQuery();
while (rs.next()) {
    System.out.println(rs.getString("name"));
}
```

7. **Close Resources** (in reverse order)
```java
rs.close();      // Close ResultSet
ps.close();      // Close Statement
con.close();     // Close Connection
```

---

## Driver Loading: Old vs New

### Old Way (Still Works)
```java
Class.forName("com.mysql.cj.jdbc.Driver");
```
Explicitly loads driver class. Constructor registers driver with DriverManager.

### New Way (JDBC 4.0+, Modern)
```java
// No Class.forName() needed
Connection con = DriverManager.getConnection(url, user, password);
```
Drivers auto-loaded from classpath via SPI (Service Provider Interface). DriverManager finds registered drivers automatically.

**Behind the scenes**: JAR file contains `META-INF/services/java.sql.Driver` listing driver class. JVM auto-loads on startup.

---

## Statement vs PreparedStatement vs CallableStatement

| Feature | Statement | PreparedStatement | CallableStatement |
|---------|-----------|-------------------|-------------------|
| **SQL type** | Any SQL | Parameterized SQL | Stored procedures |
| **Parameters** | Hardcoded strings | `?` placeholders, type-safe | `?` + `{call}` |
| **Compilation** | Compiled each time | Pre-compiled once | Pre-compiled |
| **Reusability** | Not reusable | Reusable | Reusable |
| **SQL Injection** | ❌ Vulnerable | ✅ Safe | ✅ Safe |
| **Performance** | Slower (multiple compiles) | Faster | Fastest |
| **When to use** | Simple one-time queries | User input, repeated queries | Database functions |

```java
// Statement - vulnerable
String name = "Alice'; DROP TABLE Student;--";
stmt.execute("INSERT INTO Student VALUES ('" + name + "')");  // ❌ SQL injection

// PreparedStatement - safe
ps = con.prepareStatement("INSERT INTO Student VALUES (?)");
ps.setString(1, name);  // ✅ Safe - parameter treated as data, not SQL
ps.execute();
```

---

## JDBC Example: Update Salary

```java
import java.sql.*;

public class UpdateSalary {
    public static void main(String[] args) {
        try {
            // Step 1: Establish connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/company_db",
                "root",
                "password"
            );
            
            // Step 2: Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(
                "UPDATE Employee SET salary = ? WHERE empid = ?"
            );
            
            // Step 3: Set parameters
            ps.setDouble(1, 55000);  // New salary
            ps.setInt(2, 101);       // Employee ID
            
            // Step 4: Execute
            int rows = ps.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Salary updated successfully");
            }
            
            // Step 5: Close resources
            ps.close();
            con.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
```

---