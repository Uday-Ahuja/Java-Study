public class Datatypes {
    public static void main(String[] args) {
        
        // CHAR: Stores single Unicode character (16-bit)
        char a = 'G';
        System.out.println("char: " + a);
        
        // INT: Default integer type, 32-bit (-2³¹ to 2³¹-1)
        int i = 89;
        System.out.println("integer: " + i);
        
        // BYTE: 8-bit integer (-128 to 127)
        // Use when memory is a constraint
        byte b = 4;
        System.out.println("byte: " + b);
        
        // ERROR: Value 128 exceeds byte range
        // byte b1 = 128; // Compile error: cannot convert from int to byte
        
        // SHORT: 16-bit integer (-32,768 to 32,767)
        // Use for medium-range values when saving memory
        short s = 56;
        System.out.println("short: " + s);
        
        // ERROR: Value 40000 exceeds short range
        // short s1 = 40000; // Compile error: cannot convert from int to short
        
        // DOUBLE: 64-bit floating point (default for decimals in Java)
        // By default, any decimal literal is treated as double
        double d = 4.3548732;
        System.out.println("double: " + d);
        
        // FLOAT: 32-bit floating point
        // MUST use 'f' or 'F' suffix, otherwise Java treats it as double
        float f = 4.7333343f;
        System.out.println("float: " + f);
        
        // ERROR: Missing 'f' suffix - Java assumes double by default
        // float f1 = 3.14; // Compile error: cannot convert from double to float
        
        // LONG: 64-bit integer (-2⁶³ to 2⁶³-1)
        // Use when you need to hold very large whole numbers
        // Can optionally use 'L' or 'l' suffix for clarity
        long l = 12121;
        System.out.println("long: " + l);
        
        // Example with 'L' suffix (recommended for readability with large numbers)
        long bigNumber = 9876543210L;
        System.out.println("long with L suffix: " + bigNumber);
        
        /* SUMMARY OF NUMERIC RANGES:
         * byte:   -128 to 127
         * short:  -32,768 to 32,767
         * int:    -2,147,483,648 to 2,147,483,647
         * long:   -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
         * float:  ~6-7 decimal digits precision
         * double: ~15 decimal digits precision
         */
    }
}