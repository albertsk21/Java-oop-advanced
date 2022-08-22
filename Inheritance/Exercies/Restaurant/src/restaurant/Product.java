package restaurant;

import java.math.BigDecimal;

public class Product {

    private String name;
    private BigDecimal price;


    //---CONSTRUCTOR---//
    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    //---SETTERS---//
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //---GETTERS---//
    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
        return price;
    }


}

