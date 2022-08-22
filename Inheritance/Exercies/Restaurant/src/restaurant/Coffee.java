package restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {

    private final double COFFEE_MILLILITERS = 50;
    private final BigDecimal COFFEE_PRICE = new BigDecimal("3.5");
    private final double caffeine;

    public Coffee(String name,double caffeine) {
        super(name,new BigDecimal("3.5"),50);
        this.caffeine = caffeine;
    }


    public double getCaffeine() {
        return caffeine;
    }
}
