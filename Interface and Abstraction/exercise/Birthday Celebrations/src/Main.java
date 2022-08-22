import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));


        List<Birthable> birthableList =  new ArrayList<>();

        while(true){

            String[] input =  bfr.readLine().split(" ");

            if(input[0].equals("End")){
                break;
            }else if(input[0].equals("Citizen")){

                    String name =  input[1];
                    int age = Integer.parseInt(input[2]);
                    String id = input[3];
                    String birthdate = input[4];
                    birthableList.add(new Citizen(name,age,id,birthdate));

            }else if(input[0].equals("Robot")){

            }else if(input[0].equals("Pet")){

                String name =  input[1];
                String birthdate =  input[2];
                birthableList.add(new Pet(name,birthdate));

            }
        }

        String year = bfr.readLine();

        for (int i = 0; i <birthableList.size() ; i++) {

            Birthable birthable = birthableList.get(i);


            String birthdate = birthable.getBirthDate();
            if(birthdate.contains(year)){
                System.out.println(birthdate);
            }

        }
    }
}