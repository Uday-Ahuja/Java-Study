public class MultipleExceptionsSingleCatch {
    public static void main(String[] args) {
        try{
            String str="123a";
            int num = Integer.parseInt(str);
            int result = 10/0;
        }
        catch(NumberFormatException|ArithmeticException e){
            System.out.println("Error: "+ e.getClass().getSimpleName()+" Occured.");
        }
        System.out.println("program continues after exception handling");
    }
}
