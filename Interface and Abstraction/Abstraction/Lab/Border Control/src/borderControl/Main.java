package borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr =  new BufferedReader( new InputStreamReader(System.in));


        List<Identifiable> list =  new ArrayList<>();
        while (true){


            String[] input = bfr.readLine().split(" ");

            if(input[0].equals("End")){
                break;
            }

            if(input.length == 2){
                 String model = input[0];
                 String id = input[1];

                 Robot robot =  new Robot(id,model);
                 list.add(robot);

            }else if(input.length == 3){

                String name = input[0];
                int age = Integer.parseInt(input[1]);
                String id = input[2];

                Citizen citizen =  new Citizen(name,age,id);
                list.add(citizen);
            }

        }

        String numbers = bfr.readLine();


        for (Identifiable identifiable : list) {

            String id = identifiable.getId();

            if (id.endsWith(numbers)) {
                System.out.println(identifiable.getId());
            }

        }

    }
}
