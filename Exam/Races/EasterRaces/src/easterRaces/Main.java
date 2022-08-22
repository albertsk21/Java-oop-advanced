package easterRaces;

import easterRaces.core.ControllerImpl;
import easterRaces.core.EngineImpl;
import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.racers.Race;
import easterRaces.io.ConsoleReader;
import easterRaces.io.ConsoleWriter;
import easterRaces.repositories.interfaces.CarRepository;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.RaceRepository;
import easterRaces.repositories.interfaces.Repository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        Repository<Car> motorcycleRepository = new CarRepository();
//        Repository<Race> raceRepository = new RaceRepository();
//        Repository<Driver> riderRepository  = new DriverRepository();
//
//        Controller controller =  new ControllerImpl(riderRepository, motorcycleRepository, raceRepository);
//
//        ConsoleReader reader = new ConsoleReader();
//        ConsoleWriter writer = new ConsoleWriter();
//        EngineImpl engine = new EngineImpl(reader, writer, controller);
//        engine.run();


        int currentIndexFirstName = 0;

        int[] numbers = new int[5];
        for (int i = 1; i <= 5 ; i++) {
            numbers[i] = i;
        }


        int biggestNumber = 0;
        for (int i = 0; i <= 5 ; i++) {
            int firstNumber = numbers[currentIndexFirstName];

            int firstResult = firstNumber *
            if()


        }



    }
}
