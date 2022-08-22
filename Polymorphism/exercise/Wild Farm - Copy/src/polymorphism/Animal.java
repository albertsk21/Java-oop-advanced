package polymorphism;

public abstract class Animal {


    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;



    //---CONSTRUCTOR---//
    protected Animal(String animalName, String animalType, Double animalWeight, Integer foodEaten) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = foodEaten;
    }



    //---SETTERS---//
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
    public void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }
    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    //---GETTERS---//
    public Double getAnimalWeight() {
        return animalWeight;
    }
    public String getAnimalName() {
        return animalName;
    }
    public String getAnimalType() {
        return animalType;
    }
    public Integer getFoodEaten() {
        return foodEaten;
    }



    //---ANOTHER-COMMANDS---//
    void makeSound() {}
    void eat(Food food){}


}
