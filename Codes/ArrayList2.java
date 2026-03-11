import java.util.ArrayList;

public class ArrayList2 {
    public static void main(String[] args) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        // Add elements to list
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("After adding elements: " + list);
        
        // Get element at index
        int element = list.get(1);
        System.out.println("Element at index 1: " + element);
        System.out.println(list);
        
        // Add element in between (at index 2)
        list.add(2, 25);
        System.out.println("After adding 25 at index 2: " + list);
        
        // Set element (replace at index 1)
        list.set(1, 99);
        System.out.println("After setting index 1 to 99: " + list);
        
        // Delete element (remove at index 0)
        list.remove(0);
        System.out.println("After removing index 0: " + list);
        
        // Size of list
        int size = list.size();
        System.out.println("Size of list: " + size);
        System.out.println(list);
        
        // Loop through and print
        System.out.print("Loop output: ");
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Print in general way
        System.out.println("Final list: " + list);
    }
}