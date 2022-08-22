package santasWorkshop.core;

import santasWorkshop.common.ConstantMessages;
import santasWorkshop.common.ExceptionMessages;
import santasWorkshop.models.*;
import santasWorkshop.repositories.DwarfRepository;
import santasWorkshop.repositories.PresentRepository;
import santasWorkshop.repositories.Repository;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {


    private Repository<Dwarf> dwarfRepository;
    private Repository<Present> presentRepository;

    public ControllerImpl() {

        this.dwarfRepository = new DwarfRepository();
        this.presentRepository =  new PresentRepository();
    }


    @Override
    public String addDwarf(String type, String dwarfName) {

        if(type.equals("Happy")){
            Dwarf happyDwarf = new Happy(dwarfName);
            this.dwarfRepository.add(happyDwarf);

        }else if(type.equals("Sleepy")){
            Dwarf sleepyDwarf = new Sleepy(dwarfName);
            this.dwarfRepository.add(sleepyDwarf);
        }else{
            throw new IllegalArgumentException(ExceptionMessages.DWARF_TYPE_DOESNT_EXIST);

        }
        return String.format(ConstantMessages.ADDED_DWARF,type,dwarfName);
    }

    @Override
    public String addInstrumentToDwarf(String dwarfName, int power) {

        Dwarf dwarf = this.dwarfRepository.findByName(dwarfName);

        if(dwarf == null){
            throw new IllegalArgumentException(ExceptionMessages.DWARF_DOESNT_EXIST);
        }

        Instrument instrument = new InstrumentImpl(power);
        dwarf.addInstrument(instrument);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_DWARF,power,dwarfName);


    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName,energyRequired);
        this.presentRepository.add(present);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT,presentName);
    }

    @Override
    public String craftPresent(String presentName) {


        List<Dwarf> dwarves =  new ArrayList<>();


        for (Dwarf dwarf : this.dwarfRepository.getModels()) {
            if(dwarf.getEnergy() > 50){
                dwarves.add(dwarf);
            }
        }
        if(dwarves.size() == 0){
            throw new IllegalArgumentException(ExceptionMessages.NO_DWARF_READY);
        }



        Present present = presentRepository.findByName(presentName);
        Workshop workshop =  new WorkshopImpl();

        for (Dwarf dwarf : dwarves) {
            workshop.craft(present,dwarf);
        }
        String isPresent = null;
        if(present.isDone()){
            isPresent = String.format(ConstantMessages.PRESENT_DONE,presentName,"done");
        }else{
            isPresent = String.format(ConstantMessages.PRESENT_DONE,presentName,"not done");
        }

        int brokenCount = 0;
        for (Dwarf dwarf : dwarves) {

            for (Instrument instrument : dwarf.getInstruments()) {
                if(instrument.isBroken()){
                    brokenCount++;
                }
            }

        }



        String brokenInstruments = String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS,brokenCount);

        return isPresent + brokenInstruments;
    }

    @Override
    public String report() {

        String output = "";

        int countCraftedPresents = 0;

        for (Present present : presentRepository.getModels()) {
            if(present.isDone()){
                countCraftedPresents++;
            }

        }


        output += String.format("%s presents are done!\n",countCraftedPresents);


        output += "Dwarfs info:\n";
        for (Dwarf dwarf : this.dwarfRepository.getModels()) {

            output += String.format("Name: %s\n",dwarf.getName());
            output += String.format("Energy: %d\n",dwarf.getEnergy());

            int countInstruments = 0;

            for (Instrument instrument : dwarf.getInstruments()) {
                if(!instrument.isBroken()){
                    countInstruments++;
                }
            }
            output += String.format("Instruments: %d not broken left\n",countInstruments);


        }



        return output;
    }
}
