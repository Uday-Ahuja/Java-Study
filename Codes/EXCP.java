// Custom Checked Exception
class InvalidAgeException extends Exception{
    public InvalidAgeException(String m){
        super(m);
    }
}
public class EXCP {
    public static void validate(int age) throws InvalidAgeException
    {
        if(age<18){
            throw new InvalidAgeException("Age Must be 18 or above");
        }
        System.out.println("Valid Age: "+age);
    }
    public static void main(String[] args) {
        try{
            validate(12);
        }
        catch(InvalidAgeException e){
            System.out.println("Caught Exception: "+ e.getMessage());
        }
    }
}