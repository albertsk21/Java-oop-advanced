package polymorphism;

import java.text.DecimalFormat;

public class Car extends Vehicle{

    public Car(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }
    @Override
    void drive(double distance) {
        double mainConsumption = distance * (this.getFuelConsumptionInLitersPerKm() + 0.9);
        if(mainConsumption <= this.getFuelQuantity()){
            this.setFuelQuantity(this.getFuelQuantity() - mainConsumption);
            DecimalFormat decimalFormat =  new DecimalFormat("####.##");
            System.out.printf("The car travelled %s km%n",decimalFormat.format(distance));

        }else{
            System.out.println("The car needs refueling");
        }
    }

    @Override
    void drive(double distance, boolean hasPeople) {

    }

    @Override
    void refuelling(double refuellingLiters) {

        if(refuellingLiters <= 0){
            throw new IllegalArgumentException("The fuel amount must be a positive number");
        }else if(this.getFuelQuantity() + refuellingLiters > this.getTankCapacity()){
            throw new IllegalArgumentException("The fuel amount exceeds this vehicle's capacity");
        }

        this.setFuelQuantity(this.getFuelQuantity() + refuellingLiters );
    }


}
