package polymorphism;

public class Dog  extends  Animal{
    protected Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String getAnimalInfo() {
      return String.format("%s%nBARK",this.toString());
    }
}
