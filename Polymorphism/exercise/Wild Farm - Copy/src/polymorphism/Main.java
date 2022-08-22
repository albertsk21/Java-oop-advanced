package polymorphism;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bfr =  new BufferedReader( new InputStreamReader(System.in));
        Map<String, Animal> animals =  new LinkedHashMap<>();
        int counter = 0;


        String currentName = "";
        while(true){

            String[] input  = bfr.readLine().split("\\s+");

            if(input[0].equals("End")){
                break;
            }

            if(counter % 2 == 0){
            // Animal information

                String animalType = input[0];
                String animalName = input[1];
                Double animalWeight = Double.parseDouble(input[2]);
                String animalLivingRegion = input[3];



                switch (animalType){
                    case "Mouse":
                        Mouse mouse = new Mouse(animalName,animalType,animalWeight,0, animalLivingRegion);
                        animals.put(animalName,mouse);

                        break;

                    case "Zebra":
                        Zebra zebra = new Zebra(animalName,animalType,animalWeight,0, animalLivingRegion);
                        animals.put(animalName,zebra);
                        break;

                    case "Cat":
                        String catBreed = input[4];
                        Cat cat = new Cat(animalName,animalType,animalWeight,0,animalLivingRegion ,catBreed);
                        animals.put(animalName,cat);
                        break;

                    case "Tiger":
                        Tiger tiger =  new Tiger(animalName,animalType,animalWeight,0, animalLivingRegion);
                        animals.put(animalName,tiger);
                        break;
                }


                currentName = animalName;
            }else{
            // Food information

                String foodType = input[0];
                Integer quantity = Integer.parseInt(input[1]);

                Food food;
                if(foodType.equals("Vegetable")){
                    food = new Vegetable(quantity);
                }else{
                    food = new Meat(quantity);
                }


                Animal animal  = animals.get(currentName);
                animal.makeSound();
                try {
                    animal.eat(food);
                    animals.put(currentName,animal);
                }catch (IllegalArgumentException exception){
                    System.out.println(exception.getMessage());
                }
            }
            counter++;
        }
        printAnimals(animals);
    }
    public static void printAnimals(Map<String,Animal> animals){


        for (Animal animal : animals.values()) {

            System.out.println(animal.toString());

        }
    }

}
