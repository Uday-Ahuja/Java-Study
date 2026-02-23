class pa{
    pa(){
        System.out.println("Pa Called");
    }
}
final class kid extends pa
{
    kid(){
        super();
        System.out.println("Kid Called");
    }
}
public class finalclass2 {
    public static void main(String[] args) {
        kid k= new kid();
    }
}