package restaurant.core;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.BeverageRepositoryImpl;
import restaurant.repositories.HealthFoodRepositoryImpl;
import restaurant.repositories.TableRepositoryImpl;
import restaurant.repositories.interfaces.*;

public class ControllerImpl implements Controller {

    private final HealthFoodRepositoryImpl healthFoodRepositoryMenu;
    private final BeverageRepositoryImpl beverageRepositoryMenu;
    private final TableRepositoryImpl tableRepository;
    private double totalSum;
    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {

        this.healthFoodRepositoryMenu = (HealthFoodRepositoryImpl) healthFoodRepository;
        this.beverageRepositoryMenu = (BeverageRepositoryImpl) beverageRepository;
        this.tableRepository = (TableRepositoryImpl) tableRepository;
        this.totalSum = 0;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {


        HealthyFood healthyFood;
        switch (type){
            case "Salad":
                healthyFood =  new Salad(name,price);
                break;
            case "VeganBiscuits":
                healthyFood =  new VeganBiscuits(name,price);
                break;
            default:
                healthyFood = null; //TODO: i think is a mistake to create a null healthy food
        }

        checkExceptionFood(healthyFood);


        this.healthFoodRepositoryMenu.add(healthyFood);
        return String.format(OutputMessages.FOOD_ADDED,name);
    }
    @Override
    public String addBeverage(String type, int counter, String brand, String name){

        Beverages beverages;
        switch (type){
            case "Fresh":
                beverages = new Fresh(name,counter,brand);
                break;
            case "Smoothie":
                beverages = new Smoothie(name,counter,brand);
                break;
            default:
                beverages = null; //TODO: i think is a mistake to create a null beverages
        }

        checkExceptionBeverage(beverages);

        this.beverageRepositoryMenu.add(beverages);
        return String.format(OutputMessages.BEVERAGE_ADDED,type,brand);
    }
    @Override
    public String addTable(String type, int tableNumber, int capacity) {

        Table table;
        switch(type){
            case "Indoors":
                table = new Indoors(tableNumber,capacity);
                break;
            case "InGarden":
                table =  new InGarden(tableNumber,capacity);
                break;

            default:
              table = null;  //TODO: i think is a mistake to create a null table
        }


        checkExceptionTable(table);
        this.tableRepository.add(table);
        return String.format(OutputMessages.TABLE_ADDED,tableNumber);
    }
    @Override
    public String reserve(int numberOfPeople) {
        Table table = tableExist(numberOfPeople);

        if(table == null){
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE,numberOfPeople);
        }

        table.reserve(numberOfPeople);


        return String.format(OutputMessages.TABLE_RESERVED,table.getTableNumber(),table.numberOfPeople());
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {

        Table table = this.tableRepository.byNumber(tableNumber);
        if(table == null){
            throw new IllegalArgumentException(String.format(OutputMessages.WRONG_TABLE_NUMBER,tableNumber));
        }
        table = this.tableRepository.byNumber(tableNumber);


        HealthyFood healthyFood = this.healthFoodRepositoryMenu.foodByName(healthyFoodName);

        if(healthyFood == null){
            return String.format(OutputMessages.NONE_EXISTENT_FOOD,healthyFoodName);
        }
        table.orderHealthy(healthyFood);

        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL,healthyFoodName,table.getTableNumber());
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {

        Table table = this.tableRepository.byNumber(tableNumber);

        if(table == null){
            return String.format(OutputMessages.WRONG_TABLE_NUMBER,tableNumber);
        }

        table = this.tableRepository.byNumber(tableNumber);
        Beverages beverages = this.beverageRepositoryMenu.beverageByName(name,brand);
        if(beverages == null){
            return String.format(OutputMessages.NON_EXISTENT_DRINK,name,brand);
        }
        table.orderBeverages(beverages);
        return String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL,name,table.getTableNumber());
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = this.tableRepository.byNumber(tableNumber);
        this.totalSum += table.allPeople();
        return String.format(OutputMessages.BILL,table.getTableNumber(),table.allPeople());
    }


    @Override
    public String totalMoney() {
        return String.format(OutputMessages.TOTAL_MONEY,this.totalSum);
    }

    private void checkExceptionFood(HealthyFood food){
        if(!this.healthFoodRepositoryMenu.getAllEntities().isEmpty()){
            for (HealthyFood healthyFood : this.healthFoodRepositoryMenu.getAllEntities()) {
                if(healthyFood.getName().equals(food.getName())){
                    throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST,food.getName()));
                }
            }
        }

    }
    private void checkExceptionBeverage(Beverages drink){

        if(!this.beverageRepositoryMenu.getAllEntities().isEmpty()){
            for (Beverages beverages : this.beverageRepositoryMenu.getAllEntities()) {
                if(beverages.getName().equals(drink.getName()) && beverages.getBrand().equals(drink.getBrand())  ){
                    throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST,drink.getName()));
                }
            }
        }

    }
    private void checkExceptionTable(Table table){
        Table returnTable = this.tableRepository.byNumber(table.getTableNumber());
        if(returnTable != null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_IS_ALREADY_ADDED,table.getTableNumber()));
        }
    }
    private Table tableExist(int numberOfPeople){

        if(this.tableRepository.getAllEntities().isEmpty()){
            return null;
        }

        for (Table table : this.tableRepository.getAllEntities() ) {

            if(table.getSize() >= numberOfPeople && table.isReservedTable()){
                return table;
            }

        }



        return null;
    }

}
