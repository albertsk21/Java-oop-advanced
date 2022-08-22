package polymorphism;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        List<Animal> animals = new ArrayList<>();


        while (true) {

            String[] inputAnimal = bfr.readLine().split("\\s+");

            if (inputAnimal[0].equals("End")) {
                break;
            }
            String[] inputFood = bfr.readLine().split("\\s+");


            String typeFood = inputFood[0];
            Integer quantity = Integer.parseInt(inputFood[1]);


            Food food =  null;
            if (typeFood.equals("Vegetable")) {
                food = new Vegetable(quantity);
            } else if (typeFood.equals("Meat")){
                food = new Meat(quantity);

            }


            // Animal information
            String animalType = inputAnimal[0];
            String animalName = inputAnimal[1];
            Double animalWeight = Double.parseDouble(inputAnimal[2]);
            String animalLivingRegion = inputAnimal[3];


            switch (animalType) {

                case "Mouse":

                    Mouse mouse = new Mouse(animalName, animalType, animalWeight, 0, animalLivingRegion);
                    mouse.makeSound();
                    try {
                       mouse.eat(food);
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }
                    animals.add(mouse);

                    break;

                case "Zebra":
                    Zebra zebra = new Zebra(animalName, animalType, animalWeight, 0, animalLivingRegion);
                    zebra.makeSound();
                    try {
                        zebra.eat(food);
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }
                    animals.add(zebra);
                    break;




                case "Cat":
                    String catBreed = inputAnimal[4];
                    Cat cat = new Cat(animalName, animalType, animalWeight, 0, animalLivingRegion, catBreed);
                    cat.makeSound();
                    try {
                        cat.eat(food);
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }
                    animals.add(cat);
                    break;

                case "Tiger":
                    Tiger tiger = new Tiger(animalName, animalType, animalWeight, 0, animalLivingRegion);
                    tiger.makeSound();
                    try {
                        tiger.eat(food);
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }
                    animals.add(tiger);
                    break;
            }
        }
        printAnimals(animals);
    }


    public static void printAnimals(List<Animal> animals){
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

}
