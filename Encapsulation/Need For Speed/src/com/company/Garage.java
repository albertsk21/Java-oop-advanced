package com.company;

import java.util.List;

public class Garage {

    private List<Cars> carsList;


    //---CONSTRUCTOR---//
    public Garage(List<Cars> carsList) {
        this.carsList = carsList;
    }

    //---SET---//
    public void setCarsList(List<Cars> carsList) {
        this.carsList = carsList;
    }


    //---GET---//
    public List<Cars> getCarsList() {
        return carsList;
    }


    //---ANOTHER-COMMANDS---//
    public void parkedCars(List<Cars> carsList){
        this.carsList = carsList;
    }
}
