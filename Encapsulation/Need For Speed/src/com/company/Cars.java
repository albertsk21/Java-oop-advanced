package com.company;

public class Cars {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsePower;
    private int acceleration;
    private int suspension;
    private int durability;
    private String type;
    private int stars;


    //---CONSTRUCTOR---//
    public Cars(String brand, String model, int yearOfProduction,int horsePower,  int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
        this.yearOfProduction = yearOfProduction;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
        this.stars = 0;
    }


    //---SETTERS---//
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }
    public void setDurability(int durability) {
        this.durability = durability;
    }
    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }
    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }
    public void setType(String type) {
        this.type = type;
    }


    //---GETTERS---//
    public int getHorsePower() {
        return horsePower;
    }
    public String getModel() {
        return model;
    }
    public String getBrand() {
        return brand;
    }
    public int getAcceleration() {
        return acceleration;
    }
    public int getDurability() {
        return durability;
    }
    public int getSuspension() {
        return suspension;
    }
    public int getYearOfProduction() {
        return yearOfProduction;
    }
    public String getType() {
        return type;
    }

    //---ANOTHER-COMMANDS---//
    public void addOns(){

        int increaseHorsePower = (int) (this.getHorsePower() + (this.getHorsePower() * 0.5));
        int decreaseSuspension = (int) (this.getSuspension() - (this.getSuspension() * 0.25));
        this.setHorsePower(increaseHorsePower);
        this.setSuspension(decreaseSuspension);

    }
    public void stars(int stars){
        this.stars = stars;
    }
    public void stars(){
        this.stars = this.stars + 1;
    }



}

