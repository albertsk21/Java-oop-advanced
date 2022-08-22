package santasWorkshop.repositories;

import santasWorkshop.models.Dwarf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DwarfRepository implements Repository<Dwarf> {
    private final List<Dwarf> dwarves =  new ArrayList<>();



    @Override
    public Collection getModels() {
        return Collections.unmodifiableCollection(this.dwarves);
    }

    @Override
    public void add(Dwarf model) {
        this.dwarves.add(model);
    }

    @Override
    public boolean remove(Dwarf model) {
        if(this.dwarves.contains(model)){
            this.dwarves.remove(model);
            return true;
        }
        return false;
    }

    @Override
    public Dwarf findByName(String name) {


        for (Dwarf dwarf : this.dwarves) {
            if(dwarf.getName().equals(name)){
                return dwarf;
            }

        }

        return null;

    }


}
