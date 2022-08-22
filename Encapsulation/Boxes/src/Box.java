public class Box {

    private double length;
    private double width;
    private double height;


    //---CONSTRUCTOR---//
    public Box(double length, double width, double height){
        setLength(length);
        setWidth(width);
        setHeight(height);
    }


    //---SETTERS---//
    private void setLength(double length) {

        if(length <= 0 ){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }

        this.length = length;
    }
    private void setHeight(double height) {
        if(height <= 0 ){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }
    private void setWidth(double width) {
        if(width <= 0 ){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }



    //---GETTERS---//
    public double getHeight() {
        return height;
    }
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }

     //---COMMANDS---//
     public double calculateSurface() {
         return (2 * getLength() * getWidth()) + (2 * getLength() * getHeight()) + (2 * getWidth() * getHeight());
     }
     public double calculateLateralSurface() {
         return (2 * getLength() * getHeight()) + (2 * getWidth() * getHeight());
     }
     public double calculateVolume(){
         return getLength() * getWidth() * getHeight();
     }


 }
