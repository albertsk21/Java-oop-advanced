package santasWorkshop.repositories;

import santasWorkshop.models.Present;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PresentRepository implements Repository<Present>{

    private final List<Present> presents =  new ArrayList<>();



    @Override
    public Collection getModels() {
        return Collections.unmodifiableCollection(this.presents);
    }

    @Override
    public void add(Present present) {
        this.presents.add( present);
    }

    @Override
    public boolean remove(Present present) {

        if(this.presents.contains( present)){
            this.presents.remove(present);
            return true;
        }

        return false;
    }

    @Override
    public Present findByName(String name) {
        for ( Present present : this.presents) {
            if(present.getName().equals(name)){
                return present;
            }
        }
        return null;
    }
}
