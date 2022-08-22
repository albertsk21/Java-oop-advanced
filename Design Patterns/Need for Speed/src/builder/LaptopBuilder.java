package builder;

public class LaptopBuilder {
    //required
    private String brand;
    private String model;


    //optional
    private double SSD;
    private double RAM;


    public LaptopBuilder(String brand, String model){
        this.brand = brand;
        this.model = model;
    }

    public double getSSD() {
        return SSD;
    }

    public String getBrand() {
        return brand;
    }

    public double getRAM() {
        return RAM;
    }

    public String getModel() {
        return model;
    }

    public LaptopBuilder setRAM(double RAM){
        this.RAM = RAM;
        return this;

    }
    public LaptopBuilder setSSD(double SSD){
        this.SSD = SSD;
        return this;

    }

  public Laptop build(){
        return new Laptop(this);
  }

}
