package santasWorkshop.models;

import santasWorkshop.common.ExceptionMessages;

public class InstrumentImpl implements Instrument {


    private int power;


    public InstrumentImpl(int power){
        this.setPower(power);
    }

    @Override
    public int getPower() {
        return this.power;
    }


    public void setPower(int power) {
        if(power < 0){
            throw new IllegalArgumentException(ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public void use() {

        if (this.getPower() - 10 < 0){
            this.setPower(0);
        }else {
            this.setPower(this.getPower() - 10);
        }
    }

    @Override
    public boolean isBroken() {
        return this.power == 0;
    }
}
