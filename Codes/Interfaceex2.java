interface Lib{
    void issue();
}
class  book implements Lib
{
    int isbn;
    float price;
    book(int a,float b){
        isbn=a;
        price=b;
    }
    void Details(){
        System.out.println("ISBN:"+ this.isbn);
        System.out.println("Price:"+ this.price);
    }
    public void issue(){
        System.out.println("Issue-Able Entity");
    }
}
class cd implements Lib
{
    float Duration,price;
    cd(float a, float b){
        Duration=a;
        price=b;
    }
    void Info(){
        System.out.println("Duration:"+ this.Duration);
        System.out.println("Price:"+ this.price);
    }
    public void issue(){
        System.out.println("Issue-Able Entity");
    }
}
public class Interfaceex2 {
    public static void main(String[] args) {
        book b=new book(2,4);
        cd c=new cd(2,4);
        b.Details();
        b.issue();
        c.Info();
        c.issue();
    }
}