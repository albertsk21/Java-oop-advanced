package onlineShop.models.products.peripherals;

import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.BaseProduct;

public class BasePeripheral extends BaseProduct implements Peripheral {

    private String connectionType;
    public BasePeripheral(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance);
        this.connectionType = connectionType;
    }

    @Override
    public String getConnectionType() {
        return this.connectionType;
    }

    @Override
    public String toString(){
        String output = super.toString() + OutputMessages.PERIPHERAL_TO_STRING;
        return String.format(output,this.connectionType);
    }
}
