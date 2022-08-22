package polymorphism;

public abstract class Animal {

    private String name;
    private String favouriteFood;


    //---CONSTRUCTOR---//
    protected Animal(String name, String favouriteFood){
        this.name = name;
        this.favouriteFood = favouriteFood;

    }
    //---GETTERS---//
    public String getName() {
        return name;
    }
    public String getFavouriteFood() {
        return favouriteFood;
    }
    abstract String getAnimalInfo();


    //---SETTERS---//
    public void setName(String name) {
        this.name = name;
    }
    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    @Override
    public String toString() {
        return  String.format("I am %s and may favorite food is %s",this.name,this.favouriteFood);
    }
}
