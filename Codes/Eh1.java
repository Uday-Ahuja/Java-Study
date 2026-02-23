public class Eh1 {
    public static void main(String[] args) {
        int num1=10,num2=0;
        try{
            int result=num1/num2;
            System.out.println("Result:"+ result);
        }
        catch(ArithmeticException e){
            System.out.println("Error: Cannot Divide by Zero");
            System.out.println("Exception Message:"+ e.getMessage());
        }
        System.out.println("Out of try catch");
    }
}