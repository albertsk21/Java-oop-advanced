package polymorphism;

import java.text.DecimalFormat;

public class Truck extends Vehicle {


    public Truck(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }

    @Override
    void drive(double distance) {
        double mainConsumption = distance * (this.getFuelConsumptionInLitersPerKm() + 1.6);

        if(mainConsumption <= this.getFuelQuantity()){
            this.setFuelQuantity(this.getFuelQuantity() - mainConsumption);
            DecimalFormat decimalFormat =  new DecimalFormat("####.##");
            System.out.printf("The truck travelled %s km%n",decimalFormat.format(distance));
        }else{
            System.out.println("The truck needs refueling");
        }

    }

    @Override
    void drive(double distance, boolean hasPeople) {

    }

    @Override
    void refuelling(double refuellingLiters){

        if(refuellingLiters <= 0){
            throw new IllegalArgumentException("The fuel amount must be a positive number");
        }else if(this.getFuelQuantity() + refuellingLiters > this.getTankCapacity()){
            throw new IllegalArgumentException("The fuel amount exceeds this vehicle's capacity");
        }

        this.setFuelQuantity(this.getFuelQuantity() + refuellingLiters * 0.95);
    }


}
