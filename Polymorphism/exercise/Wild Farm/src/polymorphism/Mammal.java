package polymorphism;

import java.text.DecimalFormat;

public class Mammal extends Animal{

    private String livingRegion;

    protected Mammal(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten);
        this.livingRegion =  livingRegion;
    }


    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat =  new DecimalFormat("#.##");
        return  String.format("%s[%s, %s, %s, %s]",this.getAnimalType(), this.getAnimalName(), decimalFormat.format(this.getAnimalWeight()),this.getLivingRegion(),this.getFoodEaten());
    }
}
