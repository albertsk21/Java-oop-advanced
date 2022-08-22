package com.company;

import java.util.List;
import java.util.Map;

public class CarManager {


    private int id;
    private Map<Integer,Cars> carsMap;
    public Map<Integer,Cars> parkCars;
    private Map<Integer, Races> racesMap;


    //---CONSTRUCTOR---//
    public CarManager(Map<Integer, Cars> carsMap, Map<Integer, Races> racesMap, int id) {
        this.carsMap = carsMap;
        this.racesMap = racesMap;
        this.id = id;
    }
    //---SETTERS---//
    public void setCarsMap(Map<Integer, Cars> carsMap) {
        this.carsMap = carsMap;
    }
    public void setParkCars(Map<Integer, Cars> parkCars) {
        this.parkCars = parkCars;
    }
    public void setRacesMap(Map<Integer, Races> racesMap) {
        this.racesMap = racesMap;
    }
    public void setId(int id) {
        this.id = id;
    }


    //---GETTERS---//
    public Map<Integer, Cars> getCarsMap() {
        return carsMap;
    }
    public Map<Integer, Cars> getParkCars() {
        return parkCars;
    }
    public Map<Integer, Races> getRacesMap() {
        return racesMap;
    }


    //---ANOTHER-COMMANDS---//
    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability){
        this.id = id;
        Cars cars = new Cars(brand,model,yearOfProduction,horsepower,acceleration,suspension,durability);
        carsMap.put(id,cars);

        if(type.equals("Performance")){
            cars.setType("Performance");
            cars.addOns();

        }else if(type.equals("Show")){
            cars.setType("Show");
            cars.stars();

        }

   }
    public String check(int id){
        return carsMap.get(id).toString();
    }
    public void open(int id, String type, int length, String route, int prizePool){
        Races races = racesMap.get(id);

        races.setType(type);
        races.setLength(length);
        races.setRoute(route);
        races.setPrizePool(prizePool);

        racesMap.put(id,races);

    }
    public void participate(int carId, int raceId){


        if(racesMap.containsKey(id)){

            //Take a car
            Cars cars = carsMap.get(carId);

            //Take the race
            Races races  = racesMap.get(raceId);
            carsMap.remove(id);

            //Take the carList which is in a race class
            List<Cars> carsList = races.getCarsList();

            //add a car
            carsList.add(cars);

            //Put the car in the race
            races.setCarsList(carsList);
            racesMap.put(raceId,races);

        }
    }
//    public String start(int id){}
    public void park(int id){
        Cars cars =  carsMap.get(id);
        carsMap.remove(id);
        parkCars.put(id,cars);

    }
    public void unpark(int id){
        Cars cars =  parkCars.get(id);
        parkCars.remove(id);
        carsMap.put(id,cars);

    }
    public void tune(int tuneIndex, String addOn){

        if(parkCars.containsKey(tuneIndex)){
            Cars cars = parkCars.get(tuneIndex);
            if(addOn.equals("Performance")){
                cars.addOns();
            }else if(addOn.equals("Show")){
                cars.stars();
            }
            parkCars.put(tuneIndex,cars);
        }

    }



}
