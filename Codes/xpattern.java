import java.util.Scanner;
public class xpattern {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter size:");
        int n = scr.nextInt();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j == i || j == n - 1 - i) {
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