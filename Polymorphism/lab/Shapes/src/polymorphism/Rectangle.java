package polymorphism;

public class Rectangle extends Shape{

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }


    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    @Override
    public void calculateArea() {
        setArea(this.getHeight() * this.getWidth());
    }

    @Override
    public void calculatePerimeter() {
       setPerimeter(this.getWidth() * 2 + this.getHeight() * 2);
    }
}
