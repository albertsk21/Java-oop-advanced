package santasWorkshop.models;

public class Sleepy extends BaseDwarf{
    public Sleepy(String name) {
        super(name, 50);
    }


    @Override
    public void work() {

        if(this.energy - 15 < 0){
            this.setEnergy(0);
        }else{
            this.setEnergy(this.getEnergy() - 15);
        }

    }
}
