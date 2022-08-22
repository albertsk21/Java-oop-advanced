package com.company;

import java.util.ArrayList;
import java.util.List;

public class Races implements Comparable<Cars>{

    private int length;
    private String route;
    private int prizePool;
    private List<Cars> carsList;
    private String type;


    //---CONSTRUCTOR---//
    public Races(int length, String route, int prizePool, String type) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.carsList = new ArrayList<>();
        this.type = type;
    }


    //---SETTERS--//
    public void setCarsList(List<Cars> carsList) {
        this.carsList = carsList;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }
    public void setRoute(String route) {
        this.route = route;
    }
    public void setType(String type) {
        this.type = type;
    }

    //---GETTERS---//
    public int getLength() {
        return length;
    }
    public int getPrizePool() {
        return prizePool;
    }
    public String getRoute() {
        return route;
    }
    public List<Cars> getCarsList() {
        return carsList;
    }
    public String getType() {
        return type;
    }

    @Override
    public int compareTo(Cars o) {

        if(this.type.equals("CasualRace")){

        }else if(this.type.equals("DragRace")){

        }else if(this.type.equals("DriftRace")){

        }

        return 0;
    }
}
