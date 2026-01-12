import java.util.Scanner;
public class trianglepattern {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter size:");
        int n = scr.nextInt();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2*n-1; j++) {
                if(i == n-1) {
                    // Last row - fill with stars
                    System.out.print("* ");
                } else if(j == n-1-i || j == n-1+i) {
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