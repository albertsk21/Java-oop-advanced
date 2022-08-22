public class Topping {


    private String toppingType;
    private double weight;


    //---CONSTRUCTOR---//
    public Topping(String toppingType, double weight){
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    //---SETTERS---//
    public void setToppingType(String toppingType) {

       if(!TypeUtils.TOPPING_TYPES.containsKey(toppingType)){
           throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
       }
        this.toppingType = toppingType;
    }
    public void setWeight(double weight) {
        if(!(weight >= 1 && weight <= 50 )){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",this.getToppingType()));
        }
        this.weight = weight;
    }

    //---GETTERS---//
    public double getWeight() {
        return weight;
    }

    public String getToppingType() {
        return toppingType;
    }

    public double calculateCalories (){
        return 2 * this.getWeight() * TypeUtils.TOPPING_TYPES.get(this.getToppingType());
    }

}
