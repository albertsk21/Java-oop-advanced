
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String name = bfr.readLine();
        int age = Integer.parseInt(bfr.readLine());
        Chicken  chicken = new Chicken(name,age);


        System.out.println(chicken);

    }


}
