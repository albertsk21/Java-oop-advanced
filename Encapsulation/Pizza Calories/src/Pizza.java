import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private final List<Topping> toppings;
    private int numberOfToppings;


    //---CONSTRUCTOR---//
    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }


    //---SETTERS---//
    private void setToppings(int number) {

        if(!(number > 0 && number <= 10)){
            throw new IllegalArgumentException( "Number of toppings should be in range (0..10)");
        }

        this.numberOfToppings = number;
    }
    private void setName(String name) {
        if(name.trim().isEmpty() || !(name.length() >= 1 && name.length() <= 15 )){
            throw new IllegalArgumentException( "Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }
    public void setDough(Dough dough) {
        this.dough = dough;
    }


    //---GETTERS---//
    public String getName() {
        return name;
    }
    public void addTopping(Topping topping){
        if(this.toppings.size() < this.numberOfToppings ){
            this.toppings.add(topping);
        }
    }
    public double getOverallCalories(){
        double mainResult = this.dough.calculateCalories();
        for (Topping topping : toppings) {
            mainResult += topping.calculateCalories();
        }

        return mainResult;
    }


}
