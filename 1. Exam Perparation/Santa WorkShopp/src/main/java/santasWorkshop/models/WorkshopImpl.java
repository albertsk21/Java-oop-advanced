package santasWorkshop.models;


import java.util.Collection;

public class WorkshopImpl implements Workshop {

    @Override
    public void craft(Present present, Dwarf dwarf) {

        Instrument workingInstrument = getWorkingInstrument(dwarf.getInstruments());


        if(dwarf.canWork() || workingInstrument != null){

            while (!present.isDone() && dwarf.canWork()){
                dwarf.work();
                workingInstrument.use();
                present.getCrafted();

                if(present.isDone()){
                    break;
                }


                if(workingInstrument.isBroken()){
                    workingInstrument = getWorkingInstrument(dwarf.getInstruments());
                    if(workingInstrument == null){
                        break;
                    }
                }
            }

        }


    }

    private Instrument getWorkingInstrument(Collection<Instrument> instruments){
        for (Instrument instrument : instruments) {

            if(!instrument.isBroken()){
                return instrument;
            }
        }

        return null;
    }
}
