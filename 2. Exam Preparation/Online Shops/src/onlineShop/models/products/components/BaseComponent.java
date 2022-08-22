package onlineShop.models.products.components;

import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.BaseProduct;


public class BaseComponent extends BaseProduct implements Component {

    private int generation;

    public BaseComponent(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.generation = generation;
    }


    @Override
    public int getGeneration() {
        return generation;
    }

    @Override
    public String toString() {

        String output = OutputMessages.PRODUCT_TO_STRING + OutputMessages.COMPONENT_TO_STRING;

        return String.format(output,
                this.getOverallPerformance(),
                this.getPrice(),
                this.getClass().getSimpleName(),
                this.getManufacturer(),
                this.getModel(),
                this.getId(),
                this.getGeneration());
    }


}
