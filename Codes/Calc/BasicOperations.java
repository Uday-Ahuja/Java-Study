package Calc;
public class BasicOperations {
    public int add(int a, int b){
        return a+b;
    }
    public int subtract(int a, int b){
        return a-b;
    }
    public int mul(int a, int b){
        return a*b;
    }
    public double divide(int a, int b) 
    {
        if (b != 0) {
            return (double) a / b;
        }
        return 0;
    }
}
