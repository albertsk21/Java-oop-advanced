package polymorphism;

public abstract  class Shape {

    private Double perimeter;
    private Double area;



    //---SETTERS---//
    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }
    protected void setArea(Double area) {
        this.area = area;
    }

    //---GETTERS---//
    public Double getPerimeter() {
        return perimeter;
    }
    public Double getArea() {
        return area;
    }

    //---ANOTHER-COMMANDS---//

    protected void calculateArea(){}
    protected void calculatePerimeter(){}

}
