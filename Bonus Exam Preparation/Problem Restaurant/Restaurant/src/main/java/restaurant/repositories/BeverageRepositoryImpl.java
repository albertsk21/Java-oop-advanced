package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;
import restaurant.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages>, Repository<Beverages> {
    Collection<Beverages> beveragesCollection;

    public BeverageRepositoryImpl() {
        this.beveragesCollection = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        for ( Beverages beverages : this.getAllEntities()) {
            if(beverages.getName().equals(drinkName) && beverages.getBrand().equals(drinkBrand)){
                return beverages;
            }
        }
        return null;
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(this.beveragesCollection);
    }

    @Override
    public void add(Beverages beverage) {
        this.beveragesCollection.add(beverage);
    }
}
