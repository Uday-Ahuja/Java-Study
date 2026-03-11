import Calc.BasicOperations;
import Calc.AdvancedOperations;
import Calc.Display;  
public class RunCalc {
    public static void main(String[] args) {
        
        BasicOperations basic = new BasicOperations();
        AdvancedOperations advanced = new AdvancedOperations();
        Display display = new Display();
        
        display.showHeader();
        
        System.out.println("--- BASIC OPERATIONS ---");
        display.showResult("10 + 5", basic.add(10, 5));
        display.showResult("10 - 5", basic.subtract(10, 5));
        display.showResult("10 * 5", basic.mul(10, 5));
        display.showResult("10 / 5", basic.divide(10, 5));
        
        double divResult = basic.divide(10, 0);
        if (divResult == 0) {
            display.showError("Division by zero");
        }
        
        System.out.println("\n--- ADVANCED OPERATIONS ---");
        display.showResult("2 ^ 3", advanced.power(2, 3));
        display.showResult("√16", advanced.root(16));
        display.showResult("5!", advanced.factorial(5));
    }
}
