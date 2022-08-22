import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader bfr =  new BufferedReader(new InputStreamReader(System.in));


        int iteration = Integer.parseInt(bfr.readLine());


        Map<String,Buyer> buyerMap =  new LinkedHashMap<>();
        for (int i = 0; i <iteration ; i++) {

            String[] input = bfr.readLine().split(" ");


            if(input.length == 3){

                String name = input[0];
                int age = Integer.parseInt(input[1]);
                String group = input[2];

                buyerMap.put(name,new Rebel(name,age,group));
            }else if(input.length == 4){

                String name = input[0];
                int age = Integer.parseInt(input[1]);
                String id = input[2];
                String birthdate = input[3];

                buyerMap.put(name,new Citizen(name,age,id,birthdate));
            }
        }



        String name = bfr.readLine();
        while(!name.equals("End")){


            if(buyerMap.containsKey(name)){
                Buyer buyer = buyerMap.get(name);
                buyer.buyFood();
            }


            name = bfr.readLine();
        }


        int totalFood = 0;
        for (Buyer buyer : buyerMap.values()){


            totalFood += buyer.getFood();

        }
        System.out.println(totalFood);
    }
}
