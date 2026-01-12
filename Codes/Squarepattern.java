import java.util.Scanner;
public class Squarepattern {
    public static void main(String[] args) {
        int n;
        Scanner scr=new Scanner(System.in);
        System.out.println("Enter size of square pattern");
        n=scr.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0 || i==n-1 || j==0 || j==n-1){
                    System.out.print("*");
                    continue;
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}
