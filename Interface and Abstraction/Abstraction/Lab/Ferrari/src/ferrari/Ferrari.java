package ferrari;

public class Ferrari implements Car {

    private final String driverName;
    private final String model;


    protected Ferrari(String driverName) {
        this.driverName = driverName;
        this.model = "488-Spider";
    }

    public String getDriverName() {
        return this.driverName;
    }


    public String getModel() {
        return this.model;
    }


    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",
                this.getModel(),
                this.brakes(),
                this.gas(),
                this.getDriverName());
    }
}
