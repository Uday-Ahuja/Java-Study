// Custom Unchecked Exception
class DivideByZeroException extends RuntimeException{
    public DivideByZeroException(){
        super("Division by zero is not allowed.");
    }
}
// Using the Custom Exception
public class EXCP_unchecked {

    public static void divide(int a, int b) {
        if (b == 0) {
            throw new DivideByZeroException();
        }
        System.out.println("Result: " + (a / b));
    }

    public static void main(String[] args) {
        try {
            divide(10, 0);
        } catch (DivideByZeroException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}