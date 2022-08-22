package polymorphism;

import java.text.DecimalFormat;

public class Bus extends Vehicle{


    public Bus(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }




    @Override
    void drive(double distance) {

    }

    @Override
    void drive(double distance, boolean hasPeople) {



        double mainConsumption;

        if(hasPeople){

            mainConsumption = distance * (this.getFuelConsumptionInLitersPerKm());

        }else{
            double consumption = this.getFuelConsumptionInLitersPerKm() + 1.4;
            mainConsumption = distance * consumption;
        }

        if(mainConsumption <= this.getFuelQuantity()){
            this.setFuelQuantity(this.getFuelQuantity() - mainConsumption);
            DecimalFormat decimalFormat =  new DecimalFormat("####.##");
            System.out.printf("The bus travelled %s km%n",decimalFormat.format(distance));

        }else{
            System.out.println("The bus needs refueling");
        }

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
