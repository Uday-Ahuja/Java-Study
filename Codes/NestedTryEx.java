public class NestedTryEx {
    public static void main(String[] args) {
        // OUTER TRY BLOCK
        try{
            System.out.println("Outer Try Block Started");
            // INNER TRY
            try{
                System.out.println("Inner Try Block Started");
                int result = 10/0;
            }
            // INNER CATCH
            catch(ArithmeticException e){
                System.out.println("Caught ArithmeticException in inner Catch block: "+ e.getMessage());
            }
            String str=null;
            System.out.println(str.length());
        }
        catch(NullPointerException e){
            System.out.println("Caught NullPointerException in Outer Catch block: "+ e.getMessage());
        }
        finally{
            System.out.println("Finally Block of Outer Try Executed");
        }
        System.out.println("Program Continues after nested try-catch block");
    }
}
