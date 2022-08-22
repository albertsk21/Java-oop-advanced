package santasWorkshop.models;

import santasWorkshop.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseDwarf implements Dwarf {

    private List<Instrument> instruments;
    private String name;
    public int energy;


    public BaseDwarf(String name, int energy){
        this.setName(name);
        this.setEnergy(energy);
        this.setInstruments(new ArrayList<>());

    }

    private void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.DWARF_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(int energy) {
        if(energy < 0){
            throw new IllegalArgumentException(ExceptionMessages.DWARF_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }


    @Override
    public void work(){


        if(this.getEnergy() - 10 < 0){
            this.setEnergy(0);
        }else{
            this.setEnergy(this.getEnergy() - 10);
        }
    }

    @Override
    public void addInstrument(Instrument instrument) {
        this.instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.energy > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return this.instruments;
    }
}
