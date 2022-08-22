package restaurant;

import java.math.BigDecimal;

public class Beverage extends Product{

    private double milliliters;



    //---CONSTRUCTOR---//
    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.milliliters = milliliters;
    }


    //---GETTER---//
    public double getMilliliters() {
        return milliliters;
    }

}
