import java.util.Scanner;
public class invertedtriangle {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter size:");
        int n = scr.nextInt();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2*n-1; j++) {
                if(i == 0) {
                    // First row - fill with stars
                    System.out.print("* ");
                } else if(j == i || j == 2*n-2-i) {
                    // Hollow sides
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        
        scr.close();
    }
}