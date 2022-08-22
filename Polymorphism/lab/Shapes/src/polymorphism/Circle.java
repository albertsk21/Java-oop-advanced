package polymorphism;

public class Circle extends Shape{

    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return this.radius;
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(this.getRadius() * 2 * Math.PI);
    }

    @Override
    public void calculateArea() {
        setArea(this.getRadius() * this.getRadius() * Math.PI);
    }
}
