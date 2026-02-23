import java.util.Vector;
public class Vectorex1 {
    public static void main(String[] args) {
        Vector<Integer> numbers=new Vector<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println("Vector:"+ numbers);
        numbers.remove(1);
        System.out.println("Vector after removal at index 1:"+ numbers);
        System.out.println("Size:"+ numbers.size());
        System.out.println("Element at index 0:"+ numbers.get(0));
}
}