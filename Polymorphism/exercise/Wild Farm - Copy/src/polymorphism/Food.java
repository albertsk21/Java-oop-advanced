package polymorphism;

public abstract class Food {
    private Integer quantity;


    protected Food(Integer quantity) {
        this.quantity = quantity;

    }
    //---SETTERS---///
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    //---GETTERS---//

    public Integer getQuantity() {
        return quantity;
    }
}
