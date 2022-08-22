package polymorphism;

public class Cat extends Animal{


    protected Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String getAnimalInfo() {
        return String.format("%s%nMEOW",this.toString());
    }
}
