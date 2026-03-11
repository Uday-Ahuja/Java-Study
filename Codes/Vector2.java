import java.util.Vector;

public class Vector2 {
    public static void main(String[] args) {
        
        Vector<Integer> vec = new Vector<>();
        
        // Add elements
        vec.add(10);
        vec.add(20);
        vec.add(30);
        System.out.println("After add: " + vec);
        
        // Add at index
        vec.add(1, 15);
        System.out.println("After add at index 1: " + vec);
        
        // Get element
        int element = vec.get(2);
        System.out.println("Element at index 2: " + element);
        
        // Set at index
        vec.set(0, 99);
        System.out.println("After set index 0 to 99: " + vec);
        
        // Size
        System.out.println("Size: " + vec.size());
        
        // Remove element by index
        vec.remove(1);
        System.out.println("After remove index 1: " + vec);
        
        // Remove element by value
        vec.remove(Integer.valueOf(30));
        System.out.println("After remove value 30: " + vec);
        
        // isEmpty
        System.out.println("Is empty: " + vec.isEmpty());
        
        // Clear
        vec.clear();
        System.out.println("After clear: " + vec);
        System.out.println("Is empty: " + vec.isEmpty());
    }
}