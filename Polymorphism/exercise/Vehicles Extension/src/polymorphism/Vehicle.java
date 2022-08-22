package polymorphism;

public abstract class Vehicle {

    private double fuelQuantity;
    private final double fuelConsumptionInLitersPerKm;
    private final double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
        this.tankCapacity = tankCapacity;
    }

    //---GETTERS---//
    public double getFuelConsumptionInLitersPerKm() {
        return fuelConsumptionInLitersPerKm;
    }
    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    //---SETTERS--//
    public void setFuelQuantity(double fuelQuantity) {
        if(fuelQuantity <= 0){
            throw new IllegalArgumentException("The fuel amount must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    abstract void drive(double distance);
    abstract void drive(double distance , boolean hasPeople);
    abstract void refuelling(double refuellingLiters);

}
