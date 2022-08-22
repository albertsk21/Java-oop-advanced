package aquarium.entities.aquariums;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;


public class BaseAquarium implements Aquarium{
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if(this.fish.size() >= this.capacity){
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }

        this.fish.add(fish);

    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish fish : this.fish) {
            fish.eat();
        }
    }

    @Override
    public String getInfo() {

        StringBuilder output = new StringBuilder(String.format("%s (%s):\n",this.getName(),this.getClass().getSimpleName()));
        output.append("Fish: ");

        if(this.fish.size() == 0){
            output.append("None");
        }else{
            int counter = 0;
            for (Fish fish : this.fish) {
                if(counter == this.fish.size() - 1){
                    output.append(String.format("%s%n",fish.getName()));
                }else{
                    output.append(String.format("%s ",fish.getName()));
                }
                counter++;
            }
        }
        output.append(String.format("Decorations: %s%n",this.decorations.size()));
        output.append(String.format("Comfort: %s%n",this.getTotalComfort()));
        return output.toString();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
    private int getTotalComfort(){
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

}
