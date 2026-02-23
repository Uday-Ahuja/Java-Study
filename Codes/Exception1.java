public class Exception1 {
    public static void fun(){
        try {
            throw new NullPointerException("Demo");
        }
        catch(NullPointerException e)
        {
            System.out.println("Caught inside Fun()");
            throw e;
        }
    }
    public static void main(String[] args) {
        try{
            fun();
        }
        catch(NullPointerException e){
        System.out.println("Caught inside main()");
        }
    }   
}
