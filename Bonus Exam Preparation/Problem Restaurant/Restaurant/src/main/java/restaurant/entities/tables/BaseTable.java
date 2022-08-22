package restaurant.entities.tables;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;


public class BaseTable implements Table {

    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;

    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;


    public BaseTable(int number, int size, double pricePerPerson){
        this.number = number; //TODO: I think is a mistake to add a value without a setter.
        this.setSize(size);
        this.pricePerPerson = pricePerPerson; // is initialized correctly

        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();

    }

    //SETTERS
    public void setSize(int size) {
        if(size <= 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
        }
        this.size = size;
    }
    public void setNumberOfPeople(int numberOfPeople) {
        if(numberOfPeople <= 0 ){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    //BEHAVIOR
    @Override
    public int getTableNumber() {
        return this.number;
    }
    public int getSize() {
        return this.size;
    }
    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }
    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }
    @Override
    public boolean isReservedTable() {
        return numberOfPeople == 0;
    }
    @Override
    public double allPeople() {
       return this.pricePerPerson * this.numberOfPeople;
    }
    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
    }



    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }
    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }



    @Override
    public double bill() {
        return this.totalPriceHealthyFood() + this.totalPriceBeverages();
    }
    @Override
    public void clear() {
        this.beverages = new ArrayList<>();
        this.healthyFood = new ArrayList<>();
        this.numberOfPeople = 0;
        this.pricePerPerson = 0;
        this.number = 0;
    }
    @Override
    public String tableInformation() {
        StringBuilder output = new StringBuilder(String.format("Table - %d\n",this.getTableNumber()));
        output.append(String.format("Size - %d\n",this.getSize()));
        output.append(String.format("Type - %s\n",this.getClass().getSimpleName())); // I think is a mistake
        output.append(String.format("All price - %.2f\n",this.bill()));
        return output.toString();
    }
    private double totalPriceHealthyFood(){
        return this.healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
    }
    private double totalPriceBeverages(){
        return this.beverages.stream().mapToDouble(Beverages::getPrice).sum();
    }

}
