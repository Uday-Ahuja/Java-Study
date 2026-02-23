class main{
    main(){
        this("Constructor"); //After being called the default constructor calls a parameterized constructor
    }
    main (String message){
        System.out.println(message);
    }
}
public class Const {
    public static void main(String[] args) {
        new main(); //Calls Default Constructor
        new main("Hello");
    }
}
// Only one object created in main then used in defalut then passed in parameterized