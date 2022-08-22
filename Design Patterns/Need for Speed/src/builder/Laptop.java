package builder;

public class Laptop {
    //required
    private String brand;
    private String model;


    //optional
    private double SSD;
    private double RAM;


    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public double getRAM() {
        return RAM;
    }

    public double getSSD() {
        return SSD;
    }

    Laptop(LaptopBuilder laptopBuilder){
        this.brand = laptopBuilder.getBrand();
        this.model = laptopBuilder.getModel();
        this.RAM = laptopBuilder.getRAM();
        this.SSD = laptopBuilder.getSSD();

    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", SSD=" + SSD +
                ", RAM=" + RAM +
                '}';
    }
}
