package Calc;

public class Display {
    
    public void showResult(String operation, double result) {
        System.out.println("Operation: " + operation);
        System.out.println("Result: " + result);
        System.out.println("-------------------");
    }
    
    public void showHeader() {
        System.out.println("===================");
        System.out.println("  CALCULATOR APP");
        System.out.println("===================\n");
    }
    
    public void showError(String message) {
        System.out.println("ERROR: " + message);
        System.out.println("-------------------");
    }
}