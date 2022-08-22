package com.company;

import java.util.ArrayList;
import java.util.List;

public class Software {
    private String hardwareComponentName;
    private String name;
    private int capacityConsumption;
    private int memoryConsumption;
    private List<Hardware> hardwareList;


    //---CONSTRUCTOR---//
    public Software(String hardwareComponentName, String name, int capacityConsumption, int memoryConsumption) {
        this.hardwareComponentName = hardwareComponentName;
        this.name = name;
        this.capacityConsumption = capacityConsumption;
        this.memoryConsumption = memoryConsumption;
        this.hardwareList = new ArrayList<>();
    }

    //---SETTERS---//
    public void setName(String name) {
        this.name = name;
    }
    public void addHardware(Hardware hardware){
        this.hardwareList.add(hardware);
    }
    public void setHardwareComponentName(String hardwareComponentName) {
        this.hardwareComponentName = hardwareComponentName;
    }
    public void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }
    public void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }
    public void setHardwareList(List<Hardware> hardwareList) {
        this.hardwareList = hardwareList;
    }


    //---GETTERS---//
    public List<Hardware> getHardwareList() {
        return this.hardwareList;
    }
    public Hardware getHardware(String name){

        for (Hardware hardware : this.hardwareList) {

            if(hardware.getName().equals(name)){
                return hardware;
            }

        }

        return null;
    }
    public String getName() {
        return name;
    }
    public int getCapacityConsumption() {
        return capacityConsumption;
    }
    public int getMemoryConsumption() {
        return memoryConsumption;
    }
    public String getHardwareComponentName() {
        return hardwareComponentName;
    }


    //---ANOTHER-COMMANDS---//
    public boolean checkHardware(String item){
        return getHardwareList().contains(item);
    }
    public void expressSoftware(){
        int resultMemory = this.memoryConsumption * 2;
        setMemoryConsumption(resultMemory);
    }
    public void lightSoftware(){
        int resultCapacityConsumption = (int) (this.capacityConsumption + (this.capacityConsumption * 0.5));
        setCapacityConsumption(resultCapacityConsumption);

        int resultMemoryConsumption = (int) (this.memoryConsumption - (this.memoryConsumption * 0.5));
        setMemoryConsumption(resultMemoryConsumption);
    }



}
