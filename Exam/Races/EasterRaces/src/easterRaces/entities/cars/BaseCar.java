package easterRaces.entities.cars;

import easterRaces.common.ExceptionMessages;

public class BaseCar implements Car{

    private String model;
    private int horsePower;
    private double cubicCentimeters;

    //CONSTRUCTOR
    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setCubicCentimeters(cubicCentimeters);
    }

    //SETTERS
    public void setModel(String model){

        if(model == null || model.trim().isEmpty() || model.length() < 4){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_MODEL,model,4));
        }

        this.model = model;
    }
    public void setHorsePower(int horsePower) {

        if(this.getClass().getSimpleName().equals("MuscleCar")){
            if(!(horsePower >= 400 && horsePower <= 600)){
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER,horsePower));
            }
        }else if(this.getClass().getSimpleName().equals("SportsCar")){
            if(!(horsePower >= 200 && horsePower <= 450)){
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER,horsePower));
            }
        }

        this.horsePower = horsePower;
    }
    public void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }

    //GETTERS
    @Override
    public String getModel() {
        return this.model;
    }
    @Override
    public int getHorsePower() {
        return this.horsePower;
    }
    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }


    @Override
    public double calculateRacePoints(int laps) {
        return this.getCubicCentimeters() / this.getHorsePower() * laps;
    }


}
