package restaurant.repositories;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.HealthFoodRepository;
import restaurant.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood>, Repository<HealthyFood> {
    Collection<HealthyFood> healthyFoodsCollection;

    public HealthFoodRepositoryImpl() {
        this.healthyFoodsCollection = new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name){
        for (HealthyFood healthyFood : this.getAllEntities()) {
            if(healthyFood.getName().equals(name)){
                return healthyFood;
            }
        }
        return null;
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return Collections.unmodifiableCollection(this.healthyFoodsCollection);
    }

    @Override
    public void add(HealthyFood healthyFood) {
        this.healthyFoodsCollection.add(healthyFood);
    }


}
