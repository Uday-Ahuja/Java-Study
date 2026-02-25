
public class ChainedException {
    public static void main(String[] args) {
        try{
            int[] n=new int[5];
            int divisor=0;
            for(int i=0;i<n.length;i++){
                int res=n[i]/divisor;
            }
        }
        catch(ArithmeticException e){
            // creating a new exception with the original as the cause
            throw new RuntimeException("Error: Divison by Zero Occured",e);
        }
    }
}
