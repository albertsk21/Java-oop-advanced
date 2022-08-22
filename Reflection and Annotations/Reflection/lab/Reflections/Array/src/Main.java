import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args){

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String[] stringArray = (String[]) Array.newInstance(String.class,4);
        Array.set(stringArray,0, "String Arraaaay");
        System.out.println(stringArray[0]);


        int[] intArray = (int[]) Array.newInstance(int.class,5);
        Array.set(intArray,0,323);
        System.out.println(intArray[0]);

    }
}
