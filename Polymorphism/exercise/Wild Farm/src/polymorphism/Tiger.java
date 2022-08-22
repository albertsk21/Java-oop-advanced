package polymorphism;

public class Tiger extends Felime {
    private String livingRegion;


    protected Tiger(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }
    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    void eat(Food food) {
        if(food.getClass().getSimpleName().equals("Vegetable")){
            throw new IllegalArgumentException("The type of food cannot be consumed by Tigers");
        }
        super.setFoodEaten( super.getFoodEaten() + food.getQuantity());

    }
}
