import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name.replaceAll(" ",""));
        this.setMoney(money);
        this.setProducts();
    }

    //---SETTERS---//
    private void setName (String name) {

        if(name.trim().isEmpty()){
             throw new IllegalArgumentException("Name cannot be empty.");
        }
            this.name = name.trim();

    }
    private void setMoney (double money) {
        if(money <= -1){
            throw new IllegalArgumentException("Money cannot be negative");
        }
            this.money = money;

    }
    private void setProducts(){
        this.products = new ArrayList<>();
    }


    //---GETTERS---//
    public String getName() {
        return name;
    }
    public double getMoney() {
        return money;
    }
    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }




    public void buyProduct (Product product){


        if(this.getMoney() < product.getCost()){
            System.out.printf("%s can't afford %s",this.getName(),product.getName());

        }else{
            this.setMoney( this.getMoney() - product.getCost() );
            this.products.add(product);
            System.out.printf("%s bought %s%n",this.getName(),product.getName());
        }
    }

}
