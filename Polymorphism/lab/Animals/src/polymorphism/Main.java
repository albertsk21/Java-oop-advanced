package polymorphism;

public class Main {

    public static void main(String[] args) {
        Animal cat = new Cat("Oscar", "Whiskas");
        Animal dog = new Dog("Rocky", "Meat");
        System.out.println(cat.getAnimalInfo());
        System.out.println(dog.getAnimalInfo());
    }
}
