import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader bfr =  new BufferedReader(new InputStreamReader(System.in));
        List<Animal> animals =  new ArrayList<>();

        while(true){

            String typeAnimal =  bfr.readLine();

            if(typeAnimal.equals("Beast!")){
                break;
            }
            String[] infoAnimal = bfr.readLine().split(" ");

            String name = infoAnimal[0];
            int age = Integer.parseInt(infoAnimal[1]);
            String gender = infoAnimal[2];




            if(typeAnimal.equals("Dog")){

                try {
                    Dog dog = new Dog(name,age,gender);
                    animals.add(dog);
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }

            }else if(typeAnimal.equals("Cat")){

                try {
                    Cat cat = new Cat(name,age,gender);
                    animals.add(cat);
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }

            }else if (typeAnimal.equals("Frog")){


                try {
                    Frog frog = new Frog(name,age,gender);
                    animals.add(frog);
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }

            }else if(typeAnimal.equals("Tomcat")){


                try {
                    Tomcat tomcat =  new Tomcat(name,age);
                    animals.add(tomcat);
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }

            }else if(typeAnimal.equals("Kitten")){

                try {
                    Kitten kitten =  new Kitten(name,age);
                    animals.add(kitten);
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }

            }

        }

        printAnimals(animals);





    }

    public  static  void  printAnimals(List<Animal> animals){


        for (Animal animal : animals) {
            System.out.println(animal);

        }
    }
}
