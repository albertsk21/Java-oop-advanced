package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CarRepository implements Repository<Car>{
    private Collection<Car> cars;


    public CarRepository() {
        this.cars = new ArrayList<>();
    }

    @Override
    public Car getByName(String name) {

        for (Car car : this.cars) {

            if(car.getModel().equals(name)){
                return car;
            }
        }

        return null;
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(this.cars);
    }

    @Override
    public void add(Car model) {
        this.cars.add(model);
    }

    @Override
    public boolean remove(Car model) {

        if(this.cars.contains(model)){

            this.cars.remove(model);
            return true;
        }

        return false;
    }
}
