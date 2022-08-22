package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Add extends Command{
    protected Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {

        String unitType = getData()[1];
        Unit unit = getunitFactory().createUnit(unitType);
        this.getRepository().addUnit(unit);
        return String.format("%s added!",unitType);

    }
}
