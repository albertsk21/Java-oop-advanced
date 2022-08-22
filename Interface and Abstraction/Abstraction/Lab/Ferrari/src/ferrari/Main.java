package ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr =  new BufferedReader( new InputStreamReader(System.in));


        String driver = bfr.readLine();

        Car car = new Ferrari(driver);
        System.out.println(car);

    }
}
