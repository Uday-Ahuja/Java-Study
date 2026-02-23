public class Arrayex1 {
    public static void main(String[] args) {
        int[] numbers={10,20,30,40,50};
        int[] numbers1={10,20,30,40,50};
        int[] numbers2={10,20,30,40,50};

        /*for(int i=0;i<numbers.length;i++){
            System.out.println(numbers[i]);
        }*/

        // enhanced for loop
        for(int num : numbers){
            System.out.print(num+" ");
        }
        System.out.println(" ");
        for(int num : numbers1){
            System.out.print(num+" ");
        }
        System.out.println(" ");
        for(int num : numbers2){
            System.out.print(num+" ");
        }
        System.out.println(" ");
    }
}
