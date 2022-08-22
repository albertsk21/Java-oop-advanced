package p03_IteratorTest;

import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainListIterator {
    public static void main(String[] args) throws IOException, OperationNotSupportedException {


        BufferedReader bfr =  new BufferedReader(new InputStreamReader(System.in));


        String[] input = bfr.readLine().split(" ");


        ListIterator listIterator = null;

        while(!input[0].equals("END")){

            if(input[0].equals("Create")){
                String[] currentArray = deleteWordCreate(input);
                listIterator = new ListIterator(currentArray);
            }else if(input[0].equals("HasNext")){


                System.out.println(listIterator.hasNext());
            }else if(input[0].equals("Print")){

                try{
                    System.out.println(listIterator.print());
                }catch (IllegalStateException e){
                    System.out.println(e.getMessage());
                }
            }else if(input[0].equals("Move")){


                System.out.println(listIterator.move());
            }


            input = bfr.readLine().split(" ");
        }



    }

    public static String[] deleteWordCreate(String[] input){
        input[0] = null;
        String[] output = new String[input.length-1];

        int currentIndex = 0;
        for (int i = 1; i < input.length ; i++) {
            output[currentIndex] = input[i];
            currentIndex++;
        }

        return output;
    }
}
