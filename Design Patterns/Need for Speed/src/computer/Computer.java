package computer;

public class Computer {
    private String RAM;
    private boolean isGraphicsCardEnabled;

    public Computer(String ram, boolean isGraphicsCardEnabled) {
        RAM = ram;
        this.isGraphicsCardEnabled = isGraphicsCardEnabled;
    }


    public String getRAM() {
        return RAM;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }


}
