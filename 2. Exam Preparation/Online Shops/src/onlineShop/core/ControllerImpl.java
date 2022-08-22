package onlineShop.core;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {

    private List<Computer> computers;
    private List<Component> components;
    private List<Peripheral> peripherals;


    public ControllerImpl(){
        this.computers = new ArrayList<>();
        this.components =  new ArrayList<>();
        this.peripherals =  new ArrayList<>();
    }



    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {

        for (Computer computer : this.computers) {

            if(computer.getId() == id){
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
            }
        }
        Computer computer;
        switch (computerType){
            case "Laptop":
                computer = new Laptop(id,manufacturer,model,price);
                break;
            case "DesktopComputer":
                computer = new DesktopComputer(id,manufacturer,model,price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
        }
        this.computers.add(computer);
        return String.format(OutputMessages.ADDED_COMPUTER,id);
    }
    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {

        if(this.getComputerById(computerId) == null){
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        for (Peripheral peripheral  : this.peripherals) {
            if(peripheral.getId() == id){
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_PERIPHERAL_ID);
            }
        }
        Peripheral peripheral;
        switch (peripheralType){
            case "Headset":
                peripheral =  new Headset(id,manufacturer,model,price,overallPerformance,connectionType);
                break;
            case "KeyBoard":
                peripheral =  new Keyboard(id,manufacturer,model,price,overallPerformance,connectionType);
                break;
            case "Monitor":
                peripheral =  new Monitor(id,manufacturer,model,price,overallPerformance,connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id,manufacturer,model, price,overallPerformance,connectionType);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_PERIPHERAL);
        }
      this.getPeripherals().add(peripheral);
      this.getComputerById(computerId).addPeripheral(peripheral);
      return String.format(OutputMessages.ADDED_PERIPHERAL,peripheralType,id,computerId);
    }

    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    public List<Component> getComponents() {
        return components;
    }

    public List<Computer> getComputers() {
        return computers;
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {

        if(this.getComputerById(computerId) == null){
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }



        boolean isRemoved = false;
        int peripheralId = -1;

        Computer computer =  this.getComputerById(computerId);
        Peripheral removed = computer.removePeripheral(peripheralType);


        for (int i = 0; i <this.getPeripherals().size() ; i++) {

            if(this.getPeripherals().get(i).getClass().getSimpleName().equals(peripheralType)){
                peripheralId = this.getPeripherals().remove(i).getId();
                isRemoved = true;
                break;
            }

        }

        if(isRemoved || removed == null){
            return String.format(OutputMessages.REMOVED_PERIPHERAL,peripheralType,peripheralId);
        }



        return null;
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {


        if(this.getComputerById(computerId) == null){
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }


        for (Component component : this.getComponents()) {

            if(component.getClass().getSimpleName().equals(componentType)){
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
            }
        }



        Component component;
        switch (componentType){

            case "Motherboard":
               component =  new Motherboard(id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "PowerSupply":
               component = new PowerSupply(id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "RandomAccessMemory":
               component = new RandomAccessMemory(id,manufacturer,model,price,overallPerformance,generation);
               break;
            case "SolidStateDrive":
               component = new SolidStateDrive(id,manufacturer,model,price,overallPerformance,generation);
               break;
            case "VideoCard":
               component = new VideoCard(id,manufacturer,model,price,overallPerformance,generation);
               break;
            case "CentralProcessingUnit":
               component = new CentralProcessingUnit(id,manufacturer,model,price,overallPerformance,generation);
               break;
            default:
                throw new IllegalArgumentException("Component type is invalid.");
        }


        this.getComponents().add(component);
        this.getComputerById(computerId).addComponent(component);
        return String.format(OutputMessages.ADDED_COMPONENT,componentType,id,computerId);

    }

    @Override
    public String removeComponent(String componentType, int computerId) {

        int componentId = -1;

        Computer computer =  this.getComputerById(computerId);
        Component removed = computer.removeComponent(componentType);

        for (int i = 0; i <this.getComponents().size() ; i++) {

            if(this.getComponents().get(i).getClass().getSimpleName().equals(componentType)){
                componentId = i;
                break;
            }

        }
        if(this.components.isEmpty() || removed == null){
            return String.format(OutputMessages.REMOVED_COMPONENT,componentType,componentId);
        }
        return null;
    }

    @Override
    public String buyComputer(int id) {
        if(this.getComputerById(id) == null){
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        Computer computer = this.getComputerById(id);
        this.removeComputerById(id);

        return computer.toString();

    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer computer = this.computerBestPerformance(budget);
        if(computer == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAN_NOT_BUY_COMPUTER,budget));
        }
        this.computers.remove(computer);
        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        Computer computer = this.getComputerById(id);

        if(computer != null){
            return computer.toString();

        }

        throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);


    }

    private Computer getComputerById(int computerId){
        for (Computer computer : this.computers) {
            if(computer.getId() == computerId){
                return computer;
            }
        }
        return null;
    }
    private void removeComputerById(int id){
        for (int i = 0; i < this.computers.size() ; i++) {
            if(this.computers.get(i).getId() == id){
                Computer computer = this.computers.get(i);
                this.computers.remove(computer);
                break;
            }
        }
    }
    private Computer computerBestPerformance(double budget){

        Computer bestComputer = this.computers.get(0);
        Computer lowCostGoodPerformance = null;
        for (int i = 1; i < this.computers.size() ; i++) {

            if((bestComputer.getOverallPerformance() < this.computers.get(i).getOverallPerformance())){
                bestComputer = this.computers.get(i);
                if(bestComputer.getPrice() <= budget){
                    lowCostGoodPerformance = bestComputer;
                }
            }
        }



        return lowCostGoodPerformance;
    }
}
