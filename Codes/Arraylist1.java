import java.util.ArrayList;
public class Arraylist1 {
    public static void main(String[] args) {
        ArrayList<String> fruits=new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Chery");
        fruits.add("Orange");
        for(int i=0;i<2;i++){
            System.out.println(fruits.get(i));
        }
    }
}
