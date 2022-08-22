package polymorphism;

public class Zebra extends Mammal{
    protected Zebra(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
    }



    @Override
    void eat(Food food) {
        if(food.getClass().getSimpleName().equals("Meat")){
            throw new IllegalArgumentException("The type of food cannot be consumed by Zebra");
        }

        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());

    }
}
