import java.util.Scanner;
public class hollowdiamond {
    public static void main(String[] args) {
        int n;
        Scanner scr=new Scanner(System.in);
        System.out.println("Enter size of diamond pattern");
        n=scr.nextInt();
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                if(j==n/2-i || j==n/2+i){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
                }
                System.out.print("\n");
            }
        for(int i=(n/2)-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(j==n/2-i || j==n/2+i){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
                }
                System.out.print("\n");
            }
        }
    }