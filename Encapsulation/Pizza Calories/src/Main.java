import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        //---INITIALIZE-PIZZA---//
        String[] input = bfr.readLine().split(" ");
        Pizza pizza = new Pizza(input[1],Integer.parseInt(input[2]));

        //---INITIALIZE-DOUGH---//
        input = bfr.readLine().split(" ");
        Dough dough;
        if(input.length == 3){
            dough = new Dough(input[1],Double.parseDouble(input[2]));
        }else{
            dough = new Dough(input[1],input[2],Double.parseDouble(input[3]));
        }

        pizza.setDough(dough);



        //---ADD-TOPPINGS---//
        input = bfr.readLine().split(" ");
        while(!(input[0].equals("END"))){



            Topping topping;
            if(input.length == 4){
                String name = input[1] + " " + input[2];
                double weight = Double.parseDouble(input[3]);
                topping =  new Topping(name,weight);

            }else{
                topping =  new Topping(input[1],Double.parseDouble(input[2]));

            }





            pizza.addTopping(topping);
            input = bfr.readLine().split(" ");
        }

        System.out.printf("%s - %.2f%n",pizza.getName(),pizza.getOverallCalories());

    }
}
