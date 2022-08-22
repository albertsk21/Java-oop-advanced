package com.company;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Hardware {

    private String name;
    private String type;
    private int maximumCapacity;
    private int maximumMemory;
    private List<Software> expressSoftware;
    private List<Software> lightSoftware;


    //---CONSTRUCTOR---//
    public Hardware(String name, String type, int maximumCapacity, int maximumMemory) {
        this.name = name;
        this.type = type;
        this.maximumCapacity = maximumCapacity;
        this.maximumMemory = maximumMemory;
        this.expressSoftware = new ArrayList<>();
        this.lightSoftware = new ArrayList<>();
    }


    //---SETTERS---//
    public void setName(String name) {
        this.name = name;
    }
    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }
    public void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setExpressSoftware(List<Software> expressSoftware) {
        this.expressSoftware = expressSoftware;
    }
    public void setLightSoftware(List<Software> lightSoftware) {
        this.lightSoftware = lightSoftware;
    }
    public void addSoftware(String type, Software software){

        if(type.equals("Express")){
            this.expressSoftware.add(software);

        }else if(type.equals("Light")){
            this.lightSoftware.add(software);
        }

    }

    //---GETTERS---//
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getMaximumCapacity() {
        return maximumCapacity;
    }
    public int getMaximumMemory() {
        return maximumMemory;
    }
    public List<Software> getExpressSoftware() {
        return expressSoftware;
    }
    public List<Software> getLightSoftware() {
        return lightSoftware;
    }
    public Software getSoftwareExpress(String nameSoftwareComponents){
        for (Software software : this.expressSoftware) {
            if(software.getName().equals(nameSoftwareComponents)){
                return software;
            }
        }
        return null;
    }
    public Software getSoftwareLight(String nameSoftwareComponents){
        for (Software software : this.lightSoftware) {
            if(software.getName().equals(nameSoftwareComponents)){
                return software;
            }
        }
        return null;
    }

    //---COUNTERS---//
    public int countOfExpressSoftwareComponents(){
      return expressSoftware.size() ;
    };
    public int countOfLightSoftwareComponents(){
      return lightSoftware.size() ;
    };

    //---TOTAL-CONSUMPTION---//
    public int totalMemoryConsumption(List<Software> softwareList){


        int totalMemoryInUse = 0;
        for (Software software : softwareList) {
            totalMemoryInUse += software.getMemoryConsumption();
        }


        return totalMemoryInUse;
    }
    public int totalCapacityConsumption(List<Software> softwareList){


        int totalMemoryInUse = 0;
        for (Software software : softwareList) {
            totalMemoryInUse += software.getCapacityConsumption();
        }


        return totalMemoryInUse;
    }
    public int totalMemoryConsumptionAllSoftware(){

        int totalMemory = 0;
        for (Software software: this.expressSoftware) {
            totalMemory += software.getMemoryConsumption();
        }

        for (Software software : this.lightSoftware) {
            totalMemory += software.getMemoryConsumption();
        }
        return totalMemory;
    }
    public int totalCapacityConsumptionAllSoftware(){

        int totalCapacity = 0;
        for (Software software: this.expressSoftware) {
            totalCapacity += software.getCapacityConsumption();
        }

        for (Software software : this.lightSoftware) {
            totalCapacity += software.getCapacityConsumption();
        }
        return totalCapacity;
    }

    //---ANOTHER-COMMANDS---//
    public void powerHardware(){
        int resultCapacity =  (int) (this.maximumCapacity * 0.75);
        setMaximumCapacity(this.maximumCapacity - resultCapacity);

        int resultMemory = (int) (this.maximumMemory * 0.75);
        setMaximumMemory(this.maximumMemory + resultMemory);

    }
    public void heavyHardware(){
        int resultMemory = (int) (this.maximumMemory * 0.25);
        setMaximumMemory(this.maximumMemory - resultMemory);

        int resultCapacity = this.maximumCapacity * 2;
        setMaximumCapacity(resultCapacity);
    }
    public Set<String> combineLists(){

        Set<String> combine = new LinkedHashSet<>();

        for (Software software : this.lightSoftware) {
            combine.add(software.getName());
        }
        for (Software software : this.expressSoftware) {
            combine.add(software.getName());
        }


        if(combine.isEmpty()){
            combine.add("None");
        }

        return combine;
    }
    public void print() {

        System.out.printf("Hardware Component - %s%n",this.name);
        System.out.printf("Express Software Components - %d%n",this.expressSoftware.size());
        System.out.printf("Light Software Components - %d%n",this.lightSoftware.size());
        System.out.printf("Memory Usage: %d / %d%n",totalMemoryConsumption(lightSoftware) + totalMemoryConsumption(expressSoftware),this.maximumMemory);
        System.out.printf("Capacity Usage: %d / %d%n",totalCapacityConsumption(lightSoftware) + totalCapacityConsumption(expressSoftware),this.maximumCapacity);
        System.out.printf("Type: %s%n",this.type);
        System.out.printf("Software Components: %s%n",String.join(", ",combineLists()));


    }



    //---METHODS BOOLEANS---//
    public  boolean containsExpressSoftware(String softwareComponentName){
        List<Software> expressSoftwareList = this.expressSoftware;


        for  ( Software software : expressSoftwareList ) {
            if(software.getName().equals(softwareComponentName)){
                return true;
            }

        }
        return false;
    }
    public  boolean containsLightSoftware(String softwareComponentName){
        List<Software> lightSoftwareList = this.expressSoftware;


        for  ( Software software : lightSoftwareList ) {
            if(software.getName().equals(softwareComponentName)){
                return true;
            }
        }
        return false;

    }



}
