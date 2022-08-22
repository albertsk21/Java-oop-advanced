package aquarium.core;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private DecorationRepository decorationRepository;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorationRepository = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {


        Aquarium aquarium;
        switch (aquariumType){
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
               throw new NullPointerException(ExceptionMessages.INVALID_AQUARIUM_TYPE);

            }
        this.aquariums.add(aquarium);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE,aquariumType);
    }
    @Override
    public String addDecoration(String type) {

        Decoration decoration;
        switch (type){

            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new IllegalStateException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }


        this.decorationRepository.add(decoration);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE,type);
    }
    @Override
    public String insertDecoration(String aquariumName, String decorationType) {

        Decoration decoration = this.decorationRepository.findByType(decorationType);
        Aquarium aquarium = this.findAquariumByName(aquariumName);

        if(decoration == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_DECORATION_FOUND,decorationType));
        }

        this.decorationRepository.remove(decoration);
        aquarium.addDecoration(decoration);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM,decorationType,aquariumName);
    }
    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {


        Fish fish;
        switch (fishType){

            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName,fishSpecies,price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName,fishSpecies,price);
                break;
            default:
                throw new IllegalStateException(ExceptionMessages.INVALID_FISH_TYPE);
        }

        Aquarium aquarium = this.findAquariumByName(aquariumName);



        try {
            checkWaterException(aquarium,fish);
        }catch (IllegalArgumentException ex){
            return ex.getMessage();
        }


        aquarium.addFish(fish);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM,fishType,aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = this.findAquariumByName(aquariumName);
        aquarium.feed();
        return String.format(ConstantMessages.FISH_FED,aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = findAquariumByName(aquariumName);
        double totalSum = this.allPriceOfFish(aquarium);
        return String.format(ConstantMessages.VALUE_AQUARIUM,aquariumName,totalSum);
    }

    @Override
    public String report() {


        StringBuilder output = new StringBuilder("");


        for (Aquarium aquarium : this.aquariums) {

            output.append(aquarium.getInfo());
        }
        return output.toString();
    }
    private Aquarium findAquariumByName(String aquariumName){

        for (Aquarium aquarium : this.aquariums ) {

            if(aquarium.getName().equals(aquariumName)){
                return aquarium;
            }
        }
        return null;
    }
    private void checkWaterException(Aquarium aquarium, Fish fish){

        String expected = aquarium.getClass().getSimpleName();
        expected = expected.replaceAll("Aquarium","");

        String current = fish.getClass().getSimpleName();
        current = current.replaceAll("Fish","");

        if(!expected.equals(current)){
            throw new IllegalArgumentException(ConstantMessages.WATER_NOT_SUITABLE);
        }

    }
    private double allPriceOfFish(Aquarium aquarium){
        double fishTotalSum = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double decorationSum  = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        return fishTotalSum + decorationSum;
    }

}
