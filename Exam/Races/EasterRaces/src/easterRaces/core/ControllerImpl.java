package easterRaces.core;

import easterRaces.common.ExceptionMessages;
import easterRaces.common.OutputMessages;
import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Car> carRepository;
    private Repository<Driver> driverRepository;
    private Repository<Race> raceRepository;


    public ControllerImpl( Repository<Driver> driverRepository,Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.carRepository = carRepository;
        this.driverRepository = driverRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {

        Driver instantiateDriver = new DriverImpl(driver);
        this.checkAllDriversByName(driver);

        this.driverRepository.add(instantiateDriver);
        return String.format(OutputMessages.DRIVER_CREATED,driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {

        Car car;

        switch (type){
            case "Sports":
                car = new SportsCar(model,horsePower);
                break;
            case "Muscle":
                car = new MuscleCar(model,horsePower);
                break;
            default:
                car = null;
        }
        this.checkAllCarsByModel(model);
        this.carRepository.add(car);
        return String.format(OutputMessages.CAR_CREATED,car.getClass().getSimpleName(),model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {

        Driver driver = this.driverRepository.getByName(driverName);

        if(driver == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND,driverName));
        }

        Car car = this.carRepository.getByName(carModel);

        if(car == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_NOT_FOUND,carModel));
        }
        driver.addCar(car);
        return String.format(OutputMessages.CAR_ADDED,driverName,carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {

        Race race = this.raceRepository.getByName(raceName);

        if(race == null ){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND,raceName));
        }

        Driver driver = this.driverRepository.getByName(driverName);

        if(driver == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND,driverName));
        }

        race.addDriver(driver);
        return String.format(OutputMessages.DRIVER_ADDED,driverName,raceName);
    }

    @Override
    public String startRace(String raceName) {

        Race race = this.raceRepository.getByName(raceName);

        if(race == null ){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND,raceName));
        }

        if(race.getDrivers().size() < 3){
            throw new IllegalArgumentException(String.format("Race %s cannot start with less than 3 participants.",raceName));
        }


        List<Driver> drivers = race.getDrivers().stream().sorted((driverOne,driverTwo) -> Integer.compare((int)driverTwo.getCar().calculateRacePoints(race.getLaps()),(int)driverOne.getCar().calculateRacePoints(race.getLaps()))).limit(3).collect(Collectors.toList());

        StringBuilder output = new StringBuilder(String.format(OutputMessages.DRIVER_FIRST_POSITION,drivers.get(0).getName(),raceName));
        output.append("\n");
        output.append(String.format(OutputMessages.DRIVER_SECOND_POSITION,drivers.get(1).getName(),raceName));
        output.append("\n");
        output.append(String.format(OutputMessages.DRIVER_THIRD_POSITION,drivers.get(2).getName(),raceName));

        this.raceRepository.remove(race);
        return output.toString();
    }

    @Override
    public String createRace(String name, int laps) {

        this.checkAllRacesByName(name);
        Race race = new RaceImpl(name,laps);

        this.raceRepository.add(race);
        return String.format(OutputMessages.RACE_CREATED,name);

    }


    private void checkAllDriversByName(String driverName){

        for (Driver driver : this.driverRepository.getAll()) {
            if(driver.getName().equals(driverName)){
                throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS,driverName));
            }
        }

    }
    private void checkAllCarsByModel(String model){

        for (Car car : this.carRepository.getAll()) {

            if(car.getModel().equals(model)){
                throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_EXISTS,model));
            }

        }

    }
    private void checkAllRacesByName(String name){

        for ( Race race : this.raceRepository.getAll() ) {

            if(race.getName().equals(name)){
                throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS,name));
            }

        }

    }

}
