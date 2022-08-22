
public class Main {

    public static void main(String[] args){


        StackOfStrings stackOfStrings =  new StackOfStrings();
        stackOfStrings.push("a");
        stackOfStrings.push("b");
        stackOfStrings.push("c");



        while(!(stackOfStrings.isEmpty())){


            System.out.println(stackOfStrings.pop());

        }
    }

}
