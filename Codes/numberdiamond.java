import java.util.Scanner;
public class numberdiamond {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter size:");
        int n = scr.nextInt();
        
        // Upper half including middle
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(j <= i || j > n - i) {
                    System.out.print(i);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
        // Lower half
        for(int i = n - 1; i >= 1; i--) {
            for(int j = 1; j <= n; j++) {
                if(j <= i || j > n - i) {
                    System.out.print(i);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
        scr.close();
    }
}