package Ex14;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    //calculate perimeter
    @Override
    public double perimeter() {
        return (this.height + this.width) * 2;
    }

    //calculate area
    @Override
    public double area() {
        return this.height * this.width;
    }

}
