package onlineShop.models.products.computers;
import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

public class BaseComputer extends BaseProduct implements Computer {

    private List<Component> components;
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {

        for (Component currentComponent : this.getComponents()) {

            if(currentComponent.getClass().getSimpleName().equals(component.getClass().getSimpleName())){
                throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT,
                        component.getClass().getSimpleName(),
                        this.getClass().getSimpleName(),
                        this.getId()));
            }



        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {

        int index = -1;
        for (int i = 0; i < this.components.size(); i++) {

            if(this.components.get(i).getClass().getSimpleName().equals(componentType)){
                index = i;
                break;

            }

        }
        if(this.components.isEmpty() || index == -1){
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT,
                    componentType,
                    this.getClass().getSimpleName(),
                    this.getId()));

        }

        return this.getComponents().remove(index);
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {

        for (Peripheral p  : this.getPeripherals()) {

            if(p.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName())){
                throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_PERIPHERAL,
                        peripheral.getClass().getSimpleName(),
                        this.getClass().getSimpleName(),
                        this.getId()));
            }
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {


        int index = -1;
        for (int i = 0; i < this.peripherals.size(); i++) {

            if(this.peripherals.get(i).getClass().getSimpleName().equals(peripheralType)){
                index = i;
                break;

            }

        }


        if(this.components.isEmpty() || index == -1){
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT,
                    peripheralType,
                    this.getClass().getSimpleName(),
                    this.getId()));

        }

        return this.getPeripherals().remove(index);

    }

    @Override
    public double getOverallPerformance() {
        if(this.getComponents().isEmpty()){
            return super.getOverallPerformance();
        }
        return super.getOverallPerformance() + this.calculateComponentsAveragePerformance();
    }

    @Override
    public double getPrice() {
        return super.getPrice() + this.calculateComponentsPrice() + calculatePeripheralsPrice();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString() + "\n");

        String outputComputerComponents = String.format(OutputMessages.COMPUTER_COMPONENTS_TO_STRING,this.getComponents().size()) + "\n";
        output.append(outputComputerComponents);

        for (Component component : this.components) {
            String outputComponent = component.toString() + "\n";
            output.append(outputComponent);
        }

        String outputComputerPeripherals = String.format(OutputMessages.COMPUTER_PERIPHERALS_TO_STRING,this.peripherals.size(), calculateComponentsAveragePerformance()) + "\n";
        output.append(outputComputerPeripherals);


        int counter = 0;

        String outputPeripheral;
        for (Peripheral  peripheral : this.peripherals) {


            outputPeripheral = String.format("%s",peripheral.toString());

            output.append(outputPeripheral);
            counter++;
        }


        return output.toString();
    }
    public double calculateComponentsAveragePerformance(){

        return this.getComponents()
                .stream()
                .mapToDouble(Product::getOverallPerformance)
                .average().
                orElse(0);
    }

    private double calculateComponentsPrice(){
        return this.getComponents().stream().mapToDouble(Product::getPrice).sum();
    }
    private double calculatePeripheralsPrice(){
        return this.getPeripherals().stream().mapToDouble(Product::getPrice).average().stream().sum();
    }
}
