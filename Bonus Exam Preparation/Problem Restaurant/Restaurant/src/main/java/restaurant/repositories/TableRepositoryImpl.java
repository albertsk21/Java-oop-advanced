package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.Repository;
import restaurant.repositories.interfaces.TableRepository;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<Table>, Repository<Table> {

    Collection<Table> tableCollection;

    public TableRepositoryImpl() {
        this.tableCollection = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableCollection(this.tableCollection);
    }


    @Override
    public void add(Table table) {
        this.tableCollection.add(table);
    }

    @Override
    public Table byNumber(int number) {
        for ( Table table : this.tableCollection) {
            if(table.getTableNumber() == number){
                return table;
            }

        }
        return null;
    }
}
