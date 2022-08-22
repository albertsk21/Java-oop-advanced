
public class Vehicle{


    private final double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;



    //---CONSTRUCTOR---//
    public Vehicle(double fuel, int horsePower){
        this.setFuel(fuel);
        this.setHorsePower(horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    //---SETTERS---//
    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    private void setFuel(double fuel) {
        this.fuel = fuel;
    }
    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }


    //---GETTERS---//
    public double getFuelConsumption() {
        return fuelConsumption;
    }
    public double getFuel() {
        return fuel;
    }
    public int getHorsePower() {
        return horsePower;
    }


    //---ANOTHER-COMMAND---//
    public void drive(double kilometers){
        this.fuel -= this.fuelConsumption * kilometers;
    }

}
