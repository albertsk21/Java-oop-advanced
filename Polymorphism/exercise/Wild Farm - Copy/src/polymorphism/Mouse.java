package polymorphism;

public class Mouse extends Mammal{
    protected Mouse(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }



    @Override
    void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    void eat(Food food) {


        if(food.getClass().getSimpleName().equals("Meat")){
            throw new IllegalArgumentException("The type of food cannot be consumed by Mice");
        }

        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());

    }
}
