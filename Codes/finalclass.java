final class pa{
    pa(){
        System.out.println("Pa Called");
    }
}
class kid // class kid extends pa {} // Compile-time error: cannot inherit from final class
{
    kid(){
        System.out.println("Kid Called");
        System.out.println("Kid cannot extend pa as pa is final classs");
    }
}
public class finalclass {
    public static void main(String[] args) {
        pa p = new pa();
        kid k= new kid();
    }
}
