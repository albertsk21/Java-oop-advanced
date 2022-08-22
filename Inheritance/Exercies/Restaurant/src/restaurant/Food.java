package restaurant;

import java.math.BigDecimal;

public class Food extends Product{


    private double grams;


    //---CONSTRUCTOR---//
    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.grams = grams;
    }

    //---GETTER---//
    public double getGrams() {
        return grams;
    }
}
