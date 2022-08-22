public class ExternalBox extends Box {
    protected ExternalBox(double length, double width, double height) {
        super(length, width, height);
    }

    @Override
    public String toString() {

        return  String.format("Surface - %.2f\n", calculateSurface()) +
                String.format("Lateral Surface - %.2f\n", calculateLateralSurface()) +
                String.format("Volume - %.2f", calculateVolume());
    }
}
