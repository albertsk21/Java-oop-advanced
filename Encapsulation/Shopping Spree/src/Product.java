public class Product {


    private String name;
    private double cost;


    public Product (String name, double cost) {
        this.setName(name.replaceAll(" ",""));
        this.setCost(cost);
    }


    //---SETTERS---//
    private void setName (String name) {

        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name.trim();
    }
    private void setCost (double cost) {
        if(cost <= -1){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    //---GETTERS---//
    public String getName(){
        return name;
    }
    public double getCost () {
        return cost;
    }





}
