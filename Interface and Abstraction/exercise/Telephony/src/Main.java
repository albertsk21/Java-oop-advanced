import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader bfr =  new BufferedReader(new InputStreamReader(System.in));
        List<String> number = addElements(bfr);
        List<String> urls = addElements(bfr);



        Smartphone smartphone =  new Smartphone(number,urls);
        System.out.println( smartphone.call());
        System.out.println(smartphone.browse());


    }


    public static List<String> addElements(BufferedReader bfr) throws IOException {

        String[] input =  bfr.readLine().split(" ");


        List<String> output = new ArrayList<>();
        for (String item : input) {
            output.add(item);
        }

        return output;

    }
}