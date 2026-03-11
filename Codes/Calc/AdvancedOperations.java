package Calc;
public class AdvancedOperations {
    public double power(double a, double b)
    {
         return Math.pow(a,b);
    }   
    public double root(double a){
        return Math.sqrt(a);
    }
    public int factorial(int a) {
        if (a <= 1) {
            return 1;
        }
        return a * factorial(a - 1);
    }
}