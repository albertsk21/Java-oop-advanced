package aquarium.entities.decorations;

public class BaseDecoration implements Decoration{

    private int comfort;
    private double price;


    public BaseDecoration(int comfort, double price) {
        this.comfort = comfort;
        this.price = price;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public void setComfort(int comfort) {
        this.comfort = comfort;
    }

    @Override
    public int getComfort() {
        return this.comfort;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
