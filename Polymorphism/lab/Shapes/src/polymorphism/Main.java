package polymorphism;
public class  Main {

    public static void main(String[] args)  {


        Shape rectangle = new Rectangle(5.0,2.0);
        Shape circle = new Circle(5.0);
        rectangle.calculatePerimeter();
        circle.calculateArea();
        System.out.println(rectangle.getPerimeter());
        System.out.println(circle.getArea());


    }
}
