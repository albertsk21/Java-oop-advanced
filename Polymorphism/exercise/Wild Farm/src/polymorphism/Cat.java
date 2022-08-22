package polymorphism;

import java.text.DecimalFormat;

public class  Cat extends Felime {
    private String breed;

    protected Cat(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat =  new DecimalFormat("####.#########");
        return  String.format("%s[%s, %s, %s, %s, %s]",super.getAnimalType(), super.getAnimalName(), this.getBreed(), decimalFormat.format(super.getAnimalWeight()),super.getLivingRegion(),super.getFoodEaten());
    }


    @Override
    void eat(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }
}
